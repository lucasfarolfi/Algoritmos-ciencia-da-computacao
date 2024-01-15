package graph.representation;


import graph.Edge;

import java.util.List;
import java.util.Map;

public interface IGraphRepresentation {
	void initialize(int numberOfVertex, List<Edge> edges);
	void addEdge(Edge edge);
	int getNumberOfEdges();
	int getNumberOfNodes();
	int getNodeDegree(int node);
	int getNumberOfNodesByDegree(int degree);
	int getMaximumDegree();
	String getDfsTree();
	String getBfsTree();
	void findAndShowConnectedComponents(String outputGraphDirectory);
	Map<Float, List<Integer>> calculateShortestPath(int startNode, int endNode);
	float calculateEdgeWeight(int nodeA, int nodeB);
	List<Edge> findMinimumSpanningTree();
	double calculateAverageDistance();
}
