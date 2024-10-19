package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Pickup {

    String color = "None";
    double distance = 0;

    boolean sampleInClaw = false;
    boolean correctSample = false;

    ElapsedTime pickupTimeout = new ElapsedTime();

    public void SpikeMarkAuto (int timeout, String team){

        //detect if sample is in claw otherwise keep spinning and leave wrist down
        while (pickupTimeout.milliseconds() < timeout) {

            if (distance < 7) {
                sampleInClaw = true;
                //if sample is in claw

            } else {
                sampleInClaw = false;
                RobotContainer.intakeSubsystem.wristDown();
                RobotContainer.intakeSubsystem.spinIntake(0.75);
            }

            if (sampleInClaw) {
                color = RobotContainer.colorSubsystem.DetectColor();
                if (color == "red" || color == "blue" || color == "yellow") {
                    correctSample = true;
                    RobotContainer.intakeSubsystem.stopIntake();
                    RobotContainer.intakeSubsystem.wristUp();
                    break;
                } else {
                    color = RobotContainer.colorSubsystem.DetectColor();
                    distance = RobotContainer.colorSubsystem.DetectDistance();
                }
            }


            //works in theory
        }
    }
}
