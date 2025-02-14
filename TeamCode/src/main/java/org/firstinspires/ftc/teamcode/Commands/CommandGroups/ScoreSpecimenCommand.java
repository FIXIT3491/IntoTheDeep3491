package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class ScoreSpecimenCommand extends SequentialCommandGroup {

    public ScoreSpecimenCommand(SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new SequentialCommandGroup(
                        new MoveExtensionCommand(slides, Constants.EXTENSION_MIN),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new LowerLiftCommand(slides)
                )
        );
        addRequirements(slides, wrist);

    }

}
