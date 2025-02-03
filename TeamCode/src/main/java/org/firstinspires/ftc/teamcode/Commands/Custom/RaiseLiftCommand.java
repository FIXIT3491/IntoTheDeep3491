package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.SlideSubsystem;

public class RaiseLiftCommand extends InstantCommand {
    SlideSubsystem slideSubsystem;
    int position;

    public RaiseLiftCommand(SlideSubsystem slideSubsystem, int position){
        this.slideSubsystem = slideSubsystem;
        this.position = position;

    }

    @Override
    public void initialize() {
        slideSubsystem.raiseLift(position);
    }
}
