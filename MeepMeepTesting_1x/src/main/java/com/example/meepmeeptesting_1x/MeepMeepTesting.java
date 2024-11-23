package com.example.meepmeeptesting_1x;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.VelConstraint;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setDimensions(15,18)
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 20)
                .build();

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(0, 0, 0))
                        .waitSeconds(4.2) //score bucket first sample
                .strafeToConstantHeading(new Vector2d(36, 36)) //drive to spike mark for second sample                .waitSeconds(.75) // wait for wrist to come down
                .strafeToSplineHeading(new Vector2d(53,53), Math.toRadians(45)) // drive to bucket for second sample
                .build());

        //                .waitSeconds(1)
//                .turn(45)
//                .lineToX(40) // pick up sample
//                .waitSeconds(2) // wait for wrist to come up and also set arm high bucket
//                .splineToConstantHeading(new Vector2d(40, 53), 0) // drive to bucket for second sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToSplineHeading(new Vector2d(45, 36), 0) // drive to spike mark for 3rd sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(50) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(1) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53, 53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
//                .waitSeconds(1) // wait for scoring
//                .strafeToLinearHeading(new Vector2d(55, 25), Math.toRadians(0)) // drive to spike mark for forth sample
//                .waitSeconds(.5)// wait for wrist to come down
//                .lineToX(60) // pickup sample
//                .waitSeconds(.5) // wait for claw to go up
//                .setTangent(2) // set tangent for spline to bucket
//                .splineToSplineHeading(new Pose2d(53, 53, Math.toRadians(45)), Math.toRadians(80)) // drive to bucket for third sample
//                .waitSeconds(1); // wait for scoring


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
