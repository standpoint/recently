package task.generated;

public enum TypeContry {

    UKRAINE("Ukraine");
    private final String value;

    TypeContry(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeContry fromValue(String v) {
        for (TypeContry c: TypeContry.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
