package org.firstinspires.ftc.teamcode.Commands.Custom;


import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;

public class ResetExtensionCommand extends InstantCommand {
    SlideSubsystem slideSubsystem;

    public ResetExtensionCommand(SlideSubsystem slideSubsystem){
        this.slideSubsystem = slideSubsystem;
        addRequirements(slideSubsystem);
    }

    @Override
    public void initialize() {
        slideSubsystem.liftEncoderReset();
    }
}
