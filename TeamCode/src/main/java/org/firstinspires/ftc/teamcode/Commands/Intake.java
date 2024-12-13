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

    public class pickUpSample implements Action {
        private boolean initialized = false;
        private double distance = 0;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                intakeSubsystem.wristDown();
                // @TODO check if power 1 is good
                intakeSubsystem.spinIntake(1);
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

    public class scoreBasket implements Action {
        private boolean initialized = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {
                intakeSubsystem.wristBucket();
                initialized = true;
            }   // @TODO check if this works
                intakeSubsystem.wristBucket();
                return true;
        }
    }

    //@Todo add arm logic
    public class LiftZero implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialized) {

                initialized = true;
            }

            double pos = lift.getCurrentPosition();
            packet.put("liftPos", pos);
            if (pos < 3000.0) {
                return true;
            } else {
                lift.setPower(0);
                return false;
            }
        }
    }
}