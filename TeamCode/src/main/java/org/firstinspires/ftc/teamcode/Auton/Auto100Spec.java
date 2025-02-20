package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

public abstract class Auto100Spec extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(-12,61, Math.toRadians(-90));
        initialize(startPose);
//        end();

//        wrist.wristMove(Constants.WRIST_RETRACTED);

        slides.encoderReset();

        waitForStart();

        //there are two potential paths here either driving for spike mark or pushing with intake i think driving would work better
        cs.schedule(
                new SequentialCommandGroup(

                        new ParallelCommandGroup(
                        new ScoreSpecimenCommand(slides, wrist),
                        new StrafeToPointCommand(drive, startPose, new Vector2d( -12,37) , Math.toRadians(-90)) // score preload
                        ),

                        new StrafeToPointCommand(drive, new Pose2d ( -12 , 37, Math.toRadians(-90)), new Vector2d( -36,37) , Math.toRadians(-90)), // strafe right

                        new StrafeToPointCommand(drive, new Pose2d ( -36, 37 , Math.toRadians(-90)), new Vector2d( -36, 13 ) , Math.toRadians(-90)), // go foward
                        new StrafeToPointCommand(drive, new Pose2d ( -36, 13, Math.toRadians(-90)),  new Vector2d( -48,13) , Math.toRadians(-90)), // strafe right
                        new StrafeToPointCommand(drive, new Pose2d ( -48, 13, Math.toRadians(-90)),  new Vector2d( -48,56) , Math.toRadians(-90)), // go back to obbie

                        // 2nd sample
                        new StrafeToPointCommand(drive, new Pose2d ( -48, 56, Math.toRadians(-90)),  new Vector2d( -48,13) , Math.toRadians(-90)), // same logic
                        new StrafeToPointCommand(drive, new Pose2d ( -48, 13, Math.toRadians(-90)),  new Vector2d( -56,13) , Math.toRadians(-90)),
                        new StrafeToPointCommand(drive, new Pose2d ( -56, 13, Math.toRadians(-90)),  new Vector2d( -56,56) , Math.toRadians(-90)),

                        // 3rd sample
                        new StrafeToPointCommand(drive, new Pose2d ( -56, 56, Math.toRadians(-90)),  new Vector2d( -56,13) , Math.toRadians(-90)), // same logic
                        new StrafeToPointCommand(drive, new Pose2d ( -56, 13, Math.toRadians(-90)),  new Vector2d( -66,13) , Math.toRadians(-90)),
                        new StrafeToPointCommand(drive, new Pose2d ( -66, 13, Math.toRadians(-90)),  new Vector2d( -66,13) , Math.toRadians(-90))

        ));

        while (!isStopRequested()){
            update();


        }
        end();

    }


}
