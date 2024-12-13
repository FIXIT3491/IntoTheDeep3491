package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class SpecimenTest extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();

    @Override
    public void runOpMode() {

        CommandBase.initialize(hardwareMap, telemetry, this);

        /*RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.spinIntake(0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.stopIntake(); */

        waitForStart();


        RobotContainer.driveSubsystem.setMotorPower(0.7, -0.6, -0.6, -0.6, -0.6);
        sleep(800);
        RobotContainer.driveSubsystem.setMotorPower(0.0, 0, 0, 0, 0);
        sleep(50);
        RobotContainer.extensionSubsystem.chamberHigh();
        sleep(2200);
        RobotContainer.driveSubsystem.setMotorPower(0.3, -0.2, -0.2, -0.2, -0.2);
        sleep(500);
        RobotContainer.extensionSubsystem.raiseLift(0);
        sleep(50);
        RobotContainer.driveSubsystem.setMotorPower(0.3, 0.3, 0.3, 0.3, 0.3);
        sleep(1000);
        CommandBase.drive.imuTurn(90);
        sleep(100);
        RobotContainer.driveSubsystem.setMotorPower(0.8, 0.7, 0.7, 0.7, 0.7);
        sleep(1200);
        CommandBase.drive.imuTurn(180);
        sleep(100);
        RobotContainer.driveSubsystem.setMotorPower(0.3, -0.3, -0.3, -0.3, -0.3);
        sleep(650);


    }
    }