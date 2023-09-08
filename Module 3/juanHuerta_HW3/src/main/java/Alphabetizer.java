import java.util.List;

public class Alphabetizer {

	public List<String> sort(List<String> lines) {
		final int LIST_SIZE = lines.size();

		for(int currentPosition = 0; currentPosition < LIST_SIZE; currentPosition++) {
			for (int nextPosition = currentPosition + 1; nextPosition < LIST_SIZE; nextPosition++){
				String currentWord = lines.get(currentPosition);
				String nextWord = lines.get(nextPosition);
				boolean wordSwapRequired = doesCurrentWordComeAfterNextWord(currentWord, nextWord);

				if (wordSwapRequired) {
					lines.set(currentPosition, nextWord);
					lines.set(nextPosition, currentWord);
				}
			}
		}

		return lines;
	}

	private boolean doesCurrentWordComeAfterNextWord(String currentWord, String nextWord) {
		return currentWord.toLowerCase().compareTo(nextWord.toLowerCase()) > 0;
	}
}
