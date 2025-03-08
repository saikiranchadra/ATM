
import java.util.Scanner;

public class ATMSystem {
    public static double balance = 1000.00; // Initial balance
    public static int pin = 1234; // Hardcoded PIN for simplicity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nWelcome to the ATM System");

            // PIN verification
            System.out.print("Enter your PIN (or 0 to shut down the ATM): ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == 0) {
                System.out.println("ATM is shutting down. Goodbye!");
                break;
            }

            if (enteredPin != pin) {
                System.out.println("Incorrect PIN. Please try again.");
                continue;
            }

            boolean sessionActive = true;
            while (sessionActive) {
                System.out.println("\n1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                if (choice == 1) {
                    checkBalance();
                } else if (choice == 2) {
                    deposit(scanner);
                } else if (choice == 3) {
                    withdraw(scanner);
                } else if (choice == 4) {
                    System.out.println("Thank you for using the ATM. Your session has ended.");
                    sessionActive = false;
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        }

        scanner.close();
    }

    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Withdrawal failed.");
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

