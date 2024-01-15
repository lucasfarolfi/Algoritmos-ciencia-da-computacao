package graph.representation;

import graph.Edge;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AdjacentMatrix implements IGraphRepresentation {

	private Float[][] adjacentMatrix;
	private List<Edge> edges;
	private boolean hasWeight;

	public AdjacentMatrix() { }
	
	public void initialize(int numberOfVertex, List<Edge> edges) {
		this.edges = edges;
		this.adjacentMatrix = new Float[numberOfVertex][numberOfVertex];
		for (Float[] matrix : adjacentMatrix) {
			Arrays.fill(matrix, 0f);
		}
		
		for (var edge : this.edges) {
			this.addEdge(edge);
		}
		this.hasWeight = edges.get(0).getWeight() != null;
	}

	@Override
	public String getDfsTree(){
		StringBuilder tree = new StringBuilder();
		var visited = new boolean[adjacentMatrix.length];
		int root = 0;
		dfs(root, 0, tree, visited);
		return tree.toString();
	}

	@Override
	public String getBfsTree(){
		StringBuilder tree = new StringBuilder();
		var visited = new boolean[adjacentMatrix.length];
		int root = 0;
		bfs(root, tree, visited);
		return tree.toString();
	}

	@Override
	public void findAndShowConnectedComponents(String outputGraphDirectory) {
		// Cria um array de inteiros com o tamanho do número de vértices do grafo G
		Integer[] cc = new Integer[adjacentMatrix.length];
		// Inicializa todos os elementos do array com -1
		Arrays.fill(cc, -1);
		int count = 0;
		// Para cada vértice v no grafo G

		for (int v = 0; v < adjacentMatrix.length; v++) {
			// Se o valor de cc[v] for -1, então ainda não foi visitado
			if (cc[v] == -1) {
				dfsRcc(cc, count, v);
				count++;
			}
		}
		Set<Integer> components = new HashSet<>(Arrays.asList(cc));
		components = components.stream()
				.filter(component -> component != -1)
		.collect(Collectors.toSet());

		var  filePath = outputGraphDirectory  + this.getClass().getSimpleName() +  "-connectedComponents.txt";
		try {
			FileWriter myWriter = new FileWriter(filePath);
			myWriter.write("Número de componentes conexos: " + components.size() +"\n\n");

			for (var component: components ) {
				if (component != -1) {
					myWriter.write("Componente: #" + (component+1) + "\n");

					var subGraphNodes = new ArrayList<Integer>();
					var matrix = new Float[adjacentMatrix.length][adjacentMatrix.length];
					//TODO MELHORAR A PERFOMANCE REUTILIZANDO A MEMORIaa

					for (int i=0; i < matrix.length; i++)
					{
						Arrays.fill(matrix[i], 0f);
					}

					for (int i = 0; i < cc.length; i++) {
						if (cc[i].equals(component)) {
							subGraphNodes.add(i);
						}
					}

					for (var node: subGraphNodes) {
						matrix[node] = adjacentMatrix[node];
					}

					myWriter.write( String.format("Tamanho do componente %d: %d\n", component + 1, subGraphNodes.size()));
					myWriter.write( String.format("Vértices do componente %d: %s\n\n",
							component + 1, subGraphNodes.stream().map(node -> node + 1).collect(Collectors.toSet())));
				}
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	private void dfsRcc(Integer[] cc, int count, int v)
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		while (!stack.isEmpty()) {
			int current = stack.pop();
			cc[current] = count;
			for (int i = 0; i < this.adjacentMatrix[current].length; i++) {
				if (cc[i] == -1 && this.adjacentMatrix[current][i] != 0) {
					stack.push(i);
				}
			}
		}
	}

	private void dfs(int node, int level, StringBuilder tree, boolean[] visited) {

		visited[node] = true;
		int numVertices = adjacentMatrix.length;

		String log = String.format("NODE: %d - LEVEL: %d\n", node+1, level);
		tree.append(log);
		level += 1;
		for (int i = 0; i < numVertices; i++) {
			if (adjacentMatrix[node][i] != 0 && !visited[i])
			{
				this.dfs(i, level, tree, visited);
			}
		}
	}

	private void bfs(int root, StringBuilder tree, boolean[] visited)
	{
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		String logRoot = String.format("NODE: %d - LEVEL: %d\n", root+1, 0);
		var levels = new Integer[adjacentMatrix.length];
		Arrays.fill(levels, -1);
		levels[root] = 0;
		tree.append(logRoot);
		while (!queue.isEmpty()){
			var node = queue.poll();
			visited[node] = true;
			for (int i = 0; i < adjacentMatrix.length; i++) {
				if (adjacentMatrix[node][i] != 0 && !visited[i])
				{
					queue.add(i);
					if(levels[i] == -1)
					{
						levels[i] = levels[node] + 1;
						tree.append(String.format("NODE: %d - LEVEL: %d\n", i + 1, levels[i]));
					}
				}
			}
		}
	}


	@Override
	public void addEdge(Edge edge) {
		var nodeA = edge.getNodeA() - 1;
		var nodeB = edge.getNodeB() - 1;

		adjacentMatrix[nodeA][nodeB] = edge.getWeight() != null ? edge.getWeight() : 1f;
		adjacentMatrix[nodeB][nodeA] =  edge.getWeight() != null ? edge.getWeight() : 1f;
	}

	@Override
	public int getNumberOfNodes() {
		return this.adjacentMatrix.length;
	}

	@Override
	public int getNodeDegree(int node) {
		var count = 0;
		for (var i = 0; i < adjacentMatrix[node].length; i++){
			if(!hasWeight && adjacentMatrix[node][i] == 1) count++;
			else if(hasWeight && adjacentMatrix[node][i] != 0) count++;
		}
		return count;
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
	public int getNumberOfEdges() {
		return this.edges.size();
	}


	@Override
	public Map<Float, List<Integer>> calculateShortestPath(int vertexA, int vertexB)
	{
		System.out.println("***************");
		System.out.println("Encontrando caminho de " + (vertexA+1) + " até " + (vertexB+1));
		var paths = new Path[adjacentMatrix.length];
		for (int i = 0; i < adjacentMatrix.length; i++) {
			paths[i] = new Path(null, Integer.MAX_VALUE, vertexA);
		}

		paths[vertexA] = new Path(null, 0, vertexA);
		var response = new HashMap<Float, List<Integer>>();
		Set<Integer> visited = new HashSet<Integer>();
		PriorityQueue<Path> queue = new PriorityQueue<>(adjacentMatrix.length);
		queue.add(paths[vertexA]);
		Path currentPath = null;
		while (!queue.isEmpty() && !visited.remove(vertexB))
		{
			currentPath = queue.poll();
			visited.add(currentPath.id);

			for (int i = 0; i < adjacentMatrix.length; i++)
			{
				int finalI = i;
				var isNotVisited = visited.stream().noneMatch(x -> x == finalI);

				//Encontra os vizinhos e faz o relaxamento
				if (adjacentMatrix[currentPath.id][i] > 0 && adjacentMatrix[currentPath.id][i] != null && isNotVisited)
				{
					var cost = adjacentMatrix[currentPath.id][i];
					var totalCost = cost + paths[currentPath.id].cost;
					if(paths[i].cost > totalCost)
					{
						paths[i].id = i;
						paths[i].cost = totalCost;
						paths[i].predecessor = currentPath;
					}

					if(isNotVisited)
						queue.add(paths[i]);
				}
			}
		}
		List<Integer> results = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		if(currentPath!=null)
		{
			var shortPath = currentPath;
			while (shortPath!= null)
			{
				results.add(shortPath.id);
				shortPath = shortPath.predecessor;
			}
			Collections.reverse(results);

			for (var result: results) {
				sb.append(result+1).append(" -> ");
			}

		}
		System.out.println(sb);
		System.out.println("Custo: " + currentPath.cost);
		response.put(currentPath.cost, results);
		return response;
	}

	@Override
	public float calculateEdgeWeight(int nodeA, int nodeB) {
		return 0;
	}

	@Override
	public List<Edge> findMinimumSpanningTree() {
		List<Edge> mst = new ArrayList<>();

		// Ordena as arestas pelo peso em ordem crescente
		List<Edge> sortedEdges = new ArrayList<>(edges);
		sortedEdges.sort(Comparator.comparingDouble(Edge::getWeight));

		int[] parent = new int[adjacentMatrix.length];
		Arrays.fill(parent, -1);

		int numEdgesAdded = 0;
		int numNodes = adjacentMatrix.length - 1;

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
		Float totalDistance = 0f;

		for (int node = 0; node < getNumberOfNodes(); node++) {
			for (int neighboor = 0; neighboor < node ; neighboor++) {
				if(node != neighboor)
				{
					var response = this.calculateShortestPath(node, neighboor);
					var cost = response.keySet().stream().findFirst().orElse(null);
					if(cost != null)
					{
						totalDistance += cost;
					}
				}
			}
		}

		return totalDistance / (getNumberOfNodes() * (getNumberOfNodes() - 1));
	}

	private double[] bfs(int startNode) {
		double[] distances = new double[getNumberOfNodes()];
		Arrays.fill(distances, -1);

		Queue<Integer> queue = new LinkedList<>();
		distances[startNode] = 0;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int currentNode = queue.poll();

			for (int neighbor = 0; neighbor < getNumberOfNodes(); neighbor++) {
				if (adjacentMatrix[currentNode][neighbor] != 0 && distances[neighbor] == -1) {
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
