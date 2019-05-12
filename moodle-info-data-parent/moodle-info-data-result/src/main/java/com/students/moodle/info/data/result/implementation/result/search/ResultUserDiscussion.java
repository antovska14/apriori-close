package com.students.moodle.info.data.result.implementation.result.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.students.moodle.info.data.result.implementation.read.LogFileList;
import com.students.moodle.info.data.result.implementation.read.LogFileRowContent;
import com.students.moodle.info.data.result.interfaces.result.search.SearchResult;

public final class ResultUserDiscussion implements SearchResult {

	@Override
	public List<String> getResult() throws IOException {
		final List<LogFileRowContent> logFileList = LogFileList.getList();
		final List<String> users = new ArrayList<>();
		for (final LogFileRowContent row : logFileList) {
			final String description = row.getDescription();
			if (description.contains("discussion")) {
				users.add(String.valueOf(getMappedUserId(description)));
			}
		}
		return users;

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
