package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class SpecimenTest extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {

        CommandBase.initialize(hardwareMap, telemetry, this);

        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.spinIntake(0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.stopIntake();

        waitForStart();

        RobotContainer.driveSubsystem.setMotorPower(1, 0.7, 0.7, 0.7, 0.7);
        sleep(500);
        RobotContainer.extensionSubsystem.chamberHigh();
        RobotContainer.driveSubsystem.setMotorPower(0.3, 0.2, 0.2, 0.2, 0.2);
        sleep(300);
        RobotContainer.extensionSubsystem.raiseLift(1800);
        RobotContainer.driveSubsystem.setMotorPower(0.3, -0.2, -0.2, -0.2, -0.2);
        sleep(700);
        RobotContainer.extensionSubsystem.raiseLift(0);
        RobotContainer.intakeSubsystem.wristUp();
        //Move to right to park

    }
    }