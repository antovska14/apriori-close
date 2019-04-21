import java.io.IOException;

public class MainApp {
	public static void main(String[] args) throws IOException {
		Service service = new Service();
		service.getMostFrequentUserIpAddressCombination();
	}
}
