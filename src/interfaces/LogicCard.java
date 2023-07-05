package interfaces;

import Smarter.SmarterInput;

public interface LogicCard <
        I extends GameInput,
        Tl extends LogicCard & StateCard<I>,
        Tli extends LogicCardInput & StateCardInput<I>,
        Tr extends LogicCard & StateCard<I>,
        Tri extends LogicCardInput & StateCardInput<I>
        > {
    // TODO use LogicCardInput
    boolean fire(Tl left, Tli leftInput, Tr right, Tri rightInput);
}


