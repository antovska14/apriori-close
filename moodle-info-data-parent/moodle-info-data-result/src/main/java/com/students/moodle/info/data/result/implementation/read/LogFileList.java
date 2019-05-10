package com.students.moodle.info.data.result.implementation.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class LogFileList {
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
		final String logFileName = "C:\\Users\\Dijana\\Desktop\\Project PTS Git\\apriori-close\\moodle-info-data-parent\\resources\\logs_BCS37_20181103.csv";
		List<LogFileRowContent> logFileList;
		final BufferedReader br = new BufferedReader(new FileReader(logFileName));
		try {
			String logFileRow;
			logFileList = new ArrayList<>();
			br.readLine();
			while ((logFileRow = br.readLine()) != null) {
				logFileRow = logFileRow.replaceFirst(",", "");
				final String[] values = logFileRow.split(",");
				if (values.length == 7) {
					final LogFileRowContent logFileLine = new LogFileRowContent(values);
					logFileList.add(logFileLine);
				}
			}
		} finally {
			if (br != null) {
				br.close();
			}
		}
		return logFileList;
	}
}
