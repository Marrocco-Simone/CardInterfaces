package interfaces;

import java.util.ArrayList;

public interface StateCardInput <T extends GameInput> {
    T getStateInput();
    ArrayList<DescriptionCard> getDescriptions();
}
