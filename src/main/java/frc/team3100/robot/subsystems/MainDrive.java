package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.Drive;

import static frc.team3100.robot.Robot.autoVal;


public class MainDrive extends Subsystem {

    private SpeedController leftMotor = RobotMap.leftMotor;
    private SpeedController rightMotor = RobotMap.rightMotor;
    private DifferentialDrive mainDrive = new DifferentialDrive(leftMotor, rightMotor);
    private Counter leftRotSensor = RobotMap.leftDriveCounter;
    private Counter rightRotSensor = RobotMap.rightDriveCounter;
    public int sensorValRight;
    public int sensorValLeft;
    public int storedValRight;
    public int storedValLeft;
    private int rotateValue = 0;
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    public void drive(double move, double rotate) {
        sensorValRight = rightRotSensor.get();
        sensorValLeft = rightRotSensor.get();
        if(move > .01) {
            storedValRight -= sensorValRight;
            storedValLeft -= sensorValLeft;
            rightRotSensor.reset();
            leftRotSensor.reset();
        } else if(move < .01) {
            storedValRight += sensorValRight;
            storedValLeft += sensorValLeft;
            rightRotSensor.reset();
            leftRotSensor.reset();
        }

        if(Math.abs(rotate) > .15) {

            mainDrive.arcadeDrive(move * -1, rotate);
            rotateValue = 0;


        }

        else if(Math.abs(rotate) <= .15) {

            if( leftRotSensor.getRate() > rightRotSensor.getRate() && rotateValue > 50){
                mainDrive.arcadeDrive(move * -1, 0.1);
            } else if(leftRotSensor.getRate() < rightRotSensor.getRate() && rotateValue > 50) {
                mainDrive.arcadeDrive(move * -1, -0.1);
            } else {
                mainDrive.arcadeDrive(move * -1,rotate);
                rotateValue += 1;
            }

        }

        SmartDashboard.putNumber("StoredValRight", storedValRight);
        SmartDashboard.putNumber("StoredValLeft", storedValLeft);
        SmartDashboard.putNumber("Move",move);
        SmartDashboard.putNumber("Rotate", rotate);




    }
}





