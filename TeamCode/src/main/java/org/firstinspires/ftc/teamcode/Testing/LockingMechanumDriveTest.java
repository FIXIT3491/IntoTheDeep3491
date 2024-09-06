package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class LockingMechanumDriveTest extends LinearOpMode {


    //Servos Declarations

    public Servo LMFRServo;
    public Servo LMFLServo;
    public Servo LMBRServo;
    public Servo LMBLServo;

    //Motor Declarations

    public DcMotor DriveFR;
    public DcMotor DriveFL;
    public DcMotor DriveBR;
    public DcMotor DriveBL;

    //Boolean Expressions

    boolean LMActive;


    @Override
    public void runOpMode() {
        //hardware maps

        DriveFL = hardwareMap.get(DcMotor.class, "FLD");
        DriveBL = hardwareMap.get(DcMotor.class, "BLD");
        DriveFR = hardwareMap.get(DcMotor.class, "FRD");
        DriveBR = hardwareMap.get(DcMotor.class, "BRD");

        LMFRServo = hardwareMap.get(Servo.class, "LMFRS");
        LMFLServo = hardwareMap.get(Servo.class, "LMFLS");
        LMBRServo = hardwareMap.get(Servo.class, "LMBRS");
        LMBLServo = hardwareMap.get(Servo.class, "LMBLS");

        waitForStart();

        //Checking for a or b
        if (gamepad1.a){
            LMActive = true;
        }

        else if (gamepad1.b){
            LMActive = false;
        }

        if(LMActive){
            lockMecanum();
        }

        else if (!LMActive){
            unlockMecanum();
        }


        //drive logic
        double max;
        double lateral;

        double axial = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value

        if (LMActive)
            lateral = 0;
        else
            lateral = gamepad1.left_stick_x;

        double yaw = gamepad1.right_stick_x;

        double FLPower = axial + lateral + yaw;
        double FRPower = axial - lateral - yaw;
        double BLPower = axial - lateral + yaw;
        double BRPower = axial + lateral - yaw;

        max = Math.max(Math.abs(FLPower), Math.abs(FRPower));
        max = Math.max(max, Math.abs(BLPower));
        max = Math.max(max, Math.abs(BRPower));
        if (max > 1.0) {
            FLPower /= max;
            FRPower /= max;
            BLPower /= max;
            BRPower /= max;
        }
    }
    public void lockMecanum(){
        LMFRServo.setPosition(0.28);
        LMFLServo.setPosition(0.28);
        LMBRServo.setPosition(0.28);
        LMBLServo.setPosition(0.28);
    }
    public void unlockMecanum(){
        LMFRServo.setPosition(0);
        LMFLServo.setPosition(0);
        LMBRServo.setPosition(0);
        LMBLServo.setPosition(0);
    }
}
