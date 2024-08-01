package intern.freedesk.authentication.model;

public enum Status {
    ACTIVE(1),
    PASSIVE(0);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
