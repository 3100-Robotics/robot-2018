package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.ClawDrive;


public class Claw extends Subsystem {


    private SpeedController clawMotors = RobotMap.clawMotors;

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ClawDrive());
    }



    // Changes the speed of the wheels to intake or output the power cube.
    public void run(double speed) {
        clawMotors.set(speed);
        SmartDashboard.putNumber("ClawSpeed",speed);
    }


    public void stop() {

    }




}