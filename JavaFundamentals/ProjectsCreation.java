import java.util.Scanner;

public class ProjectsCreation {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String arch = scan.nextLine();
        int projects = Integer.parseInt(scan.nextLine());
        int hours = projects * 3;


        System.out.printf("The architect %s will need %s hours to complete %s project/s.", arch, hours, projects);

    }


}
