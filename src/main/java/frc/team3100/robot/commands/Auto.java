package frc.team3100.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

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

public class Auto extends CommandGroup {

    public Auto() {
        addSequential(new AutoDriveForwards(20));
        addSequential(new AutoDriveTurnRight(180));
        addSequential(new AutoCubeCollect());

    }
}
