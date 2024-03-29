package com.students.moodle.info.data.result.implementation.read;

public final class LogFileRowContent {
	private final String dateTime;
	private final String eventContext;
	private final String component;
	private final String eventName;
	private final String description;
	private final String IPAddress;

	public LogFileRowContent(final String[] values) {
		this.dateTime = values[0];
		this.eventContext = values[1];
		this.component = values[2];
		this.eventName = values[3];
		this.description = values[4];
		this.IPAddress = values[6];
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getEventContext() {
		return eventContext;
	}

	public String getComponent() {
		return component;
	}

	public String getEventName() {
		return eventName;
	}

	public String getDescription() {
		return description;
	}

	public String getIPAddress() {
		return this.IPAddress;
	}
}
