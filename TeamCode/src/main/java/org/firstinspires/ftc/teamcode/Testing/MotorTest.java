package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;

@Autonomous(name="TestingActions", group="02")
public class MotorTest extends LinearOpMode {

//    public ColorRangeSensor colorSensor;
    @Override
    public void runOpMode() {
//        colorSensor = hardwareMap.get(ColorRangeSensor.class, "color");
//        extension = hardwareMap.get(DcMotorEx.class, "e")
        SlideSubsystem slides = new SlideSubsystem(hardwareMap, telemetry);

        waitForStart();

        while (opModeIsActive()) {
            telemetry.addData("color", slides.getExtensionPos());
            telemetry.update();

            slides.moveExtension(slides.getExtensionPos() + 4);
        }
    }

}