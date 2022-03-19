package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class PalindromicNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.PALINDROMIC;
    public PalindromicNumber(Number number) {
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
        var originalNumber = String.valueOf(number.getValue());
        StringBuilder reverseNumber = new StringBuilder();
        for (int i = originalNumber.length() - 1; i >= 0; i--) {
            reverseNumber.append(originalNumber.charAt(i));
        }
        return originalNumber.equals(reverseNumber.toString());
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
