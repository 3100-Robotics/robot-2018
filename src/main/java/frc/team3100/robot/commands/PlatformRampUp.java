package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class PlatformRampUp extends Command {
    public PlatformRampUp() {
        super("PlatformRampUp");
        requires(Robot.platform);

    }

    public void initialize() {
        if(Robot.oi.platformRasied){
            Robot.platform.lift();
            Robot.oi.platformRasied = true;
        } else {
            Robot.platform.lower();
            Robot.oi.shootState = false;
        }
    }

    public void execute() {

    }

    public boolean isFinished() {
        return true;
    }

    public void end() {

    }

    public void interrupted() {

    }
}

