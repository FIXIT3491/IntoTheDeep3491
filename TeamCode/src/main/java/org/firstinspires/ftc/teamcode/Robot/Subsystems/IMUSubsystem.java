package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

public class IMUSubsystem {
    public IMU imu;

    public IMUSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {

        imu = hardwareMap.get(IMU.class, "imu");

        //imu config
        RevHubOrientationOnRobot.LogoFacingDirection logoDirection = RevHubOrientationOnRobot.LogoFacingDirection.LEFT;
        RevHubOrientationOnRobot.UsbFacingDirection  usbDirection  = RevHubOrientationOnRobot.UsbFacingDirection.UP;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot(logoDirection, usbDirection);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample OpMode

        imu.resetYaw();
        imu.initialize(new IMU.Parameters(orientationOnRobot));
    }
    public double getHeading(){
        return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
    }
    public YawPitchRollAngles getYawPitchRoll(){
        return imu.getRobotYawPitchRollAngles();
    }
    public void resetHeading(){
        imu.resetYaw();
    }
}
