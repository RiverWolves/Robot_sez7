package org.firstinspires.ftc.teamcode.stef.resurse;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Roti;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class Autonomie_AD {

    private static int tag, FAZA = 0 ;
    private static TrajectorySequence traj1;
    private static TrajectorySequence parcare1;
    private static TrajectorySequence parcare3;

    private static SampleMecanumDrive drive = null;

    private static ElapsedTime et = null;

    public static void init (OpMode op){

        SHardware.init(op, true);
        TagBase.init(op);

        Brat.init();

        TagBase.update(op);

        if (et == null) {
            et = new ElapsedTime();
            et.reset();
        }
//


    }

    public static void loop(OpMode op){

        TagBase.update(op);
        tag = TagBase.tag();

        if (FAZA == 0){
            et.reset();
            Roti.setVelY(0.5);

            if (et.seconds() > 1){
                FAZA++;
            }
        }

        if (FAZA == 1 && tag == 0){
            et.reset();
            Roti.setVelR(0.3);

            if (et.seconds() > 0.5){
                Roti.setVelR(0);
                Roti.setVelY(0.5);

                if (et.seconds() > 1.2){
                    FAZA++;
                }
            }
        }

        if (FAZA == 1 && tag == 3){
            et.reset();
            Roti.setVelR(-0.3);

            if (et.seconds() > 0.5){
                Roti.setVelR(0);
                Roti.setVelY(0.5);

                if (et.seconds() > 1.2){
                    FAZA++;
                }
            }
        }

        if (FAZA == 2 || tag == 1){
            Roti.setVelXYR(0, 0, 0);
        }



//        drive = new SampleMecanumDrive(op.hardwareMap);
//
//        traj1 = drive.trajectorySequenceBuilder(new Pose2d(-24, -62, Math.toRadians(90)))
//                .forward(5)
//                .addTemporalMarker(6, ()->{
//
//
//                })
//                .splineToConstantHeading(new Vector2d(-10, -57), Math.toRadians(90))
//                .splineTo(new Vector2d(-17.5, -12), Math.toRadians(120) )
//                .waitSeconds(0.5)
//
//
//                .turn(Math.toRadians(60))
//                .waitSeconds(0.5)
//
//                .splineTo(new Vector2d(-58, -12), Math.toRadians(180))
//                .waitSeconds(1)
//                .setReversed(true)
//                .lineTo(new Vector2d(-48, -12))
//                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
//                .setReversed(false)
//                .waitSeconds(0.5)
//
//                .splineTo(new Vector2d(-48, -12), Math.toRadians(180))
//                .lineTo(new Vector2d(-58, -12))
//                .waitSeconds(1)
//                .setReversed(true)
//                .lineTo(new Vector2d(-48, -12))
//                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
//                .setReversed(false)
//                .waitSeconds(0.5)
//
//                .splineTo(new Vector2d(-48, -12), Math.toRadians(180))
//                .lineTo(new Vector2d(-58, -12))
//                .waitSeconds(1)
//                .setReversed(true)
//                .lineTo(new Vector2d(-48, -12))
//                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
//                .setReversed(false)
//                .waitSeconds(0.5)
//
//                .build();
//
//        parcare1 = drive.trajectorySequenceBuilder(new Pose2d(-31, -12, Math.toRadians(60)))
//
//                .splineTo(new Vector2d(-48, -12), Math.toRadians(180))
//                .lineTo(new Vector2d(-58, -12))
//
//                .build();



       op.telemetry.addData("tag: ", tag);

    }




}
