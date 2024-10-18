package org.firstinspires.ftc.teamcode.Commands;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Scoring {

    public void scoreBucket(int x) {
      if (x == 1){
          RobotContainer.extensionSubsystem.bucketLow();
            //sleep
          RobotContainer.intakeSubsystem.wristDown();
          RobotContainer.intakeSubsystem.spinIntake(-1);
          //if touch sensor isnt pressed then
          RobotContainer.intakeSubsystem.stopIntake();
          RobotContainer.intakeSubsystem.wristUp();
          //lift down
      }

        if (x == 2){
            RobotContainer.extensionSubsystem.bucketHigh();
            //sleep
            RobotContainer.intakeSubsystem.wristDown();
            RobotContainer.intakeSubsystem.spinIntake(-1);
            //if touch sensor isnt pressed then
            RobotContainer.intakeSubsystem.stopIntake();
            RobotContainer.intakeSubsystem.wristUp();
            //lift down
      }

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
