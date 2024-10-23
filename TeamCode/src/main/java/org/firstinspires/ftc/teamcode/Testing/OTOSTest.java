package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class OTOSTest extends LinearOpMode {

    public ElapsedTime pickupTimer = new ElapsedTime();


    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap, telemetry, this);

        RobotContainer.intakeSubsystem.wristUp();

        waitForStart();

        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(12, -17.5, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(130);
        sleep(500);
        RobotContainer.intakeSubsystem.wristBucket();
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(500);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);


        CommandBase.drive.otosDrive(35.5, 0, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(90);

        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(1000);
        pickupTimer.reset();
        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 2500) {
            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }


        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(12, -17.5, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(130);
        sleep(500);
        RobotContainer.intakeSubsystem.wristBucket();
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(500);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);

        CommandBase.drive.otosDrive(35.5, -9.5, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(90);


        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        sleep(1000);
        pickupTimer.reset();
        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 2500) {
            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
        }

        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(12, -17.5, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(132);
        sleep(500);
        RobotContainer.intakeSubsystem.wristBucket();
        sleep(1000);
        RobotContainer.intakeSubsystem.spinIntake(-0.5);
        sleep(500);
        RobotContainer.intakeSubsystem.wristUp();
        RobotContainer.intakeSubsystem.stopIntake();
        sleep(500);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);

        CommandBase.drive.otosDrive(35.5, -19, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(90);


//        CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//        sleep(1000);
//        pickupTimer.reset();
//        while (!CommandBase.pickup.SpikeMarkAuto("blue", telemetry) && pickupTimer.milliseconds() < 2500) {
//            CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
//            RobotContainer.driveSubsystem.moveRobot(0.2, 0, 0);
//        }
//
//        RobotContainer.extensionSubsystem.bucketHigh();
//        CommandBase.drive.imuTurn(0);
//        CommandBase.drive.otosDrive(12, -17.5, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        CommandBase.drive.imuTurn(134);
//        sleep(500);
//        RobotContainer.intakeSubsystem.wristBucket();
//        sleep(1000);
//        RobotContainer.intakeSubsystem.spinIntake(-0.5);
//        sleep(500);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        sleep(500);
//        RobotContainer.extensionSubsystem.zero();
//        CommandBase.drive.imuTurn(0);
//
//        sleep(4000);
//
//



    }
}
