package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class ExtensionSubsystem {
    private DcMotorEx extensionMotor;


    public ExtensionSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");

    }

    public void moveExtension(int pos){

    }

    // Extension method
    public void extend() {
        // Code to extend,

        //
        //


    }
    public void chamberLow() {
        // Code to retract
    }
    public void chamberHigh() {
        // Code to stop extension
    }
    public void bucketLow() {
        // Code to stop extension
    }
    public void bucketHigh() {
        // Code to stop extension
    }
}
