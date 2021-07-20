package jp.ac.hcs.gondo.common;

public enum Priority {
	HIGH(1, "高"),
	MIDDLE(2, "中"),
	LOW(3, "低");
	
	private int id;
	
	private String value;
	
	public int getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	private Priority(int id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public static Priority idOf(int id) {
		for (Priority priority : values()) {
			if (priority.getId() == id) {
				return priority;
			}
		}
		throw new IllegalArgumentException("指定されたIDのPriorityが存在しません");
	}
}