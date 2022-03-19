package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class SynnyNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.SUNNY;

    public SynnyNumber(Number number) {
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
        var number = this.value + 1;
        double sqrt = Math.sqrt(number);
        return ((sqrt - Math.floor(sqrt)) == 0);
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
