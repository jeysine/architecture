package cn.com.architecture.constants;

public enum EventConstant {
	TEST("test");

	private String value;

	private EventConstant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
