package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.Robot;

@TeleOp
@Config
public class TeleOpTest extends Robot {


    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    @Override
    public void runOpMode()  {
        initialize(new Pose2d(-1,-1,-1));

        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);




        //@TODO add in the drive logic for defult drive command here, later down below add in the operator drive command stuff

    }


}
