package Smarter;

import interfaces.DescriptionCard;
import interfaces.GameInput;
import interfaces.StateCard;
import interfaces.StateCardInput;

import java.util.ArrayList;
import java.util.Arrays;

// TODO for now, this checks only that there is at least a card that respects at least one condition from the given ones
public class OnLeftCard <T extends SmarterInput> implements StateCard<T> {
    @Override
    public boolean fire(StateCardInput<T> input) {
        String[] inputLeft = Arrays.copyOfRange(input.getStateInput().state, 0, input.getStateInput().inserted);
        boolean result = false;
        for (String inputLeftCard: inputLeft) {
            for (DescriptionCard descr: input.getDescriptions()) {
                result = result || descr.fire(inputLeftCard);
            }
        }
        return result;
    }

    public OnLeftCard() {
    }
}
