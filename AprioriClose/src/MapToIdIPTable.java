import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MapToIdIPTable extends TransactionTableMapped {
	private static Map<String, Integer> ipMap = new HashMap<String, Integer>();

	public static Map<String, Integer> getIpMap() {
		return ipMap;
	}
	
	@Override
	protected List<LogFileRowContent> filterList(List<LogFileRowContent> logFileList) {
		return logFileList;
	}

	@Override
	protected List<Integer> getMappedParams(LogFileRowContent logFileRow) {
		List<Integer> idIpArray = new ArrayList<Integer>();
		idIpArray.add(getMappedIPAddress(logFileRow));

		return idIpArray;
	}

	private static int getMappedIPAddress(LogFileRowContent logFileRow) {
		int IPAddress = 0;
		String ipAddressString = logFileRow.getIPAddress();
		IPAddress = Math.abs(ipAddressString.hashCode());

		if (!ipMap.containsKey(ipAddressString)) {
			ipMap.put(ipAddressString, IPAddress);
		}

		return IPAddress;
	}
}
