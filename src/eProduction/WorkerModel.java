package eProduction;

/**
 * Макет рабочей единицы.
 * 
 * @author Кожуров Андрей
 * @version 0.2
 */

import java.io.Serializable;
import java.util.ArrayList;

abstract class WorkerModel implements Serializable {

	private static final long serialVersionUID = -6578849685494772342L;

	int factoryUid;
	
	protected int age;
	protected String name;
	protected String status;
	protected int civilMechanicExp;
	protected int cost;
	protected int completeBuilds;

	// UIDS
	int getFactoryUid() {
		return factoryUid;
	}

	void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// Age
	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	// Name
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	// Status
	String getStatus() {
		return status;
	}

	void setStatus(String status) {
		this.status = status;
	}

	// Civil
	int getCivilMechanicExp() {
		return civilMechanicExp;
	}

	void setCivilMechanicExp(int civilMechanicExp) {
		this.civilMechanicExp = civilMechanicExp;
	}
	
	// price
	int getCost() {
		return cost;
	}

	void setCost(int cost) {
		this.cost = cost;
	}

	int getCompleteBuilds() {
		return completeBuilds;
	}
	
	// complete builds
	void setCompleteBuilds(int completeBuilds) {
		this.completeBuilds = completeBuilds;
	}
	
	abstract public ArrayList<String> getResume();

}
