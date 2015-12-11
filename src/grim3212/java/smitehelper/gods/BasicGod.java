package grim3212.java.smitehelper.gods;

public class BasicGod {

	private final String name;
	private final EnumRole role;
	private final EnumPantheon pantheon;
	private final EnumPowerType powerType;
	private final EnumDamageType damageType;

	public BasicGod(String name, String role, String pantheon, String powerType, String damageType) {
		this.name = name;
		this.role = EnumRole.valueOf(role);
		this.pantheon = EnumPantheon.valueOf(pantheon);
		this.powerType = EnumPowerType.valueOf(powerType);
		this.damageType = EnumDamageType.valueOf(damageType);
	}

	public BasicGod(String name, EnumRole role, EnumPantheon pantheon, EnumPowerType powerType, EnumDamageType damageType) {
		this.name = name;
		this.role = role;
		this.pantheon = pantheon;
		this.powerType = powerType;
		this.damageType = damageType;
	}

	public String getName() {
		return name;
	}

	public EnumRole getRole() {
		return role;
	}

	public EnumPantheon getPantheon() {
		return pantheon;
	}

	public EnumPowerType getPowerType() {
		return powerType;
	}

	public EnumDamageType getDamageType() {
		return damageType;
	}
}