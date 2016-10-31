package vn.wae.spring.dao;

public enum UserPrivilege {
	USER(0, "User"), MOD(1, "Mod"), ADMIN(2, "Admin");

	private final int value;
	private final String desc;

	private UserPrivilege(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return this.value;
	}

	public String getDesc() {
		return this.desc;
	}

	public static UserPrivilege fromValue(int value) {
		UserPrivilege[] arrPrivilege = UserPrivilege.values();
		for (UserPrivilege tmpPrivilege : arrPrivilege) {
			if (tmpPrivilege.getValue() == value) {
				return tmpPrivilege;
			}
		}
		return null;
	}
}
