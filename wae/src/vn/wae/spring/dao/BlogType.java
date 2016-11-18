package vn.wae.spring.dao;

public enum BlogType {
	TUTORIAL(0), NEWS(1);

	private final int value;

	private BlogType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
