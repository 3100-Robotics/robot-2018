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
    private Command AutoLeft;
    private Command AutoRight;
    private Command AutoCenter;
    private Command ButtonCheck;
    private Command AutoChosen;
    private Command ElevatorMotion;
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
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        //Creates instances of all of the subsystems for the commands to access.
        claw = new Claw();
        elevator = new Elevator();
        platform = new Platform();
        drive = new MainDrive();
        ButtonCheck = new ClawButton();



        // ALWAYS initialize OI last
        oi = new OI();

        AutoCenter = new AutoRunCenter();
        AutoRight = new AutoRunRight();
        AutoLeft = new AutoRunLeft();

        //Unless you need something from it...
        ElevatorMotion = new ElevatorMotion();

        RobotMap.leftDriveCounter.setDistancePerPulse(1);
        RobotMap.rightDriveCounter.setDistancePerPulse(1);

        SmartDashboard.putData("MainDrive", drive);
        RobotMap.clawGrabber.set(false);
        RobotMap.rampLeftRaise.set(false);
        RobotMap.UPP2.set(false);
        RobotMap.UPP1.set(true);
        RobotMap.UPP3.set(true);
        RobotMap.UPP5.set(true);
        RobotMap.elevatorCounter.reset();
        RobotMap.gyro.calibrate();


        autoChoice = new SendableChooser();
        autoChoice.addObject("Center", AutoCenter);
        autoChoice.addDefault("Left", AutoLeft);
        autoChoice.addObject("Right", AutoRight);
        SmartDashboard.putData(autoChoice);
        SmartDashboard.putString("welp","okay");



    }

    public void autonomousInit() {
        RobotMap.gyro.reset();
        // What to run ONCE at the beginning of the autonomous period
        gameData = DriverStation.getInstance().getGameSpecificMessage();
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
        RobotMap.gyro.reset();
        if(autoVal) {
            if(AutoChosen.isRunning()) {
                AutoChosen.cancel();
            }
        }
        ButtonCheck.start();
        ElevatorMotion.start();
        autoVal = false;
        RobotMap.platformDeployLeft.set(.3);
        RobotMap.platformDeployRight.set(.4);


    }

    public void teleopPeriodic() {
        // Starts the scheduler for the teleop period to run the commands
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("autoVal",autoVal);
        SmartDashboard.putBoolean("cubeHeld",Robot.oi.cubeHeld);
        SmartDashboard.putBoolean("test",Robot.oi.test);
        SmartDashboard.putBoolean("test2",Robot.oi.test2);
        SmartDashboard.putData(autoChoice);


    }

     public void testInit() {
        // Setting autoVal equal to false so the auto code doesn't run.
        autoVal = false;
    }

    public void testPeriodic() {
        // Starts the scheduler to test different commands.
        Scheduler.getInstance().run();
    }

}

