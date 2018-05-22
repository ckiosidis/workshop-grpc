package workshop.grpc.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;

import java.util.Objects;

public class HeaderKeyValidationInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {
        Metadata.Key<String> secret = Metadata.Key.of("SECRET", Metadata.ASCII_STRING_MARSHALLER);
//        if (!Objects.equals(headers.get(secret), "4321")) {
//            call.close(Status.UNAUTHENTICATED, new Metadata());
//        }
        return next.startCall(call, headers);
    }
}