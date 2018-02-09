package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.RobotMap;


public class Platform extends Subsystem {

    // Defining objects from RobotMap that control the platform
    private static Solenoid platformDeploy = RobotMap.platformDeploy;
    private static SpeedController platformLift = RobotMap.platformMotor;



    public void initDefaultCommand() {

    }

    public void deploy() {
        platformDeploy.set(true);
    }

    public void lift() {
        platformLift.set(1);
    }

}