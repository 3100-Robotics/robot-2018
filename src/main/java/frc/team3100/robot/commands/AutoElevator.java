package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;


public class AutoElevator extends Command {
    private int time = 0;
    private int timeStop = 0;
    private boolean timeState = false;
    public AutoElevator(String location) {
        super("AutoElevator");
        requires(Robot.elevator);
        if(location == "switch") {
            timeStop = 150;
        } else {
            timeStop = 150;
        }
    }

    protected void initialize() {

    }

    protected void execute() {
        if(time < timeStop) {
            Robot.elevator.move(.8);
        } else if(time < timeStop + 100){
            Robot.elevator.move(.3);
        } else {
            Robot.elevator.move(0);
        }
        time += 1;
    }


    protected boolean isFinished() {
        if(timeState) {
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

