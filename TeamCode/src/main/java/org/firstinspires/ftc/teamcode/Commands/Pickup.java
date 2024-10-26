package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Pickup {

    String color = "None";
    double distance = 0;

    boolean sampleInClaw = false;
    boolean correctSample = false;

    ElapsedTime pickupTimeout = new ElapsedTime();

    public Pickup(Telemetry telemetry) {

    }

    public boolean SpikeMarkAuto (String team, Telemetry telemetry) {

        //detect if sample is in claw otherwise keep spinning and leave wrist down

        distance = RobotContainer.colorSubsystem.DetectDistance();
        if (distance < 60) {
            sampleInClaw = true;
            RobotContainer.intakeSubsystem.spinIntake(0);

        } else {
            correctSample = false;
            sampleInClaw = false;
            RobotContainer.intakeSubsystem.wristDown();
            RobotContainer.intakeSubsystem.spinIntake(1);
        }

        if (sampleInClaw) {
//            color = RobotContainer.colorSubsystem.DetectColor();
//            if (color == "red" || color == "blue" || color == "yellow") {
                correctSample = true;
//                RobotContainer.intakeSubsystem.spinIntake(0.1);
//                RobotContainer.intakeSubsystem.wristUp();

                return true;
//            } else {
//                color = RobotContainer.colorSubsystem.DetectColor();
//                distance = RobotContainer.colorSubsystem.DetectDistance();
//            }
        }


        //works in theory

        return false;
    }
    public boolean SpikeMarkTeleOp (String team, Telemetry telemetry) {

        //detect if sample is in claw otherwise keep spinning and leave wrist down

        distance = RobotContainer.colorSubsystem.DetectDistance();
        if (distance < 60) {
            sampleInClaw = true;
            RobotContainer.intakeSubsystem.stopIntake();

        } else {
            correctSample = false;
            sampleInClaw = false;
            RobotContainer.intakeSubsystem.wristDown();
            RobotContainer.intakeSubsystem.spinIntake(1);
        }

        if (sampleInClaw) {
            color = RobotContainer.colorSubsystem.DetectColor();
            if (color == "red" || color == "blue" || color == "yellow") {
                correctSample = true;
//                RobotContainer.intakeSubsystem.spinIntake(0.1);
                RobotContainer.intakeSubsystem.wristUp();

                return true;
            } else {
                color = RobotContainer.colorSubsystem.DetectColor();
                distance = RobotContainer.colorSubsystem.DetectDistance();
            }
        }


        //works in theory

        return false;
    }
    public void getTelemetry(Telemetry telemetry){

        telemetry.addData("sample in claw", sampleInClaw);
        telemetry.addData("correct sample", correctSample);
        telemetry.addData("distance", RobotContainer.colorSubsystem.DetectDistance());
        telemetry.addData("color", RobotContainer.colorSubsystem.DetectColor());

    }
}
