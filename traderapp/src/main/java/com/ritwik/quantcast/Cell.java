package com.ritwik.quantcast;

import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import com.ritwik.quantcast.Token.TokenType;

public class Cell {
    private String name;
    private double evaluatedValue;
    private boolean evaluated;
    private ArrayList<String> references = new ArrayList<String>();
    private ArrayList<Token> tokens = new ArrayList<Token>();
    private int edgeCount;

    /**
     * 
     * @param input
     */
    public void setInput(final String input) {
        final StringTokenizer st = new StringTokenizer(input);
        while (st.hasMoreTokens()) {
            final String token = st.nextToken();
            if ("+".equals(token)) {
                tokens.add(new Token(TokenType.OP_ADD));
            } else if ("-".equals(token)) {
                tokens.add(new Token(TokenType.OP_SUBSTRACT));
            } else if ("*".equals(token)) {
                tokens.add(new Token(TokenType.OP_MULTIPLY));
            } else if ("/".equals(token)) {
                tokens.add(new Token(TokenType.OP_DIVIDE));
            } else if ("++".equals(token)) {
                tokens.add(new Token(TokenType.OP_INCREMENT));
            } else if ("--".equals(token)) {
                tokens.add(new Token(TokenType.OP_DECREMENT));
            } else {
                final char c = token.charAt(0);
                if ('A' <= c && c <= 'Z') {
                    // reference to other cell, reference is like A2, B1
                    tokens.add(new Token(token));
                    references.add(token);
                } else {
                    // integer
                    tokens.add(new Token(Double.valueOf(token)));
                }
            }
        }
    }

    /**
     * 
     * @return
     * @throws Exception
     */
    public double evaluate() {
        if (evaluated) {
            return evaluatedValue;
        }

        final Stack<Double> stack = new Stack<Double>();
        double eval, val2, val1;
        for (final Token token : tokens) {
            switch (token.getType()) {
                case VALUE:
                    stack.push(token.getValue());
                    break;
                case REFERENCE:
                    final Cell reference = Spreadsheet.cells[token.getReferenceRow()][token.getReferenceColumn()];
                    eval = reference.evaluate();
                    stack.push(eval);
                    break;
                case OP_ADD:
                    val1 = stack.pop();
                    val2 = stack.pop();
                    eval = val2 + val1;
                    stack.push(eval);
                    break;
                case OP_SUBSTRACT:
                    val1 = stack.pop();
                    val2 = stack.pop();
                    eval = val2 - val1;
                    stack.push(eval);
                    break;
                case OP_MULTIPLY:
                    val1 = stack.pop();
                    val2 = stack.pop();
                    eval = val2 * val1;
                    stack.push(eval);
                    break;
                case OP_DIVIDE:
                    val1 = stack.pop();
                    val2 = stack.pop();
                    eval = val2 / val1;
                    stack.push(eval);
                    break;
                case OP_INCREMENT:
                    val1 = stack.pop();
                    eval = val1 + 1;
                    stack.push(eval);
                    break;
                case OP_DECREMENT:
                    val1 = stack.pop();
                    eval = val1 - 1;
                    stack.push(eval);
                    break;
            }
        }
        evaluatedValue = stack.pop();
        evaluated = true;
        return evaluatedValue;
    }

    public ArrayList<String> getReferences() {
        return references;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(int edgeCount) {
        this.edgeCount = edgeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
