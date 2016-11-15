package vn.wae.spring.dao;

public enum LogAccessType {
	TOTAL(1), COUNTDOWN(2);

	private final int value;

	private LogAccessType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
