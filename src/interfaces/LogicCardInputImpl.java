package interfaces;

public class LogicCardInputImpl<
        Tl extends LogicCard & StateCard,
        Tli extends LogicCardInput & StateCardInput,
        Tr extends LogicCard & StateCard,
        Tri extends LogicCardInput & StateCardInput
        > implements LogicCardInput {
    Tl left;
    Tli leftInput;
    Tr right;
    Tri rightInput;

    @Override
    public Tl getLeft() {
        return left;
    }

    @Override
    public Tli getLeftInput() {
        return leftInput;
    }

    @Override
    public Tr getRight() {
        return right;
    }

    @Override
    public Tri getRightInput() {
        return rightInput;
    }

    public LogicCardInputImpl(Tl left, Tli leftInput, Tr right, Tri rightInput) {
        this.left = left;
        this.leftInput = leftInput;
        this.right = right;
        this.rightInput = rightInput;
    }
}
