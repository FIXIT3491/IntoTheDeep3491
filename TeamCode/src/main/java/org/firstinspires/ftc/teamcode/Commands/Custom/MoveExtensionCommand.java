package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;

public class MoveExtensionCommand extends InstantCommand {

    int position;
    SlideSubsystem slideSubsystem;

    public MoveExtensionCommand(SlideSubsystem slideSubsystem, int position){
        this.position = position;
        this.slideSubsystem = slideSubsystem;
        addRequirements(slideSubsystem);
    }

    @Override
    public void initialize() {
        slideSubsystem.moveExtension(position);
    }
}
