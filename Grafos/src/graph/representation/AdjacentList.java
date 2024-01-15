package graph.representation;

import graph.Edge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AdjacentList implements IGraphRepresentation {

	private ArrayList<LinkedList<Integer>> adjacentList;
	private List<Edge> edges;
	
	public AdjacentList() { }
	
	public void initialize(int numberOfVertex, List<Edge> edges) {
		this.edges = edges;
		this.adjacentList = new ArrayList<LinkedList<Integer>>(numberOfVertex+1);
		//Primeira linha do array ta vazio pq o grafo come�a sempre com 1
		for (int i = 0; i < numberOfVertex; i++) {
			adjacentList.add(new LinkedList<Integer>());
		}
		
		for (Edge edge : this.edges) {
			this.addEdge(edge);
		}
		
	}

	@Override
	public void addEdge(Edge edge) {
		var nodeA = edge.getNodeA() - 1;
		var nodeB = edge.getNodeB() - 1;

		adjacentList.get(nodeA).add(nodeB);
		adjacentList.get(nodeB).add(nodeA);
	}

	@Override
	public int getNumberOfNodes() {
		return this.adjacentList.size();
	}

	@Override
	public int getNodeDegree(int node) {
		return this.adjacentList.get(node).size();
	}

	@Override
	public int getNumberOfNodesByDegree(int degree) {
		var count = 0; 
		for (int node = 0; node < getNumberOfNodes(); node++) {
			if (this.getNodeDegree(node) == degree) {
				count++;
			}
		}
		return count;
	}

	@Override
	public int getMaximumDegree() {
		int maxDegree = 0;
		for (int i = 0; i < this.getNumberOfNodes(); i++) {
			var degree = this.getNodeDegree(i);
			if(maxDegree < degree) {
				maxDegree = degree;
			}
		}
		return maxDegree;
	}

	@Override
	public String getDfsTree() {
		StringBuilder tree = new StringBuilder();
		var visited = new boolean[adjacentList.size()];
		int root = 0;
		dfs(root, tree, visited, 0);
		return tree.toString();
	}

	@Override
	public String getBfsTree() {
		StringBuilder tree = new StringBuilder();
		var visited = new boolean[adjacentList.size()];
		int root = 0;
		bfs(root, tree, visited);
		return tree.toString();
	}

	public void bfs(int startNode, StringBuilder tree, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[startNode] = true;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();
			int level = getLevel(currentNode, startNode);
			String log = String.format("NODE: %d - LEVEL: %d\n", currentNode + 1, level);
			tree.append(log);

			LinkedList<Integer> neighbors = adjacentList.get(currentNode);
			for (int neighbor : neighbors) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					queue.offer(neighbor);
				}
			}
		}
	}

	private void dfs(int startNode, StringBuilder tree, boolean[] visited, int level) {
		visited[startNode] = true;
		String log = String.format("NODE: %d - LEVEL: %d\n", startNode + 1, level);
		tree.append(log);

		LinkedList<Integer> neighbors = adjacentList.get(startNode);
		for (int neighbor : neighbors) {
			if (!visited[neighbor]) {
				dfs(neighbor, tree, visited, level + 1);
			}
		}
	}
	@Override
	public void findAndShowConnectedComponents(String outputGraphDirectory) {
		List<List<Integer>> connectedComponents = new ArrayList<>();
		boolean[] visited = new boolean[adjacentList.size()];

		for (int node = 0; node < adjacentList.size(); node++) {
			if (!visited[node]) {
				List<Integer> connectedComponent = new ArrayList<>();
				dfs(node, visited, 0, connectedComponent);
				connectedComponents.add(connectedComponent);
			}
		}

		// Ordenar as componentes conexos em ordem decrescente de tamanho
		connectedComponents.sort((a, b) -> b.size() - a.size());

		var  filePath = outputGraphDirectory + this.getClass().getSimpleName() + "-connectedComponents.txt";
		try {
			FileWriter myWriter = new FileWriter(filePath);
			myWriter.write("Número de componentes conexos: " + connectedComponents.size() +"\n\n");

			for (int i = 0; i < connectedComponents.size(); i++) {
				myWriter.write("Componente: #" + (i+1) +"\n");

				var component = connectedComponents.get(i)
						.stream().collect(Collectors.toSet());

				// Imprimir o tamanho do componente
				myWriter.write("Tamanho do componente " + (i + 1) + ": " + component.size() +"\n");

				// Imprimir os vértices pertencentes ao componente
				myWriter.write("Vértices do componente " + (i + 1) + ": " + component +"\n\n");
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private void dfs(int startNode, boolean[] visited, int level, List<Integer> connectedComponent) {
		Stack<Integer> stack = new Stack<>();
		stack.push(startNode);

		while (!stack.isEmpty()) {
			int currentNode = stack.pop();
			visited[currentNode] = true;
			connectedComponent.add(currentNode + 1); // Adiciona o nó atual à componente conexa

			LinkedList<Integer> neighbors = adjacentList.get(currentNode);
			for (int neighbor : neighbors) {
				if (!visited[neighbor]) {
					stack.push(neighbor);
				}
			}
		}
	}

	private int getLevel(int node, int startNode) {
		int level = 0;
		int currentNode = node;
		while (currentNode != startNode) {
			currentNode = getParent(currentNode);
			level++;
		}
		return level;
	}

	private int getParent(int node) {
		for (int i = 0; i < adjacentList.size(); i++) {
			if (adjacentList.get(i).contains(node)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int getNumberOfEdges() {
		return this.edges.size();
	}

	public float calculateShortestDistance(int startNode, int endNode) {
		if (startNode == endNode) {
			return 0.0f; // O nó inicial é o mesmo que o nó de destino, a distância é zero
		}

		float[] distances = new float[adjacentList.size()];
		Arrays.fill(distances, Float.MAX_VALUE); // Inicializa todas as distâncias como infinito
		distances[startNode] = 0.0f; // Define a distância do nó inicial como zero

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> distances[node]));
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			if (currentNode == endNode) {
				return distances[currentNode]; // Retorna a distância mínima até o nó de destino
			}

			LinkedList<Integer> neighbors = adjacentList.get(currentNode);
			for (int neighbor : neighbors) {
				float weight = calculateEdgeWeight(currentNode, neighbor);

				if (weight >= 0.0f && distances[currentNode] + weight < distances[neighbor]) {
					distances[neighbor] = distances[currentNode] + weight;
					queue.offer(neighbor);
				}
			}
		}

		return -1.0f; // Caso não seja possível alcançar o nó de destino a partir do nó inicial
	}

	@Override
	public Map<Float, List<Integer>> calculateShortestPath(int startNode, int endNode) {
		List<Integer> shortestPath = new ArrayList<>();
		var response = new HashMap<Float, List<Integer>>();
		if (startNode == endNode) {
			shortestPath.add(startNode);
			response.put(0f, shortestPath);
			return response;
			// O nó inicial é o mesmo que o nó de destino, retorna uma lista com um único nó
		}

		float[] distances = new float[adjacentList.size()];
		int[] parents = new int[adjacentList.size()];
		Arrays.fill(distances, Float.MAX_VALUE); // Inicializa todas as distâncias como infinito
		Arrays.fill(parents, -1); // Inicializa todos os pais como -1 (não visitado)
		distances[startNode] = 0.0f; // Define a distância do nó inicial como zero

		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> distances[node]));
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			if (currentNode == endNode) {
				// Constrói o caminho mínimo a partir dos pais
				int node = endNode;
				while (node != -1) {
					shortestPath.add(0, node);
					node = parents[node];
				}
				response.put(0f, shortestPath);
			}

			LinkedList<Integer> neighbors = adjacentList.get(currentNode);
			for (int neighbor : neighbors) {
				float weight = calculateEdgeWeight(currentNode, neighbor);

				if (distances[currentNode] + weight < distances[neighbor]) {
					distances[neighbor] = distances[currentNode] + weight;
					parents[neighbor] = currentNode;
					queue.offer(neighbor);
				}
			}
		}

		return response; // Retorna uma lista vazia caso não seja possível alcançar o nó de destino a partir do nó inicial
	}
	@Override
	public float calculateEdgeWeight(int nodeA, int nodeB) {
		for (Edge edge : edges) {
			if ((edge.getNodeA() == nodeA && edge.getNodeB() == nodeB) ||
					(edge.getNodeA() == nodeB && edge.getNodeB() == nodeA)) {
				return edge.getWeight();
			}
		}
		return -1.0f; // Ou outro valor adequado para indicar que a aresta não foi encontrada
	}

	@Override
	public List<Edge> findMinimumSpanningTree() {
		List<Edge> mst = new ArrayList<>();

		// Ordena as arestas pelo peso em ordem crescente
		List<Edge> sortedEdges = new ArrayList<>(edges);
		sortedEdges.sort(Comparator.comparingDouble(Edge::getWeight));

		int[] parent = new int[adjacentList.size()];
		Arrays.fill(parent, -1);

		int numEdgesAdded = 0;
		int numNodes = adjacentList.size() - 1;

		for (Edge edge : sortedEdges) {
			int rootA = find(parent, edge.getNodeA() - 1);
			int rootB = find(parent, edge.getNodeB() - 1);

			if (rootA != rootB) {
				mst.add(edge);
				numEdgesAdded++;
				parent[rootB] = rootA;

				if (numEdgesAdded == numNodes - 1) {
					break;  // Encontrou todas as arestas necessárias
				}
			}
		}

		return mst;
	}

	@Override
	public double calculateAverageDistance() {
		double totalDistance = 0;
		int count = 0;

		for (int node = 0; node < getNumberOfNodes(); node++) {
			int[] distances = bfs(node);

			for (int distance : distances) {
				if (distance > 0) {
					totalDistance += distance;
					count++;
				}
			}
		}

		return totalDistance / count;
	}

	private int[] bfs(int startNode) {
		int[] distances = new int[getNumberOfNodes()];
		Arrays.fill(distances, -1);

		Queue<Integer> queue = new LinkedList<>();
		distances[startNode] = 0;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			LinkedList<Integer> neighbors = adjacentList.get(currentNode);
			for (int neighbor : neighbors) {
				if (distances[neighbor] == -1) {
					distances[neighbor] = distances[currentNode] + 1;
					queue.offer(neighbor);
				}
			}
		}

		return distances;
	}

	private int find(int[] parent, int node) {
		if (parent[node] == -1) {
			return node;
		}
		return find(parent, parent[node]);
	}
}
