package eFactory;

/**
 * <p>
 * Класс описывающий модель корпуса танка, для установки основных модулей
 * </p>
 * В данной версии необходимо наличие 3 видов оборудования
 * 
 * @param Engine
 *            -- танковый мотор
 * @param Head
 *            -- башня танка
 * @param Track
 *            -- танковые траки
 * 
 * @author Кожуров Андрей
 * @version 0.2
 */

public final class ThankMaschine {

	private int factoryUid;
	private String name;

	private int price;

	private int bodyArmour;
	private int weght;
	private char sloting;

	private ThankEngine engine;
	private ThankHead head;
	private ThankTrack track;

	/**
	 * <p>
	 * Позволяет получить значение брони танкового корпуса
	 * </p>
	 */
	public int getBodyArmour() {
		return bodyArmour;
	}

	protected void setBodyArmour(int bodyArmour) {
		this.bodyArmour = bodyArmour;
	}

	// UIDS
	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int thankUid) {
		this.factoryUid = thankUid;
	}

	// NAME
	/**
	 * <p>
	 * Позволяет получить название танкового корпуса
	 * </p>
	 */
	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	// PRICE

	/**
	 * <p>
	 * Позволяет получить значение стоимости танкового корпуса
	 * </p>
	 */
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	// WEGHT
	protected void setWeght(int weght) {
		this.weght = weght;
	}

	/**
	 * <p>
	 * Позволяет получить значение веса танкового корпуса
	 * </p>
	 */
	public int getWeght() {
		return weght;
	}

	// INSTALL MOTOR
	protected ThankEngine getEngine() {
		return engine;
	}

	protected void setEngine(ThankEngine engine) {
		if (engine.getSloting() == sloting) {
			this.engine = engine;
		} else {
			System.out.println("Эти запчасти несовместимы");
		}
	}

	// INSTALL HEAD
	protected ThankHead getHead() {
		return head;
	}

	protected void setHead(ThankHead head) {
		if (head.getSloting() == sloting) {
			this.head = head;
		} else {
			System.out.println("Эти запчасти несовместимы");
		}
	}

	// INSTALL TRACK
	protected ThankTrack getTrack() {
		return track;
	}

	protected void setTrack(ThankTrack track) {
		if (track.getSloting() == sloting) {
			this.track = track;
		} else {
			System.out.println("Эти запчасти несовместимы");
		}
	}

	// SHOW COMPLECSIVE INFO
	public void showProductionInfo() {

		if (engine != null && head != null && track != null) {
			System.out.println("Продукция : Танк");
			System.out
					.println("Общий вес : "
							+ (engine.getWeght() + head.getWeght()
									+ track.getWeght() + weght));
			System.out.println("Общая броня :"
					+ (bodyArmour + head.getArmour()));
			System.out
					.println("Общая грузоподъёмность : " + track.getWeghtUp());
			System.out.println("Тип слотирования :" + sloting);

			System.out.println("Мотор (лс) : " + engine.getPower());
			System.out.println("Мотор (вес) : " + engine.getWeght());
			System.out.println("Класс компонента :" + engine.getName());

			System.out.println("Башня (броня) :" + head.getArmour());
			System.out.println("Башня (вес) :" + head.getWeght());
			System.out.println("Класс компонента :" + head.getName());

			System.out
					.println("Трак (грузоподъёмность) :" + track.getWeghtUp());
			System.out.println("Трак (вес) : " + track.getWeght());
			System.out.println("Класс компонента :" + track.getName());

		} else {
			System.out.println("Не все детали на месте!");
		}

	}

	/**
	 * Слотирование - это тип элементов которые принимет данная платформа.
	 * Например, техника с различающимся типом слоторования несовместима.
	 * 
	 * @return char
	 */
	public char getSloting() {
		return sloting;
	}

	protected void setSloting(char sloting) {
		this.sloting = sloting;
	}

	// Controll methods

	protected boolean showComplexWeghtUp() {
		if (track.getWeghtUp()
				- (engine.getWeght() + head.getWeght() + track.getWeght() + weght) > 0) {
			return true;
		} else {
			return false;
		}
	}
}
