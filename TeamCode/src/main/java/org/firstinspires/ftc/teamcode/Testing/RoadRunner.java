package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class RoadRunner extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(52, 52, 0);

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, initialPose);
        CommandBase.initialize(hardwareMap, telemetry, this);



        TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
                .strafeToConstantHeading(new Vector2d(47, 15.5)); //drive to spike mark for second sample

        TrajectoryActionBuilder PickupFirstSpikeMark = drive.actionBuilder(new Pose2d(47, 15.5,0))
                .strafeToConstantHeading(new Vector2d(50, 15.5)); //drive to spike mark for second sample

        TrajectoryActionBuilder DriveToBucket2 = drive.actionBuilder(new Pose2d(50, 15.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(73,40), 45); // drive to bucket for second sample

        TrajectoryActionBuilder DriveToSecondSpikeMark = drive.actionBuilder(new Pose2d(73, 40, 45))
                .strafeToLinearHeading(new Vector2d(52, 15.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder PickupSecondSpikeMark = drive.actionBuilder(new Pose2d(52, 15.5, 0))
                .strafeToLinearHeading(new Vector2d(58, 15.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder DriveToBucket3 = drive.actionBuilder(new Pose2d(60, 15.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(75,40), 45); // drive to bucket for second sample

        TrajectoryActionBuilder DriveToThirdSpikeMark = drive.actionBuilder(new Pose2d(75, 40, 45))
                .strafeToLinearHeading(new Vector2d(60, 16), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder PickupThirdSpikeMark = drive.actionBuilder(new Pose2d(60, 16, 0))
                .strafeToLinearHeading(new Vector2d(65, 16), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder DriveToBucket4 = drive.actionBuilder(new Pose2d(65, 15.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(75,40), 45); // drive to bucket for second sample



        Action driveToSpikeMark = DriveToFirstSpikeMark.build();
        Action pickupSpikeMark = PickupFirstSpikeMark.build();
        Action driveToBucket2 = DriveToBucket2.build();
        Action driveToSecondSpikeMark = DriveToSecondSpikeMark.build();
        Action pickupSecondSpikeMark = PickupSecondSpikeMark.build();
        Action driveToBucket3 = DriveToBucket3.build();
        Action driveToThirdSpikeMark = DriveToThirdSpikeMark.build();
        Action pickupThirdSpikeMark = PickupThirdSpikeMark.build();
        Action driveToBucket4 = DriveToBucket4.build();

        waitForStart();

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

        Actions.runBlocking(driveToSpikeMark);
        RobotContainer.intakeSubsystem.wristDown();
        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
        sleep(400);
        Actions.runBlocking(pickupSpikeMark);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();


        Actions.runBlocking(driveToBucket2);
        RobotContainer.extensionSubsystem.moveExtension(600);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension(120);

        Actions.runBlocking(driveToSecondSpikeMark);
        RobotContainer.intakeSubsystem.wristDown();
        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
        sleep(400);
        Actions.runBlocking(pickupSecondSpikeMark);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();


        Actions.runBlocking(driveToBucket3);
        RobotContainer.extensionSubsystem.moveExtension(600);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension(120);

        Actions.runBlocking(driveToThirdSpikeMark);
        RobotContainer.intakeSubsystem.wristDown();
        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
        sleep(400);
        Actions.runBlocking(pickupThirdSpikeMark);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.bucketHigh();

        Actions.runBlocking(driveToBucket4);
        RobotContainer.extensionSubsystem.moveExtension(600);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.6);
        sleep(1000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(150);
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension(120);
        RobotContainer.extensionSubsystem.moveExtension(0);



    }

}
