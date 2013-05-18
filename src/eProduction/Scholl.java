package eProduction;

import java.util.ArrayList;
import java.util.Random;

import eFactory.ESallers;
import eFactory.Provider;
import eUtils.GlobalConstants;
import eUtils.OnEducationComplete;
import eUtils.OnRegistrIngeneer;

public final class Scholl {

	private Provider provider;

	private Random random;

	private OnRegistrIngeneer registerLisner;
	private OnEducationComplete educationListener;

	private ArrayList<String> names;

	public Scholl(Provider provider) {
		this.provider = provider;
		registerLisner = this.provider;
		random = new Random();
		generateName();
	}

	// ENGINE TECHNOLOGY
	public ArrayList<Engineer> buyIngeneers(int type, int quantity,
			ESallers sallers) {

		if (!sallers.reviewChain(provider)) {
			System.out.println("Нарушена целостность производственной цепочки в школе");
			return null;
		}

		ArrayList<Engineer> outIngeneersList = new ArrayList<>();
		switch (type) {
		case 1:
			for (int i = 0; i < quantity; i++) {
				Engineer newIngeneer = new Engineer(provider);

				newIngeneer.setName(names.get(random.nextInt(names.size())));
				newIngeneer.setAge(random.nextInt(20) + 25);
				newIngeneer
						.setStatus(GlobalConstants.FIRST_LEVEL_INGENEER_NAME);
				newIngeneer.setFactoryUid(provider.getFactoryUid());
				newIngeneer.setCivilMechanicExp(newIngeneer.getAge() * 12);
				newIngeneer.setArmyMechanicExp(newIngeneer.getAge() * 10);

				outIngeneersList.add(newIngeneer);
				registerLisner.register(newIngeneer);
			}
			return outIngeneersList;

		}
		return new ArrayList<>();
	}

	/**
	 * Метод позволяющий переобучить произвольного инженера для сбора техники.
	 * На обучение принимаются инженеры любого происхождения. Найти переобученых
	 * инженеров можно в отделе продаж через поиск готовых специалистов.
	 * 
	 * @param specialists
	 * @param sallers
	 */

	public void startStudeSpecialist(ArrayList<Engineer> specialists,
                                     ESallers sallers) {
		if (specialists == null || specialists.isEmpty()) {
			System.out.println("Некого учить!");
			return;
		}
		if (!sallers.reviewChain(provider)) {
			System.out.println("Нарушена производственная цепочка школы");
			return;
		}
		ArrayList<Engineer> vterans = refactoringEngineer(specialists);
		educationListener = sallers;
		educationListener.educationComplete(vterans, sallers);
	}

	private void generateName() {
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

	private ArrayList<Engineer> refactoringEngineer(
			ArrayList<Engineer> incomeList) {
		ArrayList<Engineer> newInEngineers = new ArrayList<>();
		
		for (Engineer tmpEngineer : incomeList) {
			if (tmpEngineer instanceof Engineer) {
				tmpEngineer.setFactoryUid(provider.getFactoryUid());
				tmpEngineer.setMainProvider(provider);
				tmpEngineer.setCost((int) (((tmpEngineer.getArmyMechanicExp()*0.01) + 
						(tmpEngineer.getCivilMechanicExp()*0.001)) +
						(tmpEngineer.getCompleteBuilds()*10) + 10000));
				
				newInEngineers.add(tmpEngineer);
			}
		}
		return newInEngineers;
	}
}
