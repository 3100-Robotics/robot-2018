package frc.team3100.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class RobotMap {

    public static int controller = 1;
    private static int leftDriveChannel = 0;
    private static int rightDriveChannel = 1;
    private static int shootChannel = 3;
    public static int ballFeederChanel = 9;
    private static int tankCycleMotor = 6;
    private static int servoX = 5;
    private static int servoY = 4;

    public static XBoxController controls = new XBoxController(controller);

    public static Jaguar shootMotor = new Jaguar(shootChannel);
    public static Jaguar ballFeeder = new Jaguar(ballFeederChanel);
    public static Jaguar tankCycle = new Jaguar(tankCycleMotor);
    public static SpeedController leftMotor = new Jaguar(leftDriveChannel);
    public static SpeedController rightMotor = new Jaguar(rightDriveChannel);

    public static Gyro gyro = new ADXRS450_Gyro();

    public static Servo xServo = new Servo(servoX);
    public static Servo yServo = new Servo(servoY);



}
