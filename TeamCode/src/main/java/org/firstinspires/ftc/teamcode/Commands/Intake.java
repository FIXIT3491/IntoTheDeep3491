package org.firstinspires.ftc.teamcode.Commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ColorSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

public class Intake {
    private DcMotorEx lift;
    private IntakeSubsystem intakeSubsystem;
    private ColorSubsystem colorSubsystem;

    public Intake(HardwareMap hardwareMap) {

    }

    public class WristDown implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
                intakeSubsystem.wristDown();
            return true;
        }
    }

    public class WristBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
                intakeSubsystem.wristBucket();
                return true;
        }
    }

    public class WristUp implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeSubsystem.wristUp();
            return true;
        }
    }

    public class Spinnny implements Action {
        private boolean initialized = false;
        private double distance = 0;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                intakeSubsystem.spinIntake(0.7);
                initialized = true;
            }
                distance = colorSubsystem.DetectDistance();
                while (distance > 60) {
                    distance = colorSubsystem.DetectDistance();
                }
                    intakeSubsystem.spinIntake(0);
            return true;
        }
    }

    public class Outtake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeSubsystem.spinIntake(-0.7);
            return true;
        }
    }

    public class StopIntake implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeSubsystem.spinIntake(0);
            return true;
        }
    }

    public Action wristDown() { return new Intake.WristDown(); }
    public Action wristBasket() { return new Intake.WristBasket(); }
    public Action wristUp() { return new Intake.WristUp(); }
    public Action spinnny() { return new Intake.Spinnny(); }
    public Action outtake() { return new Intake.Outtake(); }
    public Action stopIntake() { return new Intake.StopIntake(); }

}