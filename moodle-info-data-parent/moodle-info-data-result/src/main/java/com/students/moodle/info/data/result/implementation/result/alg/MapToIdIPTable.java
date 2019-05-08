package com.students.moodle.info.data.result.implementation.result.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.students.moodle.info.data.result.implementation.read.LogFileRowContent;

public final class MapToIdIPTable extends TransactionTableMapped {
	private static Map<String, Integer> ipMap = new HashMap<String, Integer>();

	public static Map<String, Integer> getIpMap() {
		return ipMap;
	}

	@Override
	protected List<LogFileRowContent> filterList(final List<LogFileRowContent> logFileList) {
		return logFileList;
	}

	@Override
	protected List<Integer> getMappedParams(final LogFileRowContent logFileRow) {
		final List<Integer> ipArray = new ArrayList<Integer>();
		ipArray.add(getMappedIPAddress(logFileRow));

		return ipArray;
	}

	private static int getMappedIPAddress(final LogFileRowContent logFileRow) {
		int IPAddress = 0;
		final String ipAddressString = logFileRow.getIPAddress();
		IPAddress = Math.abs(ipAddressString.hashCode());

		if (!ipMap.containsKey(ipAddressString)) {
			ipMap.put(ipAddressString, IPAddress);
		}
		return IPAddress;
	}

	private static String getKey(final Map<String, Integer> map, final int value) {
		for (final Map.Entry<String, Integer> entry : map.entrySet()) {
			if (value == entry.getValue() || value == -(int) (entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

	@Override
	public List<String> decodeParams() {
		return null;
	}

}
