package eProduction;

import java.util.ArrayList;


abstract class WorkerModel {

	/**
	 * Макет рабочей единицы.
	 * 
	 * @author Кожуров Андрей
	 * @version 0.1
	 */
	
	int factoryUid;
	
	protected int age;
	protected String name;
	protected String status;
	protected int civilMechanicExp;
	
	//UIDS
	int getFactoryUid() {
		return factoryUid;
	}
	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}
	
	//Age
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	
	//Name
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	//Status
	String getStatus() {
		return status;
	}
	void setStatus(String status) {
		this.status = status;
	}
	
	//Civil
	int getCivilMechanicExp() {
		return civilMechanicExp;
	}
	void setCivilMechanicExp(int civilMechanicExp) {
		this.civilMechanicExp = civilMechanicExp;
	}	

	abstract public ArrayList<String> getResume(); 
	
}
