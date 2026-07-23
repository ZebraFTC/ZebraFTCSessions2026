package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Examples extends OpMode{
    private RevTouchSensor touchSensor;
    private DcMotor leftDrive;
    private DcMotor rightDrive;
    private final double MAX_SPEED = 0.25;

    @Override
    public void init() {
        touchSensor = hardwareMap.get(RevTouchSensor.class, "button");
        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        leftDrive.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void tankDrive(double leftPower, double rightPower){
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }

    public void arcadeDrive(double forwardPower, double rightTurnPower)
    {
        leftDrive.setPower(forwardPower + rightTurnPower);
        rightDrive.setPower(forwardPower - rightTurnPower);
    }

    @Override
    public void loop() {
        telemetry.addData("OpMode", "started");
        telemetry.addData("runtime", getRuntime());
        telemetry.addData("panels button a", gamepad1.a);
        telemetry.addData("button", touchSensor.isPressed());
        double forwardSpeed = -gamepad1.left_stick_y * MAX_SPEED;
        double rightSpeed = gamepad1.left_stick_x * MAX_SPEED;
        arcadeDrive(forwardSpeed,rightSpeed);
    }
}
