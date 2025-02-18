package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

@TeleOp(name="field centric test", group="02")
public class AxonTest extends Robot {
    Servo servoFront;
    Servo servoBack;

    AnalogInput analogInput;
    public DcMotorEx leftFront, leftBack, rightBack, rightFront;

    public IMU imu;

    @Override
    public void runOpMode() {


        leftFront = hardwareMap.get(DcMotorEx.class, "FLD");
        leftBack = hardwareMap.get(DcMotorEx.class, "BLD");
        rightBack = hardwareMap.get(DcMotorEx.class, "BRD");
        rightFront = hardwareMap.get(DcMotorEx.class, "FRD");
        imu = hardwareMap.get(IMU.class, "imu");


        leftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {


            double headingRads = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);


            double gamepadX = gamepad1.left_stick_x;
            double gamepadY = gamepad1.left_stick_y;
            double  gamepadRX = gamepad1.right_stick_x;

//        double rotX = gamepadY * Math.cos(-headingRads) + gamepadX * Math.sin(-headingRads);
//
//        double rotY = gamepadY * Math.sin(-headingRads) - gamepadX * Math.cos(-headingRads);
            double rotX = gamepadX * Math.cos(-headingRads) - gamepadY * Math.sin(-headingRads);
            double rotY = gamepadX * Math.sin(-headingRads) + gamepadY * Math.cos(-headingRads);


            double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(gamepadRX), 1);
            double frontLeftPower = (rotY + rotX + gamepadRX) / denominator;
            double backLeftPower = (rotY - rotX + gamepadRX) / denominator;
            double frontRightPower = (rotY - rotX - gamepadRX) / denominator;
            double backRightPower = (rotY + rotX - gamepadRX) / denominator;
            if (!(Double.valueOf(frontLeftPower).isNaN() ||
                    Double.valueOf(backLeftPower).isNaN() ||
                    Double.valueOf(frontRightPower).isNaN() ||
                    Double.valueOf(backRightPower).isNaN())) {


                leftFront.setPower(frontLeftPower);
                leftBack.setPower(backLeftPower);
                rightFront.setPower(frontRightPower);
                rightBack.setPower(backRightPower);
        }

    }
}
    }