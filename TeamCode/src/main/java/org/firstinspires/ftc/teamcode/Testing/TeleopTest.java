package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;

@TeleOp(name="TeleopTest", group="Linear OpMode")
public class TeleopTest extends LinearOpMode {

    @Override
    public void runOpMode()  {
        CommandBase.initialize(hardwareMap, telemetry, this);

        waitForStart();
        while (opModeIsActive()){



            CommandBase.teleOp.fieldCentricDrive(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.left_trigger, gamepad1.right_trigger, telemetry);


        }
    }
}
