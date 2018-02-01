package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;
/* COPY AND PASTE THESE

addSequential(new AutoDriveForwards(FEET));
addSequential(new AutoDriveBackwards(FEET));
addSequential(new AutoDriveTurnRight(DEGREES));
addSequential(new AutoDriveTurnLeft(DEGREES));


 */

public class Auto extends CommandGroup {

    public Auto() {
        addSequential(new AutoDriveForwards(6));
        addSequential(new AutoDriveTurnRight(90));

    }
}
