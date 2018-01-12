package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.subsystems.*;


public class Robot extends IterativeRobot{

    // Define subsystems for Commands to access
    public static Claw claw;
    public static Elevator elevator;
    public static Platform platform;
    public static MainDrive drive;

    public static OI oi;

    // Define variables used later in the Robot class
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
        // What to run ONCE at the beginning of the autonomous period
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        autoVal = true;
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // Setting autoVal equal to false so the auto code stops running
        autoVal = false;
    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the commands
        Scheduler.getInstance().run();
    }



    // Test shouldn't ever run during a match; it is only used to set variables and debug the program

     public void testInit() {
        // Setting autoVal equal to false so the auto code doesn't run.
        autoVal = false;
    }

    public void testPeriodic() {
        // Starts the scheduler to test different commands.
        Scheduler.getInstance().run();
    }



}

