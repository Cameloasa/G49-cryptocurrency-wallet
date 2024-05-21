package se.lexicon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private String id;//the id of the transaction
    private String type; //withdraw or deposit
    private BigDecimal amount;//the amount of the transaction
    private String walletId;//the id of the wallet
    private String cryptocurrencySymbol;//the symbol of the cryptocurrency
    private String description;//the description of the transaction
    private LocalDateTime timestamp;//the date and time of the transaction


    //Constructor to fetch data from database
    public Transaction(String id, String type, BigDecimal amount, String walletId, String cryptocurrencySymbol, String description, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.description = description;
        this.timestamp = timestamp;
    }
    //Constructor to create new transaction
    public Transaction(String type, BigDecimal amount, String walletId, String cryptocurrencySymbol, String description, LocalDateTime timestamp) {
        //Validation for amount
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be positive");

        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getCryptocurrencySymbol() {
        return cryptocurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //toString method for description
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", cryptocurrencySymbol='" + cryptocurrencySymbol + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

