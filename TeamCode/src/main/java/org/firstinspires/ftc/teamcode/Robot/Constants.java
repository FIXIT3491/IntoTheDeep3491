package org.firstinspires.ftc.teamcode.Robot;

public class Constants {
    public static final int MIN_EXTENSION = 20;
    public static final int MAX_EXTENSION = 1000;
    public static final int LIFT_BUCKET_1 = -1;
    public static final int LIFT_BUCKET_2 = -1;
    public static final int LIFT_CHAMBER_1 = -1;
    public static final int LIFT_CHAMBER_2 = -1;

    public static final double SPARKFUN_SPEED_GAIN =  0.045  ;   // 0.02 Forward Speed Control "Gain". eg: Ramp up to 50% power at a 25 inch error.   (0.50 / 25.0)
    public static final double SPARKFUN_STRAFE_GAIN =  0.3;   // 0.015 Strafe Speed Control "Gain".  eg: Ramp up to 25% power at a 25 degree Yaw error.   (0.25 / 25.0)
    public static final double SPARKFUN_TURN_GAIN =  0.06  ;   // 0.01 Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)

    public static final double SPARKFUN_MAX_AUTO_SPEED = 0.5;   //  Clip the approach speed to this max value (adjust for your robot)
    public static final double SPARKFUN_MAX_AUTO_STRAFE = 0.5;   //  Clip the approach speed to this max value (adjust for your robot)
    public static final double SPARKFUN_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double IMU_TURN_GAIN =  0.040  ;   //  Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)
    public static final double IMU_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)



}
