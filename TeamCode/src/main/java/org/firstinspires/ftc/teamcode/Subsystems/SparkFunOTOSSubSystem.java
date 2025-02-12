package org.firstinspires.ftc.teamcode.Subsystems;



import static com.acmerobotics.roadrunner.ftc.OTOSKt.OTOSPoseToRRPose;
import static com.acmerobotics.roadrunner.ftc.OTOSKt.RRPoseToOTOSPose;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.DownsampledWriter;
import com.acmerobotics.roadrunner.ftc.FlightRecorder;
import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.messages.PoseMessage;

/**
 * Experimental extension of MecanumDrive that uses the SparkFun OTOS sensor for localization.
 * <p>
 * Released under the BSD 3-Clause Clear License by j5155 from 12087 Capital City Dynamics
 * Portions of this code made and released under the MIT License by SparkFun
 * Unless otherwise noted, comments are from SparkFun
 */
public class SparkFunOTOSSubSystem extends MecanumDrive {
    public static class Params {
        public SparkFunOTOS.Pose2D offset = new SparkFunOTOS.Pose2D(0.0721, 7.2089, Math.toRadians(-90));
        public double linearScalar = 1.032;
        public double angularScalar = 0.9923;
    }

    public static SparkFunOTOSSubSystem.Params PARAMS = new SparkFunOTOSSubSystem.Params();
    public SparkFunOTOSCorrected otos;
    private Pose2d lastOtosPose = pose;

    private final DownsampledWriter estimatedPoseWriter = new DownsampledWriter("ESTIMATED_POSE", 50_000_000);

    public SparkFunOTOSSubSystem(HardwareMap hardwareMap, Pose2d pose) {
        super(hardwareMap, pose);
        FlightRecorder.write("OTOS_PARAMS",PARAMS);
        otos = hardwareMap.get(SparkFunOTOSCorrected.class,"sensor_otos");
        otos.setLinearUnit(DistanceUnit.INCH);
        otos.setAngularUnit(AngleUnit.RADIANS);

        otos.setOffset(PARAMS.offset);
        System.out.println("OTOS calibration beginning!");
        System.out.println(otos.setLinearScalar(PARAMS.linearScalar));
        System.out.println(otos.setAngularScalar(PARAMS.angularScalar));

        otos.setPosition(RRPoseToOTOSPose(pose));
        System.out.println(otos.calibrateImu(255, true));
        System.out.println("OTOS calibration complete!");
    }

    //TODO make sure that this method actually works and returns the right values
    public Pose2d getOTOSPose(){
        double x = otos.getPosition().x;
        double y = otos.getPosition().y;
        double h = otos.getPosition().h;
        return new Pose2d(x, y , h);
    }


    @Override
    public PoseVelocity2d updatePoseEstimate() {
        if (lastOtosPose != pose) {
            otos.setPosition(RRPoseToOTOSPose(pose));
        }
        SparkFunOTOS.Pose2D otosPose = new SparkFunOTOS.Pose2D();
        SparkFunOTOS.Pose2D otosVel = new SparkFunOTOS.Pose2D();
        SparkFunOTOS.Pose2D otosAcc = new SparkFunOTOS.Pose2D();
        otos.getPosVelAcc(otosPose,otosVel,otosAcc);
        pose = OTOSPoseToRRPose(otosPose);
        lastOtosPose = pose;

        // RR standard
        poseHistory.add(pose);
        while (poseHistory.size() > 100) {
            poseHistory.removeFirst();
        }
        estimatedPoseWriter.write(new PoseMessage(pose));

        // RR localizer note:
        // OTOS velocity units happen to be identical to Roadrunners, so we don't need any conversion!
        return new PoseVelocity2d(new Vector2d(otosVel.x, otosVel.y),otosVel.h);
    }



    public void driveFieldCentric(double x, double y, double rx, double heading) {

        double headingRads = -Math.toRadians(heading);

        double rotX = y * Math.cos(headingRads) + x * Math.sin(headingRads);

        double rotY = y * Math.sin(headingRads) - x * Math.cos(headingRads);


        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;
        if (!(Double.valueOf(frontLeftPower).isNaN() ||
                Double.valueOf(backLeftPower).isNaN() ||
                Double.valueOf(frontRightPower).isNaN() ||
                Double.valueOf(backRightPower).isNaN())) {


            leftFront.setPower(frontLeftPower);
            leftBack.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightBack.setPower(backRightPower);
        }

        //FtcDashboard.getInstance().getTelemetry().addData("fl", frontLeftPower);
        //FtcDashboard.getInstance().getTelemetry().addData("br", backRightPower);
    }
    public void driveFieldCentric(double x, double y, double rx) {
//        driveFieldCentric(x, y, rx, lazyImu );
    }


}
