// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: services.proto

package grpc.workshop.services;

public interface ListTransactionsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:ListTransactionsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Transaction transactions = 1;</code>
   */
  java.util.List<grpc.workshop.services.Transaction> 
      getTransactionsList();
  /**
   * <code>repeated .Transaction transactions = 1;</code>
   */
  grpc.workshop.services.Transaction getTransactions(int index);
  /**
   * <code>repeated .Transaction transactions = 1;</code>
   */
  int getTransactionsCount();
  /**
   * <code>repeated .Transaction transactions = 1;</code>
   */
  java.util.List<? extends grpc.workshop.services.TransactionOrBuilder> 
      getTransactionsOrBuilderList();
  /**
   * <code>repeated .Transaction transactions = 1;</code>
   */
  grpc.workshop.services.TransactionOrBuilder getTransactionsOrBuilder(
      int index);
}