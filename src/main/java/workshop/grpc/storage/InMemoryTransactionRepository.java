package workshop.grpc.storage;

import com.google.common.collect.Lists;
import workshop.grpc.model.Transaction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InMemoryTransactionRepository implements TransactionRepository {
    private AtomicLong counter;
    private List<Transaction> transactions;
    private Random random;

    public InMemoryTransactionRepository() {
        counter = new AtomicLong();
        transactions = Lists.newArrayList();
        random = new Random();
    }

    public List<Transaction> list() {
        if (transactions.isEmpty()) {
            transactions.add(createNewTransaction());
        }
        return transactions;
    }

    public Transaction createAndAddRandomTransaction() {
        Transaction t = createNewTransaction();
        transactions.add(t);
        return t;
    }

    private Transaction createNewTransaction() {
        List<String> stringAsList = Arrays.asList("This is a long random description, that is going to be shuffled");
        Collections.shuffle(stringAsList);
        String description = stringAsList.stream().collect(Collectors.joining(" "));
        Transaction t = new Transaction(
                counter.incrementAndGet(),
                random.nextDouble(),
                description
        );
        return t;
    }
}
