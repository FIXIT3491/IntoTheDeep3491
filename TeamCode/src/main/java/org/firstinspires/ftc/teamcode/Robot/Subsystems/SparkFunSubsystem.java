package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.hardware.sparkfun.SparkFunOTOS;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class SparkFunSubsystem {
    // Create an instance of the sensor
    public SparkFunOTOSCorrected myOtos;
    SparkFunOTOSCorrected.Pose2D pos;

    public SparkFunSubsystem(HardwareMap hardwareMap, Telemetry telemetry){
        myOtos = hardwareMap.get(SparkFunOTOSCorrected.class, "sensor_otos");
    }

    public void configureOtos() {
//        telemetry.addLine("Configuring OTOS...");
//        telemetry.update();

        // myOtos.setLinearUnit(DistanceUnit.METER);
        myOtos.setLinearUnit(DistanceUnit.INCH);
        // myOtos.setAngularUnit(AnguleUnit.RADIANS);
        myOtos.setAngularUnit(AngleUnit.DEGREES);

        // Assuming you've mounted your sensor to a robot and it's not centered,
        // you can specify the offset for the sensor relative to the center of the
        // robot. The units default to inches and degrees, but if you want to use
        // different units, specify them before setting the offset! Note that as of
        // firmware version 1.0, these values will be lost after a power cycle, so
        // you will need to set them each time you power up the sensor. For example, if
        // the sensor is mounted 5 inches to the left (negative X) and 10 inches
        // forward (positive Y) of the center of the robot, and mounted 90 degrees
        // clockwise (negative rotation) from the robot's orientation, the offset
        // would be {-5, 10, -90}. These can be any value, even the angle can be
        // tweaked slightly to compensate for imperfect mounting (eg. 1.3 degrees).
        SparkFunOTOSConfig.Pose2D offset = new SparkFunOTOSConfig.Pose2D(0, -7.875, 0);
        myOtos.setOffset(new SparkFunOTOS.Pose2D(0, -7.875, 0));

        // Here we can set the linear and angular scalars, which can compensate for
        // scaling issues with the sensor measurements. Note that as of firmware
        // version 1.0, these values will be lost after a power cycle, so you will
        // need to set them each time you power up the sensor. They can be any value
        // from 0.872 to 1.127 in increments of 0.001 (0.1%). It is recommended to
        // first set both scalars to 1.0, then calibrate the angular scalar, then
        // the linear scalar. To calibrate the angular scalar, spin the robot by
        // multiple rotations (eg. 10) to get a precise error, then set the scalar
        // to the inverse of the error. Remember that the angle wraps from -180 to
        // 180 degrees, so for example, if after 10 rotations counterclockwise
        // (positive rotation), the sensor reports -15 degrees, the required scalar
        // would be 3600/3585 = 1.004. To calibrate the linear scalar, move the
        // robot a known distance and measure the error; do this multiple times at
        // multiple speeds to get an average, then set the linear scalar to the
        // inverse of the error. For example, if you move the robot 100 inches and
        // the sensor reports 103 inches, set the linear scalar to 100/103 = 0.971
        myOtos.setLinearScalar(1.0);
        myOtos.setAngularScalar(0.996);

        //slow 100.912
        //98.786
        //98.894

        // The IMU on the OTOS includes a gyroscope and accelerometer, which could
        // have an offset. Note that as of firmware version 1.0, the calibration
        // will be lost after a power cycle; the OTOS performs a quick calibration
        // when it powers up, but it is recommended to perform a more thorough
        // calibration at the start of all your OpModes. Note that the sensor must
        // be completely stationary and flat during calibration! When calling
        // calibrateImu(), you can specify the number of samples to take and whether
        // to wait until the calibration is complete. If no parameters are provided,
        // it will take 255 samples and wait until done; each sample takes about
        // 2.4ms, so about 612ms total
        myOtos.calibrateImu();

        // Reset the tracking algorithm - this resets the position to the origin,
        // but can also be used to recover from some rare tracking errors
        myOtos.resetTracking();

//         After resetting the tracking, the OTOS will report that the robot is at
//         the origin. If your robot does not start at the origin, or you have
//         another source of location information (eg. vision odometry), you can set
//         the OTOS location to match and it will continue to track from there.
        SparkFunOTOSCorrected.Pose2D currentPosition = new SparkFunOTOSCorrected.Pose2D(0, 0, 0);
        myOtos.setPosition(currentPosition);
    }


    public SparkFunOTOSCorrected.Pose2D pos(){
        return myOtos.getPosition();
    }

    public void moveOTOS(){

    }

    public SparkFunOTOSCorrected.Pose2D myPosition() {
        pos = myOtos.getPosition();
        SparkFunOTOSCorrected.Pose2D myPos = new SparkFunOTOSCorrected.Pose2D(pos.y, pos.x, pos.h);
        return(myPos);
    }

    }


