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
