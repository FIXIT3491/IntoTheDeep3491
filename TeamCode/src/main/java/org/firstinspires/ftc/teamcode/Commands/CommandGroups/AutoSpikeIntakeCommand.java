package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class AutoSpikeIntakeCommand extends SequentialCommandGroup {

    public AutoSpikeIntakeCommand(IntakeSubsystem intake, SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new ParallelCommandGroup(
                    new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                    new IntakeSpinCommand(intake,-Constants.SPINNING)
                ),
                new WaitCommand(500),
                new MoveExtensionCommand(slides, Constants.EXTENSION_SPIKE),
                new WaitCommand(1300),
                new ParallelCommandGroup(
                    new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                    new IntakeSpinCommand(intake, 0),
                    new MoveExtensionCommand(slides, 0)
                )
        );
//        addRequirements(slides, wrist, intake);

    }
}
