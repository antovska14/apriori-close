import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		List<LogFileContent> logFileList = new ArrayList<LogFileContent>();
		List<List<Integer>> transactionsTable = new ArrayList<List<Integer>>();
		try {
			logFileList = LogFileContent.readLogFile();
			transactionsTable = mapToTransactionTable(logFileList);
			System.out.println(transactionsTable.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<List<Integer>> mapToTransactionTable(List<LogFileContent> logFileList) {
		List<List<Integer>> transactionTable = new ArrayList<List<Integer>>();

		for (int i = 1; i < logFileList.size(); i++) {
			List<Integer> descriptionContent = LogFileContent.mapDescription(logFileList.get(i).getDescription());
			transactionTable.add(descriptionContent);
			System.out.println(transactionTable);
		}

		return transactionTable;
	}

}
