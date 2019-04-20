import java.io.IOException;
import java.util.List;

public interface TransactionTable {
	public List<List<Integer>> getTransactionTable() throws IOException;
}