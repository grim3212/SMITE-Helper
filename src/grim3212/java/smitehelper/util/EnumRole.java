package grim3212.java.smitehelper.util;

public enum EnumRole {
	Assassin("Physical"), Guardian("Magical"), Hunter("Physical"), Mage("Magical"), Warrior("Physical");

	private String powerType;

	private EnumRole(String powerType) {
		this.powerType = powerType;
	}

	public String getPowerType() {
		return this.powerType;
	}
}
