package MarkAshleyCrump;

public class Main {
        //these are tests that I implemented to see if all the different methods work
        //this is how I was able to verify that the different methods work
    public static void main(String[] args) {
        Customer customer = new Customer("bob");
        Account account = new Account(customer,5000);
        account.deposit(1000,"12/08/1994");
        account.withdraw(2000,"12/05/2010");
        account.transfer(1000,account,"12/04/2015");
        account.statement();
        account.printTransfers();
        account.printDeposits();
        account.printWithdraws();
        account.printDates();
    }
}
