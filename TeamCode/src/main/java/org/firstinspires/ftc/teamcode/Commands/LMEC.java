package org.firstinspires.ftc.teamcode.Commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.ColorSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;

public class LMEC {

    private DcMotorEx lift;
    private IntakeSubsystem intakeSubsystem;
    private ColorSubsystem colorSubsystem;

    public LMEC(HardwareMap hardwareMap) {

    }

    public class LockLMEC implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeSubsystem.wristDown();
            return true;
        }
    }
    public class UnlockLMEC implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            intakeSubsystem.wristDown();
            return true;
        }
    }

}
