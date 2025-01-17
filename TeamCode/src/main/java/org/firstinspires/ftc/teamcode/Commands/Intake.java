package org.firstinspires.ftc.teamcode.Commands;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.SequentialAction;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ColorSubsystem;

public class Intake {

    private DcMotorEx lift;
    private ColorSubsystem colorSubsystem;
    private CRServo intakeMotor;
    private Servo wristServoRight;
    private Servo wristServoLeft;

    IntakeSubsystem intake;
    Telemetry telemetry;

    public Intake(IntakeSubsystem i) {

        intake = i;
    }



    public class WristDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intake.wristDown();
            return false;
        }
    }

    public class WristBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intake.wristBucket();
            return false;
        }
    }

    public class WristUp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intake.wristUp();
            return false;
        }
    }


    public class Spinnny implements Action {

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
                intake.spinIntake(0.7);

            return false;
        }
    }

    public class Outtake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            intakeSubsystem.spinIntake(-0.7);
            return false;
        }
    }

    public class StopIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
//            intakeSubsystem.spinIntake(0);
            return false;
        }
    }

    public Action wristDown() { return new WristDown(); }
    public Action wristBasket() { return new WristBasket(); }
    public Action wristUp() { return new WristUp(); }
    public Action spinnny() { return new Spinnny(); }
    public Action outtake() { return new Outtake(); }
    public Action stopIntake() { return new StopIntake(); }

//    public SequentialAction taco() { wristUp(), wristUp()  }

}