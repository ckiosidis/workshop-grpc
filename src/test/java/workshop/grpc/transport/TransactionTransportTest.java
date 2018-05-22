package workshop.grpc.transport;

import com.google.common.util.concurrent.Uninterruptibles;
import grpc.workshop.services.BiStreamRequest;
import grpc.workshop.services.BiStreamResponse;
import grpc.workshop.services.ListTransactionsRequest;
import grpc.workshop.services.ListTransactionsResponse;
import grpc.workshop.services.StreamTransactionsRequest;
import grpc.workshop.services.StreamTransactionsResponse;
import grpc.workshop.services.Transaction;
import grpc.workshop.services.TransactionServiceGrpc;
import io.grpc.Channel;
import io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.junit.Ignore;
import org.junit.Test;

import java.time.Instant;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Ignore
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

    @Test
    public void streamTransactionTest() {
        Channel channel = NettyChannelBuilder.forAddress(serverAddress, port)
                .usePlaintext().build();
        TransactionServiceGrpc.TransactionServiceStub stub = TransactionServiceGrpc.newStub(channel);


          stub.streamTransactions(
                StreamTransactionsRequest.getDefaultInstance(),
                new StreamObserver<StreamTransactionsResponse>() {
                    @Override
                    public void onNext(StreamTransactionsResponse value) {
                        print(value.getTransaction());
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onCompleted() {

                    }
                }
        );
        Uninterruptibles.sleepUninterruptibly(50, TimeUnit.SECONDS);
    }


    @Test
    public void bistreamTransactionTest() {
        Random r = new Random();
        Channel channel = NettyChannelBuilder.forAddress(serverAddress, port)
                .usePlaintext().build();
        TransactionServiceGrpc.TransactionServiceStub stub = TransactionServiceGrpc.newStub(channel);

        StreamObserver<BiStreamRequest> request = stub.biStream(new StreamObserver<BiStreamResponse>() {
            @Override
            public void onNext(BiStreamResponse value) {
                print(value.getTransaction());
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onCompleted() {

            }
        });

        while (true) {
            boolean send = r.nextBoolean();
            System.out.println("\n\n"+send);
            request.onNext(BiStreamRequest.newBuilder().setSendPls(send).build());
            Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);

        }
    }


    private void print(Transaction transaction) {
        System.out.println("Transaction: ");
        System.out.println("    id: " + transaction.getId());
        System.out.println("    amount: " + transaction.getAmount());
        System.out.println("    timestamp: " + Instant.ofEpochSecond(transaction.getTimestamp().getSeconds(), transaction.getTimestamp().getNanos()));
    }
}
