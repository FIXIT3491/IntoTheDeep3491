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

        myBot.runAction(myBot.getDrive().actionBuilder(new Pose2d(-9, 61, -90))

                .strafeToSplineHeading(new Vector2d(-12,37), Math.toRadians(-90)) // score preset
                .waitSeconds(0.5)

                .strafeToSplineHeading(new Vector2d(-32,37), Math.toRadians(-90)) // strafe right

                .strafeToSplineHeading(new Vector2d(-41,10), Math.toRadians(-90)) // go forward
                .strafeToSplineHeading(new Vector2d(-44,55), Math.toRadians(-90)) // push sample to obbie

                .strafeToSplineHeading(new Vector2d(-49,10), Math.toRadians(-90)) // go forward
                .strafeToSplineHeading(new Vector2d(-60,55), Math.toRadians(-90)) // push sample to obbie

                .strafeToSplineHeading(new Vector2d(-37, 52), Math.toRadians(90)) // line up to pickup
                .strafeToSplineHeading(new Vector2d(-37,58), Math.toRadians(-270)) // pickup
                .waitSeconds(0.5)
                .strafeToSplineHeading(new Vector2d(-10, 37), Math.toRadians(-90)) // line up to score spec
                .strafeToSplineHeading(new Vector2d(-10, 34), Math.toRadians(-90)) // score spec
                .waitSeconds(0.5)

                .strafeToSplineHeading(new Vector2d(-37, 52), Math.toRadians(-270)) // line up to pickup
                .strafeToSplineHeading(new Vector2d(-37,58), Math.toRadians(-270)) // pickup
                .waitSeconds(0.5)
                .strafeToSplineHeading(new Vector2d(-8, 37), Math.toRadians(-90)) // line up to score spec
                .strafeToSplineHeading(new Vector2d(-8, 34), Math.toRadians(-90)) // score spec
                .waitSeconds(0.5)

                .strafeToSplineHeading(new Vector2d(-37, 52), Math.toRadians(-270)) // line up to pickup
                .strafeToSplineHeading(new Vector2d(-37,58), Math.toRadians(-270)) // pickup
                .waitSeconds(0.5)
                .strafeToSplineHeading(new Vector2d(-6, 37), Math.toRadians(-90)) // line up to score spec
                .strafeToSplineHeading(new Vector2d(-6, 34), Math.toRadians(-90)) // score spec


                .build());



        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
