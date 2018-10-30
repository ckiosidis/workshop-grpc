package workshop.grpc.storage;

import workshop.grpc.model.Transaction;

import java.util.List;

public interface TransactionRepository {
    List<Transaction> list();

    Transaction createAndAddRandomTransaction();
}