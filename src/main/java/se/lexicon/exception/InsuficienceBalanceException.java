package se.lexicon.exception;

public class InsuficienceBalanceException extends RuntimeException {
    public InsuficienceBalanceException(String message) {
        super(message);
    }

    public InsuficienceBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}
