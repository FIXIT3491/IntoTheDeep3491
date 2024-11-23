package org.firstinspires.ftc.teamcode.Robot.Subsystems;


import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;


import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;


public class DriveSubsystem{
    // Add motors, sensors, etc. here
    private DcMotorEx DriveFL, DriveFR, DriveBL, DriveBR;
    private Telemetry telemetry;





    public DriveSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        //drive motor hardware maps
        DriveFL = hardwareMap.get(DcMotorEx.class, "FLD");
        DriveBL = hardwareMap.get(DcMotorEx.class, "BLD");
        DriveFR = hardwareMap.get(DcMotorEx.class, "FRD");
        DriveBR = hardwareMap.get(DcMotorEx.class, "BRD");
        //imu hardware maps

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
        double leftFrontPower = x - y - yaw;
        double rightFrontPower = x + y + yaw;
        double leftBackPower = x + y - yaw;
        double rightBackPower = x - y + yaw;

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

    public void setMotorPower(double maxSpeed, double LFP, double RFP, double LBP, double RBP){


        DriveFL.setPower( Range.clip(LFP,-maxSpeed,maxSpeed));
        DriveFR.setPower( Range.clip(RFP,-maxSpeed,maxSpeed));
        DriveBL.setPower( Range.clip(LBP,-maxSpeed,maxSpeed));
        DriveBR.setPower( Range.clip(RBP,-maxSpeed,maxSpeed));
    }
    public void getTelemetry(Telemetry telemetry){
        telemetry.addData("back right power",DriveBR.getPower());
        telemetry.addData("back left power",DriveBL.getPower());
        telemetry.addData("front right power",DriveFR.getPower());
        telemetry.addData("front left power",DriveFL.getPower());
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
