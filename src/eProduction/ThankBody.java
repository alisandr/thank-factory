package eProduction;

import java.util.ArrayList;

/**
 * 
 * Класс описывающий модель корпуса танка, для установки основных модулей
 * 
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
 * @version 0.7
 */

public final class ThankBody extends WarConstruction {

	private int bodyArmour;

	private ThankEngine engine;
	private ThankHead head;
	private ThankTrack track;
	
	public ThankBody() {}

	// Body armour
	int getBodyArmour() {
		return bodyArmour;
	}

	void setBodyArmour(int bodyArmour) {
		this.bodyArmour = bodyArmour;
	}

	// UIDS
	int getFactoryUid() {
		return factoryUid;
	}

	void setFactoryUid(int thankUid) {
		this.factoryUid = thankUid;
	}

	// NAME
	String getModelType() {
		return modelType;
	}

	protected void setModekType(String modelType) {
		this.modelType = modelType;
	}

	// WEGHT
	void setWeght(int weght) {
		this.weght = weght;
	}

	int getWeght() {
		return weght;
	}

	// INSTALL MOTOR
	ThankEngine getEngine() {
		return engine;
	}

	void setEngine(ThankEngine engine) {
		if (engine.getSloting() == sloting) {
			this.engine = engine;
		} else {
			System.out.println("Эти запчасти несовместимы");
		}
	}

	// INSTALL HEAD
	ThankHead getHead() {
		return head;
	}

	void setHead(ThankHead head) {
		if (head.getSloting() == sloting) {
			this.head = head;
		} else {
			System.out.println("Эти запчасти несовместимы");
		}
	}

	// INSTALL TRACK
	ThankTrack getTrack() {
		return track;
	}

	void setTrack(ThankTrack track) {
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
			System.out.println("Класс компонента :" + engine.getModelType());

			System.out.println("Башня (броня) :" + head.getArmour());
			System.out.println("Башня (вес) :" + head.getWeght());
			System.out.println("Класс компонента :" + head.getModelType());

			System.out
					.println("Трак (грузоподъёмность) :" + track.getWeghtUp());
			System.out.println("Трак (вес) : " + track.getWeght());
			System.out.println("Класс компонента :" + track.getModelType());

		} else {
			System.out.println("Не все детали на месте!");
		}

	}

	// Sloting
	char getSloting() {
		return sloting;
	}

	void setSloting(char sloting) {
		this.sloting = sloting;
	}

	// Controll methods
	boolean showComplexWeghtUp() {
		if (track.getWeghtUp()
				- (engine.getWeght() + head.getWeght() + track.getWeght() + weght) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	ArrayList<String> getModuleInfo() {
		ArrayList<String> info = new ArrayList<>();
		info.add("Класс : " + modelType);
		info.add("Броня : " + bodyArmour);
		info.add("Вес : " + weght);

		return info;
	}
}
