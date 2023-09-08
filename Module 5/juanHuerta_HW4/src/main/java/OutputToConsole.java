import java.util.List;

public class OutputToConsole implements Output{
	SystemWrapper systemWrapper;

	public OutputToConsole(SystemWrapper systemWrapper) {
		this.systemWrapper = systemWrapper;
	}

	public void write(List<String> lines) {
		for (String line : lines) {
			this.systemWrapper.println(line);
		}
	}

}