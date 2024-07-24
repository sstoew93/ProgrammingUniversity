import java.util.Scanner;

public class BasketballEquipment {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

            int fee = Integer.parseInt(scan.nextLine());

            double shoes = fee - ( fee * 0.4 );
            double clothes =  shoes - ( shoes * 0.2 );
            double ball = clothes / 4;
            double akses = ball / 5;

            double price = fee + shoes + clothes + ball + akses;

        System.out.println(price);




    }
}

