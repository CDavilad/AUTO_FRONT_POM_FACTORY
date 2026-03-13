package utils;

public enum Priority {
    HIGH("Alta"),
    MEDIUM("Media"),
    LOW("Baja");

    private final String displayText;

    Priority(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public static Priority fromString(String text) {
        for (Priority priority : values()) {
            if (priority.name().equalsIgnoreCase(text)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Unknown priority: " + text);
    }
}
