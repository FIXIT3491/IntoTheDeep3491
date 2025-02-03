package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;

@Autonomous
public class TestingActions extends LinearOpMode {


    IntakeSubsystem intakeSubsystem = new IntakeSubsystem(hardwareMap, telemetry);

    @Override
    public void runOpMode() {

        new IntakeSpinCommand(intakeSubsystem, 0.5);


    }


}