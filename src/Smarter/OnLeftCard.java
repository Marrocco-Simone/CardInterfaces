package Smarter;

import interfaces.BooleanExpression;

import java.util.Arrays;

record OnLeftCard(SmarterInput input, BooleanExpression[] descriptions) implements BooleanExpression {
    @Override
    public boolean evaluate() {
        String[] inputLeft = Arrays.copyOfRange(input.state, 0, input.inserted);
        boolean result = false;
        for (String inputLeftCard: inputLeft) {
            for (BooleanExpression descr: descriptions) {
                result = result || descr.evaluate();
            }
        }
        return result;
    }
}
