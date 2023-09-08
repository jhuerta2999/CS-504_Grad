import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

	Output output;

	@BeforeEach
	void setUp() throws Exception {
		output = new Output();
	}

	@Test
	void output_lines_to_file() throws IOException {
		List<String> lines = new ArrayList<String>();
		lines.add("hi bye");
		lines.add("hi bye foo");
		output.write(lines);
		List<String> actual = new ArrayList<String>();
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
		assertSame(2, actual.size());
		assertEquals("hi bye", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

}
