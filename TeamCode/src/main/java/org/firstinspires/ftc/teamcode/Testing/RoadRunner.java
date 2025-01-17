package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.Drive;
import org.firstinspires.ftc.teamcode.Commands.Intake;
import org.firstinspires.ftc.teamcode.Commands.Lift;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class RoadRunner extends LinearOpMode {
    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d initialPose = new Pose2d(52, 52, 0);

        RobotContainer robot = new RobotContainer(hardwareMap);

        Intake intake = new Intake(new IntakeSubsystem(hardwareMap, telemetry));
        Lift lift = new Lift(new ExtensionSubsystem(hardwareMap, telemetry));
        SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(60,3,3));
//        Drive driveCommands = new Drive(hardwareMap, drive);

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

//        robot.initialize(telemetry);



        waitForStart();


        Actions.runBlocking(
                new SequentialAction(
                        new ParallelAction(
                                lift.moveExtensionPreload(),
                                lift.liftHighBasket()
                        ),

                        new SleepAction(2),
                        intake.wristBasket(),
                        intake.outtake(),
                        new SleepAction(1),

//                      new ParallelAction(
                        intake.wristUp(),
                        new SleepAction(1),
                        intake.stopIntake(),
                        new SleepAction(1),
                        lift.liftZero(),
                        new SleepAction(1),
                        lift.moveExtensionZero(),
//                      ),

//                        driveToSpikeMark,
                        intake.wristDown(),
                        intake.spinnny(),
                        new SleepAction(400),
                        pickupSpikeMark,
                        new SleepAction(750),

                        new ParallelAction(
                                intake.wristUp(),
                                intake.stopIntake(),
                                lift.liftHighBasket()
                        ),


                        driveToBucket2,
                        lift.moveExtensionScoring(),
                        intake.wristBasket(),
                        new SleepAction(1000),
                        intake.outtake(),
                        new SleepAction(750),

                        new ParallelAction(
                                intake.wristUp(),
                                intake.stopIntake(),
                                lift.liftZero(),
                                lift.moveExtensionZero()
                        ),


                        driveToSecondSpikeMark,
                        lift.liftZero(),
                        intake.wristDown(),
                        intake.spinnny(),
                        new SleepAction(400),
                        pickupSecondSpikeMark,
                        new SleepAction(1000),

                        new ParallelAction(
                                intake.wristBasket(),
                                intake.stopIntake(),
                                lift.liftHighBasket()
                        ),


                        driveToBucket3,
                        lift.moveExtensionScoring(),
                        intake.wristBasket(),
                        new SleepAction(1000),
                        intake.outtake(),
                        new SleepAction(750),

                        new ParallelAction(
                                intake.wristUp(),
                                intake.stopIntake(),
                                lift.liftZero(),
                                lift.moveExtensionZero()
                        ),


                        driveToThirdSpikeMark,
                        intake.wristDown(),
                        intake.spinnny(),
                        new SleepAction(400),
                        pickupThirdSpikeMark,
                        new SleepAction(750),

                        new ParallelAction(
                                intake.wristBasket(),
                                intake.stopIntake(),
                                lift.liftHighBasket()
                        ),


                        driveToBucket4,
                        lift.moveExtensionScoring(),
                        intake.wristBasket(),
                        new SleepAction(1000),
                        intake.outtake(),
                        new SleepAction(750),
                        intake.wristUp(),
                        intake.stopIntake(),
                        new SleepAction(150),
                        intake.spinnny(),
                        new SleepAction(750),

                        new ParallelAction(
                                intake.wristUp(),
                                intake.stopIntake(),
                                lift.liftZero(),
                                lift.moveExtensionZero()
                        ),

                        //turn to 0 for max
                        new SleepAction(1000)




                        )


        );

        sleep(1000);
    }
}


