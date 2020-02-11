
package org.usfirst.frc.robot;

import com.kauailabs.navx.frc.AHRS;

//import org.usfirst.frc.robot.subsystems.SwerveDriveModule;
import org.usfirst.frc.robot.subsystems.SwerveDriveSubsystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
	public static final boolean DEBUG = true;
	
	public static SwerveDriveSubsystem swerveDriveSubsystem;
	public Compressor compressor;
	public AHRS m_ahrs;
	public static Command m_autoCommand;
	SendableChooser<Integer> m_chooser = new SendableChooser<Integer>();
	SendableChooser<Integer> m_alignChooser = new SendableChooser<Integer>();
	private static OI mOI;
	public static double targetPos;

	//Auto system
	private static final int START_DEFAULT = 0;
	private static final int FRONT_DEFAULT = 0;


	public static OI getOI() {
		return mOI;
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		compressor = new Compressor();
		swerveDriveSubsystem = new SwerveDriveSubsystem();

		mOI = new OI(this);
		mOI.registerControls();
		swerveDriveSubsystem.zeroGyro();

		m_alignChooser.setDefaultOption("Front Default", FRONT_DEFAULT);
		m_chooser.setDefaultOption("Start Default", START_DEFAULT);

		SmartDashboard.putData("Align Chooser", m_alignChooser);
	}

	@Override
	public void robotPeriodic() {

		// If X Button is NOT pressed - set Auto mode to off
		if(!(getOI().getController().getXButton().get())) swerveDriveSubsystem.setIsAuto(false);

		SmartDashboard.putNumber("Adjusted Drivetrain Angle", swerveDriveSubsystem.getGyroAngle());
		SmartDashboard.putNumber("Raw Drivetrain Angle", swerveDriveSubsystem.getRawGyroAngle());
		SmartDashboard.putNumber("Drivetrain Rate", swerveDriveSubsystem.getGyroRate());
		SmartDashboard.putNumber("Gyro Update Rate", swerveDriveSubsystem.getNavX().getActualUpdateRate());
		
		for (int i = 0; i < 4; i++) {
			SmartDashboard.putNumber("Drive Current Draw " + i, swerveDriveSubsystem.getSwerveModule(i).getDriveMotor().getOutputCurrent());
			SmartDashboard.putNumber("Angle Current Draw " + i, swerveDriveSubsystem.getSwerveModule(i).getAngleMotor().getOutputCurrent());
		}

		targetPos = FRONT_DEFAULT;
	
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		for (int i = 0; i < 4; i++) {
			swerveDriveSubsystem.getSwerveModule(i).robotDisabledInit();
		}
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		SmartDashboard.putData("Auto Chooser", m_chooser);
		//m_autoCommand = new 
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		compressor.setClosedLoopControl(true);

	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testInit() {

	}
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {

	}

	public SwerveDriveSubsystem getDrivetrain() {
		return swerveDriveSubsystem;
	}
}
