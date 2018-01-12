package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.Drive;

// Reminder to future me: Remake this to integrate the two photoelectric sensors instead of using a PID!

public class MainDrive extends PIDSubsystem {

    private SpeedController leftMotor = RobotMap.leftMotor;
    private SpeedController rightMotor = RobotMap.rightMotor;
    private RobotDrive mainDrive = new RobotDrive(leftMotor, rightMotor);
    private Gyro gyro = RobotMap.gyro;
    private double targetMove = 0;
    private double targetRotate = 0;
    private boolean DEBUG = true;
    public static final double ROTATE_COEFF = 1;
    public static final double JOYSTIC_EPSILON = 0.17;

    static double setting = 0.0; //Need to remember the value instead of 0

    private double setHeading(double move, double rotate){
        if((Math.abs(move) < JOYSTIC_EPSILON) && (Math.abs(rotate) < JOYSTIC_EPSILON)){
            setting = gyro.getAngle();
        } else if (Math.abs(rotate) >= JOYSTIC_EPSILON) {
            setting = (setting + (rotate * ROTATE_COEFF));
        }
        return setting;
    }


    public MainDrive(){


        super("MainDrive", 0,0,0);
        setOutputRange(-1,1);
        getPIDController().setContinuous();
        enable();
        //SmartDashboard.putNumber("P", getPIDController().getP());
        //SmartDashboard.putNumber("I", getPIDController().getI());
        //SmartDashboard.putNumber("D", getPIDController().getD());
        //SmartDashboard.putNumber("SetPoint", getSetpoint());
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }

    protected double returnPIDInput() {

        SmartDashboard.putNumber("Gryo", gyro.getAngle());
        return gyro.getAngle();
    }

    protected void usePIDOutput(double output) {
        SmartDashboard.putNumber("PID Output", output);
        mainDrive.arcadeDrive(targetMove * -1, -targetRotate);
    }
    public void drive(double move , double rotate) {
        targetMove = move;
        targetRotate = rotate;
        setSetpoint(setHeading(move , rotate));

        enable();

        //if (DEBUG) {
        //    getPIDController().setPID(
                //SmartDashboard.getNumber("P"),
                //SmartDashboard.getNumber("I"),
                //SmartDashboard.getNumber("D")
        //    );
        //}
        SmartDashboard.putNumber("P", getPIDController().getP());
        SmartDashboard.putNumber("I", getPIDController().getI());
        SmartDashboard.putNumber("D", getPIDController().getD());

        SmartDashboard.putNumber("SetPoint", getSetpoint());

        SmartDashboard.putNumber("Move", move);
        SmartDashboard.putNumber("Rotate", rotate);

        SmartDashboard.putNumber("Left Drive", leftMotor.get());
        SmartDashboard.putNumber("Right Drive", rightMotor.get());
    }

}