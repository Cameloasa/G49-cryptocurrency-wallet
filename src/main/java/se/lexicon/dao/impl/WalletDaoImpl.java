package se.lexicon.dao.impl;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.Optional;

public class WalletDaoImpl implements WalletDao {
    @Override
    public Wallet createWallet(Wallet walletName) {
        return null;
    }

    @Override
    public Optional<Wallet> findWalletById(String id) {
        return Optional.empty();
    }
}
