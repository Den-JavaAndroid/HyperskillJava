package numbers.decorator;

import numbers.number.Number;
import numbers.number.NumberTypeProperty;

public class JumpingNumber extends NumberWrapper {
    private final Number number;
    private final boolean isSupportProperty;
    private final NumberTypeProperty property = NumberTypeProperty.JUMPING;

    public JumpingNumber(Number number) {
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
        var num = this.value;
        boolean isJumpingNumber = true;
        while (num != 0) {
            long digit1 = num % 10;
            num = num / 10;
            if (num != 0) {
                long digit2 = num % 10;
                if (Math.abs(digit1 - digit2) != 1) {
                    isJumpingNumber = false;
                    break;
                }
            }
        }
        return isJumpingNumber;
    }

    @Override
    public String toString() {
        return property.getName();
    }
}
