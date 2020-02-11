package org.usfirst.frc.robot;

public class MotorStallException extends IllegalStateException {
	public MotorStallException(String msg) {
		super(msg);
	}
}
