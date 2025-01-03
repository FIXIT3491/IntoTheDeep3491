package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp(name="TeleopTest", group="Linear OpMode")
public class TeleopTest extends LinearOpMode {
    boolean locked;

    @Override
    public void runOpMode()  {
//        CommandBase.initialize(hardwareMap, telemetry, this);

        ElapsedTime time = new ElapsedTime();
//        CommandBase.teleOp.extensionCommands(gamepad2);

        waitForStart();
        time.reset();


        while (opModeIsActive()) {
            //sequential action command


        }

        sleep(3000);
    }
}
