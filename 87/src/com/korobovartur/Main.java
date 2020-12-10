package com.korobovartur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Shop market = new Shop("INTERSPAR");

        market.addCustomerToShopList(new Customer("Коробов", "Артур", "Эдуардович", 264261, 45895674));
        market.addCustomerToShopList(new Customer("Петренко", "Алексей", "Алексеевич", 353453, 16684336));
        market.addCustomerToShopList(new Customer("Путин", "Артем", "Артемович", 212134, 15984467));
        market.addCustomerToShopList(new Customer("Трамп", "Андрей", "Дмитриевич", 888888, 47853345));
        market.addCustomerToShopList(new Customer("Белый", "Владимир", "Васильевич", 545456, 25693256));


        System.out.println("\nСортировка по имени:");
        List<Customer> listSortByName = market.getListName();
        for (Customer c : listSortByName) {
            System.out.println(c);
        }

        System.out.println("\nСоритровка по фамилии:");
        List<Customer> listSortBySurname = market.getListSurname();
        for (Customer c : listSortBySurname) {
            System.out.println(c);
        }

        System.out.println("\nНомера карт в диапазоне от 300000 до 600000:");
        List<Customer> diapasonCardumber = market.getListDiapasonCardNumber(300000, 600000);
        for (Customer c : diapasonCardumber) {
            System.out.println(c);
        }
    }
}

class Shop {

    private String ShopName;
    private ArrayList<Customer> customerList = new ArrayList<>();

    Shop(String ShopName) {
        this.ShopName = ShopName;
    }

    void addCustomerToShopList(Customer customer) {
        customerList.add(customer);
    }

    List<Customer> getListName() {
        List<Customer> list = new ArrayList<>(customerList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }

        });
        return list;
    }

    List<Customer> getListSurname() {
        List<Customer> list = new ArrayList<>(customerList);
        Collections.sort(list, new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                return o1.getSurname().compareToIgnoreCase(o2.getSurname());
            }
        });
        return list;
    }

    List<Customer> getListDiapasonCardNumber(int diapasonStart, int diapasonEnd) {
        List<Customer> list = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getCardNumber() >= diapasonStart && c.getCardNumber() <= diapasonEnd) {
                list.add(c);
            }
        }
        return list;
    }

}

class Customer {

    {
        idGenertor++;
    }

    private static int idGenertor = 0;
    private int id = idGenertor;
    private String surname;
    private String name;
    private String patronymic;
    private int CardNumber;
    private int BankNumber;

    Customer(String surname, String name, String patronymic, int CardNumber, int BankNumber) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.CardNumber = CardNumber;
        this.BankNumber = BankNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public int getBankNumber() {
        return BankNumber;
    }

    public String toString() {
        return String.format("ID: %d\t Фамилия: %s\t Имя: %s\t Отчество: %s\t Номер карты: %d\t Банковский номер: %d",
                id, surname, name, patronymic, CardNumber, BankNumber);
    }

}
