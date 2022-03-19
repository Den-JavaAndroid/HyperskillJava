package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class BuzzNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.BUZZ;

    public BuzzNumber(Number number) {
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
    public boolean isSupportProperty() {
        var number = this.value;
        return number % 10 == 7 || number % 7 == 0;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
