package org.firstinspires.ftc.teamcode.Robot;

public class Constants {
    public static final int MIN_EXTENSION = 10;
    public static final int MAX_EXTENSION = 1870;
    public static final int LIFT_BUCKET_1 = 2600;
    public static final int LIFT_BUCKET_2 = 4300;
    public static final int LIFT_CHAMBER_1 = -1;
    public static final int LIFT_CHAMBER_2 = -1;

    public static final double SPARKFUN_SPEED_GAIN =  0.09;   // 0.02 Forward Speed Control "Gain". eg: Ramp up to 50% power at a 25 inch error.   (0.50 / 25.0)
    public static final double SPARKFUN_STRAFE_GAIN =  0.2;   // 0.015 Strafe Speed Control "Gain".  eg: Ramp up to 25% power at a 25 degree Yaw error.   (0.25 / 25.0)
    public static final double SPARKFUN_TURN_GAIN =  0.09  ;   // 0.01 Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)

    public static final double SPARKFUN_MAX_AUTO_SPEED = 0.4;   //  Clip the approach speed to this max value (adjust for your robot)
    public static final double SPARKFUN_MAX_AUTO_STRAFE = 0.5;   //  Clip the approach speed to this max value (adjust for your robot)
    public static final double SPARKFUN_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double IMU_TURN_GAIN =  0.020  ;   //  Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)
    public static final double IMU_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double BUCKET_X = 9.5;   //  Position of the bucket forward value for the OTOS auto relative to the robot (adjust for your robot)
    public static final double BUCKET_Y = -19.5;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double SPINNING = 0.80;
    public static final double WRIST_DOWN = 0.01;
    public static final double WRIST_UP = 0.5;
    public static final double WRIST_OUT = -1;



}
