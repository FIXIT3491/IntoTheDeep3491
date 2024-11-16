package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.FtcDashboard;
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
public class RoadRunnerAutoTest extends LinearOpMode {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    FtcDashboard dash;
    public ElapsedTime pickupTimer = new ElapsedTime();

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(40, 60, Math.toRadians(0));
         MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
        CommandBase.initialize(hardwareMap, telemetry, this);
         dash = FtcDashboard.getInstance();





        waitForStart();
//        RobotContainer.extensionSubsystem.bucketHigh();
//        RobotContainer.extensionSubsystem.moveExtension(1700);
//
//        sleep(2300);
//        RobotContainer.intakeSubsystem.wristOut();
//        RobotContainer.intakeSubsystem.spinIntake(-0.7);
//        sleep(2000);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        RobotContainer.extensionSubsystem.zero();
//        RobotContainer.extensionSubsystem.moveExtension( 100);
//

        Actions.runBlocking(
                drive.actionBuilder(initialPose)
//                        .waitSeconds(3000)
//                        .strafeToLinearHeading (new Vector2d(40, 42), Math.toRadians(0))
                        .splineToConstantHeading(new Vector2d(36, 43), Math.toRadians(-5))
                        .splineToConstantHeading(new Vector2d(40,60), Math.toRadians(0))
                        .waitSeconds(3)
//                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());

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
        Actions.runBlocking(
                drive.actionBuilder(new Pose2d(36,43 , Math.toRadians(-5) ))
//                        .waitSeconds(3000)
//                        .strafeToLinearHeading (new Vector2d(40, 42), Math.toRadians(0))
                        .splineTo(new Vector2d(40,60), Math.toRadians(0))
//                        .splineToLinearHeading(new Pose2d(40, 60, Math.toRadians(0)), Math.toRadians(0))
//                        .splineToConstantHeading(new Vector2d(40, 60), Math.toRadians(-0))
                        .waitSeconds(3)

//                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());

        sleep(2300);
        RobotContainer.intakeSubsystem.wristOut();
        RobotContainer.intakeSubsystem.spinIntake(-0.7);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.extensionSubsystem.moveExtension( 100);

        Actions.runBlocking(
                drive.actionBuilder(initialPose)
//                        .waitSeconds(3000)
//                        .strafeToLinearHeading (new Vector2d(40, 42), Math.toRadians(0))
                        .splineToConstantHeading(new Vector2d(46, 43), Math.toRadians(-5))
                        .waitSeconds(3)
//                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());

    }

}
