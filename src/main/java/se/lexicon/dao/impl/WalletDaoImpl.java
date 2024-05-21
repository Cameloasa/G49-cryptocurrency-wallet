package se.lexicon.dao.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WalletDaoImpl implements WalletDao {

    //Create a list for the database storage
    private  List< Wallet> storage;

    //Create constructor and initialize a new list
    public WalletDaoImpl() {
        //Print a message for creating and initializing the list
        System.out.println("Creating and initializing the list...");
        this.storage = new ArrayList<>();
    }
    @Override
    public Wallet createWallet(Wallet wallet) {
        //Add wallet to list
        storage.add(wallet);

        //Return wallet
        return wallet;
    }

    @Override
    public Optional<Wallet> findWalletById(String id) {
        //Find wallet in list using stream and filter by id
        Optional<Wallet> optionalWallet = storage.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst();
        return optionalWallet;
    }
}
