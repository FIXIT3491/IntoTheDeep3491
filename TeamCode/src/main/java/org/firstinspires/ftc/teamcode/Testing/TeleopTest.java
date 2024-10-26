package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp(name="TeleopTest", group="Linear OpMode")
public class TeleopTest extends LinearOpMode {
    boolean locked;

    @Override
    public void runOpMode()  {
        CommandBase.initialize(hardwareMap, telemetry, this);
        CommandBase.teleOp.extensionCommands(gamepad2);

        waitForStart();
        while (opModeIsActive()){
            CommandBase.teleOp.fieldCentricDrive(gamepad1, gamepad2, telemetry);
            CommandBase.teleOp.lmecCommands(gamepad1);
            CommandBase.teleOp.extensionCommands(gamepad2);
            CommandBase.teleOp.wrist(gamepad2);
            CommandBase.teleOp.intake(gamepad1, gamepad2, telemetry);
            RobotContainer.telemetrySubsystem.getTelemetry(telemetry);
        }
        RobotContainer.extensionSubsystem.zero();
        RobotContainer.intakeSubsystem.wristDown();
        sleep(3000);
    }
}
