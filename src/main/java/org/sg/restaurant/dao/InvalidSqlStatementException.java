package org.sg.restaurant.dao;

public class InvalidSqlStatementException extends Exception {
    public InvalidSqlStatementException(String message) {
        super(message);
    }
}
