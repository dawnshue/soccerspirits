package soccerspirits.vshue;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Service {

	private final String PLAYER_FILENAME = "players.csv";
	private final String CSV_DELIMITER = ",";
	private Map<String, Player> playerMap;

	public static void main(String[] args) {
		Service thisService = new Service();
		thisService.loadFile();
	}

	private void loadFile() {
		try (BufferedReader br = new BufferedReader(new FileReader(
				PLAYER_FILENAME))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(CSV_DELIMITER);
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
