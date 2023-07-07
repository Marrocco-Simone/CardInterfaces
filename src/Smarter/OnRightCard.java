package Smarter;

import interfaces.BooleanExpression;

import java.util.ArrayList;
import java.util.Arrays;

record OnRightCard(SmarterInput input, BooleanExpression[] descriptions) implements BooleanExpression {
    @Override
    public boolean evaluate() {
        String[] inputRight = Arrays.copyOfRange(input.state, input.inserted + 1, input.state.length);
        boolean result = false;
        for (String inputRightCard: inputRight) {
            for (BooleanExpression descr: descriptions) {
                result = result || descr.evaluate();
            }
        }
        return result;
    }
}
