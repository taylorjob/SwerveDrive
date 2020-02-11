package org.usfirst.frc.robot;

public final class Utilities {
	private Utilities() {}

	public static double deadband(double in) {
		if (in < -0.02 || 0.02 < in) {
			return in;
		}

		return 0;
	}
}
