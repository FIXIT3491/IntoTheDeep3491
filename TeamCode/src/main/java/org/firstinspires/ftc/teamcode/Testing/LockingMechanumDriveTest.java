package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class LockingMechanumDriveTest extends LinearOpMode {
private VoltageSensor myVoltageSensor;

    //Servos Declarations

    public ServoImplEx LMFRServo;
    public ServoImplEx  LMFLServo;
    public ServoImplEx  LMBRServo;
    public ServoImplEx  LMBLServo;

    //Motor Declarations

    public DcMotor DriveFR;
    public DcMotor DriveFL;
    public DcMotor DriveBR;
    public DcMotor DriveBL;

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad previousGamepad1 = new Gamepad();

    //Boolean Expressions

    boolean LMActive = false;

    public ElapsedTime time = new ElapsedTime();
    public ElapsedTime time2 = new ElapsedTime();
    public ElapsedTime time3 = new ElapsedTime();
    public ElapsedTime time4 = new ElapsedTime();


    @Override
    public void runOpMode() {
        //hardware maps

        DriveFL = hardwareMap.get(DcMotor.class, "FLD");
        DriveBL = hardwareMap.get(DcMotor.class, "BLD");
        DriveFR = hardwareMap.get(DcMotor.class, "FRD");
        DriveBR = hardwareMap.get(DcMotor.class, "BRD");

        LMFRServo = hardwareMap.get(ServoImplEx.class, "LMFRS");
        LMFLServo = hardwareMap.get(ServoImplEx.class, "LMFLS");
        LMBRServo = hardwareMap.get(ServoImplEx.class, "LMBRS");
        LMBLServo = hardwareMap.get(ServoImplEx.class, "LMBLS");

        myVoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");

        //Direction Motors
        DriveFL.setDirection(DcMotor.Direction.REVERSE);
        DriveBL.setDirection(DcMotor.Direction.REVERSE);
        DriveFR.setDirection(DcMotor.Direction.FORWARD);
        DriveBR.setDirection(DcMotor.Direction.FORWARD);

        //brake on zero
        DriveFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        //Direction Servo
        LMFLServo.setDirection(Servo.Direction.REVERSE);
        LMBRServo.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()) {

            //logic for toggling gamepad
            previousGamepad1.copy(currentGamepad1);
            currentGamepad1.copy(gamepad1);


            //Checking for a or b
            if (gamepad1.a) {

                if (currentGamepad1.a && !previousGamepad1.a) {
                    lockMecanum();
                }
            } else if (gamepad1.b) {
                LMActive = false;
               if (currentGamepad1.b && !previousGamepad1.b) {
                    unlockMecanum();
                }
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

            //Drive Logic

            DriveFL.setPower(FLPower);
            DriveFR.setPower(FRPower);
            DriveBL.setPower(BLPower);
            DriveBR.setPower(BRPower);

            double voltage = myVoltageSensor.getVoltage();
            telemetry.addData("Battery Voltage", "%.2f volts", voltage);
            telemetry.update();
        }
    }
    public void lockMecanum(){
        if (!LMActive) {
            LMFRServo.setPosition(0.3);
            LMFLServo.setPosition(0.3);
            LMBRServo.setPosition(0.3);
            LMBLServo.setPosition(0.4);

            LMFRServo.setPosition(0.19);
            LMFLServo.setPosition(0.19);
            LMBRServo.setPosition(0.19);
            LMBLServo.setPosition(0.25);
            time.reset();


            while (time.milliseconds() < 1000){
            }


            LMFRServo.setPwmDisable();
            LMFLServo.setPwmDisable();
            LMBRServo.setPwmDisable();
            LMBLServo.setPwmDisable();

        }
    }
    public void unlockMecanum(){
        LMFRServo.setPwmEnable();
        LMFLServo.setPwmEnable();
        LMBRServo.setPwmEnable();
        LMBLServo.setPwmEnable();

        LMFRServo.setPosition(0);
        LMFLServo.setPosition(0);
        LMBRServo.setPosition(0);
        LMBLServo.setPosition(0);
        time3.reset();
        if (time3.milliseconds() > 1000) {
            LMFRServo.setPwmDisable();
            LMFLServo.setPwmDisable();
            LMBRServo.setPwmDisable();
            LMBLServo.setPwmDisable();
            LMActive = true;
        }
    }
}
