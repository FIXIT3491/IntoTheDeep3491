package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private CRServo intakeMotor;
    private Servo wristServoRight;
    private Servo wristServoLeft;

    public IntakeSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoRight = hardwareMap.get(Servo.class, "WSR");
        wristServoLeft = hardwareMap.get(Servo.class, "WSL");

        wristServoRight.setDirection(Servo.Direction.REVERSE);
    }

    // Intake method
    public void spinIntake(double power) {
        intakeMotor.setPower(power);
    }

    @Override
    public void setDefaultCommand(Command defaultCommand) {
        super.setDefaultCommand(defaultCommand);
    }

    public void wristMove(double distance){
        wristServoRight.setPosition(distance);
        wristServoLeft.setPosition(distance);
    }

}

