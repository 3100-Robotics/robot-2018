package frc.team3100.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveController = 1;
    private static int techController = 2;

    //     P W M
    private static int driveLeftChannel = 0;
    private static int driveRightChannel = 1;
    private static int elevatorChannel = 2;
    private static int clawLeftChannel = 3;
    private static int clawRightChannel = 4;
    private static int platformChannel = 5;

    //     P C M
    private static int clawGrabOpenChannel = 0;
    private static int clawGrabCloseChannel = 1;
    private static int platformDropChannel = 3;

    //     D I O
    private static int driveLeftCounterChannel = 0;
    private static int driveRightCounterChannel = 1;
    private static int elevatorCounterChannel = 2;
    private static int clawButtonChannel = 3;



    //    Initialize Xbox controllers
    public static XBoxDrive driveControls = new XBoxDrive(driveController);
    public static XBoxTech techControls = new XBoxTech(techController);

    //    Initialize speed controllers
    public static SpeedController leftMotor = new Spark(driveLeftChannel);
    public static SpeedController rightMotor = new Spark(driveRightChannel);
    public static SpeedController elevatorMotor = new Spark(elevatorChannel);
    public static SpeedController clawMotorLeft = new Spark(clawLeftChannel);
    public static SpeedController clawMotorRight = new Spark(clawRightChannel);
    public static SpeedController platformMotor = new Spark(platformChannel);

    //    Initialize pneumatic controllers
    public static Solenoid clawGrabberOpen = new Solenoid(clawGrabOpenChannel);
    public static Solenoid clawGrabberClose = new Solenoid(clawGrabCloseChannel);
    public static Solenoid platformDeploy = new Solenoid(platformDropChannel);

    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();
    public static Counter elevatorCounter = new Counter(elevatorCounterChannel);
    public static Counter leftDriveCounter = new Counter(driveLeftCounterChannel);
    public static Counter rightDriveCounter = new Counter(driveRightCounterChannel);
    public static DigitalInput clawButton = new DigitalInput(clawButtonChannel);





}
