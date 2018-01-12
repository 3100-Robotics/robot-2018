package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.subsystems.*;


public class Robot extends IterativeRobot{

    public static Claw claw;
    public static Elevator elevator;
    public static Platform platform;
    public static MainDrive drive;

    public static OI oi;

    public static boolean autoVal;
    public String gameData;
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;


    public void robotInit() {

        //creating a camera object and defining its characteristics
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture("cam0", 0);
        server.setBrightness(20);
        server.setResolution(IMG_WIDTH, IMG_HEIGHT);

        //Creates instances of all of the subsystems for the commands to access.
        claw = new Claw();
        elevator = new Elevator();
        platform = new Platform();
        drive = new MainDrive();

        // ALWAYS initialize OI last
        oi = new OI();

        SmartDashboard.putData("MainDrive", drive);
    }


    public void autonomousInit() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        autoVal = true;

    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

    }

    public void teleopPeriodic() {
        autoVal = false;
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        autoVal = false;
        Scheduler.getInstance().run();
    }



}

