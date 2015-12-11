package grim3212.java.smitehelper.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

import org.json.JSONObject;
import org.json.JSONTokener;

import grim3212.java.smitehelper.gods.BasicGod;

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

					BasicGod god = new BasicGod(obj.getJSONObject("godInfo").getString("name"), obj.getJSONObject("godInfo").getString("role"), obj.getJSONObject("godInfo").getString("pantheon"), obj.getJSONObject("godInfo").getString("powerType"), obj.getJSONObject("godInfo").getString("damageType"), obj.getJSONObject("resources"));

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
	public static TreeMap<String, ArrayList<BasicGod>> roles = new TreeMap<String, ArrayList<BasicGod>>();
	public static TreeMap<String, ArrayList<BasicGod>> powerTypes = new TreeMap<String, ArrayList<BasicGod>>();
	public static TreeMap<String, ArrayList<BasicGod>> pantheons = new TreeMap<String, ArrayList<BasicGod>>();
	public static TreeMap<String, ArrayList<BasicGod>> damageTypes = new TreeMap<String, ArrayList<BasicGod>>();

	public static HashMap<String, Integer> statistics = new HashMap<String, Integer>();

	public static void createStatistics() {
		statistics.put("Gods", gods.size());
		statistics.put("Roles", roles.keySet().size());
		statistics.put("Pantheons", pantheons.keySet().size());
		statistics.put("Power Types", powerTypes.keySet().size());

		Iterator<String> pitr = powerTypes.keySet().iterator();
		while (pitr.hasNext()) {
			String key = (String) pitr.next();
			statistics.put("# of " + key + " gods", powerTypes.get(key).size());
		}

		statistics.put("Damage Types", damageTypes.keySet().size());

		Iterator<String> ditr = damageTypes.keySet().iterator();
		while (ditr.hasNext()) {
			String key = (String) ditr.next();
			statistics.put("# of " + key + " gods", damageTypes.get(key).size());
		}

		statistics.put("Gamemodes", EnumGamemodes.values().length);
	}

	public static void increaseRole(String role, BasicGod god) {
		if (roles.containsKey(role)) {
			roles.get(role).add(god);
		} else {
			ArrayList<BasicGod> roleGods = new ArrayList<BasicGod>();
			roleGods.add(god);
			roles.put(role, roleGods);
		}
	}

	public static void increasePantheon(String pantheon, BasicGod god) {
		if (pantheons.containsKey(pantheon)) {
			pantheons.get(pantheon).add(god);
		} else {
			ArrayList<BasicGod> pantheonGods = new ArrayList<BasicGod>();
			pantheonGods.add(god);
			pantheons.put(pantheon, pantheonGods);
		}
	}

	public static void increasePowerType(String powerType, BasicGod god) {
		if (powerTypes.containsKey(powerType)) {
			powerTypes.get(powerType).add(god);
		} else {
			ArrayList<BasicGod> powerTypeGods = new ArrayList<BasicGod>();
			powerTypeGods.add(god);
			powerTypes.put(powerType, powerTypeGods);
		}
	}

	public static void increaseDamageType(String damageType, BasicGod god) {
		if (damageTypes.containsKey(damageType)) {
			damageTypes.get(damageType).add(god);
		} else {
			ArrayList<BasicGod> damageTypeGods = new ArrayList<BasicGod>();
			damageTypeGods.add(god);
			damageTypes.put(damageType, damageTypeGods);
		}
	}
}
