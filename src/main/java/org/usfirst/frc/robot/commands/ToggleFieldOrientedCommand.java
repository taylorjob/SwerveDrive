package org.usfirst.frc.robot.commands;

import org.usfirst.frc.robot.subsystems.HolonomicDrivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleFieldOrientedCommand extends Command {

	private final HolonomicDrivetrain mDrivetrain;

	public ToggleFieldOrientedCommand(HolonomicDrivetrain drivetrain) {
		mDrivetrain = drivetrain;
	}

	@Override
	protected void execute() {
		mDrivetrain.setFieldOriented(!mDrivetrain.isFieldOriented());
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
