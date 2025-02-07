package org.firstinspires.ftc.teamcode.Commands.CommandGroups;


import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.WristSubsystem;

public class ScoreSample extends SequentialCommandGroup {

    public ScoreSample(SlideSubsystem slides, WristSubsystem wrist, IntakeSubsystem intake){
        addCommands(
                new ParallelCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_OUT)
                ),
                new WaitCommand(500),
                new IntakeSpinCommand(intake,-Constants.SPINNING),
                new WaitCommand(500),
                new ParallelCommandGroup(
                        new RaiseLiftCommand(slides, 0),
                        new MoveWristCommand(wrist, Constants.WRIST_UP),
                        new IntakeSpinCommand(intake, 0)
                )
        );
        addRequirements(slides, wrist, intake);

    }

}
