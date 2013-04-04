package eFactory;

public final class Ingeneer {

	private int factoryUid;
	private Providers mainProviders;

	private int age;
	private int armyMechanicExp;
	private int civilMechanicExp;
	private String name;
	private String status;
	private int price;

	public Ingeneer() {
		factoryUid = 99;
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
	public ThankMaschine makeNewThank(ThankMaschine mainBody,
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
				armyMechanicExp += 100;
				addServiceMoney(price);
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

	// UIDS
	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}

	// AGE
	/**
	 * Позволяет получть параметр "Возраст".
	 * 
	 * @return String
	 */
	public int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	/**
	 * Позволяет получть значение параметра "Армейский опыт".
	 * Данный параметр необходим для сборки сложной армейской
	 * техники и работы в армейских цехах.
	 * 
	 * @return int
	 */
	public int getArmyMechanicExp() {
		return armyMechanicExp;
	}

	protected void setArmyMechanicExp(int armyMechanicExp) {
		this.armyMechanicExp = armyMechanicExp;
	}

	/**
	 * Позволяет получть значение параметра "Гражданский опыт".
	 * Данный параметр необходим для сборки сложной гражданской техники,
	 * работы в супер-цехах и проведения ремонтный работ
	 * 
	 * @return int
	 */
	public int getCivilMechanicExp() {
		return civilMechanicExp;
	}

	protected void setCivilMechanicExp(int civilMechanicExp) {
		this.civilMechanicExp = civilMechanicExp;
	}

	// NAME
	
	/**
	 * Позволяет получть значение параметра "Имя".
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	//STATUS
	/**
	 * Позволяет получть значение параметра "Статус".
	 * Данный параметр влияет на допуск к различному типу цехов.
	 * На данный момент не используется.
	 * 
	 * @return String
	 */
	
	protected String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}

	//CASHE
	/**
	 * Позволяет получть значение параметра "Стоимость".
	 * 
	 * @return int
	 */
	public int getPrice() {
		return price;
	}

	protected void setPrice(int cashe) {
		this.price = cashe;
	}

	// MAIN PROVIDER
	protected void setMainProviders(Providers mainProviders) {
		this.mainProviders = mainProviders;
	}
	

	// MONEY TRANSFER BLOCK
	private void addServiceMoney(int incomeMoney){
		if (mainProviders != null){
		mainProviders.addServiceMoney(incomeMoney);
		}
	}
}
