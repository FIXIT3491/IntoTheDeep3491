package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class TeleOp {
    int pos = 0;
    boolean locked;
    double rotX;
    double rotY;
    double rx;
    double x;


    public TeleOp(Telemetry telemetry) {

    }
    public void intake(Gamepad gamepad1,Gamepad gamepad2, Telemetry telemetry){
        if (gamepad2.right_trigger > 0 || gamepad1.right_trigger > 0){
            CommandBase.pickup.SpikeMarkAuto("Blue",telemetry);
        }else if (gamepad2.left_trigger > 0){
            RobotContainer.intakeSubsystem.wristBucket();
            RobotContainer.intakeSubsystem.spinIntake(-0.2);
        }
        else
            RobotContainer.intakeSubsystem.stopIntake();

        if (gamepad2.right_trigger > 0){

        }
        else if (gamepad2.left_bumper)
            RobotContainer.intakeSubsystem.spinIntake(-0.2);
        else {
            RobotContainer.intakeSubsystem.stopIntake();
        }


    }
    public void wrist (Gamepad gamepad2){

        if (gamepad2.right_trigger > 0){
            //do nothing cause pickup method will set instead
        }else if (gamepad2.left_trigger > 0) {
            RobotContainer.intakeSubsystem.wristBucket();
        } else {
            RobotContainer.intakeSubsystem.wristUp();

        }
    }
    public void extensionCommands(Gamepad gamepad2) {
        if (RobotContainer.extensionSubsystem.getTouchSensor()){
            RobotContainer.extensionSubsystem.liftReset();
        }
        if (gamepad2.x) {
            RobotContainer.extensionSubsystem.bucketLow();
        }
        if (gamepad2.b) {
            RobotContainer.extensionSubsystem.bucketHigh();
        }
        if (gamepad2.a){
            RobotContainer.extensionSubsystem.zero();
        }
        pos = pos + (int) (-gamepad2.right_stick_y * 30);
        pos = Range.clip(pos, Constants.MIN_EXTENSION, Constants.MAX_EXTENSION);

        RobotContainer.extensionSubsystem.moveExtension(pos);
    }

    public void lmecCommands(Gamepad gamepad1) {

    }

    public void fieldCentricDrive(Gamepad gamepad1, Gamepad gamepad2,  Telemetry telemetry) {
        if (gamepad1.a) {
            locked = true;
            RobotContainer.lmecSubsystem.lockMechanum();
        } else if (gamepad1.b) {
            locked = false;
            RobotContainer.lmecSubsystem.unlockMechanum();
        }

        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed


        if (locked) {
            x = 0;
            rx = 0;
        }else {
            x = gamepad1.left_stick_x;
            rx = gamepad1.right_stick_x;
        }

        double botHeading = RobotContainer.imuSubsystem.getHeading();

        rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1;  // Counteract imperfect strafing

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;



        if (gamepad1.left_trigger > 0 || gamepad1.right_trigger > 0) {
            RobotContainer.driveSubsystem.setMotorPower(0.3, frontLeftPower, frontRightPower, backLeftPower, backRightPower);
        }
        else { //slow button
            RobotContainer.driveSubsystem.setMotorPower(1, frontLeftPower, frontRightPower, backLeftPower, backRightPower);
        }
    }
}
