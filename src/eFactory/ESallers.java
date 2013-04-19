package eFactory;

/**
 * Класс отдела продаж
 * Заказать можно как запчасти для простых машин, так и для военной техники.
 * Есть возможность посмотреть прайсы кодов
 * 
 *  Через данный класс осуществляется продажа инженеров.
 *  
 *  @author Кожуров Андрей
 *  @version 0.7
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import eProduction.Conveyor;
import eProduction.Ingeneer;
import eProduction.Scholl;
import eProduction.ThankEngine;
import eProduction.ThankHead;
import eProduction.ThankBody;
import eProduction.ThankTrack;
import eUtils.GlobalConstants;

public final class ESallers {

	private Provider mainProvider;
	private Conveyor conveyor;
	private Scholl scholl;

	private int factoryUid;

	private HashMap<Integer, Integer> moneyPlainDetailTable;
	private HashMap<Integer, String> priceCode;

	ESallers(Provider hostProvider) {

		mainProvider = hostProvider;
		factoryUid = mainProvider.getFactoryUid();

		conveyor = new Conveyor(hostProvider);
		scholl = new Scholl(hostProvider);

		createPriceCode();
		generateCodetablePlain();
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

		if (type <= 3 && isAllMoney(money, type * 1, quantity)) {
			addProductionMoney(money);
			return conveyor.buyWheelCivirPart(quantity, type, this);

		} else {
			addPenaltyMoney(money);
			System.out.println("Ошибка. Изучайте прайс");
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

		if (type <= 3 && isAllMoney(money, type * 2, quantity)) {
			addProductionMoney(money);
			return conveyor.buyBodyCivirPart(quantity, type, this);

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

		if (type <= 3 && isAllMoney(money, type * 3, quantity)) {
			addProductionMoney(money);
			return conveyor.buyEngineCivirPart(quantity, type, this);

		} else {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<String>();
		}
	}

	/**
	 * Позволяет осуществить покупку танкового модуля "Двигатель"
	 * 
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * 
	 * @return ArrayList<ThankEngine> -- получаемый модуль.
	 */
	public ArrayList<ThankEngine> buyThankEngine(int money, int typeNumber,
			int quantity) {
		switch (typeNumber) {
		case 1:
			if (!isMoneyTrue(GlobalConstants.FIRST_ENGINE, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 2:
			if (!isMoneyTrue(GlobalConstants.SECOND_ENGINE, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 3:
			if (!isMoneyTrue(GlobalConstants.THIRD_ENGINE, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 4:
			if (!isMoneyTrue(GlobalConstants.FOURTH_ENGINE, money, quantity)) {
				return new ArrayList<>();
			}
			break;

		}

		ArrayList<ThankEngine> sellEngineList = conveyor.buyThankEngine(
				typeNumber, quantity, this);
		
		addProductionMoney(money);
		return sellEngineList;
	}

	/**
	 * Позволяет осуществить покупку танкового модуля "Траки"
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

		switch (typeNumber) {
		case 1:
			if (!isMoneyTrue(GlobalConstants.FIRST_TRACK, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 2:
			if (!isMoneyTrue(GlobalConstants.SECOND_TRACK, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 3:
			if (!isMoneyTrue(GlobalConstants.THIRD_TRACK, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 4:
			if (!isMoneyTrue(GlobalConstants.FOURTH_TRACK, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		}

		ArrayList<ThankTrack> sellTrackList = conveyor.buyThankTrack(
				typeNumber, quantity, this);

		addProductionMoney(money);
		return sellTrackList;
	}

	/**
	 * Позволяет осуществить покупку танкового модуля "Башня"
	 * 
	 * @param money
	 *            -- вносима при покупке сумма;
	 * @param typeNumber
	 *            -- код неободимого товара;
	 * 
	 * @param quanrity
	 *            -- количество заказываемого товара.
	 * @return ArrayList <ThankHead> -- получаемый модуль.
	 */
	public ArrayList<ThankHead> buyThankHead(int money, int typeNumber,
			int quantity) {

		switch (typeNumber) {
		case 1:
			if (!isMoneyTrue(GlobalConstants.FIRST_HEAD, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 2:
			if (!isMoneyTrue(GlobalConstants.SECOND_HEAD, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 3:
			if (!isMoneyTrue(GlobalConstants.THIRD_HEAD, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 4:
			if (!isMoneyTrue(GlobalConstants.FOURTH_HEAD, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		}

		ArrayList<ThankHead> sellHeadList = conveyor.buyThankHead(typeNumber,
				quantity, this);

		addProductionMoney(money);
		return sellHeadList;
	}

	/**
	 * Позволяет осуществить покупку танкового модуля "Корпус танка"
	 * 
	 * Данный класс является базовым гласом для сборки танка, в данный модуль
	 * осуществляется установка всех остальных модулей.
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
	public ArrayList<ThankBody> buyThankMashine(int money, int typeNumber,
			int quantity) {

		switch (typeNumber) {
		case 1:
			if (!isMoneyTrue(GlobalConstants.FIRST_BODY, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 2:
			if (!isMoneyTrue(GlobalConstants.SECOND_BODY, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 3:
			if (!isMoneyTrue(GlobalConstants.THIRD_BODY, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		case 4:
			if (!isMoneyTrue(GlobalConstants.FOURTH_BODY, money, quantity)) {
				return new ArrayList<>();
			}
			break;
		}

		ArrayList<ThankBody> sellMashineList = conveyor.buyThankBody(typeNumber, quantity, this);

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

		if (GlobalConstants.FIRST_INGENEER * quantity > money) {
			addPenaltyMoney(money);
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return new ArrayList<Ingeneer>();
		}

		ArrayList<Ingeneer> sellIngeneerList = scholl.buyIngeneers(1, quantity, this);

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
	private void generateCodetablePlain() {
		moneyPlainDetailTable = new HashMap<>();

		moneyPlainDetailTable.put(1, 3);
		moneyPlainDetailTable.put(2, 10);
		moneyPlainDetailTable.put(3, 20);

		moneyPlainDetailTable.put(4, 15);
		moneyPlainDetailTable.put(5, 50);
		moneyPlainDetailTable.put(6, 7);

		moneyPlainDetailTable.put(7, 12);
		moneyPlainDetailTable.put(8, 16);
		moneyPlainDetailTable.put(9, 20);
	}

	// Money review plain details

	private boolean isAllMoney(int money, int type, int quantity) {

		if ((moneyPlainDetailTable.get(type) * quantity) <= money) {
			return true;
		} else {
			return false;
		}
	}

	// Money review thank details
	private boolean isMoneyTrue(int typePrice, int money, int quantity) {
		if (typePrice * quantity > money) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			addPenaltyMoney(money);
			return false;
		} else {
			return true;
		}
	}

	public boolean reviewChain(Provider provider) {
		if (provider.getFactoryUid() == factoryUid) {
			return true;
		} else {
			return false;
		}
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
	public List<String> getPlainDetailPrice() {

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
	public ArrayList<String> getArmyPrice() {

		ArrayList<String> price = new ArrayList<String>();

		StringBuilder builder = new StringBuilder();
		price.add(priceBuilderHelper(builder,
				GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME, "Башня",
				GlobalConstants.FIRST_HEAD));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME, "Башня",
				GlobalConstants.SECOND_HEAD));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME, "Башня",
				GlobalConstants.THIRD_HEAD));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME, "Башня",
				GlobalConstants.FOURTH_HEAD));

		price.add(priceBuilderHelper(builder,
				GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME, "Мотор",
				GlobalConstants.FIRST_ENGINE));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME, "Мотор",
				GlobalConstants.SECOND_ENGINE));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME, "Мотор",
				GlobalConstants.THIRD_ENGINE));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME, "Мотор",
				GlobalConstants.FOURTH_ENGINE));

		price.add(priceBuilderHelper(builder,
				GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME, "Траки",
				GlobalConstants.FIRST_TRACK));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME, "Траки",
				GlobalConstants.SECOND_TRACK));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME, "Траки",
				GlobalConstants.THIRD_TRACK));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME, "Траки",
				GlobalConstants.FOURTH_TRACK));

		price.add(priceBuilderHelper(builder,
				GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME, "Корпус",
				GlobalConstants.FIRST_BODY));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME, "Корпус",
				GlobalConstants.SECOND_BODY));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME, "Корпус",
				GlobalConstants.THIRD_BODY));
		price.add(priceBuilderHelper(builder,
				GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME, "Корпус",
				GlobalConstants.FOURTH_BODY));

		price.add(priceBuilderHelper(builder,
				GlobalConstants.FIRST_LEVEL_INGENEER_NAME, "Инженер",
				GlobalConstants.FIRST_INGENEER));

		return price;
	}

	private String priceBuilderHelper(StringBuilder builder, String type,
			String name, int price) {
		builder.setLength(0);

		builder.append(name).append(" : ").append(type).append(" ").append(price)
				.append(" $");
		return builder.toString();
	}

}
