package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous( name = "Autonomie_Stanga" )
public class SAutonomie extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SHardware.init(this, true);
        Lift.init();
        Intake.init(this,true);
        Brat.init(true);
        TagBase.init(this);

        Intake.setInchis(true);

        ElapsedTime et = new ElapsedTime();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setPoseEstimate(new Pose2d(-31.22, -62.3, Math.toRadians(90)));

        TrajectorySequence TraiectorieDreapta = drive.trajectorySequenceBuilder(new Pose2d(-30.7, -61, Math.toRadians(90)))
                //Porneste
                .forward(2.5)


                .addDisplacementMarker( () -> {
                   Intake.setInchis(false);
                   Intake.loop(this);
                   Lift.setLiftLevel(3);
                })

                //Pleaca spre mijloc
                .strafeRight(18)

                 .addDisplacementMarker(()->{
                Brat.input(true);
                Brat.loop();
                })

//                 Mege la pilon
                .lineTo(new Vector2d(-11.5, -30))

                .splineTo(new Vector2d(-19, -8.8), Math.toRadians(120) )



                .addTemporalMarker(() ->{
                    Intake.setInchis(true);
                    Intake.loop(this);

                Lift.setLiftLevel(10);
                })
                .waitSeconds(0.5)

                //Se aliniaza cu turnul de conuri
                .back(4)
                .turn(Math.toRadians(60))
                .splineTo(new Vector2d(-61.5, -14), Math.toRadians(180))

                //Porneste spre pilon
                .addTemporalMarker(()->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(0.3)
                .addTemporalMarker(() ->{
                Lift.setLiftLevel(3);
                })
                .waitSeconds(0.5)

                .setReversed(true)

                .lineTo(new Vector2d(-47, -13))
                .addDisplacementMarker( ()->{
                    Intake.setRotire(false);
                    Intake.loop(this);

                    Brat.input(false);
                    Brat.loop();
                })

                .splineTo(new Vector2d(-31.2, -11.7), Math.toRadians(60))
                .setReversed(false)

                .UNSTABLE_addTemporalMarkerOffset(0.2, () ->{

                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
                .UNSTABLE_addTemporalMarkerOffset(-0.2, () ->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
                .UNSTABLE_addTemporalMarkerOffset(0.5, ()->{

                    Intake.setRotire(true);
                    Intake.loop(this);

                    Brat.input(true);
                    Brat.loop();

                    Lift.setLiftLevel(20);
                })
                .waitSeconds(1)

                //Se intoarce
                .splineTo(new Vector2d(-48, -14), Math.toRadians(180))
                .addDisplacementMarker(() ->{
                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .splineTo(new Vector2d(-60,-14.5), Math.toRadians(180))
                .UNSTABLE_addTemporalMarkerOffset(0, () ->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(1)
                .addTemporalMarker(()->{
                    Lift.setLiftLevel(3);
                })

                //Porneste spa puna con

                //  TODO: PUNE CON
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(new Vector2d(-46.3, -13))
                .addDisplacementMarker( ()->{
                        Intake.setRotire(false);
                        Intake.loop(this);

                        Brat.input(false);
                        Brat.loop();
                })
                .splineTo(new Vector2d(-31.3, -11.7), Math.toRadians(60))
                .setReversed(false)

                .UNSTABLE_addTemporalMarkerOffset(0.2, () ->{

                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
                .UNSTABLE_addTemporalMarkerOffset(-0.2, () ->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })

                .waitSeconds(0.5)
                .UNSTABLE_addTemporalMarkerOffset(0.5, ()->{

                    Intake.setRotire(true);
                    Intake.loop(this);



                    Lift.setLiftLevel(0);
                })
                .waitSeconds(0.5)
                .UNSTABLE_addTemporalMarkerOffset(0.5, ()->{
                    Brat.input(true);
                    Brat.loop();
                })
                .waitSeconds(1)
                .splineTo(new Vector2d(-35, -16), Math.toRadians(180))

                .build();



        TrajectorySequence first = drive.trajectorySequenceBuilder(TraiectorieDreapta.end())


                .lineTo(new Vector2d(-60, -13))
                .waitSeconds(10)
                .build();

        TrajectorySequence second = drive.trajectorySequenceBuilder(TraiectorieDreapta.end())


                .lineTo(new Vector2d(-36, -13))
                .waitSeconds(10)

                .build();

        TrajectorySequence third = drive.trajectorySequenceBuilder(TraiectorieDreapta.end())

                .lineTo(new Vector2d(-11,-13))
                .waitSeconds(10)
                .build();


        while (opModeInInit()){
            TagBase.update(this);

            telemetry.addData("id", TagBase.tag());
            telemetry.update();
        }



        waitForStart();

        et.reset();

        if (opModeIsActive()){



            drive.followTrajectorySequence(TraiectorieDreapta);

           /* drive.followTrajectorySequence(principala2);*/


            switch (TagBase.tag()){
                case 1:
                    drive.followTrajectorySequence(first);
                    break;
                case 2:
                    drive.followTrajectorySequence(second);
                    break;
                case 3:
                    drive.followTrajectorySequence(third);
                    break;

            }



            telemetry.addData("sec: ", et.seconds());
            telemetry.update();
        }


        if(isStopRequested()) {
            TagBase.stop();
            
        }
    }
}
