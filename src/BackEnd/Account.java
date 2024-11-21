package BackEnd;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
    private int balance;
    private PinSecurity pin;
    private ArrayList<Transaction> transactionList;

    public Account(PinSecurity pin) {
        this.balance = 0;
        this.transactionList = new ArrayList<>();
        this.pin = pin;
    }

    public int getBalance() {
        return this.balance;
    }

    public PinSecurity getPin() {
        return this.pin;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    private void addBalance(int amount) {
        this.balance += amount;
    }

    private void reduceBalance(int amount) {
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        this.transactionList.add(transaction);
        if (transaction.getType() == TransactionType.REVENUE) {
            addBalance(transaction.getAmount());
        } else if (transaction.getType() == TransactionType.EXPENSE) {
            reduceBalance(transaction.getAmount());
        }
    }

    public int validateTransaction(int amount, String type, String note) {
        return Transaction.validateTransaction(amount, type, note, this.balance);
    }

    public static String getErrorMessage(int errorCode) {
        return Transaction.getErrorMessage(errorCode);
    }
}