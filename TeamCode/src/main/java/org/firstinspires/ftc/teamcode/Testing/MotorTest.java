package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;

@Autonomous(name="TestingActions", group="02")
public class MotorTest extends LinearOpMode {

    private DcMotor liftMotorRight;
    private DcMotor liftMotorLeft;

    @Override
    public void runOpMode() {
        liftMotorRight = hardwareMap.get(DcMotor.class, "liftRight");
        liftMotorLeft = hardwareMap.get(DcMotor.class, "liftLeft");

        liftMotorLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.a) {
                liftMotorLeft.setPower(1);
                liftMotorRight.setPower(1);
            }
            if (gamepad1.b){
                liftMotorLeft.setPower(-1);
                liftMotorRight.setPower(-1);
            }
        }
    }

}