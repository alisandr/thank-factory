package eFactory;

import java.util.HashMap;

class PlainDetails {

	private HashMap<Integer, String> buildPlainCivirPart() {

		HashMap<Integer, String> civilCarParts = new HashMap<Integer, String>();
		civilCarParts.put(1, "mischlen");
		civilCarParts.put(2, "pirelli");
		civilCarParts.put(3, "racing special");

		civilCarParts.put(4, "Iron car body");
		civilCarParts.put(5, "Aluminium car body");
		civilCarParts.put(6, "Titanum car body");

		civilCarParts.put(7, "Dog engine");
		civilCarParts.put(8, "Puma engine");
		civilCarParts.put(9, "Gepard engine");
		
		return civilCarParts;
	}

	private HashMap<Integer, String> buildPlainArmyPart() {

		HashMap<Integer, String>armyCarParts = new HashMap<Integer, String>();
		armyCarParts.put(1, "Iron tracks");
		armyCarParts.put(2, "Titanium tracks");
		armyCarParts.put(3, "Special tracks");

		armyCarParts.put(4, "Iron body");
		armyCarParts.put(5, "Titanium body");
		armyCarParts.put(6, "Special body");

		armyCarParts.put(7, "Iron head");
		armyCarParts.put(8, "Titanium head");
		armyCarParts.put(9, "Special head");

		armyCarParts.put(10, "harpuun");
		armyCarParts.put(11, "cannon");
		armyCarParts.put(12, "blaster");

		return armyCarParts;
	}

	protected HashMap<Integer, String> getPlainDetailSet(int version) {
	
		switch (version) {
			case 1 :
		return buildPlainCivirPart();
			case 2 :
				return buildPlainArmyPart();
	}
		return null;
	}
}