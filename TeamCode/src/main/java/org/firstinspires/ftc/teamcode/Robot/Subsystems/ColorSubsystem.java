package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.ColorRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class ColorSubsystem {
    private ColorRangeSensor colorSensor;

    String colorValue;
    String colour;
    int valueB;
    int valueG;
    int valueR;
    double distance;


    public ColorSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        //Hardware maps
        colorSensor = hardwareMap.get(ColorRangeSensor.class, "color");
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

    public double DetectDistance() {
        // detect color apply to value put to string
        distance = colorSensor.getDistance(DistanceUnit.MM);

        return distance;
    }
    public String nameColor(int r, int g, int b) {
        colorValue = "None";
        if (r > 50 && r < 80 && g > 100 && g < 150 && b > 150 && b < 190) {
            colorValue = "blue";
            return colorValue;
        } else if (r > 10 && r < 50 && g > 90 && g < 150 && b > 140 && b < 200) {
            colorValue = "yellow";
            return colorValue;
        } else if (r > 220 && r < 270 && g > 80 && g < 120 && b > 40 && b < 100) {
            colorValue = "red";
            return colorValue;
        } else {
            colorValue = "None";
            return colorValue;
        }// values are cooked, pls change later
    }
}