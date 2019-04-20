import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TransactionTableMapped implements TransactionTable {
	private List<List<Integer>> transactionTable = null;

	protected abstract List<LogFileRowContent> filterList(List<LogFileRowContent> logFileList);

	protected abstract List<Integer> getMappedParams(LogFileRowContent logFileRow);

	@Override
	public List<List<Integer>> getTransactionTable() throws IOException {
		if (transactionTable == null) {
			transactionTable = new ArrayList<List<Integer>>();
			List<LogFileRowContent> logFileList = LogFileList.getList();
			List<LogFileRowContent> filteredLogFileList = filterList(logFileList);

			for (LogFileRowContent logFileRow : filteredLogFileList){
				List<Integer> logFileRowArray = getLogFileRowArray(logFileRow);
				transactionTable.add(logFileRowArray);
			}
		}
		return transactionTable;
	}

	private List<Integer> getLogFileRowArray(LogFileRowContent logFileRow){
		List<Integer> logFileRowArray = new ArrayList<Integer>();
		logFileRowArray.add(getMappedUserId(logFileRow.getDescription()));
		logFileRowArray.addAll(getMappedParams(logFileRow));
		return logFileRowArray;
	}

	private int getMappedUserId(String description) {
		String userId = null;
		String userIdPattern = "[0-9]+";

		Pattern pattern = Pattern.compile(userIdPattern);
		Matcher matcher = pattern.matcher(description);

		if (matcher.find()) {
			userId = matcher.group();
		}
		return Integer.parseInt(userId);
	}
}
