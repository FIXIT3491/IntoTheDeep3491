package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class ScoreSampleCommand extends SequentialCommandGroup {

    public ScoreSampleCommand(SlideSubsystem slides, WristSubsystem wrist, IntakeSubsystem intake){
//        addRequirements(slides, wrist, intake);
        addCommands(
                new ParallelCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_SCORE_BUCKET)
//                        new MoveExtensionCommand(slides, 200)
                ),
                new WaitCommand(500),
                new IntakeSpinCommand(intake, Constants.OUTTAKE),
                    new WaitCommand(600),
                new ParallelCommandGroup(

                        new LowerLiftCommand(slides),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new IntakeSpinCommand(intake, 0)
//                        new MoveExtensionCommand(slides, 0)

                )

        );
    }

}
//250 704 9418