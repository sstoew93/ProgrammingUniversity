package Methods;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String methodType = scan.nextLine();
        String value1 = scan.nextLine();
        String value2 = scan.nextLine();

        if (methodType.equals("int")) {
            System.out.println(getMax(Integer.parseInt(value1), Integer.parseInt(value2)));
        } else if (methodType.equals("char")) {
            System.out.println(getMax(value1.charAt(0),value2.charAt(0)));
        } else {
            System.out.println(getMax(value1,value2));
        }

    }

    public static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return  num2;
        }
    }

    public static char getMax(char char1, char char2) {

        if (char1 > char2) {
            return char1;
        } else {
            return char2;
        }
    }

    public static String getMax (String text1, String text2) {

        if(text1.compareTo(text2) >= 0) {
            return text1;
        } else {
            return text2;
        }
    }

}
