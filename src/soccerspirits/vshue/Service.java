package soccerspirits.vshue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Service {

	public final String PLAYER_FILENAME = "/Users/Vangie/_Main/Programming/soccerspirits/players.csv";
	public final String CSV_DELIMITER = ",";
	private final boolean DEBUG_MODE = true;
	private Map<String, Player> playerMap;

	public static void main(String[] args) {
		Service service = new Service();
		service.loadFile();

		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.nextLine();
			while (input != null && input != "") {
				service.find(input);
				service.get(input);
				input = scanner.nextLine();
			}
		}
	}

	public Service() {
		playerMap = new HashMap<>();
	}

	private void loadFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(
				PLAYER_FILENAME))) {
			int linenum = 0;
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.toUpperCase();
				// debug(line);
				linenum++;
				if (linenum == 1)
					continue;
				String[] fields = line.split(CSV_DELIMITER);
				if (fields.length != Player.NUM_FIELDS) {
					System.out.println(linenum + " Invalid: " + line);
					throw new IOException(linenum + " Invalid: " + line);
				}
				playerMap.put(fields[0], new Player(fields));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		debug("Size of map: " + playerMap.size());
	}

	private void debug(Object s) {
		if (DEBUG_MODE)
			System.out.println(s);
	}

	public void find(String n) {
		String name = n.toUpperCase();
		System.out.println("Searching for: " + name);
		String regex = "[A-Z]*[/+]"+name+"[/+]";
		for (Player p : playerMap.values()) {
			String story = p.getStory();
			if (story.contains(name))
				System.out.println(p);
		}
	}

	public void get(String n) {
		String name = n.toUpperCase();
		System.out.println("Obtaining player info for: " + name);
		if (playerMap.containsKey(name))
			System.out.println(playerMap.get(name));
	}
}
