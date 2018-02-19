package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;
import frc.team3100.robot.commands.ElevatorMotion;


public class Elevator extends Subsystem {

    // Defining objects from RobotMap that control the elevator
    private static SpeedController elevatorMotor = RobotMap.elevatorMotor;
    private static Counter elevationSensor = RobotMap.elevatorCounter;
    private static XBoxTech controller = RobotMap.techControls;


    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorMotion());
    }

    public void move(double direction) {
        if(!RobotMap.elevatorLowerButton.get() && direction <= 0){
            elevatorMotor.set(0);
            SmartDashboard.putNumber("elevatorValues",0);
        } else {
            if(direction > 0) {
                direction -= .1;
            } else if(direction < 0) {
                direction += .1;
            }
            elevatorMotor.set(direction);
            SmartDashboard.putNumber("elevatorValues",direction);
        }

    }
}