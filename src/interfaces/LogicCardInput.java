package interfaces;

public interface LogicCardInput <
        Tl extends LogicCard & StateCard,
        Tli extends LogicCardInput & StateCardInput,
        Tr extends LogicCard & StateCard,
        Tri extends LogicCardInput & StateCardInput
        > {
    Tl getLeft();
    Tli getLeftInput();
    Tr getRight();
    Tri getRightInput();
}

