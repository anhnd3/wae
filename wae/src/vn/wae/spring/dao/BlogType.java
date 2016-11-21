package vn.wae.spring.dao;

public enum BlogType {
	TUTORIAL(0, "Tutorial"), NEWS(1, "News");

	private final int value;
	private final String desc;
	
	private BlogType(int value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public int getValue() {
		return this.value;
	}
	
	public String getDesc() {
		return this.desc;
	}
}
