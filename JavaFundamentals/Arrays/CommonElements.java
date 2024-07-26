package Arrays;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] array1 = scan.nextLine().split(" ");
        String [] array2 = scan.nextLine().split(" ");

        for (String element1:array2) {
            for (String element2:array1) {
                if (element1.equals(element2)) {
                    System.out.print(element2 + " ");
                }
            }
        }





    }
}
