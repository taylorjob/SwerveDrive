package org.usfirst.frc.robot.commands;

import org.usfirst.frc.robot.subsystems.SwerveDriveModule;

import edu.wpi.first.wpilibj.command.Command;

public class SwerveModuleCommand extends Command {

	private SwerveDriveModule mDriveModule;

	public SwerveModuleCommand(SwerveDriveModule driveModule) {
		this.mDriveModule = driveModule;

		requires(driveModule);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
