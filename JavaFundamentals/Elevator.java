import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       int peopleCount = Integer.parseInt(scan.nextLine());
       int capacity = Integer.parseInt(scan.nextLine());

       int courses = peopleCount / capacity;



       if (courses % 2 != 0) {
           courses++;
       }
        if (peopleCount < capacity) {
            System.out.println("1");
        } else {
            System.out.println(courses);
        }


    }
}
