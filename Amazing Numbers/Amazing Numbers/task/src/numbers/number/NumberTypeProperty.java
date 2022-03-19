package numbers.number;

public enum NumberTypeProperty {
    EVEN("even"),
    ODD("odd"),
    BUZZ("buzz"),
    DUCK("duck"),
    PALINDROMIC("palindromic"),
    GAPFUL("gapful"),
    SPY("spy"),
    SAD("sad"),
    HAPPY("happy"),
    SUNNY("sunny"),
    SQUARE("square"),
    JUMPING("jumping");

    private final String name;

    NumberTypeProperty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
