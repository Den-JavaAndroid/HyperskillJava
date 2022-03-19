package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class EvenNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.EVEN;
    public EvenNumber(Number number) {
        this.number = number;
        this.value = number.getValue();
        this.isSupportProperty = isSupportProperty();
        this.displayFormatter = number.getDisplayFormatter();
    }

    @Override
    public String getDescription() {
        return number.getDescription() + displayFormatter.display(this);
    }

    @Override
    public  boolean isSupportProperty() {
        return number.getValue() % 2 == 0;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
