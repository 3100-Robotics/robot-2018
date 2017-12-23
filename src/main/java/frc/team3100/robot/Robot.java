package frc.team3100.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.subsystems.MainDrive;
import frc.team3100.robot.subsystems.Shooter;


public class Robot extends IterativeRobot{

    public static MainDrive drive;
    public static Shooter shooter;
    public static OI oi;

    public static boolean autoVal;
    public float driveTest;
    private static final int IMG_WIDTH = 320;
    private static final int IMG_HEIGHT = 240;


    public void robotInit() {
        UsbCamera server = CameraServer.getInstance().startAutomaticCapture("cam0", 0);
        server.setBrightness(50);
        server.setResolution(IMG_WIDTH, IMG_HEIGHT);
        driveTest = 0;
        shooter = new Shooter();
        drive = new MainDrive();
        oi = new OI();
        SmartDashboard.putData("MainDrive", drive);

    }


    public void autonomousInit() {
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

