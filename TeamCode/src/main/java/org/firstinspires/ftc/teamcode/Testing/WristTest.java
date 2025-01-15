package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.ParallelAction;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Commands.Intake;
import org.firstinspires.ftc.teamcode.Commands.Lift;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous(name="WristTest", group = "Autonomous")
    public class WristTest extends LinearOpMode{


        RobotContainer robot = new RobotContainer(hardwareMap);

        @Override
        public void runOpMode() throws InterruptedException {

//            IntakeSubsystem i = new IntakeSubsystem(hardwareMap, telemetry);

            Intake intake = new Intake(new IntakeSubsystem(hardwareMap, telemetry));
            Lift lift = new Lift(new ExtensionSubsystem(hardwareMap, telemetry));
            SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, new Pose2d(60,3,3));


            waitForStart();

            Actions.runBlocking(
                    new SequentialAction(

                    lift.liftHighBasket(),
                    intake.wristUp()

                )
            );





            sleep(1000);

        }

}
