package eProduction;

import java.util.ArrayList;

/**
 * Класс описывающий шасси танка
 * 
 * @author Кожуров Андрей
 * @version 0.7
 */

public final class ThankTrack extends WarConstruction {

	private int weghtUp;

	public ThankTrack() {
	}

	// WEGHT_UP
	void setWeghtUp(int settingWeghtUp) {
		weghtUp = settingWeghtUp;
	}

	int getWeghtUp() {
		return weghtUp;
	}

	// WEGHT
	void setWeght(int settingWeght) {
		weght = settingWeght;
	}

	int getWeght() {
		return weght;
	}

	// UIDS
	int getFactoryUid() {
		return factoryUid;
	}

	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// NAME
	String getModelType() {
		return modelType;
	}

	void setModelType(String modelType) {
		this.modelType = modelType;
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
		info.add("Грузоподъёмность : " + weghtUp);
		info.add("Вес : " + weght);
		return info;
	}
}
