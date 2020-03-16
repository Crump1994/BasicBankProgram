package MarkAshleyCrump;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Account {
    private Customer customer;
    private int balance;
    private HashMap<String, ArrayList<Integer>> withdraws = new HashMap<String, ArrayList<Integer>>();
    private HashMap<String, ArrayList<Integer>> deposits = new HashMap<String, ArrayList<Integer>>();
    private HashMap<String, ArrayList<Integer>> transfers = new HashMap<String, ArrayList<Integer>>();


    public Account(Customer customer, int balance) {
        this.customer = customer;
        this.balance = balance;
    }

    public void deposit(int deposit, String date) {
        balance = balance + deposit;
        if(deposits.get(date) == null) {
            deposits.put(date, new ArrayList<Integer>());
        }
        deposits.get(date).add(deposit);
    }

    public void withdraw(int withdraw, String date) {
        balance = balance - withdraw;
        if(withdraws.get(date) == null) {
            withdraws.put(date, new ArrayList<Integer>());
        }
        withdraws.get(date).add(withdraw);
    }

    public void receiveTransfer(int transfer, String date) {
        balance = balance + transfer;
        if(transfers.get(date) == null) {
            transfers.put(date, new ArrayList<Integer>());
        }
        transfers.get(date).add(transfer);
    }

    public void statement() {
        System.out.println("Statement for " + customer.getName());
        System.out.println("Balance: " + balance);
        printWithdraws();
        printDeposits();
        printTransfers();
    }

    public void transfer(int amount, Account receiver, String date) {
        balance = balance - amount;
        receiver.receiveTransfer(amount, date);
    }

    public void printWithdraws() {
        System.out.println("Withdraws:");
        for(Map.Entry<String, ArrayList<Integer>> entry : withdraws.entrySet()) {
            System.out.println(entry.getKey());
            for(Integer amount: entry.getValue()) {
                System.out.println(amount);
            }
        }
    }

    public void printDeposits() {
        System.out.println("Deposits:");
        for(Map.Entry<String, ArrayList<Integer>> entry : deposits.entrySet()) {
            System.out.println(entry.getKey());
            for(Integer amount: entry.getValue()) {
                System.out.println(amount);
            }
        }
    }

    public void printTransfers() {
        System.out.println("Transfers:");
        for(Map.Entry<String, ArrayList<Integer>> entry : transfers.entrySet()) {
            System.out.println(entry.getKey());
            for(Integer amount: entry.getValue()) {
                System.out.println(amount);
            }
        }
    }

    public void printDates() {
        System.out.println("Transfers:");
        for(Map.Entry<String, ArrayList<Integer>> entry : transfers.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("Deposits:");
        for(Map.Entry<String, ArrayList<Integer>> entry : deposits.entrySet()) {
            System.out.println(entry.getKey());
        }
        System.out.println("Withdraws:");
        for(Map.Entry<String, ArrayList<Integer>> entry : withdraws.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
