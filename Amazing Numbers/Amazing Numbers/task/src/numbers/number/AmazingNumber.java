package numbers.number;

import numbers.format.DisplayFormatter;

public class AmazingNumber extends Number {

    public AmazingNumber(long value, DisplayFormatter displayFormatter) {
        this.displayFormatter = displayFormatter;
        this.value = value;
    }

    @Override
    public String getDescription() {
        return displayFormatter.start(this.value);
    }

}
