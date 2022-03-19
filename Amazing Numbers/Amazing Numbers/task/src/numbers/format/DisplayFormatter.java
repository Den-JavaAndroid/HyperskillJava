package numbers.format;

import numbers.decorator.NumberWrapper;

public interface DisplayFormatter {

    String start(long number);

    String display(NumberWrapper number);
}