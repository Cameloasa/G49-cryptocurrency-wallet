package se.lexicon.dao;

import se.lexicon.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDao {
    //Create a new transaction
    Transaction create(Transaction transaction);
    //Find transaction by id
    Optional<Transaction> findById(String transactionId);
    //Find transaction by wallet id
    List<Transaction> findTransactionsByWalletId(String walletId);

}
