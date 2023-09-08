import java.io.IOException;
import java.util.List;

public interface Output {

    void write(List<String> lines) throws IOException;
}
