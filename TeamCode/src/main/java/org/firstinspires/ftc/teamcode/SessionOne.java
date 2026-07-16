package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp
public class SessionOne extends OpMode {

    public static final double TRIGGER_THRESHOLD = 0.2;
    public static final double MAX_SPEED = 0.5;
    private RevTouchSensor touchSensor;
    private DcMotor leftDrive;
    private DcMotor rightDrive;

    @Override
    public void init() {
        touchSensor = hardwareMap.get(RevTouchSensor.class, "button");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        telemetry.addData("Hello", "world");
        rightDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        telemetry.addData("x", gamepad1.left_stick_x);
        telemetry.addData("y", -gamepad1.left_stick_y);

        leftDrive.setPower(-gamepad1.left_stick_y * MAX_SPEED);
        rightDrive.setPower(-gamepad1.right_stick_y * MAX_SPEED);
    }
}
