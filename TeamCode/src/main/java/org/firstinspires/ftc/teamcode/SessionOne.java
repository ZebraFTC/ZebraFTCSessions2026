package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class SessionOne extends OpMode {

    public static final double TRIGGER_THRESHOLD = 0.2;
    public static final double MAX_SPEED = 0.5;
    public static final int TP = 10;
    private CLAW claw;
    private RevTouchSensor touchSensor;
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private Servo leftClaw;
    private Servo rightClaw;
    private RevColorSensorV3 colorSensor;


    @Override
    public void init() {
        touchSensor = hardwareMap.get(RevTouchSensor.class, "button");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftClaw = hardwareMap.get(Servo.class, "right_claw");
        rightClaw = hardwareMap.get(Servo.class, "left_claw");
        colorSensor = hardwareMap.get(RevColorSensorV3.class, "sensor");

        claw = new CLAW(leftClaw, rightClaw, colorSensor);
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("y", -gamepad1.left_stick_y);

        leftDrive.setPower((Math.signum(-gamepad1.left_stick_y) * Math.pow(gamepad1.left_stick_y, TP) + Math.signum(-gamepad1.left_stick_x) * Math.pow(gamepad1.left_stick_x, TP)) * MAX_SPEED);
        rightDrive.setPower((Math.signum(-gamepad1.left_stick_y) * Math.pow(gamepad1.left_stick_y, TP) - Math.signum(-gamepad1.left_stick_x) * Math.pow(gamepad1.left_stick_x, TP)) * MAX_SPEED);

        if (gamepad1.left_trigger_pressed){
            claw.open();
        }
        if (gamepad1.right_trigger_pressed){
            claw.close();
        }
        claw.update();
    }
}