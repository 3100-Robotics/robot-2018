package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.commands.*;
import frc.team3100.robot.subsystems.*;


public class Robot extends IterativeRobot{
    private Command AutoCommandLeft;
    private Command AutoCommandRight;
    private Command AutoCommandCenter;
    private Command AutoCommandTest;
    private Command ButtonCheck;
    private Command AutoChosen;
    private SendableChooser autoChoice;
    // Define subsystems for Commands to access
    public static Claw claw;
    public static Elevator elevator;
    public static Platform platform;
    public static MainDrive drive;
    public static OI oi;

    // Define variables used later in the Robot class
    public static boolean autoVal;
    public static String gameData;
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

        AutoCommandTest = new Auto();
        AutoCommandCenter = new AutoRunCenter();
        AutoCommandLeft = new AutoRunLeft();
        AutoCommandRight = new AutoRunRight();
        ButtonCheck = new ClawButton();

        RobotMap.leftDriveCounter.setDistancePerPulse(1);
        RobotMap.rightDriveCounter.setDistancePerPulse(1);

        SmartDashboard.putData("MainDrive", drive);
        RobotMap.clawGrabberOpen.set(false);
        RobotMap.clawGrabberClose.set(true);
        RobotMap.elevatorCounter.reset();
        RobotMap.gyro.calibrate();

        autoChoice = new SendableChooser();
        autoChoice.addDefault("Center", AutoCommandCenter);
        autoChoice.addObject("Left", AutoCommandLeft);
        autoChoice.addObject("Right", AutoCommandRight);
        autoChoice.addObject("Test",AutoCommandTest);

        //TESTING
        SmartDashboard.putData("ClawCollect",new ClawCollect());
        SmartDashboard.putData("ClawGrab",new ClawGrab());
        SmartDashboard.putData("ClawSpit",new ClawSpit());
        SmartDashboard.putData("ClawStop",new ClawStop());
        SmartDashboard.putData("PlatformRelease",new PlatformRelease());
        SmartDashboard.putData("PlatformRampUp",new PlatformRampUp());



    }


    public void autonomousInit() {
        // What to run ONCE at the beginning of the autonomous period
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        ButtonCheck.start();
        AutoChosen = (Command) autoChoice.getSelected();
        AutoChosen.start();
        autoVal = true;
    }

    public void autonomousPeriodic() {
        // Running auto code for the first 15 seconds of the match.
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
    }

    public void teleopInit() {
        // Setting autoVal equal to false so the auto code stops running
        ButtonCheck.start();
        AutoChosen.cancel();
        autoVal = false;
    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the commands
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
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

