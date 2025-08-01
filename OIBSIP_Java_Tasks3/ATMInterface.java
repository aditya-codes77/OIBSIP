import java.util.*;

class ATMInterface {
    static Scanner scanner = new Scanner(System.in);
    static double balance = 5000.00;
    static String transactionHistory = "";

    public static void main(String[] args) {
        String userId = "Aditya123";
        String userPin = "4321";

        System.out.println("===== Welcome to Java ATM =====\n");
        System.out.print("Enter User ID: ");
        String inputId = scanner.nextLine();

        System.out.print("Enter PIN: ");
        String inputPin = scanner.nextLine();

        if (userId.equals(inputId) && userPin.equals(inputPin)) {
            System.out.println("\nLogin successful!\n");
            showMenu();
        } else {
            System.out.println("\nInvalid credentials. Access denied.");
        }
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("==== ATM Menu ====");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    showTransactionHistory();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    transfer();
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (choice != 5);
    }

    public static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.\n");
        } else {
            System.out.println("=== Transaction History ===");
            System.out.println(transactionHistory + "\n");
        }
    }

    public static void withdraw() {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Withdrawn: ₹" + amount + "\n";
            System.out.println("Withdrawal successful. Current balance: ₹" + balance + "\n");
        } else {
            System.out.println("Insufficient balance or invalid amount.\n");
        }
    }

    public static void deposit() {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            transactionHistory += "Deposited: ₹" + amount + "\n";
            System.out.println("Deposit successful. Current balance: ₹" + balance + "\n");
        } else {
            System.out.println("Invalid deposit amount.\n");
        }
    }

    public static void transfer() {
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter recipient's name: ");
        String recipient = scanner.nextLine();

        System.out.print("Enter amount to transfer: ₹");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory += "Transferred ₹" + amount + " to " + recipient + "\n";
            System.out.println("Transfer to " + recipient + " successful. Current balance: ₹" + balance + "\n");
        } else {
            System.out.println("Transfer failed due to insufficient balance or invalid amount.\n");
        }
    }
} 
