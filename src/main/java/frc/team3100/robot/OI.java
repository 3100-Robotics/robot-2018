package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.commands.Shoot;
import static frc.team3100.robot.RobotMap.controls;


public class OI {

    private XBoxController controller = controls;
    private Button shootButton = new JoystickButton(controller, XBoxController.leftBumper);

    public boolean shootState = true;

    public double getDriveMoveSpeed() {
            return controls.getLeftStickY();
        }

    public double getRotateSpeed() {return controls.getRightStickX(); }

    public double getModifier() { return controls.getRightTrigger(); }

    public OI() { shootButton.whenPressed(new Shoot()); }


}
