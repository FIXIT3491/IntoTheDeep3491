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
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class RoadRunner extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-52, 52, Math.toRadians(Math.toRadians(270)));

        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, initialPose);
        CommandBase.initialize(hardwareMap, telemetry, this);



        TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
                .strafeToConstantHeading(new Vector2d(0, 52)); //drive to spike mark for second sample                .waitSeconds(.75) // wait for wrist to come down

        TrajectoryActionBuilder DriveToBucket2 = drive.actionBuilder(new Pose2d(36, 36, Math.toRadians(0)))
//                .setTangent(1) // set tangent line for spline
                .strafeToConstantHeading(new Vector2d(36,53)); // drive to bucket for second sample

        TrajectoryActionBuilder DriveToSecondSpikeMark = drive.actionBuilder(new Pose2d(36, 53, Math.toRadians(0)))
                .splineToConstantHeading(new Vector2d(36, 36), 0); // drive to spikemark for third sample



        Action driveToSpikeMark = DriveToFirstSpikeMark.build();



        waitForStart();
        Actions.runBlocking(
                driveToSpikeMark
        );


    }

}
