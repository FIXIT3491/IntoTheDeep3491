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
        DriveFL = hardwareMap.get(DcMotorEx.class, "frontL");
        DriveFR = hardwareMap.get(DcMotorEx.class, "frontR");
        DriveBL = hardwareMap.get(DcMotorEx.class, "backL");
        DriveBR = hardwareMap.get(DcMotorEx.class, "backR");

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
        telemetry.addData("tacooooooo", 1);
    }

    // Other driving-related methods can go here
}
