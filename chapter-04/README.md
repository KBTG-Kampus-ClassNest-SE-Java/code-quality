# Chapter 4: Unit Testing: How to break dependency

## Step 1: Create `TextFile`

```java
import java.io.FileReader;
import java.io.FileWriter;

public class TextFile {

    public void create(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.close();
        } catch (Exception ignored) {
        }
    }

    public void write(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(content);
            fileWriter.write("\n");
            fileWriter.close();
        } catch (Exception ignored) {
        }
    }

    public String read(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            int i;
            while ((i = fileReader.read()) != -1) {
                content.append((char) i);
            }
            fileReader.close();
        } catch (Exception ignored) {
        }
        return content.toString().trim();
    }
}

```

## Step 2: Create `Note`

```java
public class Note {
    private final String DEFAULT_FILE_NAME = "note.txt";
    private final TextFile textFile;

    public Note(TextFile textFile) {
        this.textFile = textFile;
        this.create();
    }

    private void create() {
        textFile.create(DEFAULT_FILE_NAME);
    }

    public void write(String content) {
        textFile.write(DEFAULT_FILE_NAME, content);
    }

    public String read() {
        return textFile.read(DEFAULT_FILE_NAME);
    }

}
```

## Step 3: Create `NoteTest` and empty note

```java
class NoteTest {

    @Test
    @DisplayName("given initial note my note should be empty")
    void initialNoteShouldBeEmpty() {
        TextFile textFile = new TextFile();
        Note note = new Note(textFile);

        String actual = note.read();

        String expected = "";
        assertEquals(expected, actual);
    }

}
```

## Step 4: Create note `reading book` and  `StubReadingNote`

```java
class NoteTest {

    @Test
    @DisplayName("create reading book note should return reading book")
    void createReadingNote() {
        TextFile textFile = new StubReadingNote();
        Note note = new Note(textFile);

        note.write("Reading book");

        String expected = "Reading book";
        assertEquals(expected, note.read());
    }

}

class StubReadingNote extends TextFile {
    @Override
    public String read(String fileName) {
        return "Reading book";
    }

    @Override
    public void create(String fileName) {

    }
}
```

## Step 5: Check default file name and create `SpyNoteFileName`

```java
class NoteTest {

    @Test
    @DisplayName("my default note file should be note.txt")
    void defaultNoteFile() {
        SpyNoteFileName textFile = new SpyNoteFileName();
        Note note = new Note(textFile);

        String expected = "note.txt";
        assertEquals(expected, textFile.getSpyFileName());
    }
}

class SpyNoteFileName extends TextFile {
    private String spyFileName;

    @Override
    public void create(String fileName) {
        this.spyFileName = fileName;
    }

    public String getSpyFileName() {
        return spyFileName;
    }
}
```

## Step 6: Check create function should call only one and edit `SpyNoteFileName`

```java
class NoteTest {

    @Test
    @DisplayName("initial note should create note.txt only one time")
    void createNoteFileOnlyOneTime() {
        SpyNoteFileName textFile = new SpyNoteFileName();
        Note note = new Note(textFile);

        int expected = 1;
        assertEquals(expected, textFile.getSpyCreateCount());
    }
}

class SpyNoteFileName extends TextFile {
    private String spyFileName;
    private int spyCreateCount = 0; // add this line

    @Override
    public void create(String fileName) {
        this.spyFileName = fileName;
        spyCreateCount++; // add this line
    }

    public String getSpyFileName() {
        return spyFileName;
    }

    // add this method
    public int getSpyCreateCount() {
        return spyCreateCount;
    }
}
```

## Step 7: Check write function was called and create `MockWriteTextFile`

```java
class NoteTest {

    @Test
    @DisplayName("write reading note should call write method on TextFile")
    void writeNote() {
        MockWriteTextFile textFile = new MockWriteTextFile();
        Note note = new Note(textFile);

        note.write("Reading book");

        assertTrue(textFile.isWriteCalled());
    }
}

class MockWriteTextFile extends TextFile {

    private boolean writeWasCalled;

    @Override
    public void write(String fileName, String content) {
        writeWasCalled = true;
    }

    public boolean isWriteCalled() {
        return writeWasCalled;
    }
}
```

## Step 8: Additional feature: Birthday emoji 🎂, create `BirthdayChecker`, edit `Note` and `NoteTest`

```java
class Note {
    private BirthdayChecker birthdayChecker; // add this line

    // add another constructor
    public Note(TextFile textFile, BirthdayChecker birthdayChecker) {
        this.textFile = textFile;
        this.birthdayChecker = birthdayChecker;
    }

    // edit write function
    public void write(String content) {
        if (birthdayChecker.isBirthdayToday()) {
            content += " 🎂";
        }
        textFile.write(DEFAULT_FILE_NAME, content);
    }
}
```

```java
import java.time.LocalDateTime;

public class BirthdayChecker {

    boolean isBirthdayToday() {
        LocalDateTime today = LocalDateTime.now();
        return today.getDayOfMonth() == 1 && today.getMonthValue() == 1;
    }
}
```

```java
class NoteTest {

    @Test
    @DisplayName("given today is my birthday write reading note should contain 🎂")
    void writeNoteOnMyBirthday() {
        MockWriteTextFile textFile = new MockWriteTextFile();
        BirthdayChecker birthdayChecker = new StubBirthdayChecker();
        Note note = new Note(textFile, birthdayChecker);

        note.write("Reading book");

        String expected = "Reading book 🎂";
        assertEquals(expected, textFile.getContentWasWritten());
    }
}

class StubBirthdayChecker extends BirthdayChecker {

    @Override
    boolean isBirthdayToday() {
        return true;
    }

}
```
