package org.usfirst.frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int[] DRIVETRAIN_LEFT_ENCODER = {0, 1};
	public static final int[] DRIVETRAIN_LEFT_MOTORS = {3, 4, 5};
	public static final int[] DRIVETRAIN_LEFT_SHIFTER = {0, 1};
	public static final int[] DRIVETRAIN_RIGHT_ENCODER = {2, 3};
	public static final int[] DRIVETRAIN_RIGHT_MOTORS = {0, 1, 2};
	public static final int[] DRIVETRAIN_RIGHT_SHIFTER = {6, 7};
	public static final int kTimeoutMs = 10;
	public static final int kPIDLoopIdx = 0;
}
