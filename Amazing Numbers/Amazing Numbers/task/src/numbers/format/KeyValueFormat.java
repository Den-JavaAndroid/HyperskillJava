package numbers.format;

import numbers.decorator.NumberWrapper;

public class KeyValueFormat implements DisplayFormatter {

    @Override
    public String start(long number) {
        return "\nProperties of " + number;
    }

    @Override
    public String display(NumberWrapper number) {
        return String.format("\n\t%s: %s", number.toString(), number.isSupportProperty());
    }
}