public class LogFileRowContent {
	private String dateTime;
	private String eventContext;
	private String component;
	private String eventName;
	private String description;
	private String origin;
	private String IPAddress;

	public LogFileRowContent(String[] values) {
		this.dateTime = values[0];
		this.eventContext = values[1];
		this.component = values[2];
		this.eventName = values[3];
		this.description = values[4];
		this.origin = values[5];
		this.IPAddress = values[6];
	}

	public String getDescription() {
		return this.description;
	}
	
	public String getIPAddress() {
		return this.IPAddress;
	}
}
