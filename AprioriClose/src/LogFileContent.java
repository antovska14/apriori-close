import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFileContent {
	private String dateTime;
	private String eventContext;
	private String component;
	private String eventName;
	private String description;
	private String origin;
	private String IPAddress;
	
	public LogFileContent(String [] values) {
		this.dateTime = values[0];
		this.eventContext = values[1];
		this.component = values[2];
		this.eventName = values[3];
		this.description = values[4];
		this.origin = values[5];
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

	public String getOrigin() {
		return origin;
	}

	public String getIPAddress() {
		return IPAddress;
	}
	
	
	
}
