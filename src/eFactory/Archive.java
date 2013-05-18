package eFactory;

import java.io.Serializable;
import java.util.ArrayList;

import eProduction.Engineer;

final class Archive implements Serializable {

    private static final long serialVersionUID = 4383210670861843502L;
    private ArrayList<Engineer> totalRegister;


    Archive(long createdTime) {
        setTimestamp(createdTime);
        totalRegister = new ArrayList<>();
    }

    private long timestamp;

    private long productionMoney;
    private long serviceMoney;
    private long penaltyMoney;


    // Production money
    long getProductionMoney() {
        return productionMoney;
    }

    // Service money
    long getServiceMoney() {
        return serviceMoney;
    }

    // Penalty money
    long getPenaltyMoney() {
        return penaltyMoney;
    }

    ArrayList<Engineer> getTotalRegister() {
        return totalRegister;
    }

    void setTotalIngeneer(ArrayList<Engineer> incomeArchiv) {
        if (incomeArchiv != null) {
            totalRegister = incomeArchiv;
        }
    }

    void setServiceMoneyTransfer(long servMoney) {
        if (servMoney > 0)
            serviceMoney += servMoney;
    }

    void setProductionMoney(long prodMoney) {
        if (prodMoney > 0)
            serviceMoney += prodMoney;
    }

    void setPenaltyMoney(long penMoney) {
        if (penMoney > 0)
            serviceMoney += penMoney;
    }

    long getTimestamp() {
        return timestamp;
    }

    void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    void prepareSave(Provider actionProvider) {
        if (totalRegister.isEmpty()) {
            return;
        }
        for (Engineer en : totalRegister) {
           en.archiveSavePrepear(actionProvider);

        }
    }
}
