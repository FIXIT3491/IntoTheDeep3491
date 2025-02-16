package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

public abstract class Auto10Samples extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(36,61,0);
        initialize(startPose);

//        wrist.wristMove(Constants.WRIST_RETRACTED);

        slides.encoderReset();

        waitForStart();


        cs.schedule(
                new SequentialCommandGroup(
                        new ScoreSampleCommand(slides, wrist, intake),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,1, startPose),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,2, startPose),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,3, startPose)
                )
        );
        while (!isStopRequested()){
            update();


        }
        end();

    }


}
