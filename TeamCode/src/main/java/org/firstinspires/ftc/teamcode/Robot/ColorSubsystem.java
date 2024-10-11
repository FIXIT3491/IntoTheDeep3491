package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSubsystem {
    private ColorSensor colorSensor;
    public int color;

    public ColorSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        //Hardware maps
        colorSensor = hardwareMap.get(ColorSensor.class, "extension");
    }

    // Intake method
    public int DetectColor() {
        // detect color apply to value put to string?
        //colorSensor.blue();
        //colorSensor.green();
        //colorSensor.red();


    return color;
    }


}