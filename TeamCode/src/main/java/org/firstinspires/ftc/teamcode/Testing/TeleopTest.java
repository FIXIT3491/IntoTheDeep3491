package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;

@TeleOp(name="TeleopTest", group="Linear OpMode")
public class TeleopTest extends LinearOpMode {
    boolean locked;

    @Override
    public void runOpMode()  {
        CommandBase.initialize(hardwareMap, telemetry, this);

        waitForStart();
        while (opModeIsActive()){



            CommandBase.teleOp.fieldCentricDrive(gamepad1, gamepad2, telemetry);
            CommandBase.teleOp.lmecCommands(gamepad2);
            CommandBase.teleOp.extensionCommands(gamepad2);
            CommandBase.teleOp.wrist(gamepad2);

        }
    }
}
