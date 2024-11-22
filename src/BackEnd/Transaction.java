package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public class Transaction implements Serializable {
    private int amount;
    private String note;
    private TransactionType type;
    private Date date;

    public Transaction(int amount, String note, TransactionType type) {
        this.amount = amount;
        this.note = note.trim();
        this.type = type;
        this.date = new Date(String.valueOf(LocalDate.now().getDayOfMonth()), String.valueOf(LocalDate.now().getMonthValue()), String.valueOf(LocalDate.now().getYear()));
    }

    public int getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public static int validateTransaction(int amount, String type, String note, int balance) {
        if (amount < 1000) {
            return 1; // Jumlah minimal 1000
        }
        if (type.equals("Pengeluaran") && amount > balance) {
            return 2; // Saldo tidak cukup
        }
        if (note.isEmpty()) {
            return 3; // Catatan tidak boleh kosong
        }
        return 0; // Valid
    }

    public static String getErrorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Jumlah harus lebih dari 1000";
            case 2:
                return "Saldo tidak mencukupi";
            case 3:
                return "Catatan tidak boleh kosong";
            default:
                return "Unknown error";
        }
    }
}