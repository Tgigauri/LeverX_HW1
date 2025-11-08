import model.Tea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tea Timer!");
        System.out.println("Choose your tea:");
        System.out.println("1. Green Tea");
        System.out.println("2. Black Tea");
        System.out.println("3. Herbal Tea");

        System.out.print("Enter number: ");
        int choice = scanner.nextInt();

        Tea selectedTea;
        switch (choice) {
            case 1:
                selectedTea = new Tea("Green Tea", 3);
                break;
            case 2:
                selectedTea = new Tea("Black Tea", 5);
                break;
            case 3:
                selectedTea = new Tea("Herbal Tea", 7);
                break;
            default:
                System.out.println("Invalid choice. Exiting...");
                scanner.close();
                return;
        }

        Tea.InnerCountdown countdown = selectedTea.new InnerCountdown();
        countdown.startCountdown();

        scanner.close();
    }
}