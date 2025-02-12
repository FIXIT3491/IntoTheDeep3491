package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class AutoSpikeIntake extends SequentialCommandGroup {

    public AutoSpikeIntake (IntakeSubsystem intake, SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new ParallelCommandGroup(
                    new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                    new IntakeSpinCommand(intake, Constants.SPINNING)
                ),
                new WaitCommand(500),
                new MoveExtensionCommand(slides, Constants.SPIKE_EXTENSION),
                new WaitCommand(500),
                new ParallelCommandGroup(
                    new MoveWristCommand(wrist, Constants.WRIST_UP),
                    new IntakeSpinCommand(intake, 0)
                )
        );
        addRequirements(slides, wrist, intake);

    }
}
