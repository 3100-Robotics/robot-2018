package frc.team3100.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

public class PlatformRampUp extends Command {
    private int time = 0;
    private int timesDeployed = 0;
    private boolean liftState = false;
    public PlatformRampUp() {
        super("PlatformRampUp");
        requires(Robot.platform);

    }

    public void initialize() {
        Robot.oi.test2 = false;
    }

    public void execute() {
        Robot.oi.test = false;
        time += 1;
        if(time == 50) {
            Robot.oi.test = true;
            Robot.platform.lift();
            liftState = true;
        }
        if(time == 100) {
            Robot.oi.test = false;
            Robot.platform.retract();
            liftState = false;
            time = 0;
            timesDeployed += 1;
        }
        SmartDashboard.putNumber("time",time);
        SmartDashboard.putNumber("timesDeployed",timesDeployed);

    }

    public boolean isFinished() {
        if(timesDeployed == 6) {
            timesDeployed = 0;
            time = 0;
            return true;
        } else {
            return false;
        }
    }

    public void end() {
        Robot.oi.test2 = true;
    }

    public void interrupted() {

    }

}

