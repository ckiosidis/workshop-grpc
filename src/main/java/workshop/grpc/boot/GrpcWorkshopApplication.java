package workshop.grpc.boot;

public class GrpcWorkshopApplication {
    public static void main(String[] args) throws Exception {
        GrpcServer server = new GrpcServer();
        server.start();
        server.blockUntilShutdown();
    }
}
