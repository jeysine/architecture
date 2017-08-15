package cn.com.architecture.system.constant;

public enum LogConstants {
	TRACE_ID("trace_id");

	private String value;

	private LogConstants(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
