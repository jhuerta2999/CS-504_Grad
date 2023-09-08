import java.io.IOException;
import java.util.List;

public class MasterControl {

	public void start(ScannerWrapper scannerWrapper, SystemWrapper systemWrapper) throws IOException {
		Input input = new Input();
		CircularShifter shifter = new CircularShifter();
		Alphabetizer alphabetizer = new Alphabetizer();
		Output output = new Output();

		List<String> phrases = input.read(scannerWrapper, systemWrapper);
		List<String> unorderedPhrases = shifter.shiftLines(phrases);
		List<String> orderedPhrases = alphabetizer.sort(unorderedPhrases);

		output.write(orderedPhrases, systemWrapper);
	}

	public static void main(String[] args) throws IOException {
		MasterControl control = new MasterControl();

		control.start(ScannerWrapper.getInstance(), SystemWrapper.getInstance());
	}
}
