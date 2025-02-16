package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;



public class LowerLiftCommand extends InstantCommand {

    SlideSubsystem slideSubsystem;

    public LowerLiftCommand(SlideSubsystem slideSubsystem){
        this.slideSubsystem = slideSubsystem;
        addRequirements(slideSubsystem);
    }

    @Override
    public void initialize() {
        //@TODO check to make sure this while loop doesn't break the command logic
        if (!slideSubsystem.getTouchSensor()) {
            slideSubsystem.liftRetract(-0.5);
        }else {
            slideSubsystem.liftEncoderReset();
            slideSubsystem.liftRetract(0);
        }
    }
}

