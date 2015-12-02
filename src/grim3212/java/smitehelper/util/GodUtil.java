package grim3212.java.smitehelper.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gods.EnumDamageType;
import grim3212.java.smitehelper.gods.EnumPantheon;
import grim3212.java.smitehelper.gods.EnumPowerType;
import grim3212.java.smitehelper.gods.EnumRole;

public class GodUtil {

	public static void createGodData() {
		try {
			Scanner scanner = new Scanner(new File("godInfo.csv"));

			while (scanner.hasNextLine()) {
				String[] god = scanner.nextLine().split(",");

				GodUtil.registerGod(god);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<BasicGod> gods = new ArrayList<BasicGod>();
	public static HashMap<EnumRole, ArrayList<BasicGod>> roles = new HashMap<EnumRole, ArrayList<BasicGod>>();
	public static HashMap<EnumPowerType, ArrayList<BasicGod>> powerTypes = new HashMap<EnumPowerType, ArrayList<BasicGod>>();
	public static HashMap<EnumPantheon, ArrayList<BasicGod>> pantheons = new HashMap<EnumPantheon, ArrayList<BasicGod>>();
	public static HashMap<EnumDamageType, ArrayList<BasicGod>> damageTypes = new HashMap<EnumDamageType, ArrayList<BasicGod>>();

	public static HashMap<String, Integer> statistics = new HashMap<String, Integer>();

	public static void createStatistics() {
		statistics.put("Gods", gods.size());
		statistics.put("Roles", EnumRole.values().length);
		statistics.put("Pantheons", EnumPantheon.values().length);
		statistics.put("Power Types", EnumPowerType.values().length);
		statistics.put("Damage Types", EnumDamageType.values().length);
		statistics.put("Gamemodes", EnumGamemodes.values().length);
	}

	public static void registerGod(String[] godData) {
		String name = godData[0];
		EnumRole role = EnumRole.valueOf(godData[1]);
		EnumPantheon pantheon = EnumPantheon.valueOf(godData[2]);
		EnumDamageType damageType = EnumDamageType.valueOf(godData[3]);
		EnumPowerType powerType = null;

		switch (role) {
		case Assassin:
			powerType = EnumPowerType.Physical;
			break;
		case Guardian:
			powerType = EnumPowerType.Magical;
			break;
		case Hunter:
			powerType = EnumPowerType.Physical;
			break;
		case Mage:
			powerType = EnumPowerType.Magical;
			break;
		case Warrior:
			powerType = EnumPowerType.Physical;
			break;
		}

		BasicGod god = new BasicGod(name, role, EnumPowerType.Physical, pantheon, damageType);

		gods.add(god);
		increaseRole(role, god);
		increasePantheon(pantheon, god);
		increasePowerType(powerType, god);
		increaseDamageType(damageType, god);
	}

	public static void increaseRole(EnumRole role, BasicGod god) {
		if (roles.containsKey(role)) {
			roles.get(role).add(god);
		} else {
			ArrayList<BasicGod> roleGods = new ArrayList<BasicGod>();
			roleGods.add(god);
			roles.put(role, roleGods);
		}
	}

	public static void increasePantheon(EnumPantheon pantheon, BasicGod god) {
		if (pantheons.containsKey(pantheon)) {
			pantheons.get(pantheon).add(god);
		} else {
			ArrayList<BasicGod> pantheonGods = new ArrayList<BasicGod>();
			pantheonGods.add(god);
			pantheons.put(pantheon, pantheonGods);
		}
	}

	public static void increasePowerType(EnumPowerType powerType, BasicGod god) {
		if (powerTypes.containsKey(powerType)) {
			powerTypes.get(powerType).add(god);
		} else {
			ArrayList<BasicGod> powerTypeGods = new ArrayList<BasicGod>();
			powerTypeGods.add(god);
			powerTypes.put(powerType, powerTypeGods);
		}
	}

	public static void increaseDamageType(EnumDamageType damageType, BasicGod god) {
		if (damageTypes.containsKey(damageType)) {
			damageTypes.get(damageType).add(god);
		} else {
			ArrayList<BasicGod> damageTypeGods = new ArrayList<BasicGod>();
			damageTypeGods.add(god);
			damageTypes.put(damageType, damageTypeGods);
		}
	}
}
