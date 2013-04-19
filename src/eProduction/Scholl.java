package eProduction;

import java.util.ArrayList;
import java.util.Random;

import javax.net.ssl.HostnameVerifier;

import eFactory.ESallers;
import eFactory.Provider;
import eUtils.GlobalConstants;

public final class Scholl {

	private Provider provider;
	
	private Random random;
	
	public Scholl(Provider provider) {
		this.provider = provider;
		random = new Random();
	}
	
	
	// ENGINE TECHNOLOGY
		public ArrayList<Ingeneer> buyIngeneers(int type, int quantity,
				ESallers sallers) {

			if (!sallers.reviewChain(provider)) {
				System.out.println("Нарушена целостность производственной цепочки");
				return null;
			}

			ArrayList<Ingeneer> outIngeneersList = new ArrayList<>();
			switch (type) {
			case 1:
				for (int i = 0; i < quantity; i++) {
					Ingeneer newIngeneer = new Ingeneer(provider);
					
					newIngeneer.setName("Vova");
					newIngeneer.setAge(random.nextInt(25)+25);
					newIngeneer.setStatus(GlobalConstants.FIRST_LEVEL_INGENEER_NAME);
					newIngeneer.setFactoryUid(provider.getFactoryUid());
					newIngeneer.setCivilMechanicExp(100);
					newIngeneer.setArmyMechanicExp(1000);
					
					outIngeneersList.add(newIngeneer);
				}
				return outIngeneersList;
			
			}
			return new ArrayList<>();
		}
	
}
