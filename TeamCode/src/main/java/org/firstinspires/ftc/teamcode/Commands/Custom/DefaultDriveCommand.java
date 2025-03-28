package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.CommandBase;


import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;

import java.util.function.DoubleSupplier;

public class DefaultDriveCommand extends CommandBase {
    SparkFunOTOSSubSystem drive;
    DoubleSupplier x, y, rx;
    double heading;

    public DefaultDriveCommand(SparkFunOTOSSubSystem driveSubsystem, DoubleSupplier inputX, DoubleSupplier inputY, DoubleSupplier inputRx, double robotHeading) {
        this.drive = driveSubsystem;
        this.x = inputX;
        this.y = inputY;
        this.rx = inputRx;
        this.heading = robotHeading;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.driveFieldCentric(x.getAsDouble() + getXModPower(), y.getAsDouble() + getYModPower(), rx.getAsDouble() + getRModPower(), heading);
    }

    public double getXModPower() {
        return 0.0;
    }

    public double getYModPower() {
        return 0.0;
    }

    public double getRModPower() {
        return 0.0;
    }


}