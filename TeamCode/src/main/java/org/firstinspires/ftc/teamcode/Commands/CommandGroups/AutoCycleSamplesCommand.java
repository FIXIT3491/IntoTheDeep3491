package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class AutoCycleSamplesCommand extends SequentialCommandGroup {

    Vector2d pos;

    public AutoCycleSamplesCommand(IntakeSubsystem intake, WristSubsystem wrist, SparkFunOTOSSubSystem drive, SlideSubsystem slides, int cycleCount, Pose2d startPose){

//        if (cycleCount == 1){
            pos = Constants.FIRST_SPIKE_MARK;
//        } else if (cycleCount == 2 ) {
//            pos = Constants.SECOND_SPIKE_MARK;
//        } else if (cycleCount == 3 ) {
//            pos = Constants.THIRD_SPIKE_MARK;
//        }



        addCommands(
                new StrafeToPointCommand(drive, startPose, pos),
                new AutoSpikeIntakeCommand(intake, slides, wrist),
                new StrafeToPointCommand(drive, new Pose2d(pos, 0), Constants.BUCKET, 45 ),
                new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                new ScoreSampleCommand(slides, wrist, intake)
        );
        addRequirements(slides, wrist, intake, drive);


    }



}
