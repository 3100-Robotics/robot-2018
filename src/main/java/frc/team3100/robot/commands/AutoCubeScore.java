package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;


public class AutoCubeScore extends Command {
    private int time = 0;
    public AutoCubeScore() {
        super("AutoCubeScore");
        requires(Robot.claw);

    }


    protected void initialize() {

    }

    protected void execute() {
        Robot.claw.run(-.9);
        time += 1;


    }


    protected boolean isFinished() {
        if(time > 100) {
            return true;
        } else {
            return false;
        }
    }


    protected void interrupted(){

    }


    protected void end() {
        Robot.claw.stop();

    }
}

