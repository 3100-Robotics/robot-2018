package frc.team3100.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

/*
COPY AND PASTE THESE

TO DRIVE FORWARDS:
addSequential(new AutoDriveForwards(FEET));

TO DRIVE BACKWARDS:
addSequential(new AutoDriveBackwards(FEET));

TO TURN RIGHT:
addSequential(new AutoDriveTurnRight(DEGREES));

TO TURN LEFT:
addSequential(new AutoDriveTurnLeft(DEGREES));

TO COLLECT A CUBE:
addSequential(new AutoCubeCollect());

*/

public class AutoRunCenter extends CommandGroup {

    public AutoRunCenter() {
        if(Robot.gameData.length() > 0) {
            if (Robot.gameData.charAt(0) == 'L') {
                //IF SWITCH ON LEFT SIDE
                addSequential(new AutoDriveForwards(1));
                addSequential(new AutoDriveTurnLeft(22));
                addSequential(new AutoDriveForwards(12));
                addSequential(new AutoCubeScore());

            } else {
                //IF SWITCH ON RIGHT SIDE
                addSequential(new AutoDriveForwards(1));
                addSequential(new AutoDriveTurnRight(22));
                addSequential(new AutoDriveForwards(12));
                addSequential(new AutoCubeScore());
            }

        } else {
            SmartDashboard.putString("Error", "No FMS Setup data!");
            addSequential(new AutoDriveForwards(1));
            addSequential(new AutoDriveTurnLeft(22));
            addSequential(new AutoDriveForwards(12));
        }
    }
}
