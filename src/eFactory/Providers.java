package eFactory;

import java.util.Random;

public class Providers {

	private Random random;

	private ESallers sallers;
	private ThankTechnologyTable ttt;
	private IngeneerTechnologyTable itt;
	
	private int factoryUid;

	public Providers() {
		initProvider();
	}

	private void initProvider() {
		factoryUid = random.nextInt(10000)+100;
		
		sallers = new ESallers();
		sallers.setFactoryUid(factoryUid);
		sallers.setMainProvider(this);
		
		ttt = new ThankTechnologyTable();
		ttt.setFactoryUid(factoryUid);
		
		itt = new IngeneerTechnologyTable();
		itt.setFactoryUid(factoryUid);
		
		sallers.setTtt(ttt);
		sallers.setItt(itt);

	}

	public ESallers getSallers() {
		return sallers;
	}

}
