package graph.representation;

class Path implements Comparable<Path>
{
    Path predecessor;
    float cost;
    int id;

    Path(Path _predecessor, float _cost, int _id)
    {
        this.predecessor = _predecessor;
        this.cost = _cost;
        this.id = _id;
    }

    @Override
    public int compareTo(Path other) {
        return Float.compare(cost, other.cost);
    }
}