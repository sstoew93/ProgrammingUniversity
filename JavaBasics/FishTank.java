import java.util.Scanner;

public class FishTank {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


            int duljina = Integer.parseInt(scan.nextLine());
            int shirochina = Integer.parseInt(scan.nextLine());
            int visochina = Integer.parseInt(scan.nextLine());
            double procent = Double.parseDouble(scan.nextLine());


            double obem = duljina * shirochina * visochina;
            double obemlt = obem * 0.001;
            double zaeto = procent / 100;

            double water = obemlt * ( 1.0 - zaeto );

        System.out.println(water);


    }
}
