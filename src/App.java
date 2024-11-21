import BackEnd.*;
import FrontEnd.LoginPage;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Brieftasche brieftasche = new Brieftasche();
        brieftasche.loadTransactionsFromFile("transactions.dat");

        // Add dummy data if no users are loaded
        if (brieftasche.getUserCount() == 0) {
            addDummyData(brieftasche);
        }

        // Start the application
        new LoginPage(brieftasche).setVisible(true);

        // Add a shutdown hook to save transactions on exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            brieftasche.saveTransactionsToFile("transactions.dat");
        }));
    }

    private static void addDummyData(Brieftasche brieftasche) {
        brieftasche.addNewUser("Yerry",
                                new PasswordSecurity("Yerry2510"),
                                new Address("Jawa Timur", "Surabaya", "Mulyosari", "80"),
                                new Date("25", "10", "2005"),
                                new PinSecurity('2', '5', '1', '0'));

        User user1 = brieftasche.getUsers().get(0);
        user1.getAccount().addTransaction(new Transaction(2000000, "Uang Saku Oktober", TransactionType.REVENUE));
        user1.getAccount().addTransaction(new Transaction(10000, "Makan pagi", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(10000, "Makan siang", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(10000, "Kentanggggg", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(28000, "Laundy", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(250000, "Beli Bulanan", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(10000, "Beli sarapan", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(35000, "Beli makan siang", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(160000, "Dinner", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(45000, "Uang kas", TransactionType.EXPENSE));
        user1.getAccount().addTransaction(new Transaction(500000, "Tambahan Uang Saku", TransactionType.REVENUE));
        user1.getAccount().addTransaction(new Transaction(35000, "Laundryyy", TransactionType.EXPENSE));

        brieftasche.addNewUser("ElangBesar",
                                new PasswordSecurity("Elang1234"),
                                new Address("Province", "City", "Street", "123"),
                                new Date("01", "01", "1990"),
                                new PinSecurity('1', '2', '3', '4'));
        User user2 = brieftasche.getUsers().get(1);

        user2.getAccount().addTransaction(new Transaction(250000, "Nilai Awal", TransactionType.REVENUE));
        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            int amount = 1000 + random.nextInt(100000 - 1000 + 1);
            String note = (i % 2 == 0) ? "Expense " + i : "Revenue " + i;
            TransactionType type = (i % 2 == 0) ? TransactionType.EXPENSE : TransactionType.REVENUE;
            user2.getAccount().addTransaction(new Transaction(amount, note, type));
        }
    }
}