package org.firstinspires.ftc.teamcode.Robot.Subsystems;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class DriveSubsystem{
    // Add motors, sensors, etc. here
    private DcMotorEx DriveFL, DriveFR, DriveBL, DriveBR;
    private Telemetry telemetry;

    public IMU imu;



    public DriveSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        //drive motor hardware maps
        DriveFL = hardwareMap.get(DcMotorEx.class, "FLD");
        DriveBL = hardwareMap.get(DcMotorEx.class, "BLD");
        DriveFR = hardwareMap.get(DcMotorEx.class, "FRD");
        DriveBR = hardwareMap.get(DcMotorEx.class, "BRD");
        //imu hardware maps
        imu = hardwareMap.get(IMU.class, "imu");


        //imu config
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.RIGHT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample OpMode

        imu.resetYaw();
        imu.initialize(new IMU.Parameters(orientationOnRobot));

        //Direction Motors
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

    public void moveRobotSparkfun(double x, double y, double yaw) {

        // Calculate wheel powers.
        double leftFrontPower    =  x +y +yaw;
        double rightFrontPower   =  x -y -yaw;
        double leftBackPower     =  x -y +yaw;
        double rightBackPower    =  x +y -yaw;

        // Normalize wheel powers to be less than 1.0
        double max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }

        // Send powers to the wheels.
        DriveFL.setPower(leftFrontPower);
        DriveFR.setPower(rightFrontPower);
        DriveBL.setPower(leftBackPower);
        DriveBR.setPower(rightBackPower);
    }

    public void moveRobot(double x, double y, double yaw) {
        // Calculate wheel powers.
        double leftFrontPower    =  x -y -yaw;
        double rightFrontPower   =  x +y +yaw;
        double leftBackPower     =  x +y -yaw;
        double rightBackPower    =  x -y +yaw;

        // Normalize wheel powers to be less than 1.0
        double max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
        max = Math.max(max, Math.abs(leftBackPower));
        max = Math.max(max, Math.abs(rightBackPower));

        if (max > 1.0) {
            leftFrontPower /= max;
            rightFrontPower /= max;
            leftBackPower /= max;
            rightBackPower /= max;
        }

        // Send powers to the wheels.
        DriveFL.setPower(leftFrontPower);
        DriveFR.setPower(rightFrontPower);
        DriveBL.setPower(leftBackPower);
        DriveBR.setPower(rightBackPower);
    }




    // Drive method
    public void go(double leftPower, double rightPower) {
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
    }

    // Other driving-related methods can go here
}
