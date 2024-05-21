package se.lexicon.dao.impl;

import se.lexicon.dao.TransactionDao;
import se.lexicon.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TransactionDaoImpl implements TransactionDao {

    //Create a list of transactions  in the database

    private List<Transaction> storage;

    //Create a constructor and initialize a list of transactions

    public TransactionDaoImpl() {
        this.storage = new ArrayList<>();
    }

    //Create a new transaction
    @Override
    public Transaction create(Transaction transaction) {
        storage.add(transaction);
        return transaction;
    }

    //Find transaction by id
    @Override
    public Optional<Transaction> findById(String transactionId) {
        //Create an optional object, filter by id,return first
        Optional<Transaction> optionalTransaction = storage.stream().
                filter(transaction -> transaction.getId().equals(transactionId)).
                findFirst();
        return optionalTransaction;
    }

    @Override
    public List<Transaction> findTransactionsByWalletId(String walletId) {
        //Create a list object, filter by WalletId, collect and return the list
        List<Transaction> transactionsList = storage.stream().
                filter(transaction -> transaction.getWalletId().equals(walletId)).
                collect(Collectors.toList());
        return transactionsList;
    }
}
