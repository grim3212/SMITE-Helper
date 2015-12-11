package grim3212.java.smitehelper.gods;

import org.json.JSONObject;

public class BasicGod {

	private final String name;
	private final String role;
	private final String pantheon;
	private final String powerType;
	private final String damageType;
	private final JSONObject resources;

	public BasicGod(String name, String role, String pantheon, String powerType, String damageType, JSONObject resources) {
		this.name = name;
		this.role = role;
		this.pantheon = pantheon;
		this.powerType = powerType;
		this.damageType = damageType;
		this.resources = resources;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public String getPantheon() {
		return pantheon;
	}

	public String getPowerType() {
		return powerType;
	}

	public String getDamageType() {
		return damageType;
	}

	public JSONObject getResources() {
		return resources;
	}
}