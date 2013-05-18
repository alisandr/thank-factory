package eFactory;

/**
 * Главный класс проекта.
 * Данный проект есть учебно тренеровочный.
 *
 * Суть сводится к следующему:
 * Необходимо создать экземпляр данного класса, получить от него отдел продаж.
 * Далее - по ситуации:
 *
 * 1) Покупать детали к машинам со строковыми значениями.
 *
 * 2) Попробовать собрать военную машину.
 *
 * Для этого необходимо:
 * 1) Купить в отделе продаж все нужны чести для техники.
 * 2) Купить в отделе продаж инженера.
 * 3) Передать все части инженеру, вместе с небольшим вознаграждением
 *
 * После чего, вы получите экземпляр класса боевой техники.
 *
 *
 * Внимание, инженер не сможет собрать гражданские виды техники.
 * Внимание, если Вы хотите сохранить прогресс, нужно явно вызывать метод сохранения.
 *
 * @version 0.9
 *
 * @author Андрей Кожуров
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import eProduction.Engineer;
import eUtils.OnRegistrIngeneer;
import eUtils.OnServiceMoneyTransfer;

public final class Provider implements OnServiceMoneyTransfer, OnRegistrIngeneer {

    private ESallers sallers;
    private Archive archive;

    private int factoryUid;

    private ArrayList<Engineer> veterans;

    public Provider() {

        veterans = new ArrayList<>();
        initProvider();
    }

    private void initProvider() {

        factoryUid = (new Random()).nextInt(10000) + 100;

        int choise = 0;

        System.out.println("1 - Начать заново");
        System.out.println("2 - Продолжить");

        Scanner scr = new Scanner(System.in);
        choise = scr.nextInt();
        scr.close();

        switch (choise) {
            case 1:
                archive = new Archive(new Date().getTime());
                sallers = new ESallers(this);
                break;
            case 2:
                loadSavedArchive();

                break;
            default:
                System.out.println("Не верный выбор. До новых встеч");
                return;
        }

    }

    /**
     * Метод позволяет получить экземпляр класса ESallers. Данную процедуру
     * необходимо произвести первым делом.
     *
     * @return ESallers
     */
    public ESallers getSallers() {
        return sallers;
    }

    public void loadSavedArchive() {
        File loaded = new File("eSave.efc");
        try {
            FileInputStream fis = new FileInputStream(loaded);
            ObjectInputStream ois = new ObjectInputStream(fis);
            archive = (Archive) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти файл сохранения!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        sallers = new ESallers(this);
        sallers.getScholl().startStudeSpecialist(archive.getTotalRegister(), sallers);
        System.out.println("Прогресс загружен!");
    }

    public void saveCurrentArchive() {
        File loaded = new File("eSave.efc");
        FileOutputStream fos;

        try {
            loaded.createNewFile();
            fos = new FileOutputStream(loaded);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            archive.prepareSave(this);
            archive.setTimestamp(new Date().getTime());

            oos.writeObject(archive);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Прогресс сохранён!");
    }

    /**
     * Колечество денег полученных на продаже оборудования.
     *
     * @return money (long)
     */

    // PRODUCTION MONEY
    public long getProductionMoney() {
        return archive.getProductionMoney();
    }

    void addProductionMoney(long productionMoney) {
        archive.setProductionMoney(productionMoney);
    }

    /**
     * Колечество денег полученных на штрафах и неустойках.
     *
     * @return money (long)
     */

    // PENALTY MONEY
    public long getPenaltyMoney() {
        return archive.getPenaltyMoney();
    }

    void addPenaltyMoney(long penaltyMoney) {
        archive.setPenaltyMoney(penaltyMoney);
    }

    /**
     * Колечество денег полученных от услуг инженеров.
     *
     * @return money (long)
     */

    // SERVICE MONEY
    public long getServiceMoney() {
        return archive.getServiceMoney();
    }

    @Override
    public void moneyTransact(int serviceMoney) {
        archive.setServiceMoneyTransfer(serviceMoney);
    }

    Archive getArchive() {
        return archive;
    }

    /**
     * Идентификатор фабрики.
     *
     * @return UID (int)
     */
    // UIDS
    public int getFactoryUid() {
        return factoryUid;
    }

    @Override
    public void register(Engineer engineer) {
        veterans.add(engineer);
        archive.setTotalIngeneer(veterans);
    }

}