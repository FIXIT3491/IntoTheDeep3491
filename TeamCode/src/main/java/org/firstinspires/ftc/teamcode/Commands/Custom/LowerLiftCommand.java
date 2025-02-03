package org.firstinspires.ftc.teamcode.Commands.Custom;

import android.transition.Slide;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SlideSubsystem;



public class LowerLiftCommand extends InstantCommand {

    SlideSubsystem slideSubsystem;

    public LowerLiftCommand(SlideSubsystem slideSubsystem){
        this.slideSubsystem = slideSubsystem;
    }

    @Override
    public void initialize() {
        //@TODO check to make sure this while loop doesn't break the command logic
        while (!slideSubsystem.getTouchSensor()) {
            slideSubsystem.liftRetract(-0.01);
        }
        slideSubsystem.liftEncoderReset();
    }
}

