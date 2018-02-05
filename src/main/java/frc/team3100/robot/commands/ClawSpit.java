package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawSpit extends Command {
    public ClawSpit() {
        super("ClawSpit");
        requires(Robot.claw);
    }
    @Override
    public void initialize() {
        if(Robot.oi.cubeHeld){
            Robot.claw.score();
        }
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
