package interfaces;

import java.util.ArrayList;

public interface StateCard <T extends GameInput> {
     boolean fire(StateCardInput<T> input);
}
