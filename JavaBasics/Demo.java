import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] hotels = {"Hotel A", "Hotel B", "Hotel C"}; // Списък с хотели
        double[] prices = {100.00, 120.00, 80.00}; // Цени за нощувка в хотелите
        int choice;
        int nights;
        double total;

        System.out.println("Добре дошли в нашата онлайн booking агенция!");
        System.out.println("Моля изберете хотел от следните:");
        for (int i = 0; i < hotels.length; i++) {
            System.out.println((i+1) + ". " + hotels[i] + " - Цена за нощувка: $" + prices[i]);
        }
        choice = input.nextInt(); // Избор на хотел
        System.out.println("Избрахте " + hotels[choice-1] + ".");
        System.out.println("Моля въведете брой нощувки:");
        nights = input.nextInt(); // Брой нощувки
        total = nights * prices[choice-1];
        System.out.println("Обща цена за " + nights + " нощувки в " + hotels[choice-1] + " е $" + total);
        System.out.println("Моля въведете данни за плащане:");
        // Тук може да има логика за обработване на данните за плащане (например кредитна карта)
        System.out.println("Плащането е успешно завършено. Благодарим Ви, че използвахте нашата услуга!");
    }
}
