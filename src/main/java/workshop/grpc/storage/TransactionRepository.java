package grpc.workshop.storage;

import grpc.workshop.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> list();

    Transaction createAndAddRandomTransaction();
}
