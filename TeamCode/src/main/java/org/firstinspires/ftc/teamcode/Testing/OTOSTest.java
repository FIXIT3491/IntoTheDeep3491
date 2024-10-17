package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@TeleOp
public class OTOSTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        RobotContainer.initialize(hardwareMap, telemetry);

        RobotContainer.sparkFunSubsystem.configureOtos();

        waitForStart();
        while (opModeIsActive()) {

            telemetry.addData("OTOS POS", RobotContainer.sparkFunSubsystem.myPosition());
            telemetry.update();

        }
    }
}
