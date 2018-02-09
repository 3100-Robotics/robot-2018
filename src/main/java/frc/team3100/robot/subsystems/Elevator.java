package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;
import frc.team3100.robot.commands.ElevatorMotion;


public class Elevator extends Subsystem {

    // Defining objects from RobotMap that control the elevator
    private static SpeedController elevatorMotor = RobotMap.elevatorMotor;
    private static Counter elevationSensor = RobotMap.elevatorCounter;
    private static XBoxTech controller = RobotMap.techControls;
    public  int elevation = 0;
    private double motorSpeed = .8;


    public void initDefaultCommand() {
        setDefaultCommand(new ElevatorMotion());
    }

    // Preset heights the elevator needs to reach during a match. Simplifies robot control.

    public void move(int direction) {

        if(controller.getLeftStickY() >= .5) {
            Robot.oi.elevatorTargetLevel += 1;
        } else if(controller.getLeftStickY() <= -.5) {
            Robot.oi.elevatorTargetLevel -= 1;
        }

        if(direction == 1) {
            elevation += elevationSensor.get();
            elevationSensor.reset();
        } else {
            elevation -= elevationSensor.get();
            elevationSensor.reset();
        }

        elevatorMotor.set(direction * motorSpeed);

    }

    public double vaultLevel() {
        return 0;
    } //NEED TO CHANGE

    public double pickupLevel() {
        return 0;
    }

    public double switchLevel() {
        return 0;
    } //NEED TO CHANGE

    public double lowLevel() {
        return 0;
    } //NEED TO CHANGE

    public double midLevel() {
        return 0;
    } //NEED TO CHANGE

    public double highLevel() {
        return 0;
    } //NEED TO CHANGE
}