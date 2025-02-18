package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

public abstract class Auto100Spec extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(36,61,0);
        initialize(startPose);
//        end();

//        wrist.wristMove(Constants.WRIST_RETRACTED);

        slides.encoderReset();

        waitForStart();

        //there are two potential paths here either driving for spike mark or pushing with intake i think driving would work better
        cs.schedule(
                new SequentialCommandGroup(
                        //parallel {
                            //raise spec
                            //strafe to point (score)
                        //}
                        //strafe to point(midway)
                        //strafe to point (first spike)
                        //parallel {
                            //strafe to point (observationZone)
                            //pickup spec command
                        //}
                        //autoCycleSpecCommand
                        //autoCycleSpecCommand

                )
        );
        while (!isStopRequested()){
            update();


        }
        end();

    }


}
