package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.WristSubsystem;

public class AutoSpikeIntake extends SequentialCommandGroup {

    public AutoSpikeIntake (IntakeSubsystem intake, SlideSubsystem slides, WristSubsystem wrist){
        addCommands(
                new MoveWristCommand(wrist, 1),
                new IntakeSpinCommand(intake, 1),
                new WaitCommand(1000)

        );


    }
}
