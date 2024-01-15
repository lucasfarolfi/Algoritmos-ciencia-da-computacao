package graph;

import graph.enums.SearchType;
import graph.representation.IGraphRepresentation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static graph.enums.SearchType.DFS;


public class GraphManager {
	private final IGraphRepresentation graph;
	private final String inputGraphFilePath;
	private final String outputGraphDirectory;

	public GraphManager(IGraphRepresentation graph, String inputGraphFilePath, String outputGraphDirectory) {
		this.graph = graph;
		this.inputGraphFilePath = inputGraphFilePath;
		this.outputGraphDirectory = outputGraphDirectory;
		this.buildGraphFromFile();
	}

	public void buildGraphFromFile() {
		try {
			this.convertFileToGraph();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void convertFileToGraph() throws IOException {
		System.out.println("Reading file");

		try(var reader = new BufferedReader(new FileReader(this.inputGraphFilePath))) {
			String line = reader.readLine();
			var numberOfVertex = Integer.parseInt(line);
			var edges = new ArrayList<Edge>();

			while ((line = reader.readLine()) != null) {
				String[] values = line.split(" ");
				int nodeA = Integer.parseInt(values[0]);
				int nodeB = Integer.parseInt(values[1]);

				var weight = values.length == 3 ? Float.parseFloat(values[2]) : null;

				edges.add(new Edge(nodeA, nodeB, weight));
//				System.out.println(String.format("%d %d %s", nodeA, nodeB, (weight == null ? "" : weight.toString())));
			}
			this.graph.initialize(numberOfVertex, edges);
			System.out.println("End of file reading");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public void generateTree(SearchType searchMethod) {
		String tree;
		if(searchMethod.getType() == DFS.getType()) {
			tree = graph.getDfsTree();
		} else {
			tree = graph.getBfsTree();
		}

		var  filename = graph.getClass().getSimpleName() + (searchMethod.getType() == DFS.getType() ? "-dfs-":"-bfs-")  + "node-levels.txt";
		try {
			FileWriter myWriter = new FileWriter(this.outputGraphDirectory + filename);
			myWriter.write(tree);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	public void showConnectComponents()
	{
		graph.findAndShowConnectedComponents(this.outputGraphDirectory);
	}

	public void generateGraphOutput() {
		var n = graph.getNumberOfNodes();
		var m = graph.getNumberOfEdges();
		var d = this.calculateAverageDegree();

		try(var writer = new BufferedWriter(new FileWriter(this.outputGraphDirectory + graph.getClass().getSimpleName() + "-output.txt"))){
			writer.write(String.format("# n = %s\n", n));
			writer.write(String.format("# m = %s\n", m));
			writer.write(String.format("# d = %s\n", d));

			int maxDegree = this.graph.getMaximumDegree();
			for (int i = 1; i <= maxDegree; i++) {
				Float frequency = (float) this.graph.getNumberOfNodesByDegree(i) / this.graph.getNumberOfNodes();
				writer.write(String.format("%d %s", i, frequency));
				if(i != maxDegree) writer.newLine();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private float calculateAverageDegree() {
		int degreeCount = 0;
		for (int node = 0; node < this.graph.getNumberOfNodes(); node++) {
			degreeCount += this.graph.getNodeDegree(node);
		}
		return (float) degreeCount / this.graph.getNumberOfNodes();
	}


	public float calculateDistance(int startNode, int endNode) {

		var response = graph.calculateShortestPath(startNode, endNode);
		var shortestPath = response.values().stream().findFirst().orElse(null);
		if (shortestPath.isEmpty()) {
			return Float.POSITIVE_INFINITY; // Nenhum caminho encontrado
		} else {
			return calculatePathWeight(shortestPath);
		}
	}

	public List<List<Integer>> calculateShortestPathFromNode(int startNode, int endNode) {

		graph.calculateShortestPath(startNode, endNode);
		List<List<Integer>> shortestPaths = new ArrayList<>();

//		for (int endNode = 0; endNode < graph.getNumberOfNodes(); endNode++) {
//			if (startNode != endNode) {
//				List<Integer> shortestPath = graph.calculateShortestPath(startNode, endNode);
//				shortestPaths.add(shortestPath);
//			} else {
//				shortestPaths.add(new ArrayList<>(List.of(startNode)));
//			}
//		}
//
		return shortestPaths;
	}

	public void showDistanceOfNodes(int startNode, int endNode){
		float distance = calculateDistance(startNode, endNode);

		// Verifica se a distância é válida
		if (distance >= 0) {
			System.out.println("A distância entre " + startNode + " e " + endNode + " é: " + distance);
		} else {
			System.out.println("Não é possível alcançar o vértice de destino a partir do vértice de origem.");
		}
	}

	public void showShortestPathFromNode(int startNode, int endNode){
		List<List<Integer>> shortestPaths = calculateShortestPathFromNode(startNode, endNode);

		// Imprime a distância e o caminho mínimo entre o vértice de partida e todos os outros vértices
//		for (int endNode = 0; endNode < shortestPaths.size(); endNode++) {
//			if (endNode != startNode) {
//				List<Integer> shortestPath = shortestPaths.get(endNode);
//				int distance = shortestPath.size() - 1; // A distância é o número de arestas no caminho mínimo
//				System.out.println("Distância entre " + startNode + " e " + endNode + ": " + distance);
//				System.out.println("Caminho mínimo: " + shortestPath);
//				System.out.println();
//			}
//		}
	}

	private float calculatePathWeight(List<Integer> path) {
		float weight = 0.0f;
		for (int i = 0; i < path.size() - 1; i++) {
			int currentNode = path.get(i);
			int nextNode = path.get(i + 1);
			weight += graph.calculateEdgeWeight(currentNode, nextNode);
		}
		return weight;
	}

	public void writeMinimumSpanningTreeToFile() {
		List<Edge> minimumSpanningTree = graph.findMinimumSpanningTree();

		String filename = outputGraphDirectory + graph.getClass().getSimpleName() + "-mst.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			float totalWeight = 0.0f;
			writer.write("Aresta \tPeso\n");

			for (Edge edge : minimumSpanningTree) {
				writer.write(edge.getNodeA() + " - " + edge.getNodeB() + "\t" + edge.getWeight() + "\n");
				totalWeight += edge.getWeight();
			}

			writer.write("\nPeso máximo: " + totalWeight);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public void getAverageDistance() {
		double averageDistance = graph.calculateAverageDistance();
		System.out.println("Distância média: " + averageDistance + "\n");
	}
}
