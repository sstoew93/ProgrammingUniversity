import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String FirstName = scan.nextLine();
        String SecondName = scan.nextLine();
        int Age = Integer.parseInt(scan.nextLine());
        String Town = scan.nextLine();

        System.out.print("You are " + FirstName + " " + SecondName + ", a " + Age + "-years old person from " + Town + ".");




    }
}
