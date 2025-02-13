package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

@Autonomous(name="TestingActions", group="02")
public class TestingActions extends LinearOpMode {


    IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap, telemetry);

    @Override
    public void runOpMode() {

        new IntakeSpinCommand(intakeSubsystem, 0.5);


    }


}