package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class DuckNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.DUCK;

    public DuckNumber(Number number) {
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
        return String.valueOf(number.getValue()).contains("0");
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
