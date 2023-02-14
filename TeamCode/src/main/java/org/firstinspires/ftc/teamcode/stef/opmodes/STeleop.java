package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stef.resurse.SGamepad;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Giroscop;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;



@TeleOp(name = "TeleOp")
public class STeleop extends LinearOpMode {



    @Override
    public void runOpMode() throws InterruptedException {

        SHardware.init(this, false);
        Giroscop.init();
        Lift.init();
        Intake.init();
        Brat.init();

        SGamepad.init();

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()){

            SGamepad.loop(this);

            Giroscop.loop();
            Lift.loop(this);
            Lift.nivelLoop(this);
            Brat.loop();
            Intake.loop(this);

            telemetry.update();
        }

        SHardware.initializat = false;
    }
}
