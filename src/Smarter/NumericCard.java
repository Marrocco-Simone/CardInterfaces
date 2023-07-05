package Smarter;

import interfaces.DescriptionCard;

public class NumericCard implements DescriptionCard {
    @Override
    public boolean fire(String card) {
        try {
            Integer.parseInt(card);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public NumericCard() {
    }
}
