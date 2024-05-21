package se.lexicon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.model.Cryptocurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Component
public class TransactionManagementImpl implements TransactionManagement {

    //Dependency Injection (DI)
    private WalletDao walletDao;
    private TransactionDao transactionDao;


    @Autowired
    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    @Override
    public Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        //1. Validate params
        if (walletId == null || cryptocurrency == null || amount == null || description == null)
            throw new IllegalArgumentException("All parameters must be not null");
        //2. Check if wallet id exists
        //Create an optional object and filter by id - walletDao
        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId); //Optional<Wallet>
        if ( !optionalWallet.isPresent()) throw new WalletNotFoundException("Wallet not found");
        //Create a new wallet object
        Wallet wallet = optionalWallet.get();
        //3. Call the deposit method on the wallet object
        wallet.deposit(cryptocurrency, amount);
        //4. Create transaction
        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptocurrency.getName());;
        transaction.setDescription(description);
        //5. Save it to the storage
        transactionDao.create(transaction);
        //6. Return the transaction

        return transactionDao.create(transaction);
    }

    @Override
    public Transaction createWithdrawalTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        //1. Validate params
        if (walletId == null || cryptocurrency == null || amount == null || description == null)
            throw new IllegalArgumentException("All parameters must be not null");
        //2. Check if wallet id exists
        //Create an optional object and filter by id - walletDao
        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId); //Optional<Wallet>
        if ( !optionalWallet.isPresent()) throw new WalletNotFoundException("Wallet not found");
        //Create a new wallet object
        Wallet wallet = optionalWallet.get();
        //3. Call the deposit method on the wallet object
        wallet.withdraw(cryptocurrency, amount);
        //4. Create transaction
        Transaction transaction = new Transaction("WITHDRAWAL", amount, walletId, cryptocurrency.getName());;
        transaction.setDescription(description);
        //5. Save it to the storage
        transactionDao.create(transaction);
        //6. Return the transaction
        return transactionDao.create(transaction);
    }



    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        //Create a list object, filter by WalletId, collect and return the list
        List<Transaction> transactionsList = transactionDao.findTransactionsByWalletId(walletId);
        if (transactionsList == null) throw new WalletNotFoundException("Wallet not found");
        return transactionsList;
    }
}
