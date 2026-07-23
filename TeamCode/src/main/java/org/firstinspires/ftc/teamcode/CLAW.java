package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class CLAW {
    public static final int OPEN_POSITION = 1;
    public static final int CLOSE_POSITION = 0;
    public static final double COLOR_SENSOR_THRESHOLD = 3.14;
    public boolean wasInRange = false;
    private Servo rightClaw;
    private Servo leftClaw;
    private RevColorSensorV3 colorSensor;
    public CLAW(Servo leftClaw, Servo rightClaw, RevColorSensorV3 colorSensor) {
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;
        leftClaw.setDirection(Servo.Direction.REVERSE);
    }
    public void open() {
        rightClaw.setPosition(OPEN_POSITION);
        leftClaw.setPosition(OPEN_POSITION);

    }
    public void close() {
        rightClaw.setPosition(CLOSE_POSITION);
        leftClaw.setPosition((CLOSE_POSITION));

    }
    public void update(){
        if (colorSensor.getDistance(DistanceUnit.CM) < COLOR_SENSOR_THRESHOLD && !wasInRange){
            }
        wasInRange = colorSensor.getDistance(DistanceUnit.CM) < COLOR_SENSOR_THRESHOLD
        }
    }
