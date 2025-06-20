package org.firstinspires.ftc.teamcode.Auton;

import static org.firstinspires.ftc.teamcode.Lib.Constants.WRIST_DOWN;
import static org.firstinspires.ftc.teamcode.Lib.Constants.WRIST_RETRACTED;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ManualExtensionControl;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.Pickup;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

public abstract class Auto10Samples extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(36,61,0);
        initialize(startPose);
//        end();

//        wrist.wristMove(Constants.WRIST_RETRACTED);

        slides.encoderReset();

        waitForStart();


        cs.schedule(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),

                        new ParallelCommandGroup(
                                new StrafeToPointCommand(drive, startPose,  Constants.BUCKET_POS, Math.toRadians(45)),
                                new ScoreSampleCommand(slides, wrist, intake)
                        ),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,1),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,2),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,3),
                        new StrafeToPointCommand(drive, new Pose2d(Constants.BUCKET_POS, Math.toRadians(50)), new Vector2d( 30,12) , Math.toRadians(-179)),

                        // extra cycle pick up
                        // make colour sensor work
                        new StrafeToPointCommand(drive, new Pose2d (30, 12, Math.toRadians(-179)),new Vector2d( 27,12) , Math.toRadians(-180)),
                        new MoveWristCommand(wrist, WRIST_DOWN),
                        new WaitCommand(500),
                        new ManualExtensionControl(slides, 1500),
                        new WaitCommand(1000),
                        new ManualExtensionControl(slides, 500),
                        new WaitCommand(500),
                        new IntakeSpinCommand(intake, -1),
                        new ManualExtensionControl(slides, 1800),
                        new WaitCommand(1000),
                        new ManualExtensionControl(slides, 0),
                        new MoveWristCommand(wrist, WRIST_RETRACTED),
                        new IntakeSpinCommand(intake, 0)


        ));
        while (!isStopRequested()){
            update();

        }
        end();

    }


}
