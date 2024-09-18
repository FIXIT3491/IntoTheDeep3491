package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous

public class LockingMechanumTest extends LinearOpMode {

    private VoltageSensor myVoltageSensor;

    //Servo Declarations
    public ServoImplEx LMFRServo;
    public ServoImplEx  LMFLServo;
    public ServoImplEx  LMBRServo;
    public ServoImplEx  LMBLServo;

    public ElapsedTime time = new ElapsedTime();

    @Override
    public void runOpMode() {

        //Hardware Maps
        LMFRServo = hardwareMap.get(ServoImplEx.class, "LMFRS");
        LMFLServo = hardwareMap.get(ServoImplEx.class, "LMFLS");
        LMBRServo = hardwareMap.get(ServoImplEx.class, "LMBRS");
        LMBLServo = hardwareMap.get(ServoImplEx.class, "LMBLS");

        myVoltageSensor = hardwareMap.get(VoltageSensor.class, "Control Hub");


        LMFRServo.setPwmEnable();
        LMFLServo.setPwmEnable();
        LMBRServo.setPwmEnable();
        LMBLServo.setPwmEnable();

        LMFLServo.setDirection(Servo.Direction.REVERSE);
        LMBRServo.setDirection(Servo.Direction.REVERSE);

        LMFRServo.setPosition(0.0);
        LMFLServo.setPosition(0.0);
        LMBRServo.setPosition(0.0);
        LMBLServo.setPosition(0.0);

        double voltage = myVoltageSensor.getVoltage();


        waitForStart();


        LMFRServo.setPosition(0.3);
        LMFLServo.setPosition(0.3);
        LMBRServo.setPosition(0.3);
        LMBLServo.setPosition(0.3);

        LMFRServo.setPosition(0.19);
        LMFLServo.setPosition(0.19);
        LMBRServo.setPosition(0.19);
        LMBLServo.setPosition(0.19);
        time.reset();

        while (time.milliseconds() < 1000){
            voltage = myVoltageSensor.getVoltage();

            telemetry.addData("this step 4", "%.2f volts", voltage);
            telemetry.update();
        }


        LMFRServo.setPwmDisable();
        LMFLServo.setPwmDisable();
        LMBRServo.setPwmDisable();
        LMBLServo.setPwmDisable();


        while (opModeIsActive()) {
             voltage = myVoltageSensor.getVoltage();

            telemetry.addData("Battery Voltage", "%.2f volts", voltage);
            telemetry.update();

        }
        sleep(4000);

    }
}
