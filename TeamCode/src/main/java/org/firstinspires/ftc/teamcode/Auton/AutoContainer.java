package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamples;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSample;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;

public abstract class AutoContainer extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(-1,-1,-1);
        initialize(startPose);




        wrist.wristMove(Constants.WRIST_UP);
        waitForStart();
        slides.encoderReset();

        cs.schedule(
                new SequentialCommandGroup(
                        new ScoreSample(slides, wrist, intake),
                        new AutoCycleSamples(intake, wrist, drive, slides,1, startPose),
                        new AutoCycleSamples(intake, wrist, drive, slides,2, startPose),
                        new AutoCycleSamples(intake, wrist, drive, slides,3, startPose)
                )
        );

    }


}
