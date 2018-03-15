package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.commands.*;


public class OI {

    // Initialize the XBox Controllers
    private XBoxDrive driveControls = RobotMap.driveControls;
    private XBoxTech techControls = RobotMap.techControls;

    private Button clawOutput = new JoystickButton(techControls, XBoxTech.leftBumper);
    private Button clawOpenClose = new JoystickButton(techControls,XBoxTech.aButton);

    private Button rampDeployButton = new JoystickButton(driveControls, XBoxDrive.backButton);
    private Button rampRaiseButton = new JoystickButton(driveControls, XBoxDrive.yButton);



    // Defining state variables to log the states of different subsystems
    public boolean clawOpenState = false;
    public boolean clawCollectState = false;
    public boolean cubeHeld = false;
    public boolean test = true;
    public boolean test2 = true;
    public boolean platState = false;
    public int autoRan = 0;

    public int distanceDriven = 0;

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

        clawOpenClose.whenPressed(new ClawGrab());
        clawOutput.whileHeld(new ClawSpit());

        rampDeployButton.whenPressed(new PlatformRelease());
        rampRaiseButton.whenPressed(new PlatformRampUp());

    }
}
