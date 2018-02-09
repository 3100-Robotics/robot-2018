package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawButton extends Command {
    public ClawButton() {
        super("ClawButton");
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        Robot.claw.buttonCheck();
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
