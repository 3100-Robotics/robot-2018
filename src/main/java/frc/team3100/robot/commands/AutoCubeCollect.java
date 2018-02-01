package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
/* COPY AND PASTE THESE

addSequential(new AutoDriveForwards(FEET));
addSequential(new AutoDriveBackwards(FEET));
addSequential(new AutoDriveTurnRight(DEGREES));
addSequential(new AutoDriveTurnLeft(DEGREES));


 */

public class AutoCubeCollect extends CommandGroup {

    public AutoCubeCollect() {
        addSequential(new ClawGrab());
        addSequential(new ClawCollect());


    }
}
