package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawCollect extends Command {
    public ClawCollect() {
        super("ClawWheels");
        requires(Robot.claw);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(Math.abs(Robot.oi.geRightTrigger()) > .15){
            Robot.claw.collect(Robot.oi.geRightTrigger());
        }

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
