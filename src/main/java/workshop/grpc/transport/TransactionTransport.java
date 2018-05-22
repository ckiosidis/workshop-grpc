package workshop.grpc.transport;

import grpc.workshop.services.ListTransactionsRequest;
import grpc.workshop.services.ListTransactionsResponse;
import grpc.workshop.services.TransactionServiceGrpc;
import io.grpc.stub.StreamObserver;

public class TransactionTransport extends TransactionServiceGrpc.TransactionServiceImplBase {
    @Override
    public void listTransactions(ListTransactionsRequest request, StreamObserver<ListTransactionsResponse> responseObserver) {
        responseObserver.onNext(
                ListTransactionsResponse.getDefaultInstance()
        );
        responseObserver.onCompleted();
    }
}
