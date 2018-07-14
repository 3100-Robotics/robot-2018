package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.Drive;



public class MainDrive extends Subsystem {
    /*
    public int storedValLeft = 0;
    public int storedValRight = 0;
    private SpeedController leftMotor = RobotMap.leftMotor;
    private SpeedController rightMotor = RobotMap.rightMotor;
    private DifferentialDrive mainDrive;
    private Gyro gyro = RobotMap.gyro;
    private Counter leftRotSensor = RobotMap.leftDriveCounter;
    private Counter rightRotSensor = RobotMap.rightDriveCounter;
    private double targetMove = 0;
    private static final double ROTATE_COEFF = 1.5;
    private static final double JOYSTIC_EPSILON = 0.1;
    private static double setting = 0.0;



    private double setHeading(double move, double rotate){
        if((Math.abs(move) < JOYSTIC_EPSILON) && (Math.abs(rotate) < JOYSTIC_EPSILON)){
            setting = gyro.getAngle();
        } else if (Math.abs(rotate) >= JOYSTIC_EPSILON) {
            setting += (rotate * ROTATE_COEFF);
        }
        SmartDashboard.putNumber("PIDSetting",setting);
        return setting;
    }


    public MainDrive(){
        super("MainDrive", 0.1,0,0.1);
        mainDrive = new DifferentialDrive(leftMotor, rightMotor);
        setOutputRange(-1,1);

        setAbsoluteTolerance(3);
        enable();

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    protected double returnPIDInput() {
        SmartDashboard.putNumber("gyro", gyro.getAngle());
        return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        mainDrive.arcadeDrive((targetMove), output);
        SmartDashboard.putNumber("PIDOutput", output);
    }
    public void drive(double move, double rotate) {
        if(move > .01) {
            storedValRight -= rightRotSensor.get();
            storedValLeft -= leftRotSensor.get();
            rightRotSensor.reset();
            leftRotSensor.reset();
        } else if(move < .01) {
            storedValRight += rightRotSensor.get();
            storedValLeft += leftRotSensor.get();
            rightRotSensor.reset();
            leftRotSensor.reset();
        }

        targetMove = move;
        setSetpoint(setHeading(move, rotate));
        SmartDashboard.putNumber("Rotate", rotate);
        SmartDashboard.putNumber("Move", move);
        enable();

    }
    */

    public int storedValLeft = 0;
    public int storedValRight = 0;
    private SpeedController leftMotor = RobotMap.leftMotor;
    private SpeedController rightMotor = RobotMap.rightMotor;
    private DifferentialDrive mainDrive = new DifferentialDrive(leftMotor,rightMotor);
    private Counter leftRotSensor = RobotMap.leftDriveCounter;
    private Counter rightRotSensor = RobotMap.rightDriveCounter;
    private double changeTurn;
    private double changeDrive;
    private double limit = 0.1;
    private double limitRot = 0.08;
    private double limitedJoystickDrive;
    private double limitedJoystickTurn;


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }



    public void drive(double move, double rotate) {

        if(move > .01) {
            storedValRight -= rightRotSensor.get();
            storedValLeft -= leftRotSensor.get();
            rightRotSensor.reset();
            leftRotSensor.reset();
            move -= .1;
        } else if(move < .01) {
            storedValRight += rightRotSensor.get();
            storedValLeft += leftRotSensor.get();
            rightRotSensor.reset();
            leftRotSensor.reset();
            move += .1;
        }
        changeTurn = rotate - limitedJoystickTurn;
        if(changeTurn > limitRot) {
            changeTurn = limitRot;
        } else if (changeTurn < -limitRot) {
            changeTurn = -limitRot;
        }
        limitedJoystickTurn += changeTurn;

        changeDrive = move - limitedJoystickDrive;
        if(changeDrive > limit) {
            changeDrive = limit;
        } else if (changeDrive < -limit) {
            changeDrive = -limit;
        }
        limitedJoystickDrive += changeDrive;

        mainDrive.arcadeDrive(limitedJoystickDrive,limitedJoystickTurn);
        SmartDashboard.putNumber("Rotate", rotate);
        SmartDashboard.putNumber("Move", move);
        SmartDashboard.putNumber("limitedRotate", limitedJoystickTurn);
        SmartDashboard.putNumber("limitedMove",limitedJoystickDrive);
    }
}