package com.ritwik.quantcast;

/**
 * 
 * @author ritwik.kumar
 *
 */
public class Token {
    public enum TokenType {
        VALUE, REFERENCE, OP_ADD, OP_SUBSTRACT, OP_MULTIPLY, OP_DIVIDE, OP_INCREMENT, OP_DECREMENT;
    }
    private TokenType type;
    private double value;
    private int referenceRow;
    private int referenceColumn;

    public Token(final TokenType type) {
        this.type = type;
    }

    public Token(final String reference) {
        // reference is like A2, B1
        type = TokenType.REFERENCE;
        referenceRow = reference.charAt(0) - 65;
        referenceColumn = Integer.valueOf(reference.substring(1)) - 1;
    }

    public Token(final double val) {
        type = TokenType.VALUE;
        value = val;
    }

    public TokenType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public int getReferenceRow() {
        return referenceRow;
    }

    public int getReferenceColumn() {
        return referenceColumn;
    }

}
