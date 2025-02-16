package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

public abstract class AutoContainer extends Robot {



    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(36,61,0);
        initialize(startPose);




        wrist.wristMove(Constants.WRIST_RETRACTED);

        waitForStart();
        slides.encoderReset();

        cs.schedule(false,
                new SequentialCommandGroup(
                        new ScoreSampleCommand(slides, wrist, intake),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,1, startPose),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,2, startPose),
                        new AutoCycleSamplesCommand(intake, wrist, drive, slides,3, startPose)
                )
        );

    }


}
