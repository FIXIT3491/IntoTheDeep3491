package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class MoveWristCommand extends InstantCommand {

    WristSubsystem wrist;
    double distance = 0;

    public MoveWristCommand(WristSubsystem wrist, double distance) {
        addRequirements(wrist);

        this.wrist = wrist;
        this.distance = distance;
    }

    public MoveWristCommand() {

    }

    @Override
    public void initialize() {
        wrist.wristMove(distance);
    }






}
