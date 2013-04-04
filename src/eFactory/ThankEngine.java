package eFactory;

import java.util.ArrayList;

/**
 * <p> Класс описывающий двигатель танка</p>
 * 
 * @param power  
 * @param wegth
 * 
 *@author Кожуров Андрей
 *@version 0.1
 */


public class ThankEngine {

	private int factoryUid;
	private String name;
	private int price;
	
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
	
	//PRICE
	/**
	 * <p>
	 * Позволяет получить значение стоимости танкового мотора
	 * </p>
	 */
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
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
}