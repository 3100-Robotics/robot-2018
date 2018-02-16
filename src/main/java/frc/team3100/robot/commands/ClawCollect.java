package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

public class ClawCollect extends Command {
    public ClawCollect() {
        super("ClawCollect");
        requires(Robot.claw);
    }

    @Override
    public void initialize() {
        if (Robot.oi.clawCollectState) {
            Robot.claw.stop();
            Robot.oi.clawCollectState = false;
            Robot.oi.clawScoreState = false;
            SmartDashboard.putBoolean("clawTest1",true);
        } else {
            Robot.claw.collect();
            Robot.oi.clawCollectState = true;
            Robot.oi.clawScoreState = false;
            SmartDashboard.putBoolean("clawTest1",false);
        }
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
