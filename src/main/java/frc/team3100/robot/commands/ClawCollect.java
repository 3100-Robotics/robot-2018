package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawCollect extends Command {
    public ClawCollect() {
        super("ClawCollect");
        requires(Robot.claw);
    }

    @Override
    public void initialize() {
        Robot.claw.collect();
    }

    @Override
    public void execute() {
    }

    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {

    }

    public void interrupted() {


    }
}
