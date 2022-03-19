package numbers.format;

import numbers.decorator.NumberWrapper;

public class PropertiesFormat implements DisplayFormatter {

    @Override
    public String start(long number) {
        return "\n\t\t" + number + " is";
    }

    @Override
    public String display(NumberWrapper numberWrapper) {
        if (numberWrapper.isSupportProperty() ) {
            return " " + numberWrapper;
        }
        return "";
    }
}