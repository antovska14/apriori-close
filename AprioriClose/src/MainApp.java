import java.io.IOException;
import java.util.List;

public class MainApp {
	public static void main(String[] args) {
			TransactionTable tt = new MapToIdIPTable();
			try {
				List<List<Integer>> transactionTable = tt.getTransactionTable();
				
				for(int i = 0; i < transactionTable.size(); i++) {
					for(int j = 0; j < transactionTable.get(i).size(); j++) {
						System.out.print(transactionTable.get(i).get(j)+" ");
					}
					System.out.println();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
