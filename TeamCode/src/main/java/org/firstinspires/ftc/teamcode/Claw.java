package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Claw {
    public static final int OPEN_POSITION = 0;
    public static final int CLOSE_POSITION = 1;
    public static final int SENSOR_THRESHOLD = 4;
    private Servo leftClaw;
    private Servo rightClaw;
    private RevColorSensorV3 colorSensor;
    private boolean wasInRange = false;

    public Claw(Servo leftClaw, Servo rightClaw, RevColorSensorV3 colorSensor) {
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;
        leftClaw.setDirection(Servo.Direction.REVERSE);
    }

    public void open(){
        leftClaw.setPosition(OPEN_POSITION);
        rightClaw.setPosition(OPEN_POSITION);
    }

    public void close(){
        leftClaw.setPosition(CLOSE_POSITION);
        rightClaw.setPosition(CLOSE_POSITION);
    }

    public void update(){
        if (colorSensor.getDistance(DistanceUnit.CM) < SENSOR_THRESHOLD && !wasInRange){
            close();
        }
        wasInRange = colorSensor.getDistance(DistanceUnit.CM) < SENSOR_THRESHOLD;
    }
}
