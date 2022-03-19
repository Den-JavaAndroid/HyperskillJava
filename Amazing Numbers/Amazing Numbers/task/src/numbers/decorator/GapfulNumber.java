package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class GapfulNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.GAPFUL;
    public GapfulNumber(Number number) {
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
        String convertedNumber = String.valueOf(this.value);
        int length = convertedNumber.length();
        if (length > 2) {
            String twoDigits = convertedNumber.charAt(0) + String.valueOf(convertedNumber.charAt(length - 1));
            return this.value % Integer.parseInt(twoDigits) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
