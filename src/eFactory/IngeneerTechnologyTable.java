package eFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class IngeneerTechnologyTable {
	/**
	 * Класс создания инженера.
	 * 
	 * @author Кожуров Андрей
	 * @version 0.1
	 */

	private int factoryUid;
	
	private Random random;
	
	private List <String> names;
	
	public IngeneerTechnologyTable() {
	
		generateName();
		
	}

	// ENGINE TECHNOLOGY
	protected Ingeneer generatePlainIngeneer() {
		Ingeneer newIngeneer = new Ingeneer();
		newIngeneer.setAge(random.nextInt(20)+ 25);
		newIngeneer.setArmyMechanicExp(newIngeneer.getAge()*10);
		newIngeneer.setCivilMechanicExp(newIngeneer.getAge()*12);
		newIngeneer.setFactoryUid(factoryUid);
		newIngeneer.setName(names.get(random.nextInt(names.size())));
		newIngeneer.setStatus("solder");
		
		return newIngeneer;
	}

	//UIDS
	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	private void generateName(){
		names = new ArrayList<>();
		names.add("Andriy");
		names.add("Jury");
		names.add("Valera");
		names.add("Maxim");
		names.add("Igor");
		names.add("Danila");
		names.add("Alex");
		names.add("Ignat");
		names.add("Nikolay");
		names.add("Ivan");
		names.add("Evgen");
		names.add("Artur");
		names.add("Yakiv");
		names.add("Serega");
		names.add("Iluha");
		names.add("Edvard");
		names.add("Alexander");
		names.add("Pavel");
		names.add("Konstantin");
	}
	
	
}
