package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;



public class LowerLiftCommand extends InstantCommand {

    SlideSubsystem slideSubsystem;
    double power = -0.8;

    public LowerLiftCommand(SlideSubsystem slideSubsystem, double power){
        this.slideSubsystem = slideSubsystem;
        this.power = power;
        addRequirements(slideSubsystem);
    }
    public LowerLiftCommand(SlideSubsystem slideSubsystem){
        this.slideSubsystem = slideSubsystem;
        power = -0.6;
        addRequirements(slideSubsystem);
    }

    @Override
    public void initialize() {
        slideSubsystem.liftRetract(power);
    }
}

