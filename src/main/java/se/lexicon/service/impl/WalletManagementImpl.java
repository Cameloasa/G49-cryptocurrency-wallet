package se.lexicon.service.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.exception.WalletNotFoundException;
import se.lexicon.exception.WalletValidationException;
import se.lexicon.model.Wallet;
import se.lexicon.service.WalletManagement;

import java.util.Optional;

public class WalletManagementImpl implements WalletManagement {

    //dependency injection from WalletDao and WalletDaoImpl
    private WalletDao walletDao;

    //Constructor

    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }
    // In this class we will check all the validation rules

    @Override
    public Wallet create(String walletName) {
        //
        if (walletName == null)
            throw new WalletValidationException("Wallet name cannot be null or empty", "walletName");

        //Create a new wallet object
        Wallet wallet = new Wallet(walletName);

        //Create a new wallet in the database and return it
        return  walletDao.createWallet(wallet);

    }

    @Override
    public Wallet getById(String id) {

        //create an optional object
        Optional<Wallet> optionalWallet = walletDao.findWalletById(id);

        if (optionalWallet.isPresent())
            return optionalWallet.get();
        throw new WalletNotFoundException("Wallet not found");
    }
}
