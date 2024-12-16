package br.com.joaov7r;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CollectionsTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("******** task part 1 ********");
        System.out.print("\nInsert names of people separated by ',': ");
        String names = sc.nextLine();

        List<String> list = new ArrayList<>();
        for (String name : names.split(",")) {
            list.add(name);
        }

        Collections.sort(list);

        System.out.println("Names in alphabetical order:");
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("\n******** task part 2 ********");
        System.out.println("\n**Insert names of people and their respective gender separated by '-' (Alex-M)**");
        System.out.print("**Separate the people using ',' (Alex-M,Maria-F)** : ");
        String people = sc.nextLine();

        List<String> males = new ArrayList<>();
        List<String> females = new ArrayList<>();

        for (String person : people.split(",")) {
            String[] parts = person.split("-");
            if (parts.length == 2) {
                String name = parts[0];
                String gender = parts[1];

                if (gender.equalsIgnoreCase("M")) {
                    males.add(name);
                } else if (gender.equalsIgnoreCase("F")) {
                    females.add(name);
                }
            }
        }

        System.out.println("\nMales:");
        for (String male : males) {
            System.out.println(male);
        }

        System.out.println("\nFemales:");
        for (String female : females) {
            System.out.println(female);
        }
    }
}
