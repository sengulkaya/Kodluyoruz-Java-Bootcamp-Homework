package kaya.sengul.secondweek.sat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Questions {
    public static boolean isEven(int val) {
        return val % 2 == 0;
    }

    public static void displayList(ArrayList<String> list) {
        int size = list.size();
        int index = 0;
        while (index < size) {
            System.out.printf("%d. %s%n", index + 1, list.get(index++));
        }
    }

    public static void buyTicket() {
        int ticketPrice = 100;
        boolean flag = false;
        java.util.Scanner kb = new Scanner(System.in);

        System.out.print("Yaþýnýz: ");
        int age = Integer.parseInt(kb.nextLine());

        if (age < 18) {
            ticketPrice -= ticketPrice * .1;
        } else if (age < 25) {
            ticketPrice -= ticketPrice * .05;
        }

        System.out.print("Film Korku kategorisindeyse Yes giriniz.");
        String category = kb.nextLine();

        if (category.equals("Yes"))
            flag = true;

        ticketPrice -= flag ? ticketPrice * .1 : 0;

        System.out.printf("%d yaþ biri için 100 olan bilet fiyatý %d oldu", age, ticketPrice);
    }

    public static void displayGroupedNumbersByGender(ArrayList<Person> list) {
        List<Person> listOfWomen = list.stream().filter(e -> e.gender == Gender.WOMAN).collect(Collectors.toList());
        List<Person> listOfMen = list.stream().filter(e -> e.gender == Gender.MAN).collect(Collectors.toList());
        System.out.println("Numbers of women:");
        for (int i = 0; i < listOfWomen.size(); i++) {
            System.out.printf("%d ", listOfWomen.get(i).getNumber());
        }
        System.out.println();
        System.out.println("Numbers of men:");
        for (int i = 0; i < listOfMen.size(); i++) {
            System.out.printf("%d ", listOfMen.get(i).getNumber());
        }

    }


}
