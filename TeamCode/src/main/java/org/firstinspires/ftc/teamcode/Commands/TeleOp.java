package org.firstinspires.ftc.teamcode.Commands;


import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class TeleOp {
    int pos = 0;

    public TeleOp(Telemetry telemetry) {

    }
    public void intake(Gamepad gamepad2, Telemetry telemetry){
        if (gamepad2.right_trigger > 0){
            CommandBase.pickup.SpikeMarkAuto("Blue",telemetry);
        }
    }
    public void wrist (Gamepad gamepad2){
        if (gamepad2.right_trigger > 0){
            //do nothing cause pickup method will set instead
        }else if (gamepad2.left_trigger > 0) {
            RobotContainer.intakeSubsystem.wristChamber();
        } else {
            RobotContainer.intakeSubsystem.wristUp();
        }
    }
    public void extensionCommands(Gamepad gamepad2) {
        if (gamepad2.a) {
            RobotContainer.extensionSubsystem.chamberLow();
        }
        if (gamepad2.b) {
            RobotContainer.extensionSubsystem.bucketLow();
        }
        if (gamepad2.x) {
            RobotContainer.extensionSubsystem.chamberHigh();
        }
        if (gamepad2.y) {
            RobotContainer.extensionSubsystem.bucketHigh();
        }
        pos = pos + (int) (gamepad2.right_stick_y * 12);
        Range.clip(pos, Constants.MIN_EXTENSION, Constants.MAX_EXTENSION);

        RobotContainer.extensionSubsystem.moveExtension(pos);
    }

    public void lmecCommands(Gamepad gamepad1) {
        if (gamepad1.a) {
            RobotContainer.lmecSubsystem.lockMechanum();

        }
        else if (gamepad1.b){
            RobotContainer.lmecSubsystem.unlockMechanum();

        }


    }

    public void fieldCentricDrive(Gamepad gamepad1, Gamepad gamepad2,  Telemetry telemetry){

        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        double botHeading = RobotContainer.imuSubsystem.getHeading();

        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

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

        telemetry.addData("Front leftMotor", "#4.2f", frontLeftPower);
        telemetry.addData("Back leftMotor", "#4.2f", backLeftPower);
        telemetry.addData("Front rightMotor", "#4.2f", frontRightPower);
        telemetry.addData("Back rightMotor", "#4.2f", backRightPower);

//        telemetry.addData("Launcher Position", ch.launcher.getPosition());
//        telemetry.addData("arm position", ch.shoulder.getCurrentPosition());
//        telemetry.addData("right pincer", ch.rightPincer.getPosition());
//        telemetry.addData("left pincer", ch.leftPincer.getPosition());
//        telemetry.addData("left pincer", pickupTime.milliseconds());
        telemetry.update();
    }
}
