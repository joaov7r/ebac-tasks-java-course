package br.com.joaov7r;

import java.util.Locale;
import java.util.Scanner;

public class Evaluation {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Type your first score: ");
        double grade1 = sc.nextDouble();
        System.out.print("Type your second score: ");
        double grade2 = sc.nextDouble();
        System.out.print("Type your third score: ");
        double grade3 = sc.nextDouble();
        System.out.print("Type your fourth score: ");
        double grade4 = sc.nextDouble();

        System.out.println();

        double avg = (grade1+grade2+grade3+grade4) / 4;

        if(avg >= 7.0){
            System.out.println("You're approved, congratulations!");
        }
        else if(avg >= 5){
            System.out.println("You're in recovery...");
        }
        else {
            System.out.println("You failed, better study more next time!");
        }

        sc.close();
    }
}
