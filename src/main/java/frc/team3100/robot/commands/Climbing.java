package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawStop extends Command {
    public ClawStop() {
        super("ClawStop");
        requires(Robot.claw);
    }
    @Override
    public void initialize() {
        Robot.claw.stop();
    }

    @Override
    public void execute() {

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
