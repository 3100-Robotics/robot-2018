package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;


public class AutoElevator extends Command {
    private int time = 0;
    public AutoElevator() {
        super("AutoElevator");
        requires(Robot.elevator);
    }

    protected void initialize() {

    }

    protected void execute() {
        Robot.elevator.move(.7);
        time += 1;
    }


    protected boolean isFinished() {
        if(time > 40) {
            return true;
        } else {
            return false;
        }
    }


    protected void interrupted(){

    }


    protected void end() {

    }
}

