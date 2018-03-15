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

public class AutoMaster extends CommandGroup {
    public AutoMaster(Character autoChoice, String autoData) {
        if(autoData.length() == 0) {
            autoChoice = 'A';
            SmartDashboard.putString("Error","No FMS Data");
        }
        if(autoChoice == 'A') {
            SmartDashboard.putString("AutoRan","A");
            addSequential(new AutoDriveForwards(28));
            addParallel(new AutoDriveBackwards(4));



        } else if(autoChoice == 'R') {
            SmartDashboard.putString("AutoRan","R");
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
            }




        } else if(autoChoice == 'L') {
            SmartDashboard.putString("AutoRan","L");
            if (autoData.charAt(0) == 'L') {
                addParallel(new AutoElevator("switch"));
                addSequential(new AutoDriveForwards(28));
                addSequential(new AutoCubeScore());
                addParallel(new AutoDriveBackwards(10));

            } else if(autoData.charAt(1) == 'L' && autoData.charAt(0) == 'R'){
                //IF SCALE ON OPPOSITE SIDE
                addSequential(new AutoDriveForwards(2));
                addSequential(new AutoDriveTurnLeft(30));
                addSequential(new AutoDriveForwards(20));
                addSequential(new AutoDriveTurnRight(34));
                addSequential(new AutoDriveForwards(43));
                addParallel(new AutoDriveBackwards(6));

            } else {
                addSequential(new AutoDriveForwards(28));
                addParallel(new AutoDriveBackwards(6));
            }



        } else if(autoChoice == 'C') {
            SmartDashboard.putString("AutoRan","C");
            if(Robot.gameData.charAt(0) == 'R') {
                addSequential(new AutoDriveForwards(6));
                addParallel(new AutoElevator("switch"));
                addSequential(new AutoDriveTurnRight(40));
                addSequential(new AutoDriveForwards(25));
                addSequential(new AutoDriveTurnLeft(10));
                addSequential(new AutoCubeScore());
            } else {
                addSequential(new AutoDriveForwards(6));
                addParallel(new AutoElevator("switch"));
                addSequential(new AutoDriveTurnLeft(30));
                addSequential(new AutoDriveForwards(30));
                addSequential(new AutoDriveTurnRight(10));
                addSequential(new AutoCubeScore());
            }
        }
    }

}
