package graph;

public class Edge
{
	private int NodeA;
	private int NodeB;
	private Float Weight;

	public Edge(int nodeA, int nodeB) {
		NodeA = nodeA;
		NodeB = nodeB;
		Weight = null;
	}

	public Edge(int nodeA, int nodeB, Float weight) {
		NodeA = nodeA;
		NodeB = nodeB;
		Weight = weight;
	}

	public int getNodeA() {
		return NodeA;
	}

	public void setNodeA(int nodeA) {
		NodeA = nodeA;
	}

	public int getNodeB() {
		return NodeB;
	}

	public void setNodeB(int nodeB) {
		NodeB = nodeB;
	}

	public Float getWeight() {
		return Weight;
	}

	public void setWeight(Float weight) {
		Weight = weight;
	}
}
