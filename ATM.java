import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class ATM {
    private static final String BANK_NAME = "=== Welcome to High-Tech ATM ===";
    private static String userName;
    private static int userPin;
    private static double userBalance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial setup: Get user details
        printDashedLine(40);
        System.out.println("\n" + BANK_NAME + "\n");
        printDashedLine(40);

        System.out.print("Please enter your name: ");
        userName = sc.nextLine();

        System.out.print("Set your 4-digit PIN: ");
        userPin = sc.nextInt();

        while (String.valueOf(userPin).length() != 4) {
            System.out.print("Invalid PIN. Please enter a 4-digit PIN: ");
            userPin = sc.nextInt();
        }

        System.out.print("Enter your initial deposit amount (₹): ");
        userBalance = sc.nextDouble();

        while (userBalance < 0) {
            System.out.print("Invalid amount. Please enter a positive value: ");
            userBalance = sc.nextDouble();
        }

        System.out.println("\nAccount setup complete! Welcome, " + userName + "!\n");

        // Start the ATM operations
        authenticateUser(sc);
    }

    private static void authenticateUser(Scanner sc) {
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;

        System.out.println("\nPlease authenticate to access your account.");
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == userPin) {
                System.out.println("Authentication successful!");
                mainMenu(sc);
                return;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
            }
        }

        System.out.println("Too many failed attempts. Exiting...");
    }

    private static void mainMenu(Scanner sc) {
        boolean sessionActive = true;

        while (sessionActive) {
            printDashedLine(40);
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Print Receipt");
            System.out.println("5. Exit");
            printDashedLine(40);
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(sc);
                    break;
                case 3:
                    withdrawMoney(sc);
                    break;
                case 4:
                    printReceipt();
                    break;
                case 5:
                    sessionActive = false;
                    System.out.println("Thank you for using our ATM. Goodbye, " + userName + "!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("\nYour Current Balance: " + formatCurrency(userBalance));
    }

    private static void depositMoney(Scanner sc) {
        System.out.print("Enter amount to deposit (₹): ");
        double deposit = sc.nextDouble();

        if (deposit <= 0) {
            System.out.println("Invalid deposit amount. Please try again.");
        } else {
            userBalance += deposit;
            System.out.println("Deposit successful! New Balance: " + formatCurrency(userBalance));
        }
    }

    private static void withdrawMoney(Scanner sc) {
        System.out.print("Enter amount to withdraw (₹): ");
        double withdraw = sc.nextDouble();

        if (withdraw <= 0) {
            System.out.println("Invalid withdrawal amount. Please try again.");
        } else if (withdraw > userBalance) {
            System.out.println("Insufficient funds. Your balance is: " + formatCurrency(userBalance));
        } else {
            userBalance -= withdraw;
            System.out.println("Withdrawal successful! New Balance: " + formatCurrency(userBalance));
        }
    }

    private static void printReceipt() {
        printDashedLine(50);
        System.out.println("\n" + BANK_NAME);
        System.out.println("Customer Name: " + userName);
        System.out.println("Available Balance: " + formatCurrency(userBalance));
        System.out.println("Thank you for banking with us!");
        printDashedLine(50);
    }

    private static String formatCurrency(double amount) {
        // Format the currency to ₹ using the Indian locale
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        return currencyFormat.format(amount);
    }

    private static void printDashedLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
