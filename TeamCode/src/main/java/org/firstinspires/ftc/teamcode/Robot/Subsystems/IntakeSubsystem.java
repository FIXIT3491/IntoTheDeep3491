package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.Command;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;

import java.util.function.BooleanSupplier;

public class IntakeSubsystem extends SubsystemBase {
    private CRServo intakeMotor;


    public IntakeSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "spinnny");
        //TODO add color sensor cause im lazy
    }

    // Intake method
    public void spinIntake(double power) {
        intakeMotor.setPower(power);
    }

    public boolean sampleIsRed(){
        //3;la'sdfasdf
        return true ;
    }
    public boolean sampleIsYellow(){
        //3;la'sdfasdf
        return true;
    }
    public boolean sampleIsBlue(){
        //3;la'sdfasdf
        return true;
    }
    public boolean sampleIsPurple(){
        //3;la'sdfasdf
        return true;
    }




}

