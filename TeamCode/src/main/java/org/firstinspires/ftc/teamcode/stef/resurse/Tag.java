package org.firstinspires.ftc.teamcode.stef.resurse;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;

public class Tag {

    public static int tag = 0;

    public static void init(OpMode op){


        TagBase.update(op);

        tag = TagBase.tag();


    }

    public static void start(OpMode op){

        Brat.loop(op);
        Intake.loop(op);
        Lift.nivelLoop(op);

        SampleMecanumDrive drive = new SampleMecanumDrive(op.hardwareMap);

        /*drive.trajectoryBuilder(new Pose2d())
                .forward(30)
                .build(); */

//        drive.trajectoryBuilder(new Pose2d(-24,))

    }
}
