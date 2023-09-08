import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlphabetizerTest {

	Alphabetizer alphabetizer;

	@BeforeEach
	void setUp() throws Exception {
		alphabetizer = new Alphabetizer();
	}

	@Test
	void alpha_2_lines() {
		List<String> lines = new ArrayList<String>();
		lines.add("hi bye foo");
		lines.add("bye hi");
		List<String> actual = alphabetizer.sort(lines);
		assertSame(2, actual.size());
		assertEquals("bye hi", actual.get(0));
		assertEquals("hi bye foo", actual.get(1));
	}

}
