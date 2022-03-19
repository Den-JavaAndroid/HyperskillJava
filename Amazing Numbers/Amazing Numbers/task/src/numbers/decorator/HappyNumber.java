package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class HappyNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.HAPPY;

    public HappyNumber(Number number) {
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
        var result = number;
        while (result != 1 && result != 4) {
            result = isHappyNumber(result);
        }
        return result == 1;
    }

    private long isHappyNumber(long number) {
        long rem = 0, sum = 0;
        while (number > 0) {
            rem = number % 10;
            sum = sum + (rem * rem);
            number = number / 10;
        }
        return sum;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
