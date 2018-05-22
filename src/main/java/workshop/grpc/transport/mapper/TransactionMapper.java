package workshop.grpc.transport.mapper;

import com.google.protobuf.Timestamp;
import grpc.workshop.services.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    public static Transaction translate(workshop.grpc.model.Transaction transaction) {
        Transaction.Builder builder = Transaction.newBuilder();
        return builder
                .setId(Long.toString(transaction.getId()))
                .setAmount(transaction.getAmount())
                .setTimestamp(Timestamp
                        .newBuilder()
                        .setSeconds(transaction.getCreated().getEpochSecond()).setNanos(transaction.getCreated().getNano()))
                .build();
    }

    public static List<Transaction> translate(List<workshop.grpc.model.Transaction> transactions) {
        return transactions
                .stream()
                .map(TransactionMapper::translate)
                .collect(Collectors.toList());
    }
}
