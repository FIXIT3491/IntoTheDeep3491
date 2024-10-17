package org.firstinspires.ftc.teamcode.Commands;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

public class PickupMethod {

    String color = "None";
    double distance = 0;

    public void SpikeMarkAuto (){

            RobotContainer.intakeSubsystem.wristDown();
            while (distance > 7) {
                distance = RobotContainer.colorSubsystem.DetectDistance();
                RobotContainer.intakeSubsystem.spinIntake(0.75);
            }

            color = RobotContainer.colorSubsystem.DetectColor();

            if (color == "red" && color == "blue" && color == "yellow") {
                RobotContainer.intakeSubsystem.stopIntake();
                RobotContainer.intakeSubsystem.wristUp();
            }
            else {
                color = RobotContainer.colorSubsystem.DetectColor();
                distance = RobotContainer.colorSubsystem.DetectDistance();
                RobotContainer.intakeSubsystem.spinIntake(-0.75);
            }

        //works in theory

    }
}
