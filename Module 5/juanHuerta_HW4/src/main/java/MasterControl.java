import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterControl {

	public static void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) throws IOException, IllegalAccessException {
		InputFactory inputFactory = new InputFactory(systemWrapper, scannerWrapper);
		OutputFactory outputFactory = new OutputFactory(systemWrapper);
		CircularShifter shifter = new CircularShifter();
		Alphabetizer alphabetizer = new Alphabetizer();

		systemWrapper.println("Please enter FILE to input from file or CONSOLE to input from console:");
		String inputType = scannerWrapper.nextLine();
		Input input = inputFactory.create(inputType);

		systemWrapper.println("Please enter FILE to output from file or CONSOLE to output from console:");
		String outputType = scannerWrapper.nextLine();
		Output output = outputFactory.create(outputType);

		List<String> phrases = input.read();
		List<String> unorderedPhrases = shifter.shiftLines(phrases);
		List<String> orderedPhrases = alphabetizer.sort(unorderedPhrases);
		output.write(orderedPhrases);
	}

	public static void main(String[] args) throws IOException, IllegalAccessException {
		MasterControl control = new MasterControl();

		control.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());
	}
}
