import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputFactoryTest {

	OutputFactory outputFactory;

	@BeforeEach
	void setUp() throws Exception {
		outputFactory = new OutputFactory(null);
	}

	@Test
	void create_output_to_file() {
		Output actual = outputFactory.create("FILE");
		assertTrue(actual instanceof OutputToFile);
	}

	@Test
	void create_output_to_console() {
		Output actual = outputFactory.create("CONSOLE");
		assertTrue(actual instanceof OutputToConsole);
	}

	@Test
	void illegal_argument_exception_if_invalid_input_string() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			outputFactory.create("invalid");
		});
	}
}
