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
