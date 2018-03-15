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

    }



    @Override
    public void execute() {
        Robot.claw.collect(Robot.oi.getLeftTrigger());
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
