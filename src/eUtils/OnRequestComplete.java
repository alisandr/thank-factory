package eUtils;

import java.util.ArrayList;

import eProduction.ThankBody;
import eProduction.ThankEngine;
import eProduction.ThankHead;
import eProduction.ThankTrack;

public interface OnRequestComplete {

	public void complete(ArrayList<ThankHead> heads, ArrayList<ThankTrack> track, 
			ArrayList<ThankEngine> engine,ArrayList<ThankBody> body);
}
