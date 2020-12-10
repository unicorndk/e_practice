package com.korobovartur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Payment newPayment = new Payment();

        Scanner input = new Scanner(System.in);

        printMenu();

        boolean isQuit = false;
        while (!isQuit) {
            int operationNumber = input.nextInt();

            switch (operationNumber) {
                case 1:
                    newPayment.AddProduct();
                    break;
                case 2:
                    newPayment.RemoveProduct();
                    break;
                case 3:
                    newPayment.Pay();
                    break;
                default:
                    printMenu();
            }
        }
    }

    public static void printMenu() {
        System.out.println("Введите номер операции:");
        System.out.println("1 - Добавить продукт");
        System.out.println("2 - Удалить продукт");
        System.out.println("3 - Совершить платеж");
    }
}
