package numbers;

import numbers.decorator.*;
import numbers.format.DisplayFormatter;
import numbers.format.KeyValueFormat;
import numbers.format.PropertiesFormat;
import numbers.number.AmazingNumber;
import numbers.number.Number;
import numbers.number.NumberTypeProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static numbers.number.NumberTypeProperty.*;

public class AmazingNumberController {
    private final String firstParameterNotNaturalMessage = "The first parameter should be a natural number or zero.";
    private final String secondParameterNotNaturalMessage = "The second parameter should be a natural number.";
    private List<String> availableProperties = Arrays.stream(values()).map(NumberTypeProperty::getName).collect(Collectors.toList());

    public AmazingNumberController(String userInput) {
        DisplayFormatter formatter = new KeyValueFormat();
        String[] params = userInput.split(" ");
        long firstNumber = Long.parseLong(params[0]);
        long end = firstNumber + 1;
        if (firstNumber < 0) {
            System.out.println(firstParameterNotNaturalMessage);
            return;
        }
        int secondNumber = 0;
        if (params.length > 1) {
            secondNumber = Integer.parseInt(params[1]);
            if (secondNumber < 1) {
                System.out.println(secondParameterNotNaturalMessage);
                return;
            }
            end = firstNumber + secondNumber;
            formatter = new PropertiesFormat();
        }

        String[] propertiesForSearch = null;
        if (params.length >= 3) {
            propertiesForSearch = Arrays.copyOfRange(params, 2, params.length);
            for (int i = 0; i < propertiesForSearch.length; i++) {
                propertiesForSearch[i] = propertiesForSearch[i].toLowerCase();
            }
        }

        List<List<String>> exclusiveProperties = List.of(List.of(EVEN.getName(), ODD.getName()), List.of(DUCK.getName(), SPY.getName()), List.of(SQUARE.getName(), SUNNY.getName()), List.of(SAD.getName(), HAPPY.getName()));

        List<String> incorrectProperties = null;
        if (params.length >= 3) {
            formatter = new PropertiesFormat();
            incorrectProperties = findIncorrectProperties(propertiesForSearch);
            if (!incorrectProperties.isEmpty()) {
                if (incorrectProperties.size() > 1) {
                    printWrongPropertiesMessage(String.join(",", incorrectProperties), String.valueOf(availableProperties));
                    return;
                } else {
                    printWrongPropertyMessage(incorrectProperties.get(0), String.valueOf(availableProperties));
                    return;
                }
            }

            if (params.length >= 4) {
                List<String> paramsList = Stream.of(propertiesForSearch).sorted().collect(Collectors.toList());
                for (int i = 0; i < exclusiveProperties.size(); i++) {
                    if (paramsList.containsAll(exclusiveProperties.get(i))) {
                        printExclusivePropertyMessages(exclusiveProperties.get(i).get(0), exclusiveProperties.get(i).get(1));
                        return;
                    } else {
                        if (paramsList.containsAll(exclusiveProperties.get(i).stream().map(p -> "-" + p).collect(Collectors.toList()))) {
                            printExclusivePropertyMessages("-" + exclusiveProperties.get(i).get(0), "-" + exclusiveProperties.get(i).get(1));
                            return;
                        }
                    }
                }
                for (int i = 0; i < availableProperties.size(); i++) {
                    List<String> exclusiveProperty = List.of(availableProperties.get(i), "-" + availableProperties.get(i));
                    if (paramsList.containsAll(exclusiveProperty)) {
                        printExclusivePropertyMessages(exclusiveProperty.get(0), exclusiveProperty.get(1));
                        return;
                    }
                }
            }

        }

        if (propertiesForSearch != null) {
            List<String> filterForNotContainsProperty = new ArrayList<>();
            List<String> filterForContainsProperty = new ArrayList<>();
            for (int i = 0; i < propertiesForSearch.length; i++) {
                if (propertiesForSearch[i].contains("-")) {
                    filterForNotContainsProperty.add(propertiesForSearch[i].replace("-", "").toLowerCase());
                } else {
                    filterForContainsProperty.add(propertiesForSearch[i]);
                }
            }

            int counter = 0;
            while (counter < secondNumber) {
                Number amazingNumber = decoratedAmazingNumber(formatter, firstNumber);
                String output = amazingNumber.getDescription().toLowerCase();
                String[] outputValues = output.split(" ");
                String[] foundedParams = Arrays.copyOfRange(outputValues, 2, outputValues.length);
                if (!filterForNotContainsProperty.isEmpty()) {
                    if (Arrays.asList(foundedParams).containsAll(filterForContainsProperty) && !Arrays.asList(foundedParams).containsAll(filterForNotContainsProperty)) {
                        System.out.println(output);
                        counter++;
                    }
                } else {
                    if (Arrays.asList(foundedParams).containsAll(filterForContainsProperty)) {
                        System.out.println(output);
                        counter++;
                    }
                }
                firstNumber++;
            }
        }
        if (params.length <= 2) {
            for (var i = firstNumber; i < end; i++) {
                Number amazingNumber = decoratedAmazingNumber(formatter, i);
                System.out.println(amazingNumber.getDescription());
            }
        }
    }


    private List<String> findIncorrectProperties(String[] propertiesForSearch) {
        ArrayList<String> incorrectProperties = new ArrayList<>();
        for (int i = 0; i < propertiesForSearch.length; i++) {
            if (isIncorrectProperty(propertiesForSearch[i])) {
                incorrectProperties.add(propertiesForSearch[i]);
            }
        }
        return incorrectProperties;
    }

    private void printWrongPropertyMessage(String propertyName, String availableProperties) {
        System.out.printf("The property [%s] is wrong.\n" +
                "Available properties: %s", propertyName.toUpperCase(), availableProperties.toUpperCase());
    }

    private void printExclusivePropertyMessages(String propertyName1, String propertyName2) {
        System.out.printf("The request contains mutually exclusive properties: [%s, %s]\n" +
                "There are no numbers with these properties.", propertyName1.toUpperCase(), propertyName2.toUpperCase());
    }

    private void printWrongPropertiesMessage(String properties, String availableProperties) {
        System.out.printf("The properties [%s] are wrong.\n" +
                "Available properties: %s", properties.toUpperCase(), availableProperties.toUpperCase());
    }

    private boolean isIncorrectProperty(String propertyName) {
        List<String> availablePropertiesIncludingMinus = availableProperties;
        availablePropertiesIncludingMinus.addAll(availableProperties.stream().map(p -> "-" + p).collect(Collectors.toList()));
        return !availablePropertiesIncludingMinus.contains(propertyName.toLowerCase());
    }

    private Number decoratedAmazingNumber(DisplayFormatter formatter, long firstNumber) {
        Number amazingNumber = new AmazingNumber(firstNumber, formatter);
        amazingNumber = new BuzzNumber(amazingNumber);
        amazingNumber = new SadNumber(amazingNumber);
        amazingNumber = new HappyNumber(amazingNumber);
        amazingNumber = new JumpingNumber(amazingNumber);
        amazingNumber = new DuckNumber(amazingNumber);
        amazingNumber = new PalindromicNumber(amazingNumber);
        amazingNumber = new GapfulNumber(amazingNumber);
        amazingNumber = new SpyNumber(amazingNumber);
        amazingNumber = new SquareNumber(amazingNumber);
        amazingNumber = new SynnyNumber(amazingNumber);
        amazingNumber = new EvenNumber(amazingNumber);
        amazingNumber = new OddNumber(amazingNumber);
        return amazingNumber;
    }
}