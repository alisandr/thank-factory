package eFactory;


/**
 * Главный класс проекта.
 * Данный проект есть учебно тренеровочный.
 * 
 * Суть сводится к следующему:
 * Необходимо создать экземпляр данного класса, получить от него отдел продаж.
 * Далее - по ситуации:
 * 
 * 1) Покупать детали к машинам со строковыми значениями.
 * 
 * 2) Попробовать собрать военную машину.
 * 
 * Для этого необходимо:
 * 1) Купить в отделе продаж все нужны чести для техники.
 * 2) Купить в отделе продаж инженера.
 * 3) Передать все части инженеру, вместе с небольшим вознаграждением
 * 
 * После чего, вы получите экземпляр класса боевой техники.
 * 
 * 
 * Внимание, инженер не сможет собрать гражданские виды техники.
 * 
 * @version 0.3
 * 
 * @author Андрей Кожуров
 */

import java.util.Random;

import eTechnology.IngeneerTechnologyTable;
import eTechnology.ThankTechnologyTable;

public final class Provider {

	private Random random;

	private ESallers sallers;
	private ThankTechnologyTable ttt;
	private IngeneerTechnologyTable itt;
	
	private int factoryUid;
	
	private long productionMoney;
	private long serviceMoney;
	private long penaltyMoney;
	
	public Provider() {
		initProvider();
	}

	private void initProvider() {
		random = new Random();
		factoryUid = random.nextInt(10000)+100;
		
		sallers = new ESallers();
		sallers.setFactoryUid(factoryUid);
		sallers.setMainProvider(this);
		
		ttt = new ThankTechnologyTable(this);
		//itt = new IngeneerTechnologyTable(this);
		
		sallers.setTtt(ttt);
		sallers.setItt(itt);

	}

	public ESallers getSallers() {
		return sallers;
	}

	/**
	 * Колечество денег полученных на продаже оборудования.
	 * 
	 * @return money (long)
	 */
	
	//PRODUCTION MONEY
	public long getProductionMoney() {
		return productionMoney;
	}

	void addProductionMoney(long money) {
		this.productionMoney += money;
	}
	
	/**
	 * Колечество денег полученных от услуг инженеров.
	 * 
	 * @return money (long)
	 */
	
	//SERVICE MONEY
	public long getServiceMoney() {
		return serviceMoney;
	}

	void addServiceMoney(long serviceMoney) {
		this.serviceMoney += serviceMoney;
	}
	
	/**
	 * Колечество денег полученных на штрафах и неустойках.
	 * 
	 * @return money (long)
	 */
	
	//PENALTY MONEY
	public long getPenaltyMoney() {
		return penaltyMoney;
	}

	void addPenaltyMoney(long penaltyMoney) {
		this.penaltyMoney += penaltyMoney;
	}

	
	/**
	 * Идентификатор фабрики.
	 * 
	 * @return UID (int)
	 */
	//UIDS
	public int getFactoreUid(){
		return factoryUid;
	}
}