package com.company;

import java.util.Scanner;

class Task4 {

    static void Word() {

        System.out.print("Please enter your word: ");
        Scanner read = new Scanner(System.in);
        String wrd = read.nextLine();
        StringBuilder sb = new StringBuilder(wrd);
        String reverse = sb.reverse().toString();
        if (wrd.equals(reverse)) {
            System.out.print("You entered Palindrome!");

        } else {
            System.out.print("You entered simply word");
        }

    }
}
