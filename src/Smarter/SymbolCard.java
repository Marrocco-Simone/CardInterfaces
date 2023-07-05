package Smarter;

import interfaces.DescriptionCard;

import java.util.Arrays;

public class SymbolCard implements DescriptionCard {
    String[] SYMBOLS = {"<", ">", "=", ">=", "<+"};
    @Override
    public boolean fire(String card) {
        return Arrays.asList(SYMBOLS).contains(card);
    }

    public SymbolCard() {
    }
}
