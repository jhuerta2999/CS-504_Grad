import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Input {

	public List<String> read(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) {
		List<String> list = new ArrayList<String>();

		systemWrapper.println("Please enter lines to add, then enter -1 to finish:");

		String userInput = scannerWrapper.nextLine();;

		while (!Objects.equals(userInput, "-1")){
			list.add(userInput);
			userInput = scannerWrapper.nextLine();
		}

		return list;
	}

}
