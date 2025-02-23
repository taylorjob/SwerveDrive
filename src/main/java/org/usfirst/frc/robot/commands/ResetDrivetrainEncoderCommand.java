package org.usfirst.frc.robot.commands;

import org.usfirst.frc.robot.subsystems.HolonomicDrivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class ResetDrivetrainEncoderCommand extends Command {
	private HolonomicDrivetrain mDrivetrain;

	public ResetDrivetrainEncoderCommand(HolonomicDrivetrain drivetrain) {
		mDrivetrain = drivetrain;
	}

	@Override
	public void execute() {
		mDrivetrain.zeroGyro();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
