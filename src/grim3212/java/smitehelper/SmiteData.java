package grim3212.java.smitehelper;

import java.util.ArrayList;
import java.util.HashMap;

import grim3212.java.smitehelper.util.EnumDamageType;
import grim3212.java.smitehelper.util.EnumPantheon;
import grim3212.java.smitehelper.util.EnumRole;

public class SmiteData {

	public static ArrayList<BasicGod> gods = new ArrayList<BasicGod>();
	public static HashMap<EnumRole, ArrayList<BasicGod>> numRoles = new HashMap<EnumRole, ArrayList<BasicGod>>();
	public static HashMap<EnumPantheon, ArrayList<BasicGod>> numPantheons = new HashMap<EnumPantheon, ArrayList<BasicGod>>();
	public static HashMap<EnumDamageType, ArrayList<BasicGod>> numDamageType = new HashMap<EnumDamageType, ArrayList<BasicGod>>();

	public static void registerGod(String[] godData) {
		String name = godData[0];
		EnumRole role = EnumRole.valueOf(godData[1]);
		EnumPantheon pantheon = EnumPantheon.valueOf(godData[2]);
		EnumDamageType damageType = EnumDamageType.valueOf(godData[3]);
		BasicGod god = new BasicGod(name, role, pantheon, damageType);
		gods.add(god);
		increaseRole(role, god);
		increasePantheon(pantheon, god);
		increaseDamageType(damageType, god);
	}

	public static void increaseRole(EnumRole role, BasicGod god) {
		if (numRoles.containsKey(role)) {
			numRoles.get(role).add(god);
		} else {
			ArrayList<BasicGod> roleGods = new ArrayList<BasicGod>();
			roleGods.add(god);
			numRoles.put(role, roleGods);
		}
	}

	public static void increasePantheon(EnumPantheon pantheon, BasicGod god) {
		if (numPantheons.containsKey(pantheon)) {
			numPantheons.get(pantheon).add(god);
		} else {
			ArrayList<BasicGod> pantheonGods = new ArrayList<BasicGod>();
			pantheonGods.add(god);
			numPantheons.put(pantheon, pantheonGods);
		}
	}

	public static void increaseDamageType(EnumDamageType damageType, BasicGod god) {
		if (numDamageType.containsKey(damageType)) {
			numDamageType.get(damageType).add(god);
		} else {
			ArrayList<BasicGod> damageTypeGods = new ArrayList<BasicGod>();
			damageTypeGods.add(god);
			numDamageType.put(damageType, damageTypeGods);
		}
	}

	public static ArrayList<BasicItem> items = new ArrayList<BasicItem>();

}
