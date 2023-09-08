import java.io.FileNotFoundException;
import java.util.List;

public interface Input {

    List<String> read() throws FileNotFoundException;
}
