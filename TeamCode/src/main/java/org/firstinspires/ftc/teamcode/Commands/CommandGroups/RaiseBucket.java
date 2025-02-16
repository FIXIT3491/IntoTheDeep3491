package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.SequentialCommandGroup;

import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class RaiseBucket extends SequentialCommandGroup {

    public RaiseBucket(SlideSubsystem slides, WristSubsystem wrist){
        addCommands(

                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_SCORE_BUCKET)
                )
        );
        addRequirements(slides, wrist);

    }

}
