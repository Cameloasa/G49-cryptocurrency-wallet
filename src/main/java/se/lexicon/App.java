package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.AppConfig;
import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;
import se.lexicon.dao.impl.TransactionDaoImpl;
import se.lexicon.dao.impl.WalletDaoImpl;
import se.lexicon.model.Cryptocurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;
import se.lexicon.service.WalletManagement;
import se.lexicon.service.impl.TransactionManagementImpl;
import se.lexicon.service.impl.WalletManagementImpl;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {

        //WalletDao walletDao = new WalletDaoImpl();
        //WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        //System.out.println(wallet);
        //TransactionDao transactionDao = new TransactionDaoImpl();
        //TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);
        Wallet wallet = walletManagement.create("my-first-wallet");

        Transaction depositTransactionForBTC = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.BTC,
                new BigDecimal(10),
                "Test transaction");
        Transaction depositTransactionForETH = transactionManagement.createDepositTransaction(
                wallet.getId(),
                Cryptocurrency.ETH,
                new BigDecimal(5),
                "Test transaction");
        System.out.println(walletManagement.getById(wallet.getId()));

    }
}






















