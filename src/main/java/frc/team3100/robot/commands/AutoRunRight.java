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

TO MOVE THE ELEVATOR:
addSequential(new AutoElevator("POSITION"));

*/

public class AutoRunRight extends CommandGroup {

    public AutoRunRight() {
        if(Robot.gameData.length() > 0) {
            if (Robot.gameData.charAt(0) == 'R') {
                addParallel(new AutoElevator("switch"));
                addSequential(new AutoDriveForwards(28));
                addSequential(new AutoCubeScore());
                addParallel(new AutoDriveBackwards(10));

            } else if(Robot.gameData.charAt(1) == 'R' && Robot.gameData.charAt(0) == 'L'){
                //IF SCALE ON OPPOSITE SIDE
                addSequential(new AutoDriveForwards(2));
                addSequential(new AutoDriveTurnRight(30));
                addSequential(new AutoDriveForwards(28));
                addSequential(new AutoDriveTurnLeft(26));
                addSequential(new AutoDriveForwards(43));
                addParallel(new AutoDriveBackwards(6));

            } else {
                addSequential(new AutoDriveForwards(28));
                addParallel(new AutoDriveBackwards(6));
            }

        } else {
            SmartDashboard.putString("Error", "No FMS Setup data!");
            addSequential(new AutoDriveForwards(28));
            addParallel(new AutoDriveBackwards(6));
        }


    }
}
