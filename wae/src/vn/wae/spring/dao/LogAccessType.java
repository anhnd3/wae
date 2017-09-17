package vn.wae.spring.dao;

public enum LogAccessType {
	TOTAL(1), COUNTDOWN(2), ABOUT(3), COURSE(4), TUTORIAL(5), NEWS(6), PROJECT(7), AUTOMATIC(8), CONTACT(9), HOME(10),
	COURSE_DETAIL(11), NEWS_DETAIL(12), TUTORIAL_DETAIL(13);

	private final int value;

	private LogAccessType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
