package eProduction;

import java.util.ArrayList;

/**
 * Класс описывающий двигатель танка
 * 
 * 
 * @param power
 * @param wegth
 * 
 * @author Кожуров Андрей
 * @version 0.7
 */

public final class ThankEngine extends WarConstruction {

	private int power;

	ThankEngine() {
	}

	// Power
	int getPower() {
		return power;
	}

	void setPower(int settingPower) {
		power = settingPower;
	}

	// Weght
	int getWeght() {
		return weght;
	}

	void setWeght(int settingWeght) {
		weght = settingWeght;
	}

	// NAME
	String getModelType() {
		return modelType;
	}

	void setModelType(String name) {
		this.modelType = name;
	}

	// SLOTTING
	char getSloting() {
		return sloting;
	}

	void setSloting(char sloting) {
		this.sloting = sloting;
	}

	// UIDS
	int getFactoryUid() {
		return factoryUid;
	}

	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	@Override
	ArrayList<String> getModuleInfo() {
		ArrayList<String> info = new ArrayList<>();
		info.add("Класс : " + modelType);
		info.add("Мощность : " + power);
		info.add("Вес : " + weght);

		return info;
	}
}
