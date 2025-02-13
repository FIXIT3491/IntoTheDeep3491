package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

@Autonomous(name="MotorTest", group="02")
public class MotorTest extends Robot {

    @Override
    public void runOpMode() throws InterruptedException {
        cs.schedule(new IntakeSpinCommand(intake, 0.5));

    }
}
