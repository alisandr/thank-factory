package eProduction;

/**
 * Танковый макет.
 * 
 * @author Кожуров Андрей
 * @version 0.1
 */

import java.util.ArrayList;

abstract class WarConstruction {

	int factoryUid;
	protected String modelType;
	
	protected int weght;
	protected char sloting;
	
	//Factory uid
	int getFactoryUid() {
		return factoryUid;
	}
	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}
	
	//Model type
	String getModelType() {
		return modelType;
	}
	void setModelType(String modelType) {
		this.modelType = modelType;
	}
	
	//Weght
	int getWeght() {
		return weght;
	}
	void setWeght(int weght) {
		this.weght = weght;
	}
	
	// Sloting
	char getSloting() {
		return sloting;
	}
	void setSloting(char sloting) {
		this.sloting = sloting;
	}
	
	//Astract section
	abstract ArrayList<String> getModuleInfo();
	
}
