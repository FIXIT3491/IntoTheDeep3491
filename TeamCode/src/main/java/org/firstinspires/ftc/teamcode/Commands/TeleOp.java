package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class TeleOp {
    int pos = 0;
    boolean locked;
    double rotX;
    double rotY;
    double rx;
    double x;
    public int extensionPos = 0;
    boolean extensionDown;

    public TeleOp(Telemetry telemetry) {

    }
    public void intake(Gamepad gamepad1,Gamepad gamepad2, Telemetry telemetry){
        if (gamepad1.right_trigger > 0){
            CommandBase.pickup.SpikeMarkAuto("Blue",telemetry);
        }else if (gamepad2.left_trigger > 0 || gamepad1.left_trigger > 0){
            RobotContainer.intakeSubsystem.wristBucket();
//            RobotContainer.intakeSubsystem.spinIntake(-0.5);
        }
        else
            RobotContainer.intakeSubsystem.stopIntake();

        if (gamepad1.right_trigger > 0){
        }
        else if (gamepad2.left_bumper)
            RobotContainer.intakeSubsystem.spinIntake(-0.4);
        else {
            RobotContainer.intakeSubsystem.stopIntake();
        }


    }
    public void wrist (Gamepad gamepad2, Gamepad gamepad1){

        if (gamepad2.right_trigger > 0){
            //do nothing cause pickup method will set instead
        }else if (gamepad2.left_trigger > 0 || gamepad1.left_trigger > 0) {
            RobotContainer.intakeSubsystem.wristBucket();
        } else {
            RobotContainer.intakeSubsystem.wristUp();

        }
    }
    public void extensionCommands(Gamepad gamepad2) {

        if (gamepad2.a) {
            if (!RobotContainer.extensionSubsystem.getTouchSensor()) {
                RobotContainer.extensionSubsystem.extenderRetract(-0.01);
            } else
                RobotContainer.extensionSubsystem.liftZero();

        } else if (gamepad2.x) {
            RobotContainer.extensionSubsystem.bucketLow();
        } else if (gamepad2.b) {
            RobotContainer.extensionSubsystem.bucketHigh();
        }
        else if(RobotContainer.extensionSubsystem.getTouchSensor()){
//            RobotContainer.extensionSubsystem.moveLiftRight(0.2);
        }
//        if (RobotContainer.extensionSubsystem.getRightLift() < 0)
//            RobotContainer.extensionSubsystem.moveLiftRight(0.4);
//        else
//            RobotContainer.extensionSubsystem.moveLiftRight(0);

        if (RobotContainer.extensionSubsystem.getTouchSensor()){
            RobotContainer.extensionSubsystem.liftZero();
        }

        pos = pos + (int) (-gamepad2.right_stick_y * 90);
        pos = Range.clip(pos, Constants.MIN_EXTENSION, Constants.MAX_EXTENSION);


        RobotContainer.extensionSubsystem.moveExtension(pos);
    }

    public void lmecCommands(Gamepad gamepad1) {

    }

    public void fieldCentricDrive(Gamepad gamepad1, Gamepad gamepad2,  Telemetry telemetry) {
        if (gamepad1.back){
            RobotContainer.imuSubsystem.resetHeading();
        }

        if (gamepad1.a) {
            locked = true;
            RobotContainer.lmecSubsystem.lockMechanum();
        } else if (gamepad1.b) {
            locked = false;
            RobotContainer.lmecSubsystem.unlockMechanum();
        }

        if (locked){
            double max;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial;
            double rightFrontPower = axial;
            double leftBackPower   = axial;
            double rightBackPower  = axial;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }
            RobotContainer.driveSubsystem.setMotorPower(1, leftFrontPower, rightFrontPower, leftBackPower, rightBackPower);
        }
        else {

            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed


            x = gamepad1.left_stick_x;
            rx = gamepad1.right_stick_x;

            double botHeading = RobotContainer.imuSubsystem.getHeading();

            rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1;  // Counteract imperfect strafing

            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;


                RobotContainer.driveSubsystem.setMotorPower(1, frontLeftPower, frontRightPower, backLeftPower, backRightPower);

        }
    }
}
