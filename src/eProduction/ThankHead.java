package eProduction;

import java.util.ArrayList;

/**
 * Класс описывающий башню танка
 * 
 * @author Кожуров Андрей
 * @version 0.7
 */

public final class ThankHead extends WarConstruction {

	private int armour;

	ThankHead() {
	}

	// Armour
	void setArmour(int armour) {
		this.armour = armour;
	}

	int getArmour() {
		return armour;
	}

	// WEGHT
	void setWeght(int settingWeght) {
		weght = settingWeght;
	}

	int getWeght() {
		return weght;
	}

	// NAME
	String getModelType() {
		return modelType;
	}

	// UIDS
	int getFactoryUid() {
		return factoryUid;
	}

	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// SLOTTING
	char getSloting() {
		return sloting;
	}

	void setSloting(char sloting) {
		this.sloting = sloting;
	}

	@Override
	ArrayList<String> getModuleInfo() {
		ArrayList<String> info = new ArrayList<>();
		info.add("Класс : " + modelType);
		info.add("Броня : " + armour);
		info.add("Вес : " + weght);
		return info;
	}

}
