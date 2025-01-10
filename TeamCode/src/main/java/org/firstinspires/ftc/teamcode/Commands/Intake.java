package org.firstinspires.ftc.teamcode.Commands;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ColorSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Intake {

    private DcMotorEx lift;
    private ColorSubsystem colorSubsystem;
    private CRServo intakeMotor;
    private Servo wristServoRight;
    private Servo wristServoLeft;

    IntakeSubsystem intake;
    Telemetry telemetry;

    public Intake(HardwareMap hardwareMap, IntakeSubsystem Intake) {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoRight = hardwareMap.get(Servo.class, "WSR");
        wristServoLeft = hardwareMap.get(Servo.class, "WSL");

//        wristServoTwo.setDirection(Servo.Direction.REVERSE);
        wristServoRight.setDirection(Servo.Direction.REVERSE);
        IntakeSubsystem intake = Intake;
    }

    public void wristUpMethod(){
        wristMove(Constants.WRIST_UP);
    }

    public void wristMove(double distance){
        wristServoRight.setPosition(distance);
        wristServoLeft.setPosition(distance);
    }

    public class WristDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            return true;
        }
    }

    public class WristBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intake.wristBucket();
                return true;
        }
    }

    public class WristUp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            wristUpMethod();

            return true;
        }
    }

    public class Spinnny implements Action {
        private boolean initialized = false;
        private double distance = 0;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
//                intakeSubsystem.spinIntake(0.7);
                initialized = true;
            }
                distance = colorSubsystem.DetectDistance();
                while (distance > 60) {
                    distance = colorSubsystem.DetectDistance();
                }
//                    intakeSubsystem.spinIntake(0);
            return true;
        }
    }

    public class Outtake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            intakeSubsystem.spinIntake(-0.7);
            return true;
        }
    }

    public class StopIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            intakeSubsystem.spinIntake(0);
            return true;
        }
    }

    public Action wristDown() { return new WristDown(); }
    public Action wristBasket() { return new WristBasket(); }
    public Action wristUp() { return new WristUp(); }
    public Action spinnny() { return new Spinnny(); }
    public Action outtake() { return new Outtake(); }
    public Action stopIntake() { return new StopIntake(); }

}