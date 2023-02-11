package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.stef.resurse.Autonomie_AD;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;

@Autonomous(name = "Autonomie Test")
public class AutoTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Autonomie_AD.init(this);

        waitForStart();

        while(!isStopRequested()){
            Autonomie_AD.loop(this);
            telemetry.update();
        }
        TagBase.stop();
    }

}
