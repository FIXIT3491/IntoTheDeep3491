package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;

public class RaiseLiftCommand extends CommandBase {
    SlideSubsystem slideSubsystem;
    int position;

    public RaiseLiftCommand(SlideSubsystem slideSubsystem, int position){
        this.slideSubsystem = slideSubsystem;
        this.position = position;
        addRequirements(slideSubsystem);
    }


    @Override
    public void initialize() {
        slideSubsystem.raiseLift(position);
    }


    @Override
    public boolean isFinished(){
        return true;
    }
    @Override
    public void end(boolean wasInterrupted) {

    }

}
