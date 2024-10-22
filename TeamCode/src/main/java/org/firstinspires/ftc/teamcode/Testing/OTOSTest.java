package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class OTOSTest extends LinearOpMode {


    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap, telemetry, this);

        waitForStart();
        CommandBase.drive.otosDrive(33, 0, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(90);

        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(1000);

        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry)) {
            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }
        RobotContainer.driveSubsystem.moveRobot(0, 0, 0);
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(23, -27, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(180);
        }
}
