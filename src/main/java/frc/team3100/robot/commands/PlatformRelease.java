package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class PlatformRelease extends Command {
    public PlatformRelease() {
        super("Shoot");
        requires(Robot.shooter);

    }

    public void initialize() {
        if(Robot.oi.shootState && !Robot.autoVal){
            Robot.shooter.shoot();
            Robot.oi.shootState = false;
        } else {
            Robot.shooter.stopShooting();
            Robot.oi.shootState = true;
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
        Robot.shooter.stopShooting();
        Robot.oi.shootState = true;

    }
}

