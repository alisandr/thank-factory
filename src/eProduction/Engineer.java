package eProduction;

import java.util.ArrayList;

import eFactory.Provider;
import eUtils.OnServiceMoneyTransfer;


/**
 * Класс инженер - на данный момент основной производственный элемент.
 * Главная задача - получить детали и собрать технику
 *
 * @author Андрей Кожуров
 * @version 0.8
 */

public final class Engineer extends WorkerModel {

    private static final long serialVersionUID = 6524904880833956152L;
    private Provider mainProvider;
    private OnServiceMoneyTransfer hostBank;

    private int armyMechanicExp;

    Engineer(Provider provider) {
        mainProvider = provider;
        factoryUid = mainProvider.getFactoryUid();
        hostBank = mainProvider;
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
     * @return mainBody
     */
    public ThankBody makeNewThank(ThankBody mainBody,
                                  ThankEngine installingEngine, ThankHead installingHead,
                                  ThankTrack installingTrak, int price) {

        if (mainBody != null && mainBody.getFactoryUid() == factoryUid
                && installingEngine != null && installingEngine.getFactoryUid() == factoryUid
                && installingHead != null && installingHead.getFactoryUid() == factoryUid
                && installingTrak != null && installingTrak.getFactoryUid() == factoryUid
                && price >= 100) {

            mainBody.setEngine(installingEngine);
            mainBody.setHead(installingHead);
            mainBody.setTrack(installingTrak);

            if (mainBody.showComplexWeghtUp()) {
                armyMechanicExp += price / 100;
                addServiceMoney(price);
                completeBuilds++;
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

    //AGE
    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    //Army exp
    int getArmyMechanicExp() {
        return armyMechanicExp;
    }

    void setArmyMechanicExp(int armyMechanicExp) {
        this.armyMechanicExp = armyMechanicExp;
    }

    // Civil exp
    int getCivilMechanicExp() {
        return civilMechanicExp;
    }

    void setCivilMechanicExp(int civilMechanicExp) {
        this.civilMechanicExp = civilMechanicExp;
    }

    // NAME
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    //STATUS
    String getStatus() {
        return status;
    }

    void setStatus(String status) {
        this.status = status;
    }

    // MONEY TRANSFER BLOCK
    private void addServiceMoney(int incomeMoney) {
        if (hostBank == null) {
            System.out.println("Не могу связаться с базой!");
        } else {
            hostBank.moneyTransact(incomeMoney);
        }
    }

    void setMainProvider(Provider mainProvider) {
        this.mainProvider = mainProvider;
    }

    /**
     * Данный метод позовляет получить резюме конкретного инженера.
     *
     * @return ArrayList<String>
     */
    @Override
    public ArrayList<String> getResume() {
        ArrayList<String> resumeList = new ArrayList<>();
        resumeList.add("Имя : " + name);
        resumeList.add("Статус : " + status);
        resumeList.add(String.valueOf("Возраст : " + age));
        resumeList.add(String.valueOf("Гражданский опыт : " + civilMechanicExp));
        resumeList.add(String.valueOf("Военный опыт : " + armyMechanicExp));
        resumeList.add(String.valueOf("Успешные сборки : " + completeBuilds));
        resumeList.add(String.valueOf("Стоимость : " + cost));

        return resumeList;

    }

    /**
     * Позволяет проверить происхождение инженера относительно провайдера.
     * Возвращает true если проверка пройдена.
     *
     * @param externalProvider
     * @return boolean
     */
    public boolean reviewChain(Provider externalProvider) {
        if (mainProvider.equals(externalProvider)) {
            return true;
        } else {
            return false;
        }
    }

    public void archiveSavePrepear(Provider externalProvider){
        if (reviewChain(externalProvider)){
            mainProvider = null;
            hostBank = null;
            factoryUid = 0;
        }
    }
}
