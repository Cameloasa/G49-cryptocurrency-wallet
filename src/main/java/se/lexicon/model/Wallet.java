package se.lexicon.model;

import java.math.BigDecimal;
import java.security.CryptoPrimitive;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Wallet {

    private final String id;//uuid
    private final String walletName;//name
    private final Map<Cryptocurrency, BigDecimal> cryptocurrencies;//enumeration, bigdecimal for amount


    //Constructor
    public Wallet(String walletName) {
        this.id = UUID.randomUUID().toString();
        this.walletName = walletName;
        this.cryptocurrencies = new HashMap<>();
    }

    //Getters


    public String getId() {
        return id;
    }

    public String getWalletName() {
        return walletName;
    }

    public Map<Cryptocurrency, BigDecimal> getCryptocurrencies() {
        return cryptocurrencies;
    }

    //Method for balance
    public BigDecimal getBalance(Cryptocurrency cryptocurrency) {
        //if not exist, return 0, else return amount
        return cryptocurrencies.getOrDefault(cryptocurrency, BigDecimal.ZERO);

    }

    //Method for adding
    public void deposit(Cryptocurrency cryptocurrency, BigDecimal amount) {
        //Validate if is not null
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit must be greater than 0, cannot be null");
        //get to balance
        BigDecimal currentBalance = getBalance(cryptocurrency);
        //add to balance
        BigDecimal newBalance = currentBalance.add(amount);
        //add to map -storage
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    //Method for withdraw

    public void withdraw(Cryptocurrency cryptocurrency, BigDecimal amount) {
        //Validate if is not null
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdraw must be greater than 0, cannot be null");
        //get to balance
        BigDecimal currentBalance = getBalance(cryptocurrency);
        //subtract from balance
        BigDecimal newBalance = currentBalance.subtract(amount);
        //add to map -storage
        cryptocurrencies.put(cryptocurrency, newBalance);

    }
    //toString for description

    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", walletName='" + walletName + '\'' +
                ", cryptocurrencies=" + cryptocurrencies +
                '}';
    }
}

