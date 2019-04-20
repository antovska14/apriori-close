import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogFileList {
	private static List<LogFileRowContent> list = null;

	private LogFileList() {
	}

	public static List<LogFileRowContent> getList() throws IOException {
		if (list == null) {
			list = readLogFile();
		}
		return list;
	}

	private static List<LogFileRowContent> readLogFile() throws IOException {
		final String logFileName = "logs_BCS37_20181103.csv";
		List<LogFileRowContent> logFileList;
		FileReader fr = new FileReader(logFileName);
		BufferedReader br = new BufferedReader(fr);
		try {
			String logFileRow;
			logFileList = new ArrayList<>();
			br.readLine();
			while ((logFileRow = br.readLine()) != null) {
				logFileRow = logFileRow.replaceFirst(",", "");
				String[] values = logFileRow.split(",");
				if (values.length == 7) {
					LogFileRowContent logFileLine = new LogFileRowContent(values);
					logFileList.add(logFileLine);
				}
			}
		} finally {
			if (fr != null) {
				fr.close();
			}
			if (br != null) {
				br.close();
			}
		}
		return logFileList;
	}
}
