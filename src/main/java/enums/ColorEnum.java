package enums;

public enum ColorEnum {
    RED("RED"),
    BLUE("BLUE"),
    BLACK("BLACK"),
    YELLOW("YELLOW"),
    GRAY("GRAY"),
    PURPLE("PURPLE");

    private String description;

    ColorEnum(String descrition) {
        this.description = descrition;
    }

    public String getDescription() {
        return description;
    }
}
