package org.firstinspires.ftc.teamcode.Robot;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;

public class Constants {
    public static final int MIN_EXTENSION = -1;
    public static final int SPIKE_EXTENSION = -1;
    public static final int MAX_EXTENSION = -1;
    public static final int LIFT_BUCKET_1 = -1;
    public static final int LIFT_BUCKET_2 = -1;
    public static final int LIFT_CHAMBER_1 = -1;
    public static final int LIFT_CHAMBER_2 = -1;

    public static final double IMU_TURN_GAIN =  0.020  ;   //  Turn Control "Gain".  eg: Ramp up to 25% power at a 25 degree error. (0.25 / 25.0)
    public static final double IMU_MAX_AUTO_TURN = 0.4;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double BUCKET_X = 9.5;   //  Position of the bucket forward value for the OTOS auto relative to the robot (adjust for your robot)
    public static final double BUCKET_Y = -19.5;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double SPINNING = -1;
    public static final double WRIST_DOWN = -1;
    public static final double WRIST_UP = -1;
    public static final double WRIST_OUT = -1;

    public static final Vector2d FIRST_SPIKE_MARK = new Vector2d(-1,-1);
    public static final Vector2d SECOND_SPIKE_MARK = new Vector2d(-1,-1);
    public static final Vector2d THIRD_SPIKE_MARK = new Vector2d(-1,-1);

    public static final int SPIKE_HEADING = 0;


    public static final Vector2d BUCKET = new Vector2d(-1,-1);

}