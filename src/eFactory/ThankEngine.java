package eFactory;

import java.util.ArrayList;

/**
 * <p> Класс описывающий двигатель танка</p>
 * 
 * @param power  
 * @param wegth
 * 
 *@author Кожуров Андрей
 *@version 0.3
 */


public class ThankEngine {

	private int factoryUid;
	
	private String name;
	private char sloting;
	
	private int power;
	private int weght;
	
	protected void setPower(int settingPower) {
		power = settingPower;
	}
	
	/**
	 * <p> Позволяет получить значение мощности танкового двигателя</p>
	 * 
	 */
	public int getPower() {
		return power;
	}
	
	protected void setWeght(int settingWeght) {
		weght = settingWeght;
	}
	
	/**
	 * <p> Позволяет получить значение веса танкового двигателя</p>
	 * Параметр понадобится при подборе гусениц.
	 */
	public int getWeght() {
		return weght;
	}

	protected ArrayList<String> getInstalliationInfo(){
		ArrayList<String> info = new ArrayList<>();
		info.add("Изготовитель : "+factoryUid);
		info.add("Мощность : "+power);
		info.add("Вес : "+weght);
	return info;
	}
	
	// UIDS
	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}
	
	//NAME
	/**
	 * <p> Позволяет получить название танкового двигателя</p> 
	 */
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	//SLOTTING
	/**
	 * Возвращает тип слота
	 * 
	 * @return char
	 */
	
	public char getSloting() {
		return sloting;
	}

	protected void setSloting(char sloting) {
		this.sloting = sloting;
	}
}
