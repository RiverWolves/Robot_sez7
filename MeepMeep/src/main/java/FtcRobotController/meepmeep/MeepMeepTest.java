package FtcRobotController.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTest {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(20, 70, Math.toRadians(180), Math.toRadians(180), 11.99)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-31.22, -61, Math.toRadians(90)))
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
                                .strafeRight(18)
                                .waitSeconds(0.2)
                                /* .addDisplacementMarker(()->{
                                Brat.brat_fata();
                                Brat.loop(this);
                                })
                                */
                                // Mege la pilon
                                .lineTo(new Vector2d(-11, -30))

                                .splineTo(new Vector2d(-18, -8.8), Math.toRadians(120) )

                                .waitSeconds(0.5)
                                /*.addDisplacementMarker(() ->{
                                Intake.setInchis(false);
                                Intake.loop(this);
                                Lift.setLiftLevel(0);
                                })
                                */
                                //Se aliniaza cu turnul de conuri
                                .back(4)
                                .waitSeconds(0.2)
                                .turn(Math.toRadians(60))
                                .splineTo(new Vector2d(-59, -12), Math.toRadians(180))

                                //Porneste spre pilon
                                /*.addDisplacementMarker(() ->{
                                Lift.setLiftLevel(3);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)

                                .lineTo(new Vector2d(-51, -12))
                                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
                                .waitSeconds(1.5)
                                //Se aliniaza spre turnul de conuri.
                                .setReversed(false)
                                /* .addDisplacementMarker(() ->{
                                     Lift.setLiftLevel(0);
                                 })*/
                                //Se intoarce
                                .splineTo(new Vector2d(-48, -12), Math.toRadians(180))
                                .splineTo(new Vector2d(-59, -12), Math.toRadians(180))
                                /*.addDisplacementMarker(() ->{
                                Intake.setInchis(true);
                                Intake.loop(this);
                                Lift.setLiftLevel(3);
                                })
                                */
                                //Porneste spa puna con

                                //  TODO: PUNE CON
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(new Vector2d(-51, -12))
                                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
                                //Se intoarce

                                .setReversed(false)
                                .waitSeconds(1.5)

                                /*.addDisplacementMarker(() ->{
                                Intake.setInchis(false);
                                Intake.loop(this);
                                Lift.setLiftLevel(0);
                                })
                                */
                                .splineTo(new Vector2d(-48, -12), Math.toRadians(180))
                                .splineTo(new Vector2d(-59, -12), Math.toRadians(180))
                                .build()
                );



        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_KAI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}