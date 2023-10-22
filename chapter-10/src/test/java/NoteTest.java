import io.reactivex.rxjava3.schedulers.Schedulers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NoteTest {

	@Test
	@DisplayName("given initial note, my note should be empty")
	void initialNoteShouldBeEmpty() {
		TextFile textFile = mock(TextFile.class);
		when(textFile.read(any())).thenReturn("");
		Note note = new Note(textFile);

		String expected = "";
		String actual = note.read();
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("create reading book note, my note should return reading book")
	void createReadingNote() {
		TextFile textFile = mock(TextFile.class);
		when(textFile.read(any())).thenReturn("Reading book");
		Note note = new Note(textFile);

		note.write("Reading book");

		String expected = "Reading book";
		assertEquals(expected, note.read());
	}

	@Test
	@DisplayName("my default note file should be note.txt")
	void defaultNoteFile() {
		TextFile textFile = mock(TextFile.class);
		Note note = new Note(textFile);

		String expected = "note.txt";
		verify(textFile).create(expected);
	}

	@Test
	@DisplayName("initial note should create note.txt only one file")
	void createNoteFileOnlyOneTime() {
		TextFile textFile = mock(TextFile.class);
		Note note = new Note(textFile);

		int expected = 1;
		verify(textFile, times(1)).create(any());
	}

	@Test
	@DisplayName("write reading note should call write method")
	void writeNote() {
		TextFile textFile = mock(TextFile.class);
		Note note = new Note(textFile);

		note.write("Reading book");

		verify(textFile).write("note.txt", "Reading book");
	}

	@Test
	@DisplayName("given today is my birthday write reading note and my note should contain 🎂")
	void writeNoteOnMyBirthday() {
		TextFile textFile = mock(TextFile.class);
		BirthdayChecker birthdayChecker = mock(BirthdayChecker.class);
		when(birthdayChecker.isBirthday()).thenReturn(true);
		Note note = new Note(textFile, birthdayChecker);

		note.write("Reading book");

		String expected = "Reading book 🎂";
		verify(textFile).write("note.txt", expected);
	}

	@Test
	@DisplayName("given write reading note async should success")
	void writeAsyncNoteShouldSuccess() {
		TextFile textFile = mock(TextFile.class);
		BirthdayChecker birthdayChecker = mock(BirthdayChecker.class);
		when(birthdayChecker.isBirthday()).thenReturn(true);
		Note note = new Note(textFile, birthdayChecker);

		note.writeAsync("Reading book", Schedulers.trampoline())
			.test()
			.assertComplete();
	}
}
