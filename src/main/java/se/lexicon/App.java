package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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

public class App
{
    public static void main( String[] args ) {

        //Create a wallet dao object
        //WalletDao walletDao = new WalletDaoImpl();
        //Create a wallet management object
        //WalletManagement walletManagement = new WalletManagementImpl(walletDao);
        //create a wallet object
        //Wallet wallet = walletManagement.create("My wallet");

        //System.out.println(wallet);


        //Create a transaction dao object
        //TransactionDao transactionDao = new TransactionDaoImpl();
        //Create a transaction management object
        //TransactionManagement transactionManagement = new TransactionManagementImpl(walletDao, transactionDao);
        //create a transaction object
        //Transaction transaction = new Transaction("DEPOSIT", 10, "My wallet", "Bitcoin");


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        WalletManagement walletManagement = context.getBean(WalletManagement.class);
        Wallet wallet = walletManagement.create("My wallet");
        System.out.println(wallet);
        TransactionManagement transactionManagement = context.getBean(TransactionManagement.class);

        //Create a deposit transaction with Bitcoin
        Transaction depositTransactionForBitcoin = transactionManagement.createDepositTransaction
                (wallet.getId(),
                        Cryptocurrency.BTC,
                        new BigDecimal(10),
                        "Test transaction");
        System.out.println(depositTransactionForBitcoin);
        //Create a withdrawal transaction with Ethereum
        Transaction depositTransactionForEthereum = transactionManagement.createDepositTransaction
                (wallet.getId(),
                        Cryptocurrency.ETH,
                        new BigDecimal(5),
                        "Test transaction");
        System.out.println(depositTransactionForEthereum);



















    }
}
