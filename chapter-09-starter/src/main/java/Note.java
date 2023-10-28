import java.time.LocalDateTime;

public class Note {
    private final TextFile textFile;

    public Note() {
        this.textFile = new TextFile();
    }

    private void create() {
        textFile.create("note.txt");
    }

    public void write(String content) {
        LocalDateTime today = LocalDateTime.now();
        if (today.getDayOfMonth() == 1 && today.getMonthValue() == 1) {
            content += " 🎂";
        }
        textFile.write("note.txt", content);
    }

    public String read() {
        return textFile.read("note.txt");
    }
}

