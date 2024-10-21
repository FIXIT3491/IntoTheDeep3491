package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class TeleOp {
    public TeleOp(Telemetry telemetry) {


    }
//    public void extensionCommands()

    public void fieldCentricDrive(double y, double x, double rx, double left_trigger, double right_trigger, Telemetry telemetry){

        double botHeading = RobotContainer.imuSubsystem.getHeading();

        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;  // Counteract imperfect strafing

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = (rotY + rotX + rx) / denominator;
        double backLeftPower = (rotY - rotX + rx) / denominator;
        double frontRightPower = (rotY - rotX - rx) / denominator;
        double backRightPower = (rotY + rotX - rx) / denominator;
        if (left_trigger > 0 || right_trigger > 0) {
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
