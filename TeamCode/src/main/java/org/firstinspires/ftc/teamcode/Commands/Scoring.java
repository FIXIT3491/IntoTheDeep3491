package org.firstinspires.ftc.teamcode.Commands;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Scoring {
    LinearOpMode op;

    public Scoring(Telemetry telemetry, LinearOpMode opmoderef) {
        op = opmoderef;
    }

    public void scoreBucket() {
        RobotContainer.extensionSubsystem.bucketHigh();
        CommandBase.drive.imuTurn(0);
        CommandBase.drive.otosDrive(12, -18, 0, RobotContainer.sparkFunSubsystem.myOtos);
        CommandBase.drive.imuTurn(130);
        op.sleep(500);
        RobotContainer.intakeSubsystem.wristBucket();
        RobotContainer.intakeSubsystem.spinIntake(-0.5);
        op.sleep(1000);
        RobotContainer.intakeSubsystem.wristUp();
        op.sleep(500);
        RobotContainer.extensionSubsystem.zero();
        CommandBase.drive.imuTurn(0);

    }

    public void scoreChamber(int y){
        if (y == 1){
            RobotContainer.extensionSubsystem.chamberLow();
            //sleep
            RobotContainer.intakeSubsystem.wristDown();
            //lift goes down a lil bit
            RobotContainer.intakeSubsystem.spinIntake(-1);
            //if touch sensor isnt pressed then
            RobotContainer.intakeSubsystem.stopIntake();
            RobotContainer.intakeSubsystem.wristUp();
            //sleep
            RobotContainer.extensionSubsystem.chamberLow();
            //lift down

        }

        if (y == 2){
            RobotContainer.extensionSubsystem.chamberHigh();
            //sleep
            RobotContainer.intakeSubsystem.wristDown();
            //lift goes down a lil bit
            RobotContainer.intakeSubsystem.spinIntake(-1);
            //if touch sensor isnt pressed then
            RobotContainer.intakeSubsystem.stopIntake();
            RobotContainer.intakeSubsystem.wristUp();
            //sleep
            RobotContainer.extensionSubsystem.chamberHigh();
            //lift down
        }
    }





}
