package Smarter;

import interfaces.DescriptionCard;
import interfaces.StateCard;
import interfaces.StateCardInput;

import java.util.ArrayList;
import java.util.Arrays;

// TODO for now, this checks only that there is at least a card that respects at least one condition from the given ones
public class OnRightCard<T extends SmarterInput> implements StateCard<T> {
    @Override
    public boolean fire(StateCardInput<T> input) {
        String[] inputRight = Arrays.copyOfRange(input.getStateInput().state, input.getStateInput().inserted + 1, input.getStateInput().state.length);
        boolean result = false;
        for (String inputRightCard: inputRight) {
            for (DescriptionCard descr: input.getDescriptions()) {
                result = result || descr.fire(inputRightCard);
            }
        }
        return result;
    }

    public OnRightCard() {
    }
}
