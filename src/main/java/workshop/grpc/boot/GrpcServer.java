package workshop.grpc.boot;

import io.grpc.Server;
import io.grpc.ServerInterceptors;
import io.grpc.netty.NettyServerBuilder;
import workshop.grpc.interceptor.HeaderKeyValidationInterceptor;
import workshop.grpc.storage.InMemoryTransactionRepository;
import workshop.grpc.transport.TransactionTransport;

import java.io.IOException;

public class GrpcServer {

    private Server server;

    public GrpcServer() {
    }

    public void start() throws IOException {
        NettyServerBuilder serverBuilder = NettyServerBuilder.forPort(12354);

        TransactionTransport transactionTransport = new TransactionTransport(new InMemoryTransactionRepository());

        serverBuilder.addService(ServerInterceptors.intercept(transactionTransport, new HeaderKeyValidationInterceptor()));

        server = serverBuilder.build()
                .start();
        System.out.println("gRPC server running...");

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                GrpcServer.this.stop();
            }
        });
    }

    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private void stop() {
        server.shutdownNow();
    }
}
