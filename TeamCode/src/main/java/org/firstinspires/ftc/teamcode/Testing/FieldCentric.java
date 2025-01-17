package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class FieldCentric extends LinearOpMode {

    double rotX;
    double rotY;
    double rx;
    double x;

    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;

    IMU imu;

    @Override
    public void runOpMode() throws InterruptedException {

         frontLeftMotor =  hardwareMap.get(DcMotor.class, "frontLeftMotor");
         backLeftMotor = hardwareMap.get(DcMotor.class, "backLeftMotor");
         frontRightMotor =  hardwareMap.get(DcMotor.class, "frontRightMotor");
         backRightMotor =  hardwareMap.get(DcMotor.class, "backRightMotor");

        imu = hardwareMap.get(IMU.class, "imu");

        //imu config
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample OpMode

        imu.resetYaw();
        imu.initialize(new IMU.Parameters(orientationOnRobot));



        // Reverse the right side motors. This may be wrong for your setup.
        // If your robot moves backwards when commanded to go forwards,
        // reverse the left side instead.
        // See the note about this earlier on this page.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad1.back) {
                RobotContainer.imuSubsystem.resetHeading();
            }


            double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed


            x = gamepad1.left_stick_x;
            rx = gamepad1.right_stick_x;

            double botHeading = getHeading();

            rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1;  // Counteract imperfect strafing

            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            double frontLeftPower = (rotY + rotX + rx) / denominator;
            double backLeftPower = (rotY - rotX + rx) / denominator;
            double frontRightPower = (rotY - rotX - rx) / denominator;
            double backRightPower = (rotY + rotX - rx) / denominator;

            setMotorPower(1, frontLeftPower, frontRightPower, backLeftPower, backRightPower);
        }

    }
    public void setMotorPower(double maxSpeed, double LFP, double RFP, double LBP, double RBP){


        frontLeftMotor.setPower( Range.clip(LFP,-maxSpeed,maxSpeed));
        frontRightMotor.setPower( Range.clip(RFP,-maxSpeed,maxSpeed));
        backLeftMotor.setPower( Range.clip(LBP,-maxSpeed,maxSpeed));
        backRightMotor.setPower( Range.clip(RBP,-maxSpeed,maxSpeed));
    }

    public double getHeading(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
    public YawPitchRollAngles getYawPitchRoll(){
        return imu.getRobotYawPitchRollAngles();
    }
    public void resetHeading(){
        imu.resetYaw();
    }
}