package workshop.grpc.transport;

import grpc.workshop.services.ListTransactionsRequest;
import grpc.workshop.services.ListTransactionsResponse;
import grpc.workshop.services.Transaction;
import grpc.workshop.services.TransactionServiceGrpc;
import io.grpc.Channel;
import io.grpc.netty.NettyChannelBuilder;
import org.junit.Test;

import java.time.Instant;

public class TransactionTransportTest {


    private String serverAddress = "localhost";
    private int port = 12354;

    @Test
    public void listTransactionsTest() {
        Channel channel = NettyChannelBuilder.forAddress(serverAddress, port)
                .usePlaintext().build();
        TransactionServiceGrpc.TransactionServiceBlockingStub stub = TransactionServiceGrpc.newBlockingStub(channel);
        ListTransactionsResponse response = stub.listTransactions(ListTransactionsRequest.getDefaultInstance());
        response.getTransactionsList()
                .stream()
                .forEach(this::print);
        System.out.println("Size: "+response.getTransactionsList().size() + " transactions");
    }


    private void print(Transaction transaction) {
        System.out.println("Transaction: ");
        System.out.println("    id: " + transaction.getId());
        System.out.println("    amount: " + transaction.getAmount());
        System.out.println("    timestamp: " + Instant.ofEpochSecond(transaction.getTimestamp().getSeconds(), transaction.getTimestamp().getNanos()));
    }
}
