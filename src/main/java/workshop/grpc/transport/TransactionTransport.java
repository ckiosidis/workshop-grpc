package workshop.grpc.transport;

import io.grpc.stub.StreamObserver;
import workshop.grpc.services.generated.ListTransactionsRequest;
import workshop.grpc.services.generated.ListTransactionsResponse;
import workshop.grpc.services.generated.Transaction;
import workshop.grpc.services.generated.TransactionServiceGrpc;
import workshop.grpc.storage.TransactionRepository;
import workshop.grpc.transport.converter.TransactionMapper;

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
}
