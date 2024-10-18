package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class OTOSTest extends LinearOpMode {


    @Override
    public void runOpMode() {
        RobotContainer.initialize(hardwareMap, telemetry);

        RobotContainer.sparkFunSubsystem.configureOtos();

        waitForStart();
        while (opModeIsActive()) {

            telemetry.addData("OTOS POS", RobotContainer.sparkFunSubsystem.myPosition().x);
            telemetry.addData("OTOS POS", RobotContainer.sparkFunSubsystem.myPosition().y);
            telemetry.addData("OTOS POS", RobotContainer.sparkFunSubsystem.myPosition().h);
            telemetry.update();

        }
    }
}
