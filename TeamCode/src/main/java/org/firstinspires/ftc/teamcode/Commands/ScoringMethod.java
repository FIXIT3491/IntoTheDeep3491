package org.firstinspires.ftc.teamcode.Commands;
import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

public class ScoringMethod {

    public void scoreBucket(int x) {
      if (x == 1){
          RobotContainer.extensionSubsystem.bucketLow();


      }

        if (x == 2){
            RobotContainer.extensionSubsystem.bucketHigh();


      }

    }

    public void scoreChamber(int y){
        if (y == 1){
            RobotContainer.extensionSubsystem.chamberLow();

        }

        if (y == 2){
            RobotContainer.extensionSubsystem.chamberHigh();

        }
    }

    //if i = 1 than score low basket




}
