package br.com.joaov7r;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Groups {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type people's names separeted by ',' : ");
        String names = sc.nextLine();
        System.out.println("Type their respective gender using 'M' ou 'F' separeted by ',' : ");
        String genders = sc.nextLine();

        List<String> male = new ArrayList<>();
        List<String> female = new ArrayList<>();

        String[] nameArray = names.split(",");
        String[] genderArray = genders.split(",");

        for (int i = 0; i <nameArray.length; i++){
            if(genderArray[i].equalsIgnoreCase("M")){
                male.add(nameArray[i]);
            } else if(genderArray[i].equalsIgnoreCase("F")){
                female.add(nameArray[i]);
            }
        }

        System.out.println("\nMale group: ");
        male.forEach(System.out::println);

        System.out.println("\nFemale group: ");
        female.forEach(System.out::println);
    }
}
