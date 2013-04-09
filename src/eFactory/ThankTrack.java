package eFactory;

import java.util.ArrayList;

/**
 * <p> Класс описывающий шасси танка</p>
 *@author Кожуров Андрей
 *@version 0.2
 */


public class ThankTrack {

	private int factoryUid;
	
	private String name;
	private int price;
	private char sloting;
	
	private int weghtUp;
	private int weght;

	
	//WEGHT_UP
	protected void setWeghtUp(int settingWeghtUp) {
		weghtUp = settingWeghtUp;
	}
	
	/**
	 * <p> Позволяет получить значение грузоподъемности танкового трака</p>
	 * Это и есть глобальная грузоподъёмность.
	 */
	public int getWeghtUp() {
		return weghtUp;
	}
	
	// WEGHT
	protected void setWeght(int settingWeght) {
		weght = settingWeght;
	}
	
	/**
	 * <p> Позволяет получить значение веса танкового трака</p>
	 * Важно понимать, что вес гусениц учитывается.
	 */
	public int getWeght() {
		return weght;
	}
	
	// MODULE INFO
	protected ArrayList<String> getInstalliationInfo(){
		ArrayList<String> info = new ArrayList<>();
		info.add("Изготовитель : "+factoryUid);
		info.add("Грузоподъёмность : "+weghtUp);
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
	
	// PRICE
	/**
	 * <p>
	 * Позволяет получить значение стоимости танкового трака
	 * </p>
	 */
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	// NAME
	
	protected void setName(String name) {
		this.name = name;
	}
	
	/**
	 * <p> Позволяет получить название танкового трака</p>
	 */
	public String getName() {
		return name;
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
