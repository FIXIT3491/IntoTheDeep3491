package org.firstinspires.ftc.teamcode.Commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;

public class Lift {
        private DcMotorEx lift;
        private ExtensionSubsystem extensionSubsystem;
        private IntakeSubsystem intakeSubsystem;

        public Lift(HardwareMap hardwareMap) {

        }

        public class LiftHighChamber implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                return extensionSubsystem.chamberHigh();
            }
        }

        public class LiftHighBasket implements Action {
            private boolean initialized = false;

            @Override
            public boolean run(@NonNull TelemetryPacket packet) {
                return extensionSubsystem.bucketHigh();
        }
    }

    //@Todo add arm logic
    public class LiftZero implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {

            while (!extensionSubsystem.getTouchSensor()) {
                extensionSubsystem.liftRetract(-0.01);
            }
                extensionSubsystem.liftRetract(0);
                extensionSubsystem.liftEncoderReset();
                return true;
        }
    }
    //@Todo add arm logic
    public class MoveExtension implements Action {
        private boolean initialized = false;

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {

            while (!extensionSubsystem.getTouchSensor()) {
                extensionSubsystem.liftRetract(-0.01);
            }
            extensionSubsystem.liftRetract(0);
            extensionSubsystem.liftEncoderReset();
            return true;
        }
    }

    public Action liftHighBasket() {return new LiftHighBasket();}
    public Action liftHighChamber() {return new LiftHighChamber();}
    public Action liftZero() {return new LiftZero();}





}