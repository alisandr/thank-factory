package eFactory;

import java.util.ArrayList;
import java.util.HashMap;

import eProduction.Engineer;

public final class ESearcher {

    private ArrayList<Engineer> archiveRegister;

    private int i;
    private String[] parts;
    private StringBuilder sbuild;

    ESearcher(Archive archive) {
        archiveRegister = archive.getTotalRegister() != null ? archive
                .getTotalRegister() : new ArrayList<Engineer>();
        sbuild = new StringBuilder();
    }

    HashMap<Integer, String> searchByArmyExp(long minimalExpNeed) {
        HashMap<Integer, String> searchResult = new HashMap<>();
        i = 0;
        for (Engineer en : archiveRegister) {
            i++;
            parts = en.getResume().get(4).split(": ");
            if (Integer.parseInt(parts[1]) >= minimalExpNeed) {
                sbuild.setLength(0);
                sbuild.append(en.getResume().get(4)).append(". ")
                        .append(en.getResume().get(6)).append(" $");
                searchResult.put(i, sbuild.toString());
            }
        }
        return searchResult;
    }

    HashMap<Integer, String> searchByCivilExp(long minimalExpNeed) {
        HashMap<Integer, String> searchResult = new HashMap<>();
        i = 0;
        for (Engineer en : archiveRegister) {
            i++;
            parts = en.getResume().get(3).split(": ");
            if (Integer.parseInt(parts[1]) >= minimalExpNeed) {
                sbuild.setLength(0);
                sbuild.append(en.getResume().get(3)).append(". ").append(en.getResume().get(6)).append(" $");
                searchResult.put(i, sbuild.toString());
            }
        }
        return searchResult;
    }

    HashMap<Integer, String> searchByCompleteBuilds(long minimalUnitNeed) {
        HashMap<Integer, String> searchResult = new HashMap<>();
        i = 0;
        for (Engineer en : archiveRegister) {
            i++;
            parts = en.getResume().get(5).split(": ");
            if (Integer.parseInt(parts[1]) >= minimalUnitNeed) {

                sbuild.setLength(0);
                sbuild.append(en.getResume().get(5)).append(". ").append(en.getResume().get(6)).append(" $");

                searchResult.put(i, sbuild.toString());
            }
        }
        return searchResult;
    }

}
