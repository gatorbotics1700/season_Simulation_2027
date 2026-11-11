// Copyright 2021-2025 FRC 6328
// http://github.com/Mechanical-Advantage
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU General Public License
// version 3 as published by the Free Software Foundation or
// available in the root directory of this project.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.

package frc.robot;

import static edu.wpi.first.units.Units.Centimeters;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.util.RobotConfigLoader;

/**
 * This class defines the runtime mode used by AdvantageKit and loads robot-specific configuration
 * based on the roboRIO serial number. The mode is always "real" when running on a roboRIO. Change
 * the value of "simMode" to switch between "sim" (physics sim) and "replay" (log replay from a
 * file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  // Robot identification
  public static final String ROBOT_SERIAL_NUMBER;

  // Vision Constants (loaded from config)

  static {
    // Load configuration based on roboRIO serial number (auto-loads on first access)
    ROBOT_SERIAL_NUMBER = RobotConfigLoader.getSerialNumber();
  }

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static final CANBus driveCANBus =
        new CANBus(
            RobotConfigLoader.getString("tuner.drive_canbus_name").equals("null")
                ? ""
                : RobotConfigLoader.getString("tuner.drive_canbus_name"),
            "U/logs");

    // Mechanism CAN bus - reuses driveCANBus if they're the same physical bus
    public static final CANBus mechCANBus;

    static {
      String driveBusName = driveCANBus.getName();
      String mechBusName =
          RobotConfigLoader.getString("tuner.mech_canbus_name").equals("null")
              ? ""
              : RobotConfigLoader.getString("tuner.mech_canbus_name");

      // If both buses have the same name, reuse the same object
      if (driveBusName.equals(mechBusName)) {
        mechCANBus = driveCANBus;
      } else {
        mechCANBus = new CANBus(mechBusName, "./logs/example.hoot");
      }
    }

  public static final int KRAKEN_TICKS_PER_REV = 2048;

  public static final Distance CENTER_TO_BUMPER_OFFSET = Centimeters.of(40);
  // left and right offsets for the poles on the reef
  public static final Distance CENTER_TO_POLE_OFFSET = Centimeters.of(16.5);
  public static final Distance ROBOT_RADIUS_WITH_BUMPERS = Centimeters.of(57);
}
