package FtcRobotController.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTest {

    public static Pose2d A = new Pose2d(     -36,    -60 , Math.toRadians(270));
    public static Vector2d B = new Vector2d( -36,    -40 ); public  static double BU = Math.toRadians(90); // BU = Unghiul B
    public static Vector2d C = new Vector2d( -30, -12.15 ); public  static double CU = Math.toRadians(70);
    public static Pose2d CP = new Pose2d(-36, -9,Math.toRadians(55));
    public static Vector2d D = new Vector2d( -54,    -11); public  static double DU = Math.toRadians(180);
    public static Vector2d E = new Vector2d( -59.825  , -11 ); public  static double EU = Math.toRadians(180);


    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(50, 35, Math.toRadians(180), Math.toRadians(180), 11.99)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(D.getX()+45,D.getY()))

                                .back(40)
                                .setReversed(false)
                                .splineTo(new Vector2d(A.getX(),A.getY()),A.getHeading())





                                .build());





        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}