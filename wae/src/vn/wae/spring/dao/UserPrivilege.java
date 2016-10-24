package vn.wae.spring.dao;

public enum UserPrivilege {
	USER(0), ADMIN(1), MASTER(2);

	private final int value;

	private UserPrivilege(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
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
