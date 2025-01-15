package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous
public class LimeLightTest extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();

    @Override
    public void runOpMode() {

        CommandBase.initialize(hardwareMap, telemetry, this);

        waitForStart();

    }

}