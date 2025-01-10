package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp

public class swyftSlideTest extends LinearOpMode {

     DcMotor left;
     DcMotor right;
     DcMotor horizontal;

    @Override
    public void runOpMode() throws InterruptedException {

    left = hardwareMap.get(DcMotorEx.class, "left");
    right = hardwareMap.get(DcMotorEx.class, "right");
    horizontal = hardwareMap.get(DcMotorEx.class, "horizontal");

    waitForStart();

    while (opModeIsActive()){

            left.setPower(gamepad1.left_stick_y);
            right.setPower(gamepad1.right_stick_y);
            horizontal.setPower(gamepad1.left_trigger);

    }


    }



}
