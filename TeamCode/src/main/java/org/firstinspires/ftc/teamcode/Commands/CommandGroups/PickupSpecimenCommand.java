package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class PickupSpecimenCommand extends SequentialCommandGroup {

    public PickupSpecimenCommand(SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_PICKUP_SPECIMEN),
                        new MoveWristCommand(wrist, Constants.WRIST_PICKUP_SPECIMEN),
                        new MoveExtensionCommand(slides, 0)
                )
        );
        addRequirements(slides, wrist);

    }

}
