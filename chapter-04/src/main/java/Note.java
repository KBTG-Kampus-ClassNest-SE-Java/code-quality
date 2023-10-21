public class Note {
	private final String DEFAULT_FILE_NAME = "note.txt";
	private final TextFile textFile;
	private BirthdayChecker birthdayChecker;

	public Note(TextFile textFile) {
		this.textFile = textFile;
		this.create();
	}

	public Note(TextFile textFile, BirthdayChecker birthdayChecker) {
		this.textFile = textFile;
		this.birthdayChecker = birthdayChecker;
	}

	private void create() {
		textFile.create(DEFAULT_FILE_NAME);
	}

	public void write(String content) {
		if (birthdayChecker != null && birthdayChecker.isBirthdayToday()) {
			content += " 🎂";
		}
		textFile.write(DEFAULT_FILE_NAME, content);
	}

	public String read() {
		return textFile.read(DEFAULT_FILE_NAME);
	}
}
