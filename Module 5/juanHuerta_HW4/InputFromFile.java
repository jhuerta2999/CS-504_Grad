import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

	public List<String> read() throws FileNotFoundException {
		List<String> list = new ArrayList<String>();
		File file = new File("src/kwic.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine()){
			String line = scanner.nextLine();
			list.add(line);
		}

		return list;
	}

}
