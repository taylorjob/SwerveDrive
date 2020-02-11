package org.usfirst.frc.robot;

import org.usfirst.frc.robot.commands.AdjustFieldOrientedAngleCommand;
import org.usfirst.frc.robot.commands.ResetDrivetrainEncoderCommand;
import org.usfirst.frc.robot.commands.ToggleFieldOrientedCommand;
import org.usfirst.frc.robot.commands.ZeroNavX;
import org.usfirst.frc.robot.input.DPadButton;
import org.usfirst.frc.robot.input.IGamepad;
import org.usfirst.frc.robot.input.XboxGamepad;
import org.usfirst.frc.robot.subsystems.HolonomicDrivetrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private IGamepad mController = new XboxGamepad(0);

	private Robot mRobot;

	public OI(Robot robot) {
		mRobot = robot;
	}

	public void registerControls() { 
		//mController.getAButton().whenPressed(new ResetDrivetrainEncoderCommand(mRobot.getDrivetrain()));
		mController.getYButton().whenPressed(new ZeroNavX());
		mController.getStartButton().whenPressed(new ToggleFieldOrientedCommand(mRobot.getDrivetrain()));
		//mController.getDPadButton(DPadButton.Direction.LEFT).whenPressed(new AdjustFieldOrientedAngleCommand(mRobot.getDrivetrain(), false));
		//mController.getDPadButton(DPadButton.Direction.RIGHT).whenPressed(new AdjustFieldOrientedAngleCommand(mRobot.getDrivetrain(), true));
	}

	public IGamepad getController() {
		return mController;
	}
}
