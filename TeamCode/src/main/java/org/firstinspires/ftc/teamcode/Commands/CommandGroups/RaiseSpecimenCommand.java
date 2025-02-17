package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class RaiseSpecimenCommand extends SequentialCommandGroup {

    public RaiseSpecimenCommand(SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new ParallelCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_CHAMBER_2),
                        new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                        new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN)
                )
        );
        addRequirements(slides, wrist);

    }

}
