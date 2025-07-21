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
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.messages.PoseMessage;

import java.util.function.DoubleSupplier;

/**
 * Experimental extension of MecanumDrive that uses the SparkFun OTOS sensor for localization.
 * <p>
 * Released under the BSD 3-Clause Clear License by j5155 from 12087 Capital City Dynamics
 * Portions of this code made and released under the MIT License by SparkFun
 * Unless otherwise noted, comments are from SparkFun
 */
public class SparkFunOTOSSubSystem extends MecanumDrive {
    public static class Params {
        public SparkFunOTOS.Pose2D offset = new SparkFunOTOS.Pose2D(-7.118,0.06, -1.5622);
        public double linearScalar = 1.032;
        public double angularScalar = 0.9923;
    }

    public static SparkFunOTOSSubSystem.Params PARAMS = new SparkFunOTOSSubSystem.Params();
    public SparkFunOTOSCorrected otos;
    public IMU imu;
    private Pose2d lastOtosPose = pose;

    private final DownsampledWriter estimatedPoseWriter = new DownsampledWriter("ESTIMATED_POSE", 50_000_000);

    public SparkFunOTOSSubSystem(HardwareMap hardwareMap, Pose2d pose) {
        super(hardwareMap, pose);
        FlightRecorder.write("OTOS_PARAMS",PARAMS);
        otos = hardwareMap.get(SparkFunOTOSCorrected.class,"sensor_otos");
        imu = hardwareMap.get(IMU.class, "imu");
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
    public double getHeading(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);    }
    public void reset(){
        imu.resetYaw();
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



    public void driveFieldCentric(double gamepadX, double gamepadY, double gamepadRX, double heading) {

        double headingRads = getHeading();



//        double rotX = gamepadY * Math.cos(-headingRads) + gamepadX * Math.sin(-headingRads);
//
//        double rotY = gamepadY * Math.sin(-headingRads) - gamepadX * Math.cos(-headingRads);
        double rotX = gamepadX * Math.cos(-headingRads) - gamepadY * Math.sin(-headingRads);
        double rotY = gamepadX * Math.sin(-headingRads) + gamepadY * Math.cos(-headingRads);


        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(gamepadRX), 1);
        double frontLeftPower = (rotY + rotX + gamepadRX) / denominator;
        double backLeftPower = (rotY - rotX + gamepadRX) / denominator;
        double frontRightPower = (rotY - rotX - gamepadRX) / denominator;
        double backRightPower = (rotY + rotX - gamepadRX) / denominator;
        if (!(Double.valueOf(frontLeftPower).isNaN() ||
                Double.valueOf(backLeftPower).isNaN() ||
                Double.valueOf(frontRightPower).isNaN() ||
                Double.valueOf(backRightPower).isNaN())) {


            leftFront.setPower(frontLeftPower);
            leftBack.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightBack.setPower(backRightPower);
//            double botHeading = RobotContainer.imuSubsystem.getHeading();
//
//            rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
//            rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);
//
//            rotX = rotX * 1;  // Counteract imperfect strafing
//
//            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
//            double frontLeftPower = (rotY + rotX + rx) / denominator;
//            double backLeftPower = (rotY - rotX + rx) / denominator;
//            double frontRightPower = (rotY - rotX - rx) / denominator;
//            double backRightPower = (rotY + rotX - rx) / denominator;
        }

        //FtcDashboard.getInstance().getTelemetry().addData("fl", frontLeftPower);
        //FtcDashboard.getInstance().getTelemetry().addData("br", backRightPower);
    }
    public void driveFieldCentric(double x, double y, double rx) {
//        driveFieldCentric(x, y, rx, lazyImu );
    }

    public void setDrivePower(Pose2d drivePower) {
        double x = drivePower.position.x;
        double y = drivePower.position.y;
        double heading = drivePower.heading.log(); // If you're on RR v1.0 beta (new heading type)

        double denominator = Math.max(Math.abs(x) + Math.abs(y) + Math.abs(heading), 1);

        double frontLeftPower  = (x + y + heading) / denominator;
        double backLeftPower   = (x - y + heading) / denominator;
        double frontRightPower = (x - y - heading) / denominator;
        double backRightPower  = (x + y - heading) / denominator;

        if (!(Double.isNaN(frontLeftPower) || Double.isNaN(backLeftPower) ||
                Double.isNaN(frontRightPower) || Double.isNaN(backRightPower))) {
            leftFront.setPower(frontLeftPower);
            leftBack.setPower(backLeftPower);
            rightFront.setPower(frontRightPower);
            rightBack.setPower(backRightPower);
        }
    }

    public void update() {
        updatePoseEstimate();
    }

}
