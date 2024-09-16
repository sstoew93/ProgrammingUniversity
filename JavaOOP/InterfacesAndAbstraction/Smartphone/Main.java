package InterfacesAndAbstraction.Smartphone;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] numbersArr = scan.nextLine().split("\\s+");
        String[] urlsArr = scan.nextLine().split("\\s+");

        Smartphone smart = new Smartphone(List.of(numbersArr), List.of(urlsArr));

        System.out.println(smart.call());
        System.out.println(smart.browse());
    }
}
