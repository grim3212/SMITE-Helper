package grim3212.java.smitehelper.gods;

public class BasicGod {

	private final String name;
	private final EnumRole role;
	private final EnumPantheon pantheon;
	private final EnumDamageType damageType;

	public BasicGod(String name, EnumRole role, EnumPantheon pantheon, EnumDamageType damageType) {
		this.name = name;
		this.role = role;
		this.pantheon = pantheon;
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

	public EnumDamageType getDamageType() {
		return damageType;
	}
}