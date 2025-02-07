package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.WristSubsystem;

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
