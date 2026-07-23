package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Claw extends mechanism {
    public static final int OPEN_POSITION = 1;
    public static final int CLOSED_POSITION = 0;
    public static final int SENSOR_THRESHOLD = 3;
    private Servo rightClaw;
    private Servo leftClaw;
    private RevColorSensorV3 sensor;
    Telemetry telemetry;
    private boolean wasInRange = false;
    public Claw(Servo leftClaw, Servo rightClaw, RevColorSensorV3 sensor, Telemetry telemetry) {
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;
        this.sensor = sensor;
        this.telemetry = telemetry;
        leftClaw.setDirection(Servo.Direction.REVERSE);
    }

    public void open() {
      rightClaw.setPosition(OPEN_POSITION);
      leftClaw.setPosition(OPEN_POSITION);
    }

    public void close(){
        rightClaw.setPosition(CLOSED_POSITION);
        leftClaw.setPosition(CLOSED_POSITION);
    }

    public void update() {
        if (sensor.getDistance(DistanceUnit.CM) < SENSOR_THRESHOLD){}
            close();
    }
    telemetry.addData("distance", sensor.getDistance(DistanceUnit.CM));
    wasInRange = sensor.getDistance(DistanceUnit.CM) < SENSOR_THRESHOLD;
}
