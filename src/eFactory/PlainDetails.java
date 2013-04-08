package eFactory;

/**
 * Класс описывающий генерацию списков продажи простых запчастей.
 * 
 * @version 0.2
 * @author Андрей Кожуров
 * 
 */


class PlainDetails {

	protected String[] getWheelCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Mischlen", quantity);
		case 2:
			return fillSellPartsArray("Pirelli", quantity);
		case 3:
			return fillSellPartsArray("Racing special", quantity);
		}
		return null;
	}

	protected String[] getBodyCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Iron car body", quantity);
		case 2:
			return fillSellPartsArray("Aluminium car body", quantity);
		case 3:
			return fillSellPartsArray("Titanum car body", quantity);
		}
		return null;
	}

	protected String[] getEngineCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Dog engine", quantity);
		case 2:
			return fillSellPartsArray("Puma engine", quantity);
		case 3:
			return fillSellPartsArray("Gepard engine", quantity);
		}
		return null;
	}

	private String[] fillSellPartsArray(String parts, int quantity) {
		String[] sell = new String[quantity];
		String inParts = parts;

		for (String part : sell) {
			part = inParts.toString();
		}

		return sell;
	}

}