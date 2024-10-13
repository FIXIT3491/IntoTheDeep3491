package org.firstinspires.ftc.teamcode.Robot;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DriveSubsystem {
    // Add motors, sensors, etc. here
    private DcMotorEx DriveFL, DriveFR, DriveBL, DriveBR;
    private Telemetry telemetry;


    public DriveSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        DriveFL = hardwareMap.get(DcMotorEx.class, "FLD");
        DriveBL = hardwareMap.get(DcMotorEx.class, "BLD");
        DriveFR = hardwareMap.get(DcMotorEx.class, "FRD");
        DriveBR = hardwareMap.get(DcMotorEx.class, "BRD");

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


    // Drive method
    public void go(double leftPower, double rightPower) {
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
        DriveBR.setPower(10000);
    }

    // Other driving-related methods can go here
}
