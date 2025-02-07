package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;

public class LMECControl extends InstantCommand {

    LMECSubsystem lmecSubsystem;
    boolean locked;


    public LMECControl(LMECSubsystem lmecSubsystem, boolean locked ) {
        this.lmecSubsystem  = lmecSubsystem;
        this.locked = locked;
    }

    @Override
    public void initialize() {
        if (locked)
            lmecSubsystem.lockMechanum();
        else
            lmecSubsystem.unlockMechanum();
    }
}
