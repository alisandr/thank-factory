package eFactory;

import java.util.ArrayList;

/**
 * <p>
 * Класс описывающий башню танка
 * </p>
 * 
 * @author Кожуров Андрей
 * @version 0.2
 */

public class ThankHead {

	private int factoryUid;
	
	private String name;
	private int price;
	private char sloting;
	
	private int armour;
	private int weght;
	
	// Armour
	protected void setArmour(int armour) {
		this.armour = armour;
	}

	/**
	 * <p>
	 * Позволяет получить значение брони танковой башни
	 * </p>
	 * 
	 */
	public int getArmour() {
		return armour;
	}

	// WEGHT
	protected void setWeght(int settingWeght) {
		weght = settingWeght;
	}

	/**
	 * <p>
	 * Позволяет получить значение веса танковой башни
	 * </p>
	 */
	public int getWeght() {
		return weght;
	}

	// GET INFO
	protected ArrayList<String> getInstalliationInfo() {
		ArrayList<String> info = new ArrayList<>();
		info.add("Изготовитель : " + factoryUid);
		info.add("Броня : " + armour);
		info.add("Вес : " + weght);
		return info;
	}

	// NAME
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * <p>
	 * Позволяет получить название танковой башни
	 * </p>
	 * 
	 */

	public String getName() {
		return name;
	}

	// UIDS
	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// PRICE
	/**
	 * <p>
	 * Позволяет получить значение стоимости танковой башни
	 * </p>
	 */
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
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
