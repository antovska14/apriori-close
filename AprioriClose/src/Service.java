import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Service {
	
	public void getMostFrequentUserIpAddressCombination() throws IOException {
		final String algorithmResultFile = "algorithm-result.txt"; 
		TransactionTable tt = new MapToIdIPTable();
		String resultFile = Result.getResultFile(tt);
		AlgoAprioriClose algorithm = new AlgoAprioriClose();
		Itemsets resultTable = algorithm.runAlgorithm(0.01, resultFile, algorithmResultFile);
	}
	
	public static String getKey(Map<String, Integer> map, int value) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (value == (int) entry.getValue() || value == -(int)(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;
	}
}
