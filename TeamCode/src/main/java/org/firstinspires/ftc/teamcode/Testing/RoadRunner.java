package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Intake;
import org.firstinspires.ftc.teamcode.Commands.Lift;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class RoadRunner extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(52, 52, 0);

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, initialPose);
        Lift lift = new Lift(hardwareMap);
//        CommandBase.initialize(hardwareMap, telemetry, this);



        TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
                .strafeToConstantHeading(new Vector2d(48, 12.5)); //drive to spike mark for second sample

        TrajectoryActionBuilder PickupFirstSpikeMark = drive.actionBuilder(new Pose2d(48, 12.5,0))
                .strafeToConstantHeading(new Vector2d(50, 12.5)); //drive to spike mark for second sample

        TrajectoryActionBuilder DriveToBucket2 = drive.actionBuilder(new Pose2d(50, 12.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample

        TrajectoryActionBuilder DriveToSecondSpikeMark = drive.actionBuilder(new Pose2d(75, 36, 45))
                .strafeToLinearHeading(new Vector2d(54, 11.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder PickupSecondSpikeMark = drive.actionBuilder(new Pose2d(52, 11.5, 0))
                .strafeToLinearHeading(new Vector2d(58, 11.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder DriveToBucket3 = drive.actionBuilder(new Pose2d(58, 11.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample

        TrajectoryActionBuilder DriveToThirdSpikeMark = drive.actionBuilder(new Pose2d(75, 36, 45))
                .strafeToLinearHeading(new Vector2d(64, 11.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder PickupThirdSpikeMark = drive.actionBuilder(new Pose2d(63, 11.5, 0))
                .strafeToLinearHeading(new Vector2d(68, 11.5), 0); // drive to spikemark for third sample

        TrajectoryActionBuilder DriveToBucket4 = drive.actionBuilder(new Pose2d(63, 11.5,0))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample
        TrajectoryActionBuilder DriveToZero = drive.actionBuilder(new Pose2d(75, 36,45))
//                .setTangent(1) // set tangent line for spline
                .strafeToLinearHeading(new Vector2d(72,32), -Math.PI/2 ); // drive to bucket for second sample


        Action driveToSpikeMark = DriveToFirstSpikeMark.build();
        Action pickupSpikeMark = PickupFirstSpikeMark.build();
        Action driveToBucket2 = DriveToBucket2.build();
        Action driveToSecondSpikeMark = DriveToSecondSpikeMark.build();
        Action pickupSecondSpikeMark = PickupSecondSpikeMark.build();
        Action driveToBucket3 = DriveToBucket3.build();
        Action driveToThirdSpikeMark = DriveToThirdSpikeMark.build();
        Action pickupThirdSpikeMark = PickupThirdSpikeMark.build();
        Action driveToBucket4 = DriveToBucket4.build();
        Action driveToZero = DriveToZero.build();

        waitForStart();


//        RobotContainer.extensionSubsystem.bucketHigh();
//        RobotContainer.extensionSubsystem.moveExtension(1600);
//        sleep(2300);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.spinIntake(-0.7);
//        sleep(1750);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.zero();
//        RobotContainer.extensionSubsystem.moveExtension( 120);
//
//        Actions.runBlocking(driveToSpikeMark);
//        RobotContainer.intakeSubsystem.wristDown();
//        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
//        sleep(400);
//        Actions.runBlocking(pickupSpikeMark);
//        sleep(750);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.bucketHigh();
//
//
//        Actions.runBlocking(driveToBucket2);
//        RobotContainer.extensionSubsystem.moveExtension(850);
//        RobotContainer.intakeSubsystem.wristMove(0.4);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.spinIntake(-0.6);
//        sleep(750);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        sleep(150);
//        RobotContainer.extensionSubsystem.zero();
//        RobotContainer.extensionSubsystem.moveExtension(120);
//
//        Actions.runBlocking(driveToSecondSpikeMark);
//        RobotContainer.intakeSubsystem.wristDown();
//        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
//        sleep(400);
//        Actions.runBlocking(pickupSecondSpikeMark);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.bucketHigh();
//
//
//        Actions.runBlocking(driveToBucket3);
//        RobotContainer.extensionSubsystem.moveExtension(850);
//        RobotContainer.intakeSubsystem.wristMove(0.4);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.spinIntake(-0.6);
//        sleep(750);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        sleep(150);
//        RobotContainer.extensionSubsystem.zero();
//        RobotContainer.extensionSubsystem.moveExtension(150);
//
//        Actions.runBlocking(driveToThirdSpikeMark);
//        RobotContainer.intakeSubsystem.wristDown();
//        RobotContainer.intakeSubsystem.spinIntake(Constants.SPINNING);
//        sleep(400);
//        Actions.runBlocking(pickupThirdSpikeMark);
//        sleep(750);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.bucketHigh();
//
//        Actions.runBlocking(driveToBucket4);
//        RobotContainer.extensionSubsystem.moveExtension(850);
//        RobotContainer.intakeSubsystem.wristMove(0.4);
//        sleep(1000);
//        RobotContainer.intakeSubsystem.spinIntake(-0.6);
//        sleep(750);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        sleep(150);
//        RobotContainer.extensionSubsystem.zero();
//        CommandBase.drive.imuTurn(-90);
//        RobotContainer.extensionSubsystem.moveExtension(0);
//        sleep(1000);

    }
}
