package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.commands.*;


public class OI {

    private XBoxDrive driveControls = RobotMap.driveControls;
    private XBoxTech techControls = RobotMap.techControls;

    private Button vaultLevel = new JoystickButton(techControls, XBoxTech.xButton);
    private Button clawYToggle = new JoystickButton(techControls, XBoxTech.aButton);
    private Button collectToggle = new JoystickButton(techControls, XBoxTech.bButton);
    private Button clawXToggle = new JoystickButton(techControls, XBoxTech.leftBumper);

    public boolean shootState = true;
    public boolean clawYState = false;
    public boolean clawXState = true;
    public int elevatorLevel = 0;
    public String elevatorPosition = "pickup";

    public double getDriveMoveSpeed() {
            return driveControls.getLeftStickY();
        }

    public double getRotateSpeed() {return driveControls.getRightStickX(); }

    public OI() {

        vaultLevel.whenPressed(new ElevatorVault());
        clawXToggle.whenPressed(new ClawGrab());
        clawYToggle.whenPressed(new ClawDrop());

        int checkVal = techControls.getPOV();
        if(checkVal == 0) {
            new ElevatorHigh();
        } else if(checkVal == 90) {
            new ElevatorSwitch();
        } else if(checkVal == 180) {
            new ElevatorLow();
        } else if(checkVal == 270) {
            new ElevatorMid();
        }


    }


}
