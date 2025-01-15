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

    ExtensionSubsystem extensionSubsystem;

    public Lift(ExtensionSubsystem i) {
        extensionSubsystem = i;
    }

    public class LiftHighChamber implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extensionSubsystem.chamberHigh();
            return false;
        }
    }

    public class LiftHighBasket implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extensionSubsystem.bucketHigh();
            return false;
        }
    }

    //Todo: test da code
    public class LiftZero implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {

            while (!extensionSubsystem.getTouchSensor()) {
                extensionSubsystem.liftRetract(-0.01);
            }
                extensionSubsystem.liftRetract(0);
                extensionSubsystem.liftEncoderReset();
            return false;
        }
    }
    public class MoveExtensionPreload implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extensionSubsystem.moveExtension(1600);

            return false;
        }
    }
    public class MoveExtensionZero implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extensionSubsystem.moveExtension(120);

            return false;
        }
    }

    public class MoveExtensionScoring implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            extensionSubsystem.moveExtension(850);

            return false;
        }
    }

    public Action liftHighBasket() {return new LiftHighBasket();}
    public Action liftHighChamber() {return new LiftHighChamber();}
    public Action liftZero() {return new LiftZero();}
    public Action moveExtensionPreload() {return new MoveExtensionPreload();}
    public Action moveExtensionZero() {return new MoveExtensionZero();}
    public Action moveExtensionScoring() {return new MoveExtensionScoring();}





}