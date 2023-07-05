package interfaces;

import java.util.ArrayList;

public class StateCardInputImpl  <T extends GameInput> implements StateCardInput {
    T stateInput;
    ArrayList<DescriptionCard> descriptions;

    @Override
    public T getStateInput() {
        return stateInput;
    }

    @Override
    public ArrayList<DescriptionCard> getDescriptions() {
        return descriptions;
    }

    public StateCardInputImpl(T input, ArrayList<DescriptionCard> descriptions) {
        this.input = input;
        this.descriptions = descriptions;
    }
}
