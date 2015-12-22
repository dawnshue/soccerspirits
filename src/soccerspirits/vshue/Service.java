package soccerspirits.vshue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Service {

	public final String PLAYER_FILENAME = "players.csv";
	public final String CSV_DELIMITER = ",";
	private Map<String, Player> playerMap;

	public static void main(String[] args) {
		Service service = new Service();
		service.loadFile();
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
				linenum++;
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
	}
}
