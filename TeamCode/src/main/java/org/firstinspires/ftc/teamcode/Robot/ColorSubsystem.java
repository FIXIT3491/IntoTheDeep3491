package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ColorSubsystem {
    private ColorSensor colorSensor;
    String color;
    String colour;
    int valueB;
    int valueG;
    int valueR;


    public ColorSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        //Hardware maps
        colorSensor = hardwareMap.get(ColorSensor.class, "extension");
    }

    // Intake method
    public String DetectColor() {
        // detect color apply to value put to string
        valueB = colorSensor.blue();
        valueG = colorSensor.green();
        valueR = colorSensor.red();
        colour = nameColor(valueR, valueG, valueB);

        return colour;
    }

    public String nameColor(int r, int g, int b) {
        color = "None";
        if (r > 50 && r < 80 && g > 100 && g < 150 && b > 150 && b < 190) {
            color = "blue";
            return color;
        } else if (r > 10 && r < 50 && g > 90 && g < 150 && b > 140 && b < 200) {
            color = "yellow";
            return color;
        } else if (r > 125 && r < 250 && g > 25 && g < 100 && b > 25 && b < 100) {
            color = "red";
            return color;
        } else {
            color = "None";
            return color;
        }// values are cooked, pls change later
    }
}