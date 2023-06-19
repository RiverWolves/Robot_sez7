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
                        drive.trajectorySequenceBuilder(new Pose2d(31.22, -61, Math.toRadians(90)))
                                //Porneste
                                .forward(2.5)


                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis(false);
                                    Intake.loop(this);
                                    Lift.setLiftLevel(3);
                                })*/

                                //Pleaca spre mijloc
                                .strafeLeft(18)

                                /*.addDisplacementMarker(()->{
                                    Brat.input(true);
                                    Brat.loop();
                                })*/

//                 Mege la pilon
                                .lineTo(new Vector2d(12, -30))

                                .splineTo(new Vector2d(18.7, -9.8), Math.toRadians(60) )



                               /* .addTemporalMarker(() ->{
                                    Intake.setInchis(true);
                                    Intake.loop(this);

                                    Lift.setLiftLevel(10);
                                })*/
                                .waitSeconds(0.5)

                                //Se aliniaza cu turnul de conuri
                                .back(4)
                                .turn(Math.toRadians(-60))
                                .splineTo(new Vector2d(60, -14.5), Math.toRadians(0))

                                //Porneste spre pilon
                                /*.addTemporalMarker(()->{
                                    Intake.setInchis(false);
                                    Intake.loop(this);
                                })*/
                                .waitSeconds(0.3)
                                /*.addTemporalMarker(() ->{
                                    Lift.setLiftLevel(3);
                                })*/
                                .waitSeconds(0.5)

                                .setReversed(true)

                                .lineTo(new Vector2d(49, -15))
                                /*.addDisplacementMarker( ()->{
                                    Intake.setRotire(false);
                                    Intake.loop(this);

                                    Brat.input(false);
                                    Brat.loop();
                                })*/

                                .splineTo(new Vector2d(31, -11.2), Math.toRadians(120))
                                .setReversed(false)

                                /*.addTemporalMarker(() ->{

                                    Intake.setInchis(true);
                                    Intake.loop(this);
                                })*/
                                .waitSeconds(1)
                                /*.addTemporalMarker(()->{
                                    Intake.setInchis(false);
                                    Intake.loop(this);
                                })*/
                                .waitSeconds(0.5)
                                /*.addDisplacementMarker(() ->{
                                    Intake.setRotire(true);
                                    Intake.loop(this);

                                    Brat.input(true);
                                    Brat.loop();

                                    Lift.setLiftLevel(20);
                                })*/

                                //Se intoarce
                                .splineTo(new Vector2d(48, -14), Math.toRadians(0))
                                /*.addDisplacementMarker(() ->{
                                    Intake.setInchis(true);
                                    Intake.loop(this);
                                })*/
                                .splineTo(new Vector2d( 60, -14.5), Math.toRadians(0))
                               /* .UNSTABLE_addTemporalMarkerOffset(0.5, () ->{
                                    Intake.setInchis(false);
                                    Intake.loop(this);
                                })*/
                                .waitSeconds(1)
                                /*.addTemporalMarker(()->{
                                    Lift.setLiftLevel(3);
                                })*/

                                //Porneste spa puna con

                                //  TODO: PUNE CON
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(new Vector2d(49, -15))
                                /*.addDisplacementMarker( ()->{
                                    Intake.setRotire(false);
                                    Intake.loop(this);

                                    Brat.input(false);
                                    Brat.loop();
                                })*/
                                .splineTo(new Vector2d(31, -11.2), Math.toRadians(120))
                                .setReversed(false)

                                .build());




        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}