import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        double area = Double.parseDouble(scan.nextLine());
        double priceper = 7.61;
        double price = area * priceper;
        // discount is 18% = 0.18
        double discount = price * 0.18;
        double finalprice = price - discount;

        System.out.printf("The final price is: %s lv. %n", finalprice);
        System.out.printf("The discount is: %s lv.", discount);



    }
}
