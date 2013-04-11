package eFactory;

/**
 * Класс отдела продаж
 * Заказать можно как запчасти для простых машин, так и для военной техники.
 * Есть возможность посмотреть прайсы кодов
 * 
 *  Через данный класс осуществляется продажа инженеров.
 *  
 *  @author Кожуров Андрей
 *  @version 0.5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ESallers {

	private ThankTechnologyTable ttt;
	private IngeneerTechnologyTable itt;
	private Providers mainProvider;

	private int factoryUid;

	private HashMap<Integer, Integer> codeTable;
	private HashMap<Integer, String> priceCode;

	ESallers() {
		factoryUid = 98;
		createPriceCode();
		generateCodetable();
	}

	/**
	 * Метод продажи колёс к машинам.
	 * 
	 * @param type
	 *            - код товара
	 * @param quantity
	 *            - количество товара
	 * 
	 * @return ArrayList<String>
	 * 
	 */
	public ArrayList<String> buyPlainWheel(int money, int type, int quantity) {
		PlainDetails pd = new PlainDetails();

		if (type <= 3 && isAllMoney(money, type * 1, quantity)) {
			addProductionMoney(money);
			return pd.getWheelCivirPart(quantity, type);

		} else {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<String>();
		}
	}

	/**
	 * Метод продажи корпусов к машинам.
	 * 
	 * @param type
	 *            - код товара
	 * @param quantity
	 *            - количество товара
	 * 
	 * @return ArrayList<String>
	 * 
	 */
	public ArrayList<String> buyPlainBody(int money, int type, int quantity) {
		PlainDetails pd = new PlainDetails();

		if (type <=3 &&isAllMoney(money, type * 2, quantity)) {
			addProductionMoney(money);
			return pd.getBodyCivirPart(quantity, type);

		} else {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<String>();
		}
	}
	
	/**
	 * Метод продажи Моторов к машинам.
	 * 
	 * @param type
	 *            - код товара
	 * @param quantity
	 *            - количество товара
	 * 
	 * @return ArrayList<String>
	 * 
	 */

	public ArrayList<String> buyPlainEngine(int money, int type, int quantity) {
		PlainDetails pd = new PlainDetails();

		if (type <= 3 && isAllMoney(money, type * 3, quantity)) {
			addProductionMoney(money);
			return pd.getEngineCivirPart(quantity,type);

		} else {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<String>();
		}
	}

	/**
	 * <p>
	 * Позволяет осуществить покупку танкового модуля "Двигатель"
	 * </p>
	 * Перед покупкой необходимо ознакомиться со списком продаваемой продукции,
	 * ценами и технологией.
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * 
	 * @return ArrayList c ThankEngine -- получаемый модуль.
	 */
	public ArrayList<ThankEngine> buyThankEngine(int money, int typeNumber,
			int quantity) {

		ArrayList<ThankEngine> sellEngineList = new ArrayList<>();
		int type = typeNumber;

		for (int i = quantity; i >= 0; i--) {
			ThankEngine thankEngineForSale = new ThankEngine();
			ttt.setEngineParams(type, thankEngineForSale);
			sellEngineList.add(thankEngineForSale);
		}
		if (sellEngineList.get(0).getPrice() * quantity < money) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			addPenaltyMoney(money);
			new ArrayList<ThankEngine>();
		}

		addProductionMoney(money);
		return sellEngineList;
	}

	/**
	 * <p>
	 * Позволяет осуществить покупку танкового модуля "Траки"
	 * </p>
	 * Перед покупкой необходимо ознакомиться со списком продаваемой продукции,
	 * ценами и технологией.
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * 
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * @return ArrayList c ThankTrack -- получаемый модуль.
	 */
	public ArrayList<ThankTrack> buyThankTrack(int money, int typeNumber,
			int quantity) {

		ArrayList<ThankTrack> sellTrackList = new ArrayList<>();
		int type = typeNumber;

		for (int i = type; i > 0; i--) {
			ThankTrack thankThrackForSale = new ThankTrack();
			ttt.setTrackParams(type, thankThrackForSale);
			sellTrackList.add(thankThrackForSale);
		}

		if (sellTrackList.get(0).getPrice() * quantity < money) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			addPenaltyMoney(money);
			return new ArrayList<ThankTrack>();
		}

		addProductionMoney(money);
		return sellTrackList;
	}

	/**
	 * <p>
	 * Позволяет осуществить покупку танкового модуля "Башня"
	 * </p>
	 * Перед покупкой необходимо ознакомиться со списком продаваемой продукции,
	 * ценами и технологией.
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * 
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * @return ArrayList c ThankHead -- получаемый модуль.
	 */
	public ArrayList<ThankHead> buyThankHead(int money, int typeNumber,
			int quantity) {

		ArrayList<ThankHead> sellHeadList = new ArrayList<>();
		int type = typeNumber;

		for (int i = quantity; i > 0; i--) {
			ThankHead thankHeadForSale = new ThankHead();
			ttt.setHeadParams(type, thankHeadForSale);
			sellHeadList.add(thankHeadForSale);
		}
		if (sellHeadList.get(0).getPrice() * quantity < money) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			addPenaltyMoney(money);
			return new ArrayList<ThankHead>();
		}

		addProductionMoney(money);
		return sellHeadList;
	}

	/**
	 * <p>
	 * Позволяет осуществить покупку танкового модуля "Корпус танка"
	 * </p>
	 * Перед покупкой необходимо ознакомиться со списком продаваемой продукции,
	 * ценами и технологией.
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * 
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * @return ArrayList c ThankMashine -- получаемый модуль.
	 */
	public ArrayList<ThankMaschine> buyThankMashine(int money, int typeNumber,
			int quantity) {

		ArrayList<ThankMaschine> sellMashineList = new ArrayList<>();
		int type = typeNumber;

		for (int i = quantity; i > 0; i--) {
			ThankMaschine thankMashineForSale = new ThankMaschine();
			ttt.setBodyParams(type, thankMashineForSale);
			sellMashineList.add(thankMashineForSale);
		}
		if (sellMashineList.get(0).getPrice() * quantity < money) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			addPenaltyMoney(money);
			return new ArrayList<ThankMaschine>();
		}

		addProductionMoney(money);
		return sellMashineList;
	}

	/**
	 * Позволяет осуществить покупку Инженера.
	 * 
	 * Данный класс является ключевым звеном во всех технологии изготовления
	 * армейского оборудования
	 * 
	 * @param money
	 *            - стоимость покупки
	 * @param quantity
	 *            - количество заказываемого товара.
	 * 
	 * @return Ingeneer
	 * 
	 */
	public ArrayList<Ingeneer> byIgeIngeneer(int money, int quantity) {

		ArrayList<Ingeneer> sellIngeneerList = new ArrayList<>();

		for (int i = quantity; i > 0; i--) {

			Ingeneer newIngeneer = new Ingeneer();
			itt.generatePlainIngeneer(newIngeneer);

			sellIngeneerList.add(newIngeneer);
		}

		if (sellIngeneerList.get(0).getPrice() * quantity < money) {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<Ingeneer>();
		}
		addProductionMoney(money);
		return sellIngeneerList;
	}

	// Generate equalsTable with part name and internal code
	private void createPriceCode() {
		priceCode = new HashMap<>();

		priceCode.put(1, "Корпус Мышонок");
		priceCode.put(2, "Башня Мышонок");
		priceCode.put(3, "Мотор Мышонок");
		priceCode.put(4, "Траки Мышонок");
		priceCode.put(5, "Солдат-инженер");
	}

	// Generate internal use code equals price - plain details
	private void generateCodetable() {
		codeTable = new HashMap<>();
		codeTable.put(1, 3);
		codeTable.put(2, 10);
		codeTable.put(3, 20);
		codeTable.put(4, 15);
		codeTable.put(6, 50);
		codeTable.put(7, 7);
		codeTable.put(8, 12);
		codeTable.put(9, 19);
	}

	// Money review

	private boolean isAllMoney(int money, int type, int quantity) {

		if ((codeTable.get(type) * quantity) <= money) {
			return true;
		} else {
			return false;
		}
	}

	// UIDS
	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// TECHNOLOGY
	protected void setTtt(ThankTechnologyTable ttt) {
		this.ttt = ttt;
	}

	// MAIN PROVIDER
	protected void setMainProvider(Providers mainProvider) {
		this.mainProvider = mainProvider;
	}

	// INGENEER TRAINER
	protected void setItt(IngeneerTechnologyTable itt) {
		this.itt = itt;
	}

	// MONEY TRANSFER SECTION

	private void addProductionMoney(int incomeMoney) {
		if (mainProvider != null) {
			mainProvider.addProductionMoney(incomeMoney);
		}
	}

	private void addPenaltyMoney(int incomeMoney) {
		if (mainProvider != null) {
			mainProvider.addPenaltyMoney(incomeMoney);
		}
	}

	/**
	 * Прайс простых запчастей
	 * 
	 * @return
	 */
	public List<String> getFullPrice() {

		ArrayList<String> price = new ArrayList<String>();

		price.add("Купить колесо \"Гудиер\" - 3");
		price.add("Купить колесо \"Пирелли\" - 10");
		price.add("Купить колесо \"Мишлен\"  - 20");

		price.add("Купить корпус \"Бегун\" - 15");
		price.add("Купить корпус \"Силач\" - 20");
		price.add("Купить корпус \"Чемпион\" - 50");

		price.add("Купить двигатель \"Собака\" - 7");
		price.add("Купить двигатель \"Пума\" - 12");
		price.add("Купить двигатель \"Гепард\" - 19");

		return price;
	}

	/**
	 * Прайс военный запчастей
	 * 
	 * @return
	 */
	public List<String> getArmyPrice() {

		ArrayList<String> price = new ArrayList<String>();

		StringBuilder builder = new StringBuilder();
		builder.append("Башня ")
				.append(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME)
				.append(" : ").append(GlobalConstants.FIRST_HEAD);
		price.add(builder.toString());
		builder.setLength(0);

		builder.append("Мотор ")
				.append(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME)
				.append(" : ").append(GlobalConstants.FIRST_ENGINE);
		price.add(builder.toString());
		builder.setLength(0);

		builder.append("Траки ")
				.append(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME)
				.append(" : ").append(GlobalConstants.FIRST_TRACK);
		price.add(builder.toString());
		builder.setLength(0);

		builder.append("Корпус ")
				.append(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME)
				.append(" : ").append(GlobalConstants.FIRST_BODY);
		price.add(builder.toString());
		builder.setLength(0);

		builder.append("Инженер ")
				.append(GlobalConstants.FIRST_LEVEL_INGENEER_NAME)
				.append(" : ").append(GlobalConstants.FIRST_INGENEER);
		price.add(builder.toString());
		builder.setLength(0);

		return price;
	}

}
