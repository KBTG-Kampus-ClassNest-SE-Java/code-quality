public class App {
	public static void main(String[] args) {
		TextFile textFile = new TextFile();
		Note note = new Note(textFile);
		note.write("Coding is fun!");
		note.write("Testing is fun!");

		System.out.println("My Note:");
		System.out.println(note.read());
	}
}
