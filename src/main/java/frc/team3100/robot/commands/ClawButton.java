package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;

public class ClawButton extends Command {
    public ClawButton() {
        super("ClawButton");
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        Robot.oi.cubeHeld = !RobotMap.clawButton.get();
        if(Robot.oi.cubeHeld && (Robot.oi.clawCollectState || Robot.oi.clawOpenState)) {
            Robot.claw.stop();
            Robot.claw.close();
            Robot.oi.clawCollectState = false;
            Robot.oi.clawOpenState = false;
        }
    }

    public boolean isFinished() {
        return false;
    }

    @Override
    public void end() {

    }

    public void interrupted() {

    }
}
