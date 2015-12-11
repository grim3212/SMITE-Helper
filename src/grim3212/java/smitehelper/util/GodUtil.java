package grim3212.java.smitehelper.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

import grim3212.java.smitehelper.gods.BasicGod;
import grim3212.java.smitehelper.gods.EnumDamageType;
import grim3212.java.smitehelper.gods.EnumPantheon;
import grim3212.java.smitehelper.gods.EnumPowerType;
import grim3212.java.smitehelper.gods.EnumRole;

public class GodUtil {

	public static void createGodData() {
		try {
			File f = new File("resources/gods/");
			ArrayList<File> names = new ArrayList<File>(Arrays.asList(f.listFiles()));
			for (int i = 0; i < names.size(); i++) {
				String extension = names.get(i).getName().substring(names.get(i).getName().lastIndexOf('.') + 1);

				if (extension.equals("json")) {
					FileInputStream fileIn = new FileInputStream(names.get(i));
					JSONObject obj = new JSONObject(new JSONTokener(fileIn));

					BasicGod god = new BasicGod(obj.getJSONObject("godInfo").getString("name"), obj.getJSONObject("godInfo").getString("role"), obj.getJSONObject("godInfo").getString("pantheon"), obj.getJSONObject("godInfo").getString("powerType"), obj.getJSONObject("godInfo").getString("damageType"));

					gods.add(god);
					increaseRole(god.getRole(), god);
					increasePantheon(god.getPantheon(), god);
					increasePowerType(god.getPowerType(), god);
					increaseDamageType(god.getDamageType(), god);
				}
			}

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
		statistics.put("# of " + EnumPowerType.Magical + " gods", powerTypes.get(EnumPowerType.Magical).size());
		statistics.put("# of " + EnumPowerType.Physical + " gods", powerTypes.get(EnumPowerType.Physical).size());
		statistics.put("Damage Types", EnumDamageType.values().length);
		statistics.put("# of " + EnumDamageType.Melee + " gods", damageTypes.get(EnumDamageType.Melee).size());
		statistics.put("# of " + EnumDamageType.Ranged + " gods", damageTypes.get(EnumDamageType.Ranged).size());
		statistics.put("Gamemodes", EnumGamemodes.values().length);
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
