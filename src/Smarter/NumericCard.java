package Smarter;

import interfaces.BooleanExpression;

public record NumericCard(String card) implements BooleanExpression {
    @Override
    public boolean evaluate() {
        try {
            Integer.parseInt(card);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}