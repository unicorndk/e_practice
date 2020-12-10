package com.korobovartur;

import java.util.Scanner;

class Common {
    public static String readNotEmptyString(Scanner scanner) {
        String string = "";
        while (string.length() == 0) {
            string = scanner.nextLine();
        }
        return string;
    }
}