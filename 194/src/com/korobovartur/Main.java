package com.korobovartur;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"; // Алфавит

        String text = "";
        System.out.println("Введите текст");
        Scanner input = new Scanner(System.in);
        text = input.nextLine();

        char[] charArray = text.toCharArray();

        //Выводим в консоль введенные символы с двумя пробелами
        for(int i = 0; i < text.length(); i++){
            System.out.print(charArray[i] + "  ");
        }

        System.out.println("");

        //Выводим в консоль номер позиции буквы в алфавите
        for (char x : charArray){
            //Игнорируем символ пробела в веденном тексте
            if(x == ' '){
                System.out.print("");
            } else {
                int i = alphabet.lastIndexOf(x);
                i+=1;
                System.out.print(i + "  ");
            }
        }
    }
}