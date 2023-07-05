package Smarter;

import interfaces.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndCard<
        I extends SmarterInput,
        Tl extends StateCard<I> & LogicCard,
        Tli extends StateCardInput<I> & LogicCardInput,
        Tr extends StateCard<I> & LogicCard,
        Tri extends StateCardInput<I> & LogicCardInput
        > implements LogicCard<I, Tl, Tli, Tr, Tri> {
    @Override
    public boolean fire(Tl left, Tli leftInput, Tr right, Tri rightInput) {
        return left.fire(leftInput) && right.fire(rightInput);
    }

    public AndCard() {
    }

    public static void main(String[] args) {
        String[] state = {"2", "3", "=", "4", "<"};
        int inserted = 2;
        SmarterInput stateInput = new SmarterInput(state, inserted);
        return new AndCard().fire(
                new OnLeftCard(),
                new StateCardInputImpl<SmarterInput>(stateInput, new ArrayList<DescriptionCard>() {{
                    add(new NumericCard());
                }}),
                new OnRightCard(),
                new StateCardInputImpl<SmarterInput>(stateInput, new ArrayList<DescriptionCard>() {{
                    add(new SymbolCard());
                    add(new NumericCard());
                }})
        );
    }
}
