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
addSequential(new AutoElevator("LEVEL"));

TO SCORE A CUBE:
addSequential(new AutoCubeScore());

*/

public class AutoRunLeft extends CommandGroup {

    public AutoRunLeft() {

        addSequential(new AutoDriveForwards(60));
        /*
        if(Robot.gameData.length() > 0) {
            if (Robot.gameData.charAt(1) == 'L') {
                //IF SCALE ON CORRECT SIDE
                addParallel(new AutoElevator("high"));
                addSequential(new AutoDriveForwards(27.943));
                addSequential(new AutoCubeScore());

                addSequential(new AutoDriveBackwards(7.729));
                addParallel(new AutoElevator("pickup"));
                addSequential(new AutoDriveTurnRight(90));

                addSequential(new AutoCubeCollect());
                addSequential(new AutoDriveBackwards(Robot.oi.distanceDriven));

                addSequential(new AutoDriveTurnLeft(90));
                addParallel(new AutoElevator("high"));
                addSequential(new AutoDriveForwards(7.729));
                addSequential(new AutoCubeScore());

            } else {
                //IF SCALE ON OPPOSITE SIDE
                addSequential(new AutoDriveForwards(20));
                addSequential(new AutoDriveTurnRight(82));
                addSequential(new AutoDriveForwards(15));
                addSequential(new AutoDriveTurnLeft(95));
                addSequential(new AutoDriveForwards(7.943));
                addSequential(new AutoCubeScore());
            }

        } else {
            SmartDashboard.putString("Error", "No FMS Setup data!");
            addSequential(new AutoDriveForwards(12));
        }
        */
    }
}
