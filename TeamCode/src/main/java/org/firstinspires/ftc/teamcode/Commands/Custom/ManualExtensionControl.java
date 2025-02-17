package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;



public class ManualExtensionControl extends InstantCommand {

    SlideSubsystem slideSubsystem;
    int gamepadPos;

    public ManualExtensionControl(SlideSubsystem slideSubsystem, int gamepadPos){
        this.slideSubsystem = slideSubsystem;
        this.gamepadPos = gamepadPos;

        addRequirements(slideSubsystem);

    }

    @Override
    public void initialize() {
        // Map gamepadPos (0 to 1) to slide position (0 to 360) and convert to int


        slideSubsystem.moveExtension(gamepadPos);
    }
//    @Override
//    public boolean isFinished(){
//        return true;
//    }
}

