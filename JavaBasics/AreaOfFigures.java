import java.util.Scanner;

public class AreaOfFigures {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String Figure = scan.nextLine();

    double area = 0;
        if (Figure.equals("square")) {
            double side = Double.parseDouble(scan.nextLine());
            area = side * side;
        } else if (Figure.equals("rectangle")) {
            double length = Double.parseDouble(scan.nextLine());
            double width = Double.parseDouble(scan.nextLine());
            area = length * width;
        } else if (Figure.equals("circle")) {
            double radius = Double.parseDouble(scan.nextLine());
            area = Math.PI * radius * radius;
        } else if (Figure.equals("triangle")) {
            double base = Double.parseDouble(scan.nextLine());
            double height = Double.parseDouble(scan.nextLine());
            area = base * height / 2;
        }



        System.out.printf("%.3f", area);


    }

    public static class Shop {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            String product = scan.nextLine();
            String town = scan.nextLine();
            double quantity = Double.parseDouble(scan.nextLine());

            double price = 0;


            switch (town) {
                case "Sofia":
                    if (product.equals("coffee")) {
                        price = 0.50;
                    } else if (product.equals("water")) {
                        price = 0.80;
                    } else if (product.equals("beer")) {
                        price = 1.20;
                    } else if (product.equals("sweets")) {
                        price = 1.45;
                    } else if (product.equals("peanuts")) {
                        price = 1.60;
                    }
                        break;

                case "Plovdiv":
                    if (product.equals("coffee")) {
                        price = 0.40;
                    } else if (product.equals("water")) {
                        price = 0.70;
                    } else if (product.equals("beer")) {
                        price = 1.15;
                    } else if (product.equals("sweets")) {
                        price = 1.30;
                    } else if (product.equals("peanuts")) {
                        price = 1.50;
                    }
                    break;

                case "Varna":
                    if (product.equals("coffee")) {
                        price = 0.45;
                    } else if (product.equals("water")) {
                        price = 0.70;
                    } else if (product.equals("beer")) {
                        price = 1.10;
                    } else if (product.equals("sweets")) {
                        price = 1.35;
                    } else if (product.equals("peanuts")) {
                        price = 1.55;
                    break;
                    }



            }

            System.out.println(price * quantity);

        }
    }
}
