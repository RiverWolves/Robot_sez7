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

@Autonomous( name = "amin" )
public class Parcare extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SHardware.init(this, true);
        Lift.init();
        Intake.init();
        Brat.init();
//        TagBase.init(this);

        Intake.setInchis(true);

        ElapsedTime et = new ElapsedTime();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setPoseEstimate(new Pose2d(-31.22, -62, Math.toRadians(90)));

        TrajectorySequence principala1 = drive.trajectorySequenceBuilder(new Pose2d(-31.22, -61, Math.toRadians(90)))
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
                .lineTo(new Vector2d(-12, -30))

                .splineTo(new Vector2d(-18.7, -9.8), Math.toRadians(120) )


                .waitSeconds(0.5)
                .addDisplacementMarker(() ->{
                Intake.setInchis(true);
                Intake.loop(this);
                Lift.setLiftLevel(10);
                })

                //Se aliniaza cu turnul de conuri
                .back(4)
                .waitSeconds(0.2)
                .turn(Math.toRadians(60))
                .splineTo(new Vector2d(-58, -16), Math.toRadians(180))

                //Porneste spre pilon
                .addDisplacementMarker(() ->{
                Lift.setLiftLevel(3);
                })

                .setReversed(true)

                .lineTo(new Vector2d(-51, -16))
                .addDisplacementMarker( ()->{
                    Intake.setRotire(false);
                    Intake.loop(this);

                    Brat.input(false);
                    Brat.loop();
                })
                .splineTo(new Vector2d(-31, -14), Math.toRadians(60))
//                        .setConstraints(SampleMecanumDrive.getVelocityConstraint(
//                        30, Math.toRadians(90), 11.89),
//                        SampleMecanumDrive.getAccelerationConstraint(30))

                //Se aliniaza spre turnul de conuri.
                .setReversed(false)
                 .addDisplacementMarker(() ->{
                     Intake.setRotire(true);
                     Intake.loop(this);
                     Brat.input(true);
                     Brat.loop();
                     Lift.setLiftLevel(20);
                 })
                .waitSeconds(1.5)
                //Se intoarce
                .splineTo(new Vector2d(-48, -16), Math.toRadians(180))
                .splineTo(new Vector2d(-58, -16), Math.toRadians(180))
                .addDisplacementMarker(() ->{
                Lift.setLiftLevel(3);
                })

                //Porneste spa puna con

                //  TODO: PUNE CON
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(new Vector2d(-51, -16))
                .addDisplacementMarker( ()->{
                        Intake.setRotire(false);
                        Intake.loop(this);

                        Brat.input(false);
                        Brat.loop();
                })
                .splineTo(new Vector2d(-31, -14), Math.toRadians(60))
                //Se intoarce

                .setReversed(false)
                .waitSeconds(1.5)

             /*   .addDisplacementMarker(() ->{
                Intake.setRotire(true);
                     Intake.loop(this);
                     Brat.input(true);
                     Brat.loop(this);
                     Lift.setLiftLevel(0);
                })*/

                .build();

        TrajectorySequence principala2 = drive.trajectorySequenceBuilder(new Pose2d(33, -61, Math.toRadians(90)))
                                 //Porneste
                                .forward(2.5)
                                .waitSeconds(0.2)
                                 /*
                                 .addDisplacementMarker( () -> {
                                 Intake.setInchis(false);
                                 Intake.loop(this);
                                 Lift.setLiftLevel(3);
                                 })
                                 */
                                //Pleaca spre mijloc
                                .strafeLeft(21.5)
                                .waitSeconds(0.2)
                                /*.addDisplacementMarker(()->{
                                       Brat.brat_fata();
                                       Brat.loop(this);
                                })*/
                                // Mege la pilon
                                .lineTo(new Vector2d(11, -30))
                                .splineTo(new Vector2d(18, -8.8), Math.toRadians(60) )

                                .waitSeconds(0.5)
                                /*.addDisplacementMarker(() ->{
                                Intake.setInchis(false);
                                Intake.loop(this);
                                Lift.setLiftLevel(0);
                                })
                                */
                                //Se aliniaza spre turnul de conuri.

                                .back(4)
                                .waitSeconds(0.2)
                                .turn(Math.toRadians(-60))
                                .splineTo(new Vector2d(62, -15), Math.toRadians(0))

                                //Porneste spre pilon
                                /*.addDisplacementMarker(() ->{
                                Lift.setLiftLevel(3);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)

                                .lineTo(new Vector2d(51, -15))
                                .splineTo(new Vector2d(29, -8.8), Math.toRadians(120))
                                .waitSeconds(1.5)
                                //Se aliniaza spre turnul de conuri.
                                .setReversed(false)
                                /*.addDisplacementMarker(()->{
                                 Lift.setLiftLevel(0);
                                 })*/
                                .splineTo(new Vector2d(48, -15), Math.toRadians(0))
                                .splineTo(new Vector2d(62, -15), Math.toRadians(0))
                                 /*.addDisplacementMarker(() ->{
                                 Intake.setInchis(true);
                                 Intake.loop(this);
                                 Lift.setLiftLevel(3);
                                 })
                                */

                                //  TODO: PUNE CON
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(new Vector2d(51, -15))
                                .splineTo(new Vector2d(29, -8.8), Math.toRadians(120))

                                .setReversed(false)
                                .waitSeconds(1.5)
                                //Se aliniaza spre turnul de conuri.
                                /*.addDisplacementMarker(() ->{
                                Intake.setInchis(false);
                                Intake.loop(this);
                                Lift.setLiftLevel(0);
                                })
                                 */
                                 //Se intoarce
                                .splineTo(new Vector2d(48, -15), Math.toRadians(0))
                                .splineTo(new Vector2d(62, -15), Math.toRadians(0))
                                .build();

        TrajectorySequence first = drive.trajectorySequenceBuilder(principala1.end())

                .lineTo(new Vector2d(-60, -16))
                .build();

        TrajectorySequence second = drive.trajectorySequenceBuilder(principala1.end())

                .addDisplacementMarker(() ->{
                    Intake.setRotire(true);
                    Intake.loop(this);
                    Brat.input(true);
                    Brat.loop();
                    Lift.setLiftLevel(0);
                })
                .splineTo(new Vector2d(-35, -16), Math.toRadians(180))

                .waitSeconds(10)

                .build();

        TrajectorySequence third = drive.trajectorySequenceBuilder(principala1.end())

                .lineTo(new Vector2d(-12,-16))
                .build();


//        while (opModeInInit()){
//            TagBase.update(this);
//        }



        waitForStart();

        et.reset();

        if (opModeIsActive()){



            drive.followTrajectorySequence(principala1);

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
//            TagBase.stop();
            return;
        }
    }
}
