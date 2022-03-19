package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class SpyNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.SPY;

    public SpyNumber(Number number) {
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
        var convertedNumber = String.valueOf(number.getValue());
        var summ = 0;
        var product = 1;
        for (int i = 0; i <= convertedNumber.length()-1; i++) {
            int numberAtPosition = Integer.parseInt(convertedNumber.charAt(i) + "");
            summ += numberAtPosition;
            product *= numberAtPosition;
        }
        return summ == product;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
