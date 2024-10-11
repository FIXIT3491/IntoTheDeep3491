package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSubsystem {
    private CRServo intakeMotor;

    public IntakeSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "extension");
    }

    // Intake method
    public void activateIntake(double power) {
        intakeMotor.setPower(power);
    }

    public void stopIntake() {
        intakeMotor.setPower(0);
    }
}

