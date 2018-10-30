package workshop.grpc.transport.converter;

import com.google.protobuf.Timestamp;
import workshop.grpc.model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionMapper {
    public static workshop.grpc.services.generated.Transaction translate(Transaction transaction) {
        workshop.grpc.services.generated.Transaction.Builder builder = workshop.grpc.services.generated.Transaction.newBuilder();
        return builder
                .setId(Long.toString(transaction.getId()))
                .setAmount(transaction.getAmount())
                .setTimestamp(Timestamp
                        .newBuilder()
                        .setSeconds(transaction.getCreated().getEpochSecond()).setNanos(transaction.getCreated().getNano()))
                .build();
    }

    public static List<workshop.grpc.services.generated.Transaction> translate(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(TransactionMapper::translate)
                .collect(Collectors.toList());
    }

}
