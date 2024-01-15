package graph.enums;

public enum EGraphRepresentation {
    LIST(1),
    MATRIX(2);

    private final int type;

    EGraphRepresentation(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static EGraphRepresentation getValue(int enumType) {
        for (var type : values()) {
            if (type.getType() == enumType) {
                return type;
            }
        }
        throw new RuntimeException("An error was occurred. Graph representation does not exist!");
    }
}
