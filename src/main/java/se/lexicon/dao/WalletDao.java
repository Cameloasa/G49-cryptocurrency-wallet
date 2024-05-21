package se.lexicon.dao;

import se.lexicon.model.Wallet;

import java.util.Optional;

public interface WalletDao {

    Wallet createWallet(Wallet wallet);//This should  create new Wallet and return Wallet

    Optional<Wallet> findWalletById(String id);//T should return Optional;

}
