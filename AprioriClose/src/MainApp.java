import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp {
	
	
	public static void main(String[] args) {		
		List<LogFileContent> logFileList = new ArrayList<LogFileContent>();
		List<List<Integer>> transactionsTable = new ArrayList<List<Integer>>(); 
		try {
			logFileList = readLogFile();
			transactionsTable = mapToTransactionTable(logFileList);
			System.out.println(transactionsTable.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<LogFileContent> readLogFile() throws IOException {
		List<LogFileContent> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("logs_BCS37_20181103.csv"));
			String line;
			int counter = 0;
			boolean first = true;
			while((line = br.readLine())!=null && counter < 100) {
				if(!first) {
					line = line.replaceFirst(",", "");
				}
				first = false;
				String[] values = line.split(",");
				LogFileContent logFileLine = new LogFileContent(values); 
				list.add(logFileLine);
				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static List<List<Integer>> mapToTransactionTable(List<LogFileContent> logFileList){
		List<List<Integer>> transactionTable = new ArrayList<List<Integer>>();
		
		for(int i = 1 ; i < logFileList.size(); i++) {
			List<Integer> descriptionContent = mapDescription(logFileList.get(i).getDescription());
			transactionTable.add(descriptionContent);
			System.out.println(transactionTable);
		}
		
		return transactionTable;
	}
	
	public static List<Integer> mapDescription(String description) {
		List<Integer> descriptionContent = new ArrayList<Integer>();
		String contentPattern = "[0-9]+";
		
		Pattern pattern = Pattern.compile(contentPattern);
		Matcher matcher = pattern.matcher(description);
		
		while(matcher.find()) {
			descriptionContent.add(Integer.parseInt(matcher.group(0)));
		}
		
		return descriptionContent;
	}

}
