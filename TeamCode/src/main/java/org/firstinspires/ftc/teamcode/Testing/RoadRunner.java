package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Drive;
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

        RobotContainer robot = new RobotContainer(hardwareMap);
        Drive drive = new Drive(hardwareMap);
        Lift lift = new Lift(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        robot.initialize(telemetry);

//        CommandBase.initialize(hardwareMap, telemetry, this);


        waitForStart();


        Actions.runBlocking(
                new SequentialAction(


                )
        );



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
