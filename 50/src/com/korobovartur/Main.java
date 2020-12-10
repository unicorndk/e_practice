package com.korobovartur;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int N = 6;

        System.out.println
                (IntStream
                .rangeClosed(1, N * N)
                .mapToObj(i -> i % N == 0 ? i + "\t\n" : i + "\t")
                .collect(Collectors.joining()));
    }
}
