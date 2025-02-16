package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class RetractAllCommand extends SequentialCommandGroup {
    public RetractAllCommand(SlideSubsystem slides, WristSubsystem wrist, IntakeSubsystem intake){
        addCommands(
                new SequentialCommandGroup(
                        new LowerLiftCommand(slides),
                        new MoveExtensionCommand(slides, 0),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new IntakeSpinCommand(intake, 0)
                )
        );
        addRequirements(slides, wrist, intake);

    }
}
