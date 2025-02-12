package org.firstinspires.ftc.teamcode.Testing;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Robot;

public class MotorTest extends Robot {

    @Override
    public void runOpMode() throws InterruptedException {
        cs.schedule(new IntakeSpinCommand(intake, 0.5));

    }
}
