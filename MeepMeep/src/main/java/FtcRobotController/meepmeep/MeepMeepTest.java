package FtcRobotController.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTest {

   public static Pose2d A = new Pose2d(36,-61 , Math.toRadians(270));
    public static Vector2d B = new Vector2d(36,-24 ); public  static double BU = Math.toRadians(270); // BU = Unghiul B
    public static Vector2d C = new Vector2d(29.81,-11.6 ); public  static double CU = Math.toRadians(118);
    public static Vector2d D = new Vector2d(48,-12 ); public  static double DU = Math.toRadians(0);
    public static Vector2d E = new Vector2d(60,-12  ); public  static double EU = Math.toRadians(0);
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(40, 30, Math.toRadians(180), Math.toRadians(180), 11.99)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(A)
                                .setReversed(true)
                                /*.addDisplacementMarker(()->{
                                    Intake.setInchis2in1(true,this);
                                })*/
                                .lineTo(B)
                                /*.addDisplacementMarker( () -> {

                                    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);
                                    Brat.setRotireFata(false);
                                })*/
                                .splineTo(C, CU) //Ajunge la stalp
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () ->{  //deschide clestele?????
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .waitSeconds(0.5)
                                //Incepe loop de la turn
                                .setReversed(false)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(10);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                })*/
                                .splineTo(D,DU)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .lineTo(E) //Ajunge la turnul de conuri
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () -> {
                                    Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(1);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                /*.addDisplacementMarker(() ->{
                                    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);
                                    Brat.setRotireFata(false);
                                })*/
                                .splineTo(C,CU)
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () ->{  //deschide clestele?????
                                    Intake.setRotire2in1(false,this);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(false)
                                //Incepe loop de la turn
                                .setReversed(false)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setRotire2in1(true,this);
                                    Lift.setLiftLevel(10);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                })*/
                                .splineTo(D,DU)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .lineTo(E) //Ajunge la turnul de conuri
                                /*.UNSTABLE_addTemporalMarkerOffset( 0.41,() -> {
                                    Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(1);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                /*.addDisplacementMarker(() ->{
                                    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);
                                    Brat.setRotireFata(false);
                                })*/
                                .splineTo(C,CU)
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () ->{  //deschide clestele?????
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(false)
                                //Incepe loop de la turn
                                .setReversed(false)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setRotire2in1(true,this);
                                    Lift.setLiftLevel(10);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                })*/
                                .splineTo(D,DU)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .lineTo(E) //Ajunge la turnul de conuri
                                /*.UNSTABLE_addTemporalMarkerOffset( 0.41,() -> {
                                    Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(1);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                /*.addDisplacementMarker(() ->{
                                    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);
                                    Brat.setRotireFata(false);
                                })*/
                                .splineTo(C,CU)
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () ->{  //deschide clestele?????
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(false)
                                //Incepe loop de la turn
                                .setReversed(false)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setRotire2in1(true,this);
                                    Lift.setLiftLevel(10);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                })*/
                                .splineTo(D,DU)
                                /*.addDisplacementMarker( () -> {
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .lineTo(E) //Ajunge la turnul de conuri
                                /*.UNSTABLE_addTemporalMarkerOffset( 0.41,() -> {
                                    Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(1);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                /*.addDisplacementMarker(() ->{
                                    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);
                                    Brat.setRotireFata(false);
                                })*/
                                .splineTo(C,CU)
                                /*.UNSTABLE_addTemporalMarkerOffset(0.41, () ->{  //deschide clestele?????
                                    Intake.setInchis2in1(false,this);
                                })*/
                                .waitSeconds(0.5)
                                .setReversed(false)
                                .build());




        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}