import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InputFromConsole implements Input {
	SystemWrapper systemWrapper;
	ScannerWrapper scannerWrapper;

	public InputFromConsole (SystemWrapper systemWrapper, ScannerWrapper scannerWrapper) {
		this.systemWrapper = systemWrapper;
		this.scannerWrapper = scannerWrapper;
	}

	public List<String> read() {
		List<String> list = new ArrayList<String>();

		this.systemWrapper.println("Please enter lines to add, then enter -1 to finish:");

		String userInput = this.scannerWrapper.nextLine();

		while (!Objects.equals(userInput, "-1")){
			list.add(userInput);
			userInput = this.scannerWrapper.nextLine();
		}

		return list;
	}

}
