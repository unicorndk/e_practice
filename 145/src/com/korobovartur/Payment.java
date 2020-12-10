package com.korobovartur;

import java.util.ArrayList;

public class Payment {

    private ArrayList<Product> itemsList = new ArrayList<>();
    private int id = 0;


    public Payment() {
        this.id = 10000000 + (int)(Math.random() * 100000000);

        System.out.printf("Платеж %d создан! \n", this.id);
    }


    public void Pay() {
        if (itemsList.size() > 0) {
            System.out.println("Платеж выполняется...");
            System.out.println("Платеж успешно выполнен!");

            itemsList.clear();
        } else {
            System.out.println("Ваша корзина пуста! Платеж не выполнен.");
        }
    }


    public void AddProduct() {
        Product newProduct = new Product(itemsList.size() + 1);

        itemsList.add(newProduct);

        System.out.printf("Продукт %d добавлен список! \n", itemsList.get(itemsList.size() - 1).id);
    }


    public void RemoveProduct() {
        if (itemsList.size() > 0) {
            System.out.printf("Продукт %d удален из списка! \n", itemsList.get(0).id);

            itemsList.remove(0);
        } else {
            System.out.println("Ваша корзина пуста!");
        }
    }


    public class Product {

        private int id;


        public Product(int _id) {
            this.id = _id;

        }
    }
}
