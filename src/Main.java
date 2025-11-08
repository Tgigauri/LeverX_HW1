import model.Tea;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @FunctionalInterface
        interface Countdown {
            void start();
        }
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

        Countdown countdown = () -> {
            Runnable printer = () -> {
                AnsiConsole.systemInstall();
                for (int i = selectedTea.getBrewTime(); i > 0; i--) {
                    System.out.println(Ansi.ansi().fgYellow().a("Time left: " + i + " seconds").reset());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Ansi.ansi().fgGreen().a("Done! Enjoy your " + selectedTea.getTeaName()).reset());
                AnsiConsole.systemUninstall();
            };
            printer.run();
        };

        countdown.start();

        scanner.close();
    }
}