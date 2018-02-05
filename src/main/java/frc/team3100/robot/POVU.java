package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class POVU extends Trigger {
    public boolean get() {
        return RobotMap.techControls.getPOV() == 90;
    }
}
