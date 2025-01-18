package org.firstinspires.ftc.teamcode.Commands;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Scoring {
    LinearOpMode op;

    public Scoring(Telemetry telemetry, LinearOpMode opmoderef) {
        op = opmoderef;
    }

    public void scoreBucket(/*SparkFunOTOSConfig myOtos*/) {
//        RobotContainer.extensionSubsystem.bucketHigh();
//        CommandBase.drive.imuTurn(0);
//        CommandBase.drive.otosDrive(9.5, -18, 0, RobotContainer.sparkFunSubsystem.myOtos);
//        CommandBase.drive.imuTurn(141);
//        RobotContainer.intakeSubsystem.wristBucket();
//        op.sleep(200);
//        RobotContainer.intakeSubsystem.spinIntake(-0.6);
//        op.sleep(200);
//        RobotContainer.intakeSubsystem.wristUp();
//        RobotContainer.intakeSubsystem.stopIntake();
//        op.sleep(150);
////        op.sleep(500);
//        RobotContainer.extensionSubsystem.zero();
//        CommandBase.drive.imuTurn(0);
    }

    public void scoreChamber(int y){
        if (y == 1){
            RobotContainer.extensionSubsystem.chamberScore();

            RobotContainer.intakeSubsystem.wristDown();
            //lift goes down a lil bit
            RobotContainer.intakeSubsystem.spinIntake(-1);
            //if touch sensor isnt pressed then
            RobotContainer.intakeSubsystem.stopIntake();
            RobotContainer.intakeSubsystem.wristUp();
            //sleep
            RobotContainer.extensionSubsystem.chamberScore();
            //lift down

        }

        if (y == 2){
            RobotContainer.extensionSubsystem.chamberRaise();
            //sleep
            RobotContainer.intakeSubsystem.wristDown();
            //lift goes down a lil bit
            RobotContainer.intakeSubsystem.spinIntake(-1);
            //if touch sensor isnt pressed then
            RobotContainer.intakeSubsystem.stopIntake();
            RobotContainer.intakeSubsystem.wristUp();
            //sleep
            RobotContainer.extensionSubsystem.chamberRaise();
            //lift down
        }
    }
}
