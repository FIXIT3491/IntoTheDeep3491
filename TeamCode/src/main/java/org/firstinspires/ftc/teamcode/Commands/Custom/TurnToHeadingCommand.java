package org.firstinspires.ftc.teamcode.Commands.Custom;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.arcrobotics.ftclib.command.CommandBase;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;

public class TurnToHeadingCommand extends CommandBase {
    private final SparkFunOTOSSubSystem drive;
    private final double desiredTargetHeadingDegrees;

    private double targetHeadingRad;
    private final double tolerance = Math.toRadians(0.5);
    private final double maxPower = 0.9;
    private final double minPower = 0.8;
    private final double kP = 0.017;

    public TurnToHeadingCommand(SparkFunOTOSSubSystem drive, double desiredTargetHeadingDegrees) {
        this.drive = drive;
        this.desiredTargetHeadingDegrees = desiredTargetHeadingDegrees;
        addRequirements(drive);
    }

    @Override
    public void initialize() {
        // Normalize target heading to range (-π, π]
        double currentHeading = normalizeAngle(drive.getHeading());
        double desiredHeadingRad = normalizeAngle(Math.toRadians(desiredTargetHeadingDegrees));

        // Shortest angular difference
        double delta = normalizeAngle(desiredHeadingRad - currentHeading);

        // Target = current + shortest angular delta
        targetHeadingRad = currentHeading + delta;
    }

    @Override
    public void execute() {
        double currentHeading = normalizeAngle(drive.getHeading());
        double error = normalizeAngle(targetHeadingRad - currentHeading);
        double direction = Math.signum(error);
        double absError = Math.abs(error);

        double power = kP * absError;
        power = Math.max(minPower, Math.min(maxPower, power));
        power *= direction;

        drive.setDrivePower(new Pose2d(0, 0, power));
        drive.update();
    }

    @Override
    public boolean isFinished() {
        double error = normalizeAngle(targetHeadingRad - normalizeAngle(drive.getHeading()));
        return Math.abs(error) < tolerance;
    }

    @Override
    public void end(boolean interrupted) {
        drive.setDrivePower(new Pose2d(0, 0, 0));
    }

    private double normalizeAngle(double angle) {
        // Normalize to range (-π, π]
        while (angle > Math.PI) angle -= 2 * Math.PI;
        while (angle <= -Math.PI) angle += 2 * Math.PI;
        return angle;
    }
}
