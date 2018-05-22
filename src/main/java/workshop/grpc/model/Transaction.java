package grpc.workshop.model;

import java.time.Instant;
import java.util.Date;

public class Transaction {
    private long id;
    private double amount;
    private String description;
    private Instant created;

    public Transaction(long id, double amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.created = Instant.now();
    }

    public long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreated() {
        return created;
    }

}
