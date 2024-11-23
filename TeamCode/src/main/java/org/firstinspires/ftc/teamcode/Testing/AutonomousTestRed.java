package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class AutonomousTestRed extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(36, 61, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);

        CommandBase.initialize(hardwareMap, telemetry, this);



        TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
                .strafeToLinearHeading(new Vector2d(34.5, 33), Math.toRadians(5)); //drive to spike mark for second sample                .waitSeconds(.75) // wait for wrist to come down
//48 47
        TrajectoryActionBuilder DriveToSecondSpikeMark = drive.actionBuilder(new Pose2d(48, 47, 0))
                .strafeToLinearHeading(new Vector2d(31.5, 41.5), 0); //drive to spike mark for second sample                .waitSeconds(.75) // wait for wrist to come down
        TrajectoryActionBuilder DriveToThirdSpikeMark = drive.actionBuilder(new Pose2d(48, 47, 0))
                .strafeToLinearHeading(new Vector2d(36, 42), 0); //drive to spike mark for second sample                .waitSeconds(.75) // wait for wrist to come down


        Action DriveToSpikeMark2 = DriveToSecondSpikeMark.build();
        Action DriveToSpikeMark1 = DriveToFirstSpikeMark.build();
        Action DriveToSpikeMark3 = DriveToThirdSpikeMark.build();

        waitForStart();
//
//        CommandBase.scoring.scoreBucket(RobotContainer.sparkFunSubsystem.myOtos);
//
//
//
//        CommandBase.drive.imuTurn(90);
//        Actions.runBlocking(DriveToSpikeMark1);

        RobotContainer.extensionSubsystem.bucketHigh();
        RobotContainer.extensionSubsystem.moveExtension(1600);
        sleep(2300);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.spinIntake(-0.7);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension( 120);

        Actions.runBlocking(DriveToSpikeMark1);


//        CommandBase.drive.otosDrive(15, -3.2, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        CommandBase.drive.otosDrive(23, -3.2, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        sleep(500);
//        CommandBase.drive.imuTurn(47);
//        sleep(1000);

        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(400);
        pickupTimer.reset();
        while (pickupTimer.milliseconds() < 1000) {
            if(!CommandBase.pickup.SpikeMarkAuto("blue", telemetry))
                RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();

//        CommandBase.drive.imuTurn(0);


        CommandBase.drive.otosDrive(12, 14, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(48);

        RobotContainer.extensionSubsystem.moveExtension(800);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension(120);
        CommandBase.drive.imuTurn(0);


        Actions.runBlocking(DriveToSpikeMark2);
        RobotContainer.intakeSubsystem.stopIntake();


        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(1000);
        pickupTimer.reset();
        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 1000) {
            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }
        RobotContainer.intakeSubsystem.wristBucket();
        RobotContainer.extensionSubsystem.bucketHigh();

        CommandBase.drive.otosDrive(12, 14, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(45);


        RobotContainer.extensionSubsystem.moveExtension(800);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristMove(0.35);
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.extensionSubsystem.moveExtension(120);
        CommandBase.drive.imuTurn(0);
//
//
//        Actions.runBlocking(DriveToSpikeMark3);
//        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//        sleep(1000);
//        pickupTimer.reset();
//        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 1000) {
//            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
//        }
//        RobotContainer.intakeSubsystem.wristBucket();
//        RobotContainer.extensionSubsystem.bucketHigh();
//
//        CommandBase.drive.otosDrive(12, 14, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        CommandBase.drive.imuTurn(45);
//
//        RobotContainer.extensionSubsystem.moveExtension(800);
//        RobotContainer.intakeSubsystem.wristMove(0.4);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.spinIntake(-0.6);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.wristMove(0.35);
//        RobotContainer.intakeSubsystem.stopIntake();
//        sleep(150);
//        RobotContainer.extensionSubsystem.moveExtension(0);
//        RobotContainer.extensionSubsystem.zero();
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.extensionSubsystem.moveExtension(0);
//        CommandBase.drive.imuTurn(0);

    }
}
