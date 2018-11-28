package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Word {


    static String word;

    public static void Word(){
        Scanner read = new Scanner(System.in);
        word = read.nextLine();
        String revers="";
        char[] charters =word.toCharArray();
        char[] reverscharters = word.toCharArray();

        System.out.println(Arrays.toString(charters));

        for (int i = charters.length - 1; i >= 0; i--) {
            revers = String.valueOf(charters[i]);
            System.out.print(charters[i]);
            System.out.printf(revers);
    }

}}
