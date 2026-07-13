package org.firstinspires.ftc.teamcode;
import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class TelemetryTest extends OpMode{
    private TelemetryManager panelsTelemetry;

    @Override
    public void init() {
        panelsTelemetry = PanelsTelemetry.INSTANCE.getTelemetry();
        panelsTelemetry.addData("OpMode", "Initialised");
        panelsTelemetry.update(telemetry);
    }

    @Override
    public void loop() {
        panelsTelemetry.addData("OpMode", "started");
        panelsTelemetry.update(telemetry);

    }
}
