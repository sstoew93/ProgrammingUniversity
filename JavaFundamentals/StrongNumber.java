import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number = Integer.parseInt(scan.nextLine());
        int startNum = number;
        int sumFact = 0;

        while (number > 0) {
            int last = number % 10;
            int fact = 1;
            for (int i = 1; i <= last ; i++) {
                fact *= i;
            }

            sumFact += fact;

            number = number / 10;
        }
        
        if (sumFact == startNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        
    }
}
