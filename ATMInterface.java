import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String cName, String cId) {
        customerName = cName;
        customerId = cId;
    }

    public final void clrscr() {
        try {
            try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime();
            } else {
                Runtime.getRuntime();
            }
        } catch (final Exception e) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
    } catch (final Exception es) {
        // System.out.println("Nothing here!");
    }

    }

    void checkId() {
        clrscr();
        System.out.println("Welcome " + customerName);
        System.out.println();
        System.out.print("Please enter the Customer ID or PIN number: ");
        try (Scanner id = new Scanner(System.in)) {
            String chk = id.nextLine();
            if (chk.equals(customerId)) {
                clrscr();
                showMenu();
            } else {
                System.out.println("=============");
                System.out.println("Wrong Login!!");
                System.out.println("=============");

                if (flag < 3) {
                    flag++;
                    checkId();
                }
            }
        }
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            clrscr();
            System.out.println("===================================================");
            System.out.println("Sufficient Balance not available for the withdrawl!");
            System.out.println("===================================================");
        }
    }

    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction has occured. ");
        }
    }

    public void transfer(double amount, BankAccount acc) {
        if (this.balance < amount) {
            clrscr();
            System.out.println("============================================");
            System.out.println("Transfer Failed due to insufficient balance!");
            System.out.println("============================================");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + acc.customerName + " becomes $" + acc.balance);
            System.out.println("\n");
        }
    }

    private void showMenu() {
        char option;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Welcome " + customerName);
            System.out.println("Your ID is  " + customerId);
            do {
                System.out.println("\n");
                System.out.println("\n");
                System.out.println("1. Previous Transaction");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Check Balance");
                System.out.println("5. Transfer");
                System.out.println("6. Exit");

                System.out.println("================");
                System.out.println("Enter the option");
                System.out.println("================");
                option = sc.next().charAt(0);
                option = Character.toUpperCase(option);
                System.out.println("\n");

                switch (option) {
                    case '1':
                        clrscr();
                        System.out.println("================");
                        getPrevTransaction();
                        System.out.println("================");
                        System.out.println("\n");
                        
                        break;

                    case '2':
                        clrscr();
                        System.out.println("====================================================");
                        System.out.println("Enter the amount of money to deposit in the account:");
                        System.out.println("====================================================");
                        int amount = sc.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                        System.out.println("The amount of money deposited in your account is  $ "+ amount);
                        break;
                    
                    case '3':
                        clrscr();
                        System.out.println("=======================================================");
                        System.out.println("Enter the amount of money to withdrawn from the account:");
                        System.out.println("=======================================================");
                        int amount2 = sc.nextInt();
                        withdraw(amount2);
                        System.out.println("\n");
                        System.out.println("The amount of money withdrawn from your account is  $ "+ amount2);
                        System.out.println("Please collect your money!!!");

                        break;

                    case '4':
                        clrscr();
                        System.out.println("================");
                        System.out.println("Balance " + balance);
                        System.out.println("================");
                        System.out.println("\n");
                        System.out.println("The current balance is $ "+balance);
                        break;

                    case '5':
                        clrscr();
                        System.out.println("****************************");
                        System.out.println("To whom");
                        BankAccount bb = new BankAccount("Ram", "1235");
                        System.out.println(bb.customerName);
                        System.out.println("****************************");
                        System.out.println("Amount of money  to Transfer");
                        double am = sc.nextDouble();
                        System.out.println("****************************");
                        transfer(am, bb);
                        break;

                    case '6':
                        clrscr();
                        System.exit(0);
                        break;
                    
                    default:
                        clrscr();
                        System.out.println("Invalid Option!!! Please Enter Again");
                }

            } while (option != 'F');
        }
        System.out.println("Thank You For using our services!!!");

    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Tanuj", "1234");
        ba.checkId();
    }

}
