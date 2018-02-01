package frc.team3100.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.commands.*;


public class OI {

    // Initialize the XBox Controllers
    private XBoxDrive driveControls = RobotMap.driveControls;
    private XBoxTech techControls = RobotMap.techControls;

    // Define all of the buttons used
    private Button vaultLevel = new JoystickButton(techControls, XBoxTech.xButton);
    private Button clawOutput = new JoystickButton(techControls, XBoxTech.leftBumper);
    private Button clawInput = new JoystickButton(techControls,XBoxTech.rightBumper);
    private Button clawOpenClose = new JoystickButton(techControls,XBoxTech.aButton);
    private Button pickupLevel = new JoystickButton(techControls,XBoxTech.bButton);
    public Button elevatorManual = new JoystickButton(techControls,XBoxTech.leftYAxis);
    private DigitalInput clawButton = RobotMap.clawButton;




    // Defining state variables to log the states of different subsystems
    public boolean shootState = true;
    public boolean clawOpenState = false;
    public boolean platformRaised = false;
    public boolean cubeState = true;
    public boolean clawCollectState = false;
    public int clawDriveState = 2;
    public double elevatorTargetLevel = 0;
    // clawDriveState: 2 = output, 3 = off, 4 = input;




    public double getDriveMoveSpeed() {
            return driveControls.getLeftStickY();
        }

    public double getRotateSpeed() {return driveControls.getRightStickX(); }

    public double getLeftTrigger() {
        return techControls.getLeftTrigger();
    }

    public double geRightTrigger() {
        return techControls.getRightTrigger();
    }


    public OI() {
        int checkVal = techControls.getPOV();

        if(clawButton.get()) {
            cubeState = true;
            if(clawCollectState) {
                Robot.claw.stop();
                clawCollectState = false;
            }
        } else {
            cubeState = false;
        }


        if(cubeState) {
            vaultLevel.whenPressed(new ElevatorMotion(Robot.elevator.vaultLevel()));
            if(checkVal == 0) { elevatorTargetLevel = Robot.elevator.highLevel();
            } else if(checkVal == 90) {
                elevatorTargetLevel = Robot.elevator.switchLevel();
            } else if(checkVal == 180) {
                elevatorTargetLevel = Robot.elevator.lowLevel();
            } else if(checkVal == 270) {
                elevatorTargetLevel = Robot.elevator.midLevel();
            }

            clawOutput.whenPressed(new ClawSpit());
        } else {
            clawInput.whenPressed(new ClawCollect());
            clawOpenClose.whenPressed(new ClawGrab());
            pickupLevel.whenPressed(new ElevatorMotion(Robot.elevator.pickupLevel()));
        }
    }
}
