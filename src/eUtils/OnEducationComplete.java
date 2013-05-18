package eUtils;

import java.util.ArrayList;

import eFactory.ESallers;
import eProduction.Engineer;

public interface OnEducationComplete {

	public void educationComplete(ArrayList<Engineer> skillsEngineer, ESallers targetSallers);
}
