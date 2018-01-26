package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.RobotMap;


public class Elevator extends Subsystem {

    // Defining objects from RobotMap that control the elevator
    private static SpeedController elevatorMotor = RobotMap.elevatorMotor;




    public void initDefaultCommand() {

    }

    // Preset heights the elevator needs to reach during a match. Simplifies robot control.

    public void vault() {

    }

    public void switchMD() {

    }

    public void scaleHI() {

    }

    public void scaleMD() {

    }

    public void scaleLO() {

    }

    // Allows manual control for more fine movement of the elevator, scaled to be more precise
    public void manual(double speed) {
        if(Math.abs(speed) > 0.05) {
            elevatorMotor.set(speed * 0.9);
        }
    }

}