import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Result{
	
	public static String getResultFile(TransactionTable tt) throws IOException {
		String resultFile = "result.txt";
		List<List<Integer>> transactionTable = tt.getTransactionTable();
		writeToFile(transactionTable, resultFile);
		return resultFile;
	}

	public static void writeToFile(List<List<Integer>> transactionTable, String fileName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		try {

			for (int i = 0; i < transactionTable.size(); i++) {
				for (int j = 0; j < transactionTable.get(i).size(); j++) {
					if(j == transactionTable.get(i).size() - 1) {
						bw.write(transactionTable.get(i).get(j)+"");
					}else {						
						bw.write(transactionTable.get(i).get(j) + " ");
					}
				}
				bw.newLine();
			}
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}
}
