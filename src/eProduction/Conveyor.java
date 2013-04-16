package eProduction;

import java.util.ArrayList;

import utils.GlobalConstants;
import eFactory.ESallers;
import eFactory.Provider;

public final class Conveyor {

	private Provider provider;
	private int factoryUid;

	public Conveyor(Provider iprovider) {
		this.provider = iprovider;
		factoryUid = provider.getFactoreUid();
	}

	public ArrayList<String> getWheelCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Mischlen", quantity);
		case 2:
			return fillSellPartsArray("Pirelli", quantity);
		case 3:
			return fillSellPartsArray("Racing special", quantity);
		}

		return new ArrayList<String>();
	}

	public ArrayList<String> getBodyCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Iron car body", quantity);
		case 2:
			return fillSellPartsArray("Aluminium car body", quantity);
		case 3:
			return fillSellPartsArray("Titanum car body", quantity);
		}
		return new ArrayList<String>();
	}

	public ArrayList<String> getEngineCivirPart(int quantity, int type) {

		switch (type) {
		case 1:
			return fillSellPartsArray("Dog engine", quantity);
		case 2:
			return fillSellPartsArray("Puma engine", quantity);
		case 3:
			return fillSellPartsArray("Gepard engine", quantity);
		}
		return new ArrayList<String>();
	}

	private ArrayList<String> fillSellPartsArray(String parts, int quantity) {
		ArrayList<String> sell = new ArrayList<>();
		sell.add(parts);
		return sell;
	}

	// ENGINE TECHNOLOGY
	public ArrayList<ThankEngine> setEngineParams(int type, int quantity,
			ESallers sallers) {

		if (sallers.getFactoryUid() != factoryUid) {
			System.out.println("Нарушена целостность производственной цепочки");
			return null;
		}

		ArrayList<ThankEngine> outEnginsList = new ArrayList<>();
		switch (type) {
		case 1:
			for (int i = quantity; i > quantity; i--) {
				ThankEngine newEngine = new ThankEngine();

				newEngine.setFactoryUid(factoryUid);
				newEngine.setPower(100);
				newEngine.setWeght(50);
				newEngine
						.setModelType(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
				newEngine.setSloting('A');

				outEnginsList.add(newEngine);
			}
			return outEnginsList;
		case 2:
			for (int i = quantity; i > quantity; i--) {
				ThankEngine newEngine = new ThankEngine();

				newEngine.setFactoryUid(factoryUid);
				newEngine.setPower(330);
				newEngine.setWeght(100);
				newEngine
						.setModelType(GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME);
				newEngine.setSloting('B');

				outEnginsList.add(newEngine);
			}
			return outEnginsList;

		case 3:
			for (int i = quantity; i > quantity; i--) {
				ThankEngine newEngine = new ThankEngine();

				newEngine.setFactoryUid(factoryUid);
				newEngine.setPower(540);
				newEngine.setWeght(300);
				newEngine
						.setModelType(GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME);
				newEngine.setSloting('C');

				outEnginsList.add(newEngine);
			}
			return outEnginsList;

		case 4:
			for (int i = quantity; i > quantity; i--) {
				ThankEngine newEngine = new ThankEngine();

				newEngine.setFactoryUid(factoryUid);
				newEngine.setPower(700);
				newEngine.setWeght(500);
				newEngine
						.setModelType(GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME);
				newEngine.setSloting('D');

				outEnginsList.add(newEngine);

			}
			return outEnginsList;
		}
		return new ArrayList<>();
	}

	// TRACK TECHNOLOGY
	protected ArrayList<ThankTrack> setTrackParams(int type, int quantity,
			ESallers sallers) {

		if (sallers.getFactoryUid() != factoryUid) {
			System.out.println("Нарушена целостность производственной цепочки");
			return null;
		}

		ArrayList<ThankTrack> outTrackList = new ArrayList<>();

		switch (type) {
		case 1:
			for (int i = quantity; i > quantity; i--) {
				ThankTrack newTrack = new ThankTrack();

				newTrack.setFactoryUid(factoryUid);
				newTrack.setWeghtUp(1000);
				newTrack.setWeght(150);
				newTrack.setModelType(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
				newTrack.setSloting('A');

				outTrackList.add(newTrack);
			}
			return outTrackList;

		case 2:
			for (int i = quantity; i > quantity; i--) {
				ThankTrack newTrack = new ThankTrack();

				newTrack.setFactoryUid(factoryUid);
				newTrack.setWeghtUp(3000);
				newTrack.setWeght(300);
				newTrack.setModelType(GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME);
				newTrack.setSloting('B');
				outTrackList.add(newTrack);
			}
			return outTrackList;

		case 3:
			for (int i = quantity; i > quantity; i--) {
				ThankTrack newTrack = new ThankTrack();

				newTrack.setFactoryUid(factoryUid);
				newTrack.setWeghtUp(10000);
				newTrack.setWeght(500);
				newTrack.setModelType(GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME);
				newTrack.setSloting('C');

				outTrackList.add(newTrack);
			}
			return outTrackList;

		case 4:
			for (int i = quantity; i > quantity; i--) {
				ThankTrack newTrack = new ThankTrack();

				newTrack.setFactoryUid(factoryUid);
				newTrack.setWeghtUp(15000);
				newTrack.setWeght(1000);
				newTrack.setModelType(GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME);
				newTrack.setSloting('D');

				outTrackList.add(newTrack);
			}
			return outTrackList;
		}
		return null;
	}

	// HEAD TECHNOLOGY
	protected ArrayList<ThankHead> setHeadParams(int type, int quantity,
			ESallers sallers) {

		if (sallers.getFactoryUid() != factoryUid) {
			System.out.println("Нарушена целостность производственной цепочки");
			return null;
		}

		ArrayList<ThankHead> outHeadList = new ArrayList<>();

		switch (type) {
		case 1:
			for (int i = quantity; i > quantity; i--) {
				ThankHead newHead = new ThankHead();

				newHead.setFactoryUid(factoryUid);
				newHead.setArmour(30);
				newHead.setWeght(250);
				newHead.setModelType(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
				newHead.setSloting('A');

				outHeadList.add(newHead);
			}
			return outHeadList;

		case 2:
			for (int i = quantity; i > quantity; i--) {
				ThankHead newHead = new ThankHead();

				newHead.setFactoryUid(factoryUid);
				newHead.setArmour(30);
				newHead.setWeght(500);
				newHead.setModelType(GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME);
				newHead.setSloting('B');

				outHeadList.add(newHead);
			}
			return outHeadList;

		case 3:
			for (int i = quantity; i > quantity; i--) {
				ThankHead newHead = new ThankHead();

				newHead.setFactoryUid(factoryUid);
				newHead.setArmour(30);
				newHead.setWeght(1500);
				newHead.setModelType(GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME);
				newHead.setSloting('C');

				outHeadList.add(newHead);
			}
			return outHeadList;

		case 4:
			for (int i = quantity; i > quantity; i--) {
				ThankHead newHead = new ThankHead();

				newHead.setFactoryUid(factoryUid);
				newHead.setArmour(30);
				newHead.setWeght(2500);
				newHead.setModelType(GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME);
				newHead.setSloting('D');

				outHeadList.add(newHead);
			}
			return outHeadList;
		}
		return null;
	}

	// BODY TECHNOLOGY
	protected ArrayList<ThankBody> setBodyParams(int type, int quantity,
			ESallers sallers) {

		if (sallers.getFactoryUid() != factoryUid) {
			System.out.println("Нарушена целостность производственной цепочки");
			return null;
		}

		ArrayList<ThankBody> outBidyList = new ArrayList<>();

		switch (type) {
		case 1:
			for (int i = quantity; i > quantity; i--) {
				ThankBody newThankBody = new ThankBody();

				newThankBody.setFactoryUid(factoryUid);
				newThankBody.setBodyArmour(30);
				newThankBody.setWeght(500);
				newThankBody
						.setModelType(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
				newThankBody.setSloting('A');

				outBidyList.add(newThankBody);
			}
			return outBidyList;

		case 2:
			for (int i = quantity; i > quantity; i--) {
				ThankBody newThankBody = new ThankBody();

				newThankBody.setFactoryUid(factoryUid);
				newThankBody.setBodyArmour(145);
				newThankBody.setWeght(2000);
				newThankBody
						.setModelType(GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME);
				newThankBody.setSloting('B');

				outBidyList.add(newThankBody);
			}
			return outBidyList;

		case 3:
			for (int i = quantity; i > quantity; i--) {
				ThankBody newThankBody = new ThankBody();

				newThankBody.setFactoryUid(factoryUid);
				newThankBody.setBodyArmour(500);
				newThankBody.setWeght(7000);
				newThankBody
						.setModelType(GlobalConstants.THIRD_LEVEL_ARMY_PARTS_NAME);
				newThankBody.setSloting('C');

				outBidyList.add(newThankBody);
			}
			return outBidyList;

		case 4:
			for (int i = quantity; i > quantity; i--) {
				ThankBody newThankBody = new ThankBody();

				newThankBody.setFactoryUid(factoryUid);
				newThankBody.setBodyArmour(750);
				newThankBody.setWeght(10000);
				newThankBody
						.setModelType(GlobalConstants.FOURTH_LEVEL_ARMY_PARTS_NAME);
				newThankBody.setSloting('D');

				outBidyList.add(newThankBody);
			}
			return outBidyList;
		}
		return new ArrayList<>();
	}
}