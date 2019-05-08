package com.students.moodle.info.data.result.implementation.result.alg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.students.moodle.info.data.result.implementation.read.LogFileList;
import com.students.moodle.info.data.result.implementation.read.LogFileRowContent;
import com.students.moodle.info.data.result.interfaces.result.alg.TransactionTable;

public abstract class TransactionTableMapped implements TransactionTable {
	private List<List<Integer>> transactionTable = null;

	protected abstract List<LogFileRowContent> filterList(List<LogFileRowContent> logFileList);

	protected abstract List<Integer> getMappedParams(LogFileRowContent logFileRow);

	@Override
	public List<List<Integer>> getTransactionTable() throws IOException {
		if (transactionTable == null) {
			transactionTable = new ArrayList<List<Integer>>();
			final List<LogFileRowContent> logFileList = LogFileList.getList();
			final List<LogFileRowContent> filteredLogFileList = filterList(logFileList);

			for (final LogFileRowContent logFileRow : filteredLogFileList) {
				final List<Integer> logFileRowArray = getLogFileRowArray(logFileRow);
				transactionTable.add(logFileRowArray);
			}
		}
		return transactionTable;
	}

	private List<Integer> getLogFileRowArray(final LogFileRowContent logFileRow) {
		final List<Integer> logFileRowArray = new ArrayList<Integer>();
		logFileRowArray.add(getMappedUserId(logFileRow.getDescription()));
		logFileRowArray.addAll(getMappedParams(logFileRow));
		return logFileRowArray;
	}

	private int getMappedUserId(final String description) {
		String userId = null;
		final String userIdPattern = "[0-9]+";

		final Pattern pattern = Pattern.compile(userIdPattern);
		final Matcher matcher = pattern.matcher(description);

		if (matcher.find()) {
			userId = matcher.group();
		}
		return Integer.parseInt(userId);
	}
}