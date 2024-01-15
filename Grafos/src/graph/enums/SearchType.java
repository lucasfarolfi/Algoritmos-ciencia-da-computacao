package graph.enums;

public enum SearchType {
    DFS(1),
    BFS(2);

    private final int type;

    SearchType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static SearchType getValue(int enumType) {
        for (var type : values()) {
            if (type.getType() == enumType) {
                return type;
            }
        }
        throw new RuntimeException("An error was occurred. Search type does not exist!");
    }
}
