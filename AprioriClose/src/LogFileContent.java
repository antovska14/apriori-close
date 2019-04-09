import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileContent {
	private String dateTime;
	private String eventContext;
	private String component;
	private String eventName;
	private String description;
	private String origin;
	private String IPAddress;

	public LogFileContent(String[] values) {
		this.dateTime = values[0];
		this.eventContext = values[1];
		this.component = values[2];
		this.eventName = values[3];
		this.description = values[4];
		this.origin = values[5];
		this.IPAddress = values[6];
	}

	public String getDescription() {
		return description;
	}

	
	public static List<LogFileContent> readLogFile() throws IOException {
		List<LogFileContent> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("logs_BCS37_20181103.csv"));
			String line;
			int counter = 0;
			boolean first = true;
			while ((line = br.readLine()) != null && counter < 100) {
				if (!first) {
					line = line.replaceFirst(",", "");
				}
				first = false;
				String[] values = line.split(",");
				LogFileContent logFileLine = new LogFileContent(values);
				list.add(logFileLine);
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static List<Integer> mapDescription(String description) {
		List<Integer> descriptionContent = new ArrayList<Integer>();
		String contentPattern = "[0-9]+";

		Pattern pattern = Pattern.compile(contentPattern);
		Matcher matcher = pattern.matcher(description);

		while (matcher.find()) {
			descriptionContent.add(Integer.parseInt(matcher.group(0)));
		}

		return descriptionContent;
	}

}
