package se.lexicon.model;

public enum Cryptocurrency {
    BTC("Bitcoin"),
    ETH("Ethereum"),
    USDT("TetherUs"),
    BNB("BNB");

    private final String name;

    public String getName() {
        return name;
    }

    Cryptocurrency(String name) {
        this.name = name;
    }


}
