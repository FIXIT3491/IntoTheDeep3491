package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class IntakeSubsystem extends SubsystemBase {
    private CRServo intakeMotor;
    private ColorRangeSensor colorSensor;


    public IntakeSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "spinnny");
        colorSensor = hardwareMap.get(ColorRangeSensor.class, "color");
        //TODO add color sensor cause im lazy
    }

    // Intake method
    public void spinIntake(double power) {
        intakeMotor.setPower(power);
    }

    public double getDistance(){
        return colorSensor.getDistance(DistanceUnit.MM);
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

