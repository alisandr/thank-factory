package eFactory;

/**
 * Класс отдела продаж
 * Заказать можно как запчасти для простых машин, так и для военной техники.
 * Есть возможность посмотреть прайсы кодов
 * 
 *  Через данный класс осуществляется продажа инженеров.
 *  
 *  @author Кожуров Андрей
 *  @version 0.1
 */ 
 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ESallers {

	private ThankTechnologyTable ttt;
	private IngeneerTechnologyTable itt;
	private Providers mainProvider;

	private PlainDetails plainDetais;
	private int factoryUid;

	private HashMap<Integer, String> priceCode;
	
	
	ESallers() {
		factoryUid = 98;
		plainDetais = new PlainDetails();
		createPriceCode();
	}

	/**
	 * Метод позволяет получить полный прайс-лист с кодами военных товаров.
	 * 
	 */
	public HashMap<Integer, String> getArmyPrice() {
		return priceCode;
	}

	/**
	 * Метод продажи простых запчастей к машинам
	 * 
	 * @param type
	 * @param quantity
	 * @return
	 */
	public ArrayList<HashMap<Integer, String>> byPlainDitails(int type,
			int quantity) {
		ArrayList<HashMap<Integer, String>> plainDetailsProduction = new ArrayList<>();
		for (int i = 0; i < quantity; i++) {
			plainDetailsProduction.add(plainDetais.getPlainDetailSet(type));
		}

		return plainDetailsProduction;
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
	 * @return ThankEngine -- получаемый модуль.
	 */
	public ThankEngine buyThankEngine(int money, int typeNumber) {
		ThankEngine thankEngineForSale = new ThankEngine();
		ttt.setEngineParams(1, thankEngineForSale);

		if (money < thankEngineForSale.getPrice()) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return null;
		}
		
		addProductionMoney(money);
		return thankEngineForSale;
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
	 * @return ThankTrack -- получаемый модуль.
	 */
	public ThankTrack buyThankTrack(int money, int typeNumber) {
		ThankTrack thankThrackForSale = new ThankTrack();
		ttt.setTrackParams(1, thankThrackForSale);
		if (money < thankThrackForSale.getPrice()) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return null;
		}
		
		addProductionMoney(money);
		return thankThrackForSale;
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
	 * @return ThankHead -- получаемый модуль.
	 */
	public ThankHead buyThankHead(int money, int typeNumber) {
		ThankHead thankHeadForSale = new ThankHead();
		ttt.setHeadParams(1, thankHeadForSale);

		if (money < thankHeadForSale.getPrice()) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return null;
		}
		
		addProductionMoney(money);
		return thankHeadForSale;
	}
	
	
	/**
	 * Позволяет осуществить покупку Инженера.
	 * 
	 * Данный класс является ключевым звеном во всех технологии изготовления армейского оборудования
	 * 
	 * @param money - стоимость покупки
	 * 
	 * @return Ingeneer
	 */
	public Ingeneer byIgeIngeneer(int money){
		
		Ingeneer newIngeneer = new Ingeneer();
		itt.generatePlainIngeneer(newIngeneer);
		
		if (money < newIngeneer.getPrice()) {
			System.out.println("Недостаточное финансирование. Изучайте прайс");
			return null;
		}
		addProductionMoney(money);
		return newIngeneer;
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
	
	//MAIN PROVIDER
	protected void setMainProvider(Providers mainProvider) {
		this.mainProvider = mainProvider;
	}
	
	//INGENEER TRAINER
	protected void setItt(IngeneerTechnologyTable itt) {
		this.itt = itt;
	}
	
	// MONEY TRANSFER SECTION
	
	private void addProductionMoney(int incomeMoney){
		if (mainProvider != null){
			mainProvider.addProductionMoney(incomeMoney);
		}
	}
/**
 * Прайс простых запчастей
 * 	
 * @return
 */
	public List<String> getFullPrice(){
		
		ArrayList<String>price = new ArrayList<String>();
		price.add("Купить военный чертёж - 11.000");
		price.add("Купить гражданский чертёж - 7.000");
		
		price.add("Купить колесо \"мишлен\" - 100");
		price.add("Купить колесо \"пирелли\" - 200");
		price.add("Купить гоночное колесо - 500");
		
		price.add("Купить железный корпус - 1000");
		price.add("Купить алюминиевый корпус - 2000");
		price.add("Купить корпус из специальных сплавов - 1000");
		
		price.add("Купить двигатель \"Собака\" - 700");
		price.add("Купить двигатель \"Пума\" - 800");
		price.add("Купить двигатель \"Гепард\" - 1300");

		return price;
	}
}
