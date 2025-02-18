package org.firstinspires.ftc.teamcode.Commands.Custom;


import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;

public class ResetIMUCommand extends InstantCommand {
    SparkFunOTOSSubSystem drive;

    public ResetIMUCommand(SparkFunOTOSSubSystem drive){
        this.drive = drive;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        drive.reset();
    }
}
