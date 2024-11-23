package org.firstinspires.ftc.teamcode.Commands;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;



public class Drive {

    private LinearOpMode op;
    private SparkFunOTOSConfig.Pose2D pos;
    private MecanumDrive drive;

    public DcMotor DriveFR;
    public DcMotor DriveFL;
    public DcMotor DriveBR;
    public DcMotor DriveBL;


    public Drive(LinearOpMode op, Telemetry telemetry){

        this.op = op;
    }

    public Drive(Telemetry telemetry) {

    }


    public void otosDrive(double targetx, double targetY, double targetHeading, SparkFunOTOSCorrected myOtos ) {
        double targetX = targetx/1.1;
        double drive, strafe, turn;
        double currentRange, targetRange, initialBearing, targetBearing, xError, yError, yawError;
        double opp, adj;

        SparkFunOTOSCorrected.Pose2D currentPos = RobotContainer.sparkFunSubsystem.myPosition();
        xError = targetX-currentPos.x;
        yError = targetY-currentPos.y;
        yawError = targetHeading-currentPos.h;


        while(op.opModeIsActive() && ((Math.abs(xError) > 0.87) || (Math.abs(yError) > 0.75)) ) {
            // Use the speed and turn "gains" to calculate how we want the robot to move.
            drive  = Range.clip(xError * Constants.SPARKFUN_SPEED_GAIN, -Constants.SPARKFUN_MAX_AUTO_SPEED, Constants.SPARKFUN_MAX_AUTO_SPEED);
            strafe = Range.clip(yError * Constants.SPARKFUN_STRAFE_GAIN, -Constants.SPARKFUN_MAX_AUTO_STRAFE, Constants.SPARKFUN_MAX_AUTO_STRAFE);
            turn   = Range.clip(yawError * Constants.SPARKFUN_TURN_GAIN, -Constants.SPARKFUN_MAX_AUTO_TURN, Constants.SPARKFUN_MAX_AUTO_TURN) ;

            op.telemetry.addData("Auto","Drive %5.2f, Strafe %5.2f, Turn %5.2f ", drive, strafe, turn);
            // current x,y swapped due to 90 degree rotation
            op.telemetry.addData("current X coordinate", currentPos.x);
            op.telemetry.addData("current Y coordinate", currentPos.y);
            op.telemetry.addData("current Heading angle", currentPos.h);
            op.telemetry.addData("target X coordinate", targetX);
            op.telemetry.addData("target Y coordinate", targetY);
            op.telemetry.addData("target Heading angle", targetHeading);
            op.telemetry.addData("xError", xError);
            op.telemetry.addData("yError", yError);
            op.telemetry.addData("yawError", yawError);
            op.telemetry.update();

            // Apply desired axes motions to the drivetrain.
            RobotContainer.driveSubsystem.moveRobotSparkfun(drive, strafe, 0);

            // then recalc error
            currentPos = RobotContainer.sparkFunSubsystem.myPosition();
            xError = targetX-currentPos.x;
            yError = targetY-currentPos.y;
//            yawError = targetHeading-currentPos.h;
        }
        RobotContainer.driveSubsystem.moveRobotSparkfun(0,0,0);

        currentPos = RobotContainer.sparkFunSubsystem.myPosition();
        op.telemetry.addData("current X coordinate", currentPos.x);
        op.telemetry.addData("current Y coordinate", currentPos.y);
        op.telemetry.addData("current Heading angle", currentPos.h);
        op.telemetry.update();
    }
    public void driveForwards(){
        DriveFL = hardwareMap.get(DcMotor.class, "FLD");
        DriveBL = hardwareMap.get(DcMotor.class, "BLD");
        DriveFR = hardwareMap.get(DcMotor.class, "FRD");
        DriveBR = hardwareMap.get(DcMotor.class, "BRD");

        DriveFL.setDirection(DcMotor.Direction.REVERSE);
        DriveBL.setDirection(DcMotor.Direction.REVERSE);
        DriveFR.setDirection(DcMotor.Direction.FORWARD);
        DriveBR.setDirection(DcMotor.Direction.FORWARD);

        //brake on zero
        DriveFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    public void imuTurn(double heading) {

        YawPitchRollAngles orientation;
        double turn, headingError;

        orientation = RobotContainer.imuSubsystem.getYawPitchRoll();
        headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);

        while(Math.abs(headingError) > 5/* && opModeIsActive()*/) {  // just guessing that heading error of 3 is close enough

            orientation = RobotContainer.imuSubsystem.getYawPitchRoll();
            headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);
            turn   = Range.clip(headingError * Constants.IMU_TURN_GAIN, -Constants.IMU_MAX_AUTO_TURN, Constants.IMU_MAX_AUTO_TURN);
            RobotContainer.driveSubsystem.moveRobot(0, 0, turn);
            op.sleep(10);

        }
        RobotContainer.driveSubsystem.moveRobot(0, 0, 0);  // stop motors when turn done
    }


}
