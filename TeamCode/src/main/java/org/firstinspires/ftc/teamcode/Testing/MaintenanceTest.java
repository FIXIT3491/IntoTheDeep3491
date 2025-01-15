package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Pickup;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp(name="MaintenaceTest", group = "TeleOp")
public class MaintenanceTest extends LinearOpMode {

    boolean locked;
    double rotX;
    int pos = 0;
    double rotY;
    double rx;
    double x;

    @Override
    public void runOpMode(){


        if (gamepad1.right_trigger > 0){
            RobotContainer.extensionSubsystem.moveExtension(1600);
        }

        if (gamepad1.left_trigger > 0){
            RobotContainer.extensionSubsystem.raiseLift(4300);
        }

        if (gamepad1.left_bumper){
            RobotContainer.intakeSubsystem.wristDown();
        }

        if (gamepad1.right_bumper){
            RobotContainer.intakeSubsystem.wristUp();
        }

    }
    public void lmecCommands(Gamepad gamepad1) {

    }

    public void fieldCentricDrive(Gamepad gamepad1, Gamepad gamepad2,  Telemetry telemetry) {
        if (gamepad1.back) {
            RobotContainer.imuSubsystem.resetHeading();
        }

        if (gamepad1.a) {
            locked = true;
//            RobotContainer.lmecSubsystem.lockMechanum();
        } else if (gamepad1.b) {
            locked = false;
//            RobotContainer.lmecSubsystem.unlockMechanum();
        }

        if (locked) {
            double max;

            // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
            double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x;

            // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower = axial;
            double rightFrontPower = axial;
            double leftBackPower = axial;
            double rightBackPower = axial;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower /= max;
                rightFrontPower /= max;
                leftBackPower /= max;
                rightBackPower /= max;
            }
            RobotContainer.driveSubsystem.setMotorPower(1, leftFrontPower, rightFrontPower, leftBackPower, rightBackPower);
        } else {

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
        }
    }
}