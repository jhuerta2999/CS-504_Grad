import java.util.List;

public class Output {

	public void write(List<String> lines, SystemWrapper systemWrapper) {
		for (String line : lines) {
			systemWrapper.println(line);
		}
	}

}