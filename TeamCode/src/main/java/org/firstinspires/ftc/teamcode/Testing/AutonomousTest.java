package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class AutonomousTest extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap, telemetry, this);

        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.spinIntake(0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.stopIntake();

//        RobotContainer.intakeSubsystem.spinIntake(-0.5);

        waitForStart();
//
        CommandBase.scoring.scoreBucket(RobotContainer.sparkFunSubsystem.myOtos);
//
//
//
//        CommandBase.drive.otosDrive(15, -3.2, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.otosDrive(23, -3.2, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        sleep(500);
        CommandBase.drive.imuTurn(41);
//        sleep(1000);

        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(400);
        pickupTimer.reset();
        while (pickupTimer.milliseconds() < 2000) {
            if(!CommandBase.pickup.SpikeMarkAuto("blue", telemetry))
                RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);


        CommandBase.drive.otosDrive(11, -16, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.otosDrive(Constants.BUCKET_X, Constants.BUCKET_Y, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(141);
        RobotContainer.intakeSubsystem.wristBucket();
        sleep(200);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(250);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);

        CommandBase.drive.otosDrive(30, -9.25, 0, RobotContainer.sparkFunSubsystem.myOtos);

        CommandBase.drive.imuTurn(90);



        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(1000);
        pickupTimer.reset();
        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 2000) {
            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);


        CommandBase.drive.otosDrive(11, -15, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.otosDrive(Constants.BUCKET_X, Constants.BUCKET_Y, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(141);
        RobotContainer.intakeSubsystem.wristBucket();
        sleep(200);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(250);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(153);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(11, -15, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        CommandBase.drive.otosDrive(35.5, -19, 0, RobotContainer.sparkFunSubsystem.myOtos);
    }
}
