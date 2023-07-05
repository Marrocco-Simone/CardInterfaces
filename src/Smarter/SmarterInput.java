package Smarter;

import interfaces.GameInput;

public class SmarterInput implements GameInput {
    String[] state;
    int inserted;

    SmarterInput(String[] state, int inserted) {
        this.state = state;
        this.inserted = inserted;
    }
}
