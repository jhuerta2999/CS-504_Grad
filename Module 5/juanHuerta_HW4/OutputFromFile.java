import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Output {

	public void write(List<String> lines) throws IOException {
		FileWriter fileWriter = new FileWriter("kwic_output.txt");

		for (String line : lines) {
			fileWriter.write(line + "\n");
		}

		fileWriter.close();
	}

}
