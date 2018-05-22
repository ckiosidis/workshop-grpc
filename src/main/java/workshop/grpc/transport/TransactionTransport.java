package workshop.grpc.transport;

import grpc.workshop.services.BiStreamRequest;
import grpc.workshop.services.ListTransactionsRequest;
import grpc.workshop.services.ListTransactionsResponse;
import grpc.workshop.services.StreamTransactionsRequest;
import grpc.workshop.services.StreamedTransactionResponse;
import grpc.workshop.services.Transaction;
import grpc.workshop.services.TransactionServiceGrpc;
import io.grpc.stub.StreamObserver;
import workshop.grpc.storage.TransactionRepository;
import workshop.grpc.transport.mapper.TransactionMapper;
import java.util.List;

public class TransactionTransport extends TransactionServiceGrpc.TransactionServiceImplBase {

    private TransactionRepository transactionRepository;

    public TransactionTransport(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void listTransactions(ListTransactionsRequest request, StreamObserver<ListTransactionsResponse> responseObserver) {
        System.out.println("list transactions");

        List<workshop.grpc.model.Transaction> coreTransactions = transactionRepository.list();
        List<Transaction> grpcTransactions  = TransactionMapper.translate(coreTransactions);

        responseObserver.onNext(
                ListTransactionsResponse
                        .newBuilder()
                        .addAllTransactions(grpcTransactions)
                        .build()
        );
        responseObserver.onCompleted();
    }

    @Override
    public void streamTransactions(StreamTransactionsRequest request, StreamObserver<StreamedTransactionResponse> responseObserver) {
        System.out.println("stream transactions");

        while(true) {

            workshop.grpc.model.Transaction coreTransaction = transactionRepository.createAndAddRandomTransaction();
            Transaction grpcTransaction = TransactionMapper.translate(coreTransaction);

            responseObserver.onNext(
                    StreamedTransactionResponse
                            .newBuilder()
                            .setTransaction(grpcTransaction)
                            .build()
            );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public StreamObserver<BiStreamRequest> biStream(StreamObserver<StreamedTransactionResponse> responseObserver) {
        System.out.println("bidirectional stream");

        return new StreamObserver<BiStreamRequest>() {
            @Override
            public void onNext(BiStreamRequest streamingRequest) {
                if (streamingRequest.getRequestsTransaction()) {

                    workshop.grpc.model.Transaction coreTransaction = transactionRepository.createAndAddRandomTransaction();
                    Transaction grpcTransaction = TransactionMapper.translate(coreTransaction);

                    responseObserver.onNext(
                            StreamedTransactionResponse
                                    .newBuilder()
                                    .setTransaction(grpcTransaction)
                                    .build()
                    );
                }
            }

            @Override
            public void onError(Throwable t) {
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

}