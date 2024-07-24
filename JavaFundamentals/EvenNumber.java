import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);



        boolean EvenFound = false;
        while (!EvenFound) {
            int num = Integer.parseInt(scan.nextLine());
            if (num % 2 == 0) {
                EvenFound = true;
                System.out.printf("The number is: %d", Math.abs(num));
            } else {
                System.out.println("Please write an even number.");
            }
        }

    }
}


