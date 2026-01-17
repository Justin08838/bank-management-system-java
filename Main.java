import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Helper method to find account by account number
    private static Account findAccount(ArrayList<Account> accounts, int accNo) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("   BANK MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View Account Details");
            System.out.println("6. View All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1: // Create account
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine(); // consume newline

                    if (findAccount(accounts, accNo) != null) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    accounts.add(new Account(accNo, name, balance));
                    System.out.println("Account created successfully!");
                    break;

                case 2: // Deposit
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account accDeposit = findAccount(accounts, accNo);
                    if (accDeposit == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter Deposit Amount: ");
                    double deposit = sc.nextDouble();
                    accDeposit.deposit(deposit);
                    break;

                case 3: // Withdraw
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account accWithdraw = findAccount(accounts, accNo);
                    if (accWithdraw == null) {
                        System.out.println("Account not found!");
                        break;
                    }

                    System.out.print("Enter Withdrawal Amount: ");
                    double withdraw = sc.nextDouble();
                    accWithdraw.withdraw(withdraw);
                    break;

                case 4: // Check balance
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account accBalance = findAccount(accounts, accNo);
                    if (accBalance == null) {
                        System.out.println("Account not found!");
                    } else {
                        System.out.println("Current Balance: " + accBalance.getBalance());
                    }
                    break;

                case 5: // View account details
                    System.out.print("Enter Account Number: ");
                    accNo = sc.nextInt();

                    Account accDetails = findAccount(accounts, accNo);
                    if (accDetails == null) {
                        System.out.println("Account not found!");
                    } else {
                        accDetails.displayDetails();
                    }
                    break;

                case 6: // View all accounts
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (Account acc : accounts) {
                            acc.displayDetails();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Thank you for using the Bank Management System.");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 7);

        sc.close();
    }
              }
