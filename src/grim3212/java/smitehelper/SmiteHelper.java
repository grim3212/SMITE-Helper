package grim3212.java.smitehelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SmiteHelper {

	public static void createGodData() {
		try {
			Scanner scanner = new Scanner(new File("godInfo.csv"));

			while (scanner.hasNextLine()) {
				String[] god = scanner.nextLine().split(",");

				SmiteData.registerGod(god);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
