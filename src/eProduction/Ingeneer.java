package eProduction;

import java.util.ArrayList;

import eFactory.Provider;
import eUtils.OnMoneyTransfer;



/**
 * Класс инженер - на данный момент основной производственный элемент.
 * Главная задача - получить детали и собрать технику
 * 
 * @author Андрей Кожуров
 * 
 * @version 0.7
 */

public final class Ingeneer extends WorkerModel {

	private Provider mainProviders;
	private OnMoneyTransfer hostBank;
	
	private int completeBuilds;
	private int armyMechanicExp;

	Ingeneer(Provider provider) {
		mainProviders = provider;
		factoryUid = mainProviders.getFactoryUid();
		hostBank = mainProviders;
		completeBuilds = 0;
	}

	/**
	 * Основное умение военного инжинера - собирает танки!
	 * Внимательно ознакомтесь с прайсами, всеми входными параметрами,
	 * всей документацией и подсказками. Используейте только купленных инжинеров,
	 * только купленные, оригинальные запчасти.
	 * 
	 * @param mainBody
	 * @param installingEngine
	 * @param installingHead
	 * @param installingTrak
	 * 
	 * @return mainBody
	 */
	public ThankBody makeNewThank(ThankBody mainBody,
			ThankEngine installingEngine, ThankHead installingHead,
			ThankTrack installingTrak, int price) {
		
		if (mainBody != null &&mainBody.getFactoryUid() == factoryUid
		&& installingEngine !=null && installingEngine.getFactoryUid() == factoryUid
		&& installingHead != null && installingHead.getFactoryUid() == factoryUid
		&& installingTrak != null &&installingTrak.getFactoryUid() == factoryUid
		&& price >= 100) {

			mainBody.setEngine(installingEngine);
			mainBody.setHead(installingHead);
			mainBody.setTrack(installingTrak);

			if (mainBody.showComplexWeghtUp()) {
				armyMechanicExp += price/100 ;
				addServiceMoney(price);
				completeBuilds++;
				return mainBody;
			} else {
				System.out.println("Ошибочная конфигурация техники!!");
				return null;
			}

		} else {
			System.out.println("Пользуйтесь оригинальным магазином! Читайте инструкции!");
			return null;
		}
	}

	//AGE
	int getAge() {
		return age;
	}
	
	void setAge(int age) {
		this.age = age;
	}
	
	//Army exp
	int getArmyMechanicExp() {
		return armyMechanicExp;
	}

	void setArmyMechanicExp(int armyMechanicExp) {
		this.armyMechanicExp = armyMechanicExp;
	}
	// Civil exp
	int getCivilMechanicExp() {
		return civilMechanicExp;
	}

	void setCivilMechanicExp(int civilMechanicExp) {
		this.civilMechanicExp = civilMechanicExp;
	}

	// NAME
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	//STATUS
	String getStatus() {
		return status;
	}

	void setStatus(String status) {
		this.status = status;
	}

	// MONEY TRANSFER BLOCK
	private void addServiceMoney(int incomeMoney){
		if (hostBank == null){
			System.out.println("Не могу связаться с базой!");
		}else{
			hostBank.moneyTransact(incomeMoney);
		}
	}
	
	public void showDetails(ThankBody tb){
		for (String th : tb.getModuleInfo()){
			System.out.println(th);
		}
		
	}

	@Override
	public ArrayList<String> getResume() {
		ArrayList<String> resumeList = new ArrayList<>();
		resumeList.add("Имя : "+name);
		resumeList.add("Статус : "+status);
		resumeList.add(String.valueOf("Имя : "+age));
		resumeList.add(String.valueOf("Гражданский опыт : "+civilMechanicExp));
		resumeList.add(String.valueOf("Военный опыт : "+armyMechanicExp));
		resumeList.add(String.valueOf("Успешные сборки : "+completeBuilds));
		
		return resumeList;
		
	}
}
