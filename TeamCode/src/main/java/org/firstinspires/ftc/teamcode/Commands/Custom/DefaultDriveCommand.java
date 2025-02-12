package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.CommandBase;


import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;

import java.util.function.DoubleSupplier;

public class DefaultDriveCommand extends CommandBase {
    SparkFunOTOSDrive drive;
    DoubleSupplier x, y, rx, heading;

    public DefaultDriveCommand(SparkFunOTOSDrive driveSubsystem, DoubleSupplier inputX, DoubleSupplier inputY, DoubleSupplier inputRx, DoubleSupplier robotHeading) {
        this.drive = driveSubsystem;
        this.x = inputX;
        this.y = inputY;
        this.rx = inputRx;
        this.heading = robotHeading;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        drive.driveFieldCentric(-x.getAsDouble() + getXModPower(), y.getAsDouble() + getYModPower(), rx.getAsDouble() + getRModPower(), heading.getAsDouble());
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