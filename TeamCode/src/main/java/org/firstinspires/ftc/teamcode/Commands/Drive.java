package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;



public class Drive {

    private LinearOpMode op;
    private SparkFunOTOSConfig.Pose2D pos;


    public Drive(LinearOpMode op, Telemetry telemetry){

        this.op = op;
    }

    public Drive(Telemetry telemetry) {

    }


    public void otosDrive(double targetX, double targetY, double targetHeading, SparkFunOTOSConfig myOtos ) {
        final double SPARKFUN_SPEED_GAIN =  0.045  ;   // 0.02 Forward Speed Control "Gain". eg: Ramp up to 50% power at a 25 inch error.   (0.50 / 25.0)
        final double SPARKFUN_STRAFE_GAIN =  0.25;   // 0.015 Strafe Speed Control "Gain".  eg: Ramp up to 25% power at a 25 degree Yaw error.   (0.25 / 25.0)
        final double SPARKFUN_TURN_GAIN =  0.06  ;   // 0.01 Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)

        final double SPARKFUN_MAX_AUTO_SPEED = 0.5;   //  Clip the approach speed to this max value (adjust for your robot)
        final double SPARKFUN_MAX_AUTO_STRAFE = 0.5;   //  Clip the approach speed to this max value (adjust for your robot)
        final double SPARKFUN_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

        double drive, strafe, turn;
        double currentRange, targetRange, initialBearing, targetBearing, xError, yError, yawError;
        double opp, adj;

        SparkFunOTOSConfig.Pose2D currentPos = RobotContainer.sparkFunSubsystem.myPosition();
        xError = targetX-currentPos.x;
        yError = targetY-currentPos.y;
        yawError = targetHeading-currentPos.h;


        while(op.opModeIsActive() && ((Math.abs(xError) > 0.87) || (Math.abs(yError) > 0.75)
                || (Math.abs(yawError) > 4)) ) {
            // Use the speed and turn "gains" to calculate how we want the robot to move.
            drive  = Range.clip(xError * SPARKFUN_SPEED_GAIN, -SPARKFUN_MAX_AUTO_SPEED, SPARKFUN_MAX_AUTO_SPEED);
            strafe = Range.clip(yError * SPARKFUN_STRAFE_GAIN, -SPARKFUN_MAX_AUTO_STRAFE, SPARKFUN_MAX_AUTO_STRAFE);
            turn   = Range.clip(yawError * SPARKFUN_TURN_GAIN, -SPARKFUN_MAX_AUTO_TURN, SPARKFUN_MAX_AUTO_TURN) ;

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
            RobotContainer.driveSubsystem.moveRobotSparkfun(drive, strafe, turn);

            // then recalc error
            currentPos = RobotContainer.sparkFunSubsystem.myPosition();
            xError = targetX-currentPos.x;
            yError = targetY-currentPos.y;
            yawError = targetHeading-currentPos.h;
        }
        RobotContainer.driveSubsystem.moveRobotSparkfun(0,0,0);
        currentPos = RobotContainer.sparkFunSubsystem.myPosition();
        op.telemetry.addData("current X coordinate", currentPos.x);
        op.telemetry.addData("current Y coordinate", currentPos.y);
        op.telemetry.addData("current Heading angle", currentPos.h);
        op.telemetry.update();
    }
    public void imuTurn(double heading) {

        final double IMU_TURN_GAIN =  0.040  ;   //  Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)
        final double IMU_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

        YawPitchRollAngles orientation;
        double turn, headingError;

        orientation = RobotContainer.driveSubsystem.imu.getRobotYawPitchRollAngles();
        headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);

        while(Math.abs(headingError) > 5/* && opModeIsActive()*/) {  // just guessing that heading error of 3 is close enough

            orientation = RobotContainer.driveSubsystem.imu.getRobotYawPitchRollAngles();
            headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);
            turn   = Range.clip(headingError * IMU_TURN_GAIN, -IMU_MAX_AUTO_TURN, IMU_MAX_AUTO_TURN);
            RobotContainer.driveSubsystem.moveRobot(0, 0, turn);
            op.sleep(10);

        }
        RobotContainer.driveSubsystem.moveRobot(0, 0, 0);  // stop motors when turn done
    }


}
