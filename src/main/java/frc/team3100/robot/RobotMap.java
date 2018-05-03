package frc.team3100.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    //     C O N T R O L L E R S
    private static int driveController = 1;
    private static int techController = 2;

    //     P W M
    private static int driveLeftChannel = 1;
    private static int driveRightChannel = 2;
    private static int elevatorChannel = 4;
    private static int clawChannel = 3;
    private static int platformChannel = 5;
    private static int platformDeployLeftChannel = 6;
    private static int platformDeployRightChannel = 7;
    private static int climberMotorChannel = 8;


    //     P C M
    private static int clawCloseChannel = 0;
    private static int clawOpenChannel = 1;
    private static int UPP2Channel = 2;
    private static int UPP3Channel = 3;
    private static int rampLeftRaiseChannel = 4;
    private static int UPP5Channel = 5;

    //     D I O
    private static int driveLeftCounterChannel = 2;
    private static int driveRightCounterChannel = 1;
    private static int elevatorCounterChannel = 0;
    private static int clawButtonChannel = 3;
    private static int elevatorLowerLimitChannel = 4;
    private static int elevatorUpperLimitChannel = 5;



    //    Initialize Xbox controllers
    public static XBoxDrive driveControls = new XBoxDrive(driveController);
    public static XBoxTech techControls = new XBoxTech(techController);

    //    Initialize speed controllers
    public static SpeedController leftMotor = new Spark(driveLeftChannel);
    public static SpeedController rightMotor = new Spark(driveRightChannel);
    public static SpeedController elevatorMotor = new Spark(elevatorChannel);
    public static SpeedController clawMotors = new Spark(clawChannel);
    public static SpeedController platformMotor = new Spark(platformChannel);
    public static SpeedController climbMotor = new Spark(climberMotorChannel);

    //    Initialize pneumatic controllers
    public static Solenoid clawCloser = new Solenoid(clawCloseChannel);
    public static Solenoid clawOpener = new Solenoid(clawOpenChannel);
    public static Solenoid rampLeftRaise = new Solenoid(rampLeftRaiseChannel);
    public static Solenoid UPP3 = new Solenoid(UPP3Channel);
    public static Solenoid UPP2 = new Solenoid(UPP2Channel);
    public static Solenoid UPP5 = new Solenoid(UPP5Channel);

    //    Initialize servos
    public static Servo platformDeployLeft = new Servo(RobotMap.platformDeployLeftChannel);
    public static Servo platformDeployRight = new Servo(RobotMap.platformDeployRightChannel);


    //    Initialize sensors
    public static Gyro gyro = new ADXRS450_Gyro();
    public static Counter elevatorCounter = new Counter(elevatorCounterChannel);
    public static Counter leftDriveCounter = new Counter(driveLeftCounterChannel);
    public static Counter rightDriveCounter = new Counter(driveRightCounterChannel);
    public static DigitalInput clawButton = new DigitalInput(clawButtonChannel);
    public static DigitalInput elevatorUpperButton = new DigitalInput(elevatorUpperLimitChannel);
    public static DigitalInput elevatorLowerButton = new DigitalInput(elevatorLowerLimitChannel);





}
