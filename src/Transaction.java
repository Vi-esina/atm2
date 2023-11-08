package atm.src;

import java.time.LocalDateTime;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime data;

    public Transaction(String type, double amount, LocalDateTime data) {
        this.type = type;
        this.amount = amount;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getData() {
        return data;
    }
}