package com.students.moodle.info.data.result.implementation.result.alg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.students.moodle.info.data.result.implementation.read.LogFileRowContent;

public final class IdIpTableMapper extends TransactionTableMapped {
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

	@Override
	public List<String> decodeParams(final List<String> params) {
		final List<String> ipAddresses = new ArrayList<>();
		for (final String parameter : params) {
			ipAddresses.add(getKey(Integer.parseInt(parameter)));
		}
		return ipAddresses;
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

	private static String getKey(final int value) {
		for (final Map.Entry<String, Integer> entry : ipMap.entrySet()) {
			if (value == entry.getValue() || value == -(int) (entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}

}
