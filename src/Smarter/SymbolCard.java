package Smarter;

import interfaces.BooleanExpression;

import java.util.Arrays;

public record SymbolCard(String card) implements BooleanExpression {
    static String[] SYMBOLS = {"<", ">", "=", ">=", "<+"};

    @Override
    public boolean evaluate() {
        return Arrays.asList(SYMBOLS).contains(card);
    }
}
