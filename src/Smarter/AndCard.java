package Smarter;

import interfaces.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record AndCard(BooleanExpression left, BooleanExpression right) implements BooleanExpression {
    @Override
    public boolean evaluate() {
        return left().evaluate() && right().evaluate();
    }

    public static void main(String[] args) {
        String[] state = {"2", "3", "=", "4", "<"};
        int inserted = 2;
        SmarterInput stateInput = new SmarterInput(state, inserted);

        boolean b = new AndCard(
                new NumericCard("5"),
                new AndCard(new SymbolCard(">"), new NumericCard("5"))
        ).evaluate();
        System.out.println(b);


    }
}
