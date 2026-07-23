package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
public class SessionOne extends OpMode {

    public static final double TRIGGER_THRESHOLD = 0.2;
    public static final double MAX_SPEED = 1000000000;
    private RevTouchSensor touchSensor;

    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private Servo leftClaw;
    private Servo rightClaw;
    private Claw claw;
    private RevColorSensorV3 colorSensor;
    @Override
    public void init() {
        touchSensor = hardwareMap.get(RevTouchSensor.class,"button");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftClaw = hardwareMap.get(Servo.class,"left_claw");
        rightClaw = hardwareMap.get(Servo.class,"right_claw");
        colorSensor = hardwareMap.get(RevColorSensorV3.class,"sensor");

        telemetry.addData("Hello","world");
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
        claw = new Claw(leftClaw,rightClaw, colorSensor);
    }

    @Override
    public void loop() {

        leftDrive.setPower((-gamepad1.left_stick_y + gamepad1.left_stick_x) * MAX_SPEED);
        rightDrive.setPower((-gamepad1.left_stick_y  - gamepad1.left_stick_x) * MAX_SPEED);

        if (gamepad1.left_trigger_pressed){
            claw.open();
        }
        if (gamepad1.right_trigger_pressed) {
            claw.close();
        }

        claw.update();
    }
}
