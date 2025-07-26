package org.firstinspires.ftc.teamcode.Lib;

import com.acmerobotics.roadrunner.Vector2d;

public class Constants {
    public static final int EXTENSION_MIN = 0;
    public static final int EXTENSION_SPIKE = 1410;
    public static final int EXTENSION_SCORE_SPECIMEN = 1025;
    public static final int EXTENSION_MAX = 360;


    public static final int LIFT_PICKUP_SPECIMEN = 350;
    public static final int LIFT_BUCKET_2 = 1810;
    public static final int LIFT_BUCKET_1 = 550;
    public static final int LIFT_CHAMBER_2 = 617;


    public static final double BUCKET_X = 9.5;   //  Position of the bucket forward value for the OTOS auto relative to the robot (adjust for your robot)
    public static final double BUCKET_Y = -19.5;   //  Clip the turn speed to this max value (adjust for your robot)

    public static final double SPINNING = 1;
    public static final double OUTTAKE = -0.25;


    public static final double WRIST_DOWN = -0.2;
    public static final double WRIST_START = 0.6;
    public static final double WRIST_RETRACTED = 0.5;
    public static final double WRIST_PICKUP_SPECIMEN = 0;
    public static final double WRIST_SCORE_BUCKET = 0.2;
    public static final double WRIST_SCORE_CHAMBER = 0.30;
    public static final Vector2d FIRST_SPIKE_MARK_POS = new Vector2d(46,51);

    public static final Vector2d SECOND_SPIKE_MARK_POS = new Vector2d(59,51);
    public static final Vector2d THIRD_SPIKE_MARK_POS = new Vector2d(53,44);

    public static final Vector2d BUCKET_POS = new Vector2d(47, 48 );

    public static final double  FIRST_SPIKE_MARK = -90;
    public static final double  SECOND_SPIKE_MARK = -100;
    public static final double  THIRD_SPIKE_MARK = -120;

    public static final int SPIKE_HEADING = 0;

    public static final double LMEC_FRONT_LOCK = -1;
    public static final double LMEC_FRONT_UNLOCK = 1;
    public static final double LMEC_BACK_UNLOCK = -1;
    public static final double LMEC_BACK_LOCK = -1;

    public static final double DISTANCE_WHEN_IN = 58;

}