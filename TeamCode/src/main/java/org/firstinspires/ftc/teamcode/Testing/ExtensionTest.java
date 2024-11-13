package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous

public class ExtensionTest extends LinearOpMode {
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotorRight;
    private DcMotorEx liftMotorLeft;
    private TouchSensor touchSensor;


    @Override
    public void runOpMode() {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");
        liftMotorRight = hardwareMap.get(DcMotorEx.class, "liftRight");
        liftMotorLeft = hardwareMap.get(DcMotorEx.class, "liftLeft");
        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");

        liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorLeft.setDirection(DcMotor.Direction.REVERSE);
//        liftMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        extensionMotor.setDirection(DcMotor.Direction.REVERSE);
        extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RobotContainer.initialize(hardwareMap, telemetry);
        RobotContainer.extensionSubsystem.encoderReset();

        waitForStart();

        liftMotorRight.setTargetPosition(1000);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorRight.setPower(1);
        liftMotorLeft.setTargetPosition(1000);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorLeft.setPower(1);
    }
}
