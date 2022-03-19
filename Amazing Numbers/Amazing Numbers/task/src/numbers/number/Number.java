package numbers.number;

import numbers.format.DisplayFormatter;

public abstract class Number {
    protected long value;
    protected DisplayFormatter displayFormatter;
    public abstract String getDescription();
    public long getValue() {
        return value;
    }

    public DisplayFormatter getDisplayFormatter() {
        return displayFormatter;
    }

}
