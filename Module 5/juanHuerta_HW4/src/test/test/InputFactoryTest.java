import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputFactoryTest {

	InputFactory inputFactory;

	@BeforeEach
	void setUp() throws Exception {
		inputFactory = new InputFactory(null, null);
	}

	@Test
	void input_from_file() throws IllegalAccessException {
		Input actual = inputFactory.create("FILE");
		assertTrue(actual instanceof InputFromFile);
	}

	@Test
	void create_input_from_console() throws IllegalAccessException {
		Input actual = inputFactory.create("CONSOLE");
		assertTrue(actual instanceof InputFromConsole);
	}

	@Test
	void illegal_argument_exception_if_invalid_input_string() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			inputFactory.create("invalid");
		});
	}
}
