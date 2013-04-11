package eFactory;

import java.util.ArrayList;

/**
 * Класс описывающий генерацию списков продажи простых запчастей.
 * 
 * @version 0.3
 * @author Андрей Кожуров
 * 
 */

class PlainDetails {

	protected ArrayList<String> getWheelCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Mischlen", quantity);
		case 2:
			return fillSellPartsArray("Pirelli", quantity);
		case 3:
			return fillSellPartsArray("Racing special", quantity);
		}

		return new ArrayList<String>();
	}

	protected ArrayList<String> getBodyCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Iron car body", quantity);
		case 2:
			return fillSellPartsArray("Aluminium car body", quantity);
		case 3:
			return fillSellPartsArray("Titanum car body", quantity);
		}
		return new ArrayList<String>();
	}

	protected ArrayList<String> getEngineCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Dog engine", quantity);
		case 2:
			return fillSellPartsArray("Puma engine", quantity);
		case 3:
			return fillSellPartsArray("Gepard engine", quantity);
		}
		return new ArrayList<String>();
	}

	private ArrayList<String> fillSellPartsArray(String parts, int quantity) {
		ArrayList<String> sell = new ArrayList<>();
		sell.add(parts);
		return sell;
	}

}