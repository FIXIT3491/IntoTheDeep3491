package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.Drive;
import org.firstinspires.ftc.teamcode.Commands.Intake;
import org.firstinspires.ftc.teamcode.Commands.Lift;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;

@Autonomous
public class TestingActions extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d initialPose = new Pose2d(52, 52, 0);

        Intake intake = new Intake(new IntakeSubsystem(hardwareMap, telemetry));
        Lift lift = new Lift(new ExtensionSubsystem(hardwareMap, telemetry));
        Drive drive = new Drive(new SparkFunOTOSDrive(hardwareMap, new Pose2d(3,3,3)), new LMECSubsystem(hardwareMap));
        waitForStart();


        Actions.runBlocking(
                new SequentialAction(
                        lift.liftHighBasket(),
                        intake.wristBasket(),
                        new SleepAction(2),
                        intake.outtake(),
                        new SleepAction(0.3),
                        intake.wristUp(),
                        new ParallelAction (
                                lift.liftZero(),
                                drive.driveToSpikeMark
                        ),
                        new ParallelAction(
                                intake.wristDown(),
                                intake.intake()
                        ),
                        drive.pickupSpikeMark,
                        new SleepAction(1),
                        new ParallelAction(
                                intake.wristDown(),
                                intake.intake()
                        ),





                )
        );


        sleep(1000);
    }
}


