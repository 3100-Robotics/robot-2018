package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;


public class AutoCubeCollect extends CommandGroup {

    public AutoCubeCollect() {
        if(!Robot.oi.clawCollectState) {
            addSequential(new ClawCollect());
        }
        if(!Robot.oi.clawOpenState) {
            addSequential(new ClawGrab());
        }
        addSequential(new AutoCubeGrab());
        if(Robot.oi.clawOpenState) {
            addSequential(new ClawGrab());
        }

    }
}
