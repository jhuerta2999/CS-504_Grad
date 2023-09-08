import java.util.ArrayList;
import java.util.List;

public class CircularShifter {

	public List<String> shiftLines(List<String> lines) {
		List<String> allPhraseIterations = new ArrayList<>();

		for (String line : lines) {
			List<String> shiftedPhrases = getAllShiftedPhrasesForLine(line);

			allPhraseIterations.addAll(shiftedPhrases);
		}

		return allPhraseIterations;
	}

	private List<String> getAllShiftedPhrasesForLine(String line){
		List<String> listOfShiftedPhrases = new ArrayList<String>();
		String[] listOfWordsInPhrase = line.split(" ");
		final int LIST_SIZE = listOfWordsInPhrase.length;

		for (int i = 0; i < LIST_SIZE; i++) {
			String shiftedPhrase = shiftWordsInList(listOfWordsInPhrase, LIST_SIZE);

			listOfShiftedPhrases.add(shiftedPhrase);
		}

		return listOfShiftedPhrases;
	}

	private String shiftWordsInList(String[] listOfWordsInPhrase, int LIST_SIZE){
		String firstWordInList = listOfWordsInPhrase[0];
		String newPhrase = "";

		for (int j = 0; j < LIST_SIZE - 1; j++) {
			listOfWordsInPhrase[j] =listOfWordsInPhrase[j + 1];
			newPhrase += listOfWordsInPhrase[j] + " ";
		}

		listOfWordsInPhrase[LIST_SIZE - 1] = firstWordInList;
		newPhrase += firstWordInList;

		return newPhrase;
	}
}
