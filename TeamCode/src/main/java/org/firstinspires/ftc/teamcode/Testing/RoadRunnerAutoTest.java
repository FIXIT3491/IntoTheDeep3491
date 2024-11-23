package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;


public class RoadRunnerAutoTest extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(40, 60, Math.toRadians(0));

        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        CommandBase.initialize(hardwareMap, telemetry, this);

//        .waitSeconds(4.2) //score bucket first sample
//                .strafeToConstantHeading(new Vector2d(35, 25)) //drive to spike mark for second sample
//                .waitSeconds(.75) // wait for wrist to come down
//                .lineToX(40) // pick up sample
//                .waitSeconds(.5) // wait for wrist to come up and also set arm high bucket
//                .setTangent(1) // set tangent line for spline
//                .splineToSplineHeading(new Pose2d(53,53, Math.toRadians(45) ), Math.toRadians(80)) // drive to bucket for second sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToLinearHeading(new Vector2d(45, 25), Math.toRadians(0)) // drive to spike mark for 3rd sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(50) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(1) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53,53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToLinearHeading(new Vector2d(55, 25), Math.toRadians(0)) // drive to spike mark for forth sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(60) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(2) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53,53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
//                .waitSeconds(1) // wait for scoring


        TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
                .strafeToConstantHeading(new Vector2d(40, 40)) //drive to spike mark for second sample
                .waitSeconds(.75) // wait for wrist to come down
//                .lineToX(40) // pick up sample
//                .waitSeconds(.5) // wait for wrist to come up and also set arm high bucket
//                .setTangent(14) // set tangent line for spline
//                .turnTo(Math.toRadians(43))
//                .waitSeconds(3)
//                .strafeTo(new Vector2d(53,53))
//                .lineToX(53)
//                .strafeToSplineHeading(new Vector2d(53, 53), Math.toRadians(43)) // drive to bucket for second sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToSplineHeading(new Vector2d(45, 25), 0) // drive to spike mark for 3rd sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(50) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(1) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53, 53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToLinearHeading(new Vector2d(55, 25), Math.toRadians(0)) // drive to spike mark for forth sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(60) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(2) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53, 53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
                .waitSeconds(1); // wait for scoring
//

        TrajectoryActionBuilder trajectory1 = drive.actionBuilder(new Pose2d(40, 40, 0))
                .lineToX(40); // pick up sample

        TrajectoryActionBuilder driveToBucket = drive.actionBuilder(initialPose);


        Action DriveToSpikeMark = DriveToFirstSpikeMark.build();


        waitForStart();

        RobotContainer.extensionSubsystem.bucketHigh();
        RobotContainer.extensionSubsystem.moveExtension(1700);
        sleep(2300);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.spinIntake(-0.7);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension( 100);

        Actions.runBlocking(
                DriveToSpikeMark
        );

//        Actions.runBlocking(
//                drive.actionBuilder(initialPose)
////                        .waitSeconds(3000)
////                        .strafeToLinearHeading (new Vector2d(40, 42), Math.toRadians(0))
//                        .splineToConstantHeading(new Vector2d(36, 43), Math.toRadians(-5))
//                        .splineToConstantHeading(new Vector2d(40,60), Math.toRadians(0))
//                        .waitSeconds(3)
////                        .splineTo(new Vector2d(0, 60), Math.PI)
//                        .build());

//        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//        pickupTimer.reset();
//        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 1000) {
//            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//            RobotContainer.driveSubsystem.moveRobot(0.15, 0, 0);
//        }
//        RobotContainer.driveSubsystem.moveRobot(0,0,0);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.moveExtension(1700);
//        RobotContainer.extensionSubsystem.bucketHigh();

        sleep(2300);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.spinIntake(-0.7);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension(100);
    }

}
