
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MusicApp {

	static List<String> musicList = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO code application logic here
		Scanner scanner = new Scanner(System.in);
		System.out.println("Db:");
		int count = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < count; i++) {
			String music = read();
			musicList.add(music);
		}
		System.out.println("\nPrinting:");
		for (String music : musicList) {
			System.out.println(music);
		}

	}

	static String read() {
		Scanner scanner = new Scanner(System.in);

		String input = null;

		do {
			System.out.println("Enter your favourite song:");
			System.out.println("Please use the following format: Artist - Title (Year)");
			input = scanner.nextLine();
		} while (!isValid(input));

		return input;
	}

	static boolean isValid(String input) {
		return input != null && !input.isEmpty() && input.contains("-") && input.contains("(") && input.contains(")");
	}

	static void print(String music) {
		String[] parts = music.split("-");
		String artist = parts[0].trim();

		String[] titleAndYear = parts[1].split("\\(");
		String title = titleAndYear[0].trim();
		String year = titleAndYear[1].substring(0, titleAndYear[1].length() - 1).trim();

		System.out.println("Title: " + title);
		System.out.println("Artist: " + artist);
		System.out.println("Released: " + year);
	}

}
