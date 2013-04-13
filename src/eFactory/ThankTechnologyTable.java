package eFactory;

final class ThankTechnologyTable {
	/**
	 * Класс описания технологический параметров танков 1 - mice
	 * 
	 * @author Кожуров Андрей
	 * @version 0.5
	 */

	private int factoryUid;
	

	// ENGINE TECHNOLOGY
	protected ThankEngine setEngineParams(int type, ThankEngine newEngine) {
		switch (type) {
		case 1:
			newEngine.setFactoryUid(factoryUid);
			newEngine.setPower(100);
			newEngine.setWeght(50);
			newEngine.setName(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
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
			newTrack.setName(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
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
			newHead.setName(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
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
			newThankBody.setPrice(GlobalConstants.FIRST_BODY);
			newThankBody.setName(GlobalConstants.FIRST_LEVEL_ARMY_PARTS_NAME);
			newThankBody.setSloting('A');
			return newThankBody;
		case 2:
			newThankBody.setFactoryUid(factoryUid);
			newThankBody.setBodyArmour(45);
			newThankBody.setWeght(800);
			newThankBody.setPrice(GlobalConstants.SECOND_BODY);
			newThankBody.setName(GlobalConstants.SECOND_LEVEL_ARMY_PARTS_NAME);
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
