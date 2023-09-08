import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class MasterControlTest {

	MasterControl masterControl;
	ScannerWrapper scannerWrapper;
	SystemWrapper systemWrapper;

	@BeforeEach
	void setUp() throws Exception {
		masterControl = new MasterControl();
		scannerWrapper = Mockito.mock(ScannerWrapper.class);
		systemWrapper = Mockito.mock(SystemWrapper.class);
	}

	@Test
	void input_from_file_and_output_to_file() throws IOException, IllegalAccessException {
		Mockito.when(scannerWrapper.nextLine()).thenReturn("FILE", "FILE");
		List<String> lines = new ArrayList<String>();
		lines.add("Descent of Man");
		lines.add("The Ascent of Man");
		lines.add("The Old Man and The Sea");
		FileWriter fileWriter = new FileWriter("kwic.txt");
		for (String line : lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();
		masterControl.start(scannerWrapper, systemWrapper);
		List<String> actual = new ArrayList<String>();
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
		assertSame(13, actual.size());
		assertEquals("and The Sea The Old Man", actual.get(0));
		assertEquals("Ascent of Man The", actual.get(1));
		assertEquals("Descent of Man", actual.get(2));
		assertEquals("Man and The Sea The Old", actual.get(3));
		assertEquals("Man Descent of", actual.get(4));
		assertEquals("Man The Ascent of", actual.get(5));
		assertEquals("of Man Descent", actual.get(6));
		assertEquals("of Man The Ascent", actual.get(7));
		assertEquals("Old Man and The Sea The", actual.get(8));
		assertEquals("Sea The Old Man and The", actual.get(9));
		assertEquals("The Ascent of Man", actual.get(10));
		assertEquals("The Old Man and The Sea", actual.get(11));
		assertEquals("The Sea The Old Man and", actual.get(12));
		InOrder inOrder = Mockito.inOrder(systemWrapper);
		inOrder.verify(systemWrapper).println("Please enter FILE to input from file or CONSOLE to input from console:");
		inOrder.verify(systemWrapper)
				.println("Please enter FILE to output from file or CONSOLE to output from console:");
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	void input_from_console_and_output_to_console() throws IOException, IllegalAccessException {
		Mockito.when(scannerWrapper.nextLine()).thenReturn("CONSOLE", "CONSOLE", "Descent of Man", "The Ascent of Man",
				"The Old Man and The Sea", "-1");
		masterControl.start(scannerWrapper, systemWrapper);
		InOrder inOrder = Mockito.inOrder(systemWrapper);
		inOrder.verify(systemWrapper).println("Please enter FILE to input from file or CONSOLE to input from console:");
		inOrder.verify(systemWrapper)
				.println("Please enter FILE to output from file or CONSOLE to output from console:");
		inOrder.verify(systemWrapper).println("Please enter lines to add, then enter -1 to finish:");
		inOrder.verify(systemWrapper).println("and The Sea The Old Man");
		inOrder.verify(systemWrapper).println("Ascent of Man The");
		inOrder.verify(systemWrapper).println("Descent of Man");
		inOrder.verify(systemWrapper).println("Man and The Sea The Old");
		inOrder.verify(systemWrapper).println("Man Descent of");
		inOrder.verify(systemWrapper).println("Man The Ascent of");
		inOrder.verify(systemWrapper).println("of Man Descent");
		inOrder.verify(systemWrapper).println("of Man The Ascent");
		inOrder.verify(systemWrapper).println("Old Man and The Sea The");
		inOrder.verify(systemWrapper).println("Sea The Old Man and The");
		inOrder.verify(systemWrapper).println("The Ascent of Man");
		inOrder.verify(systemWrapper).println("The Old Man and The Sea");
		inOrder.verify(systemWrapper).println("The Sea The Old Man and");
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	void input_from_file_and_output_to_console() throws IOException, IllegalAccessException {
		Mockito.when(scannerWrapper.nextLine()).thenReturn("FILE", "CONSOLE");
		List<String> lines = new ArrayList<String>();
		lines.add("Descent of Man");
		lines.add("The Ascent of Man");
		lines.add("The Old Man and The Sea");
		FileWriter fileWriter = new FileWriter("kwic.txt");
		for (String line : lines) {
			fileWriter.write(line);
			fileWriter.write("\n");
		}
		fileWriter.close();
		masterControl.start(scannerWrapper, systemWrapper);
		InOrder inOrder = Mockito.inOrder(systemWrapper);
		inOrder.verify(systemWrapper).println("Please enter FILE to input from file or CONSOLE to input from console:");
		inOrder.verify(systemWrapper)
				.println("Please enter FILE to output from file or CONSOLE to output from console:");
		inOrder.verify(systemWrapper).println("and The Sea The Old Man");
		inOrder.verify(systemWrapper).println("Ascent of Man The");
		inOrder.verify(systemWrapper).println("Descent of Man");
		inOrder.verify(systemWrapper).println("Man and The Sea The Old");
		inOrder.verify(systemWrapper).println("Man Descent of");
		inOrder.verify(systemWrapper).println("Man The Ascent of");
		inOrder.verify(systemWrapper).println("of Man Descent");
		inOrder.verify(systemWrapper).println("of Man The Ascent");
		inOrder.verify(systemWrapper).println("Old Man and The Sea The");
		inOrder.verify(systemWrapper).println("Sea The Old Man and The");
		inOrder.verify(systemWrapper).println("The Ascent of Man");
		inOrder.verify(systemWrapper).println("The Old Man and The Sea");
		inOrder.verify(systemWrapper).println("The Sea The Old Man and");
		inOrder.verifyNoMoreInteractions();
	}

	@Test
	void input_from_console_and_output_to_file() throws IOException, IllegalAccessException {
		Mockito.when(scannerWrapper.nextLine()).thenReturn("CONSOLE", "FILE", "Descent of Man", "The Ascent of Man",
				"The Old Man and The Sea", "-1");
		masterControl.start(scannerWrapper, systemWrapper);
		List<String> actual = new ArrayList<String>();
		File file = new File("kwic_output.txt");
		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			actual.add(reader.nextLine());
		}
		reader.close();
		assertSame(13, actual.size());
		assertEquals("and The Sea The Old Man", actual.get(0));
		assertEquals("Ascent of Man The", actual.get(1));
		assertEquals("Descent of Man", actual.get(2));
		assertEquals("Man and The Sea The Old", actual.get(3));
		assertEquals("Man Descent of", actual.get(4));
		assertEquals("Man The Ascent of", actual.get(5));
		assertEquals("of Man Descent", actual.get(6));
		assertEquals("of Man The Ascent", actual.get(7));
		assertEquals("Old Man and The Sea The", actual.get(8));
		assertEquals("Sea The Old Man and The", actual.get(9));
		assertEquals("The Ascent of Man", actual.get(10));
		assertEquals("The Old Man and The Sea", actual.get(11));
		assertEquals("The Sea The Old Man and", actual.get(12));
		InOrder inOrder = Mockito.inOrder(systemWrapper);
		inOrder.verify(systemWrapper).println("Please enter FILE to input from file or CONSOLE to input from console:");
		inOrder.verify(systemWrapper)
				.println("Please enter FILE to output from file or CONSOLE to output from console:");
		inOrder.verify(systemWrapper).println("Please enter lines to add, then enter -1 to finish:");
		inOrder.verifyNoMoreInteractions();
	}

}
