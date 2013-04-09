package eFactory;

final class ThankTechnologyTable {
	/**
	 * Класс описания технологический параметров танков 1 - mice
	 * 
	 * @author Кожуров Андрей
	 * @version 0.3
	 */

	private int factoryUid;

	// ENGINE TECHNOLOGY
	protected ThankEngine setEngineParams(int type, ThankEngine newEngine) {
		switch (type) {
		case 1:
			newEngine.setFactoryUid(factoryUid);
			newEngine.setPower(100);
			newEngine.setWeght(50);
			newEngine.setPrice(400);
			newEngine.setName("Мышонок");
			newEngine.setSloting('A');
			return newEngine;
		}
		return null;
	}

	// TRACK TECHNOLOGY
	protected ThankTrack setTrackParams(int type, ThankTrack newTrack) {
		switch (type) {
		case 1:
			newTrack.setFactoryUid(factoryUid);
			newTrack.setWeghtUp(1000);
			newTrack.setWeght(150);
			newTrack.setPrice(700);
			newTrack.setName("Мышонок");
			newTrack.setSloting('A');
			return newTrack;
		}
		return null;
	}

	// HEAD TECHNOLOGY
	protected ThankHead setHeadParams(int type, ThankHead newHead) {
		switch (type) {
		case 1:
			newHead.setFactoryUid(factoryUid);
			newHead.setArmour(30);
			newHead.setWeght(250);
			newHead.setPrice(500);
			newHead.setName("Мышонок");
			newHead.setSloting('A');
			return newHead;
		}
		return null;
	}
	
	// BODY TECHNOLOGY
	protected ThankMaschine setBodyParams(int type, ThankMaschine newThankBody){
		switch (type) {
		case 1:
			newThankBody.setFactoryUid(factoryUid);
			newThankBody.setBodyArmour(30);
			newThankBody.setWeght(500);
			newThankBody.setPrice(1200);
			newThankBody.setName("Мышонок");
			newThankBody.setSloting('A');
			return newThankBody;
		case 2:
			newThankBody.setFactoryUid(factoryUid);
			newThankBody.setBodyArmour(45);
			newThankBody.setWeght(800);
			newThankBody.setPrice(1500);
			newThankBody.setName("Крыса");
			newThankBody.setSloting('B');
		}
		return null;
	}

	protected int getFactoryUid() {
		return factoryUid;
	}

	protected void setFactoryUid(int factoryUid) {
		this.factoryUid = factoryUid;
	}
}
