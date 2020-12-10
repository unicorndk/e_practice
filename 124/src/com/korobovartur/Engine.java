package com.korobovartur;

import java.util.*;

public class Engine {
    private int number;
    private double power;
    public Engine(int number_, double power_) {
        number = number_;
        power = power_;
    }
    public String toString() {
        String string = "engine: " + number + ", power:" + power;
        return string;
    }
    public static Engine get(Scanner scanner) {
        Engine object = new Engine(0, 0);
        System.out.print("Введи номер двигателя: ");
        object.number = scanner.nextInt();
        System.out.print("Введи мощность двигателя: ");
        object.power = scanner.nextDouble();
        return object;
    }
}
