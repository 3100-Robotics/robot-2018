package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawSpit extends Command {
    public ClawSpit() {
        super("ClawWheels2");
        requires(Robot.claw);
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        if(Math.abs(Robot.oi.getLeftTrigger()) > .15) {
            Robot.claw.score(Robot.oi.getLeftTrigger());
        }

    }

    public boolean isFinished() {
        return false;
    }
    @Override
    public void end() {

    }

    public void interrupted() {
        Robot.claw.stop();

    }
}
