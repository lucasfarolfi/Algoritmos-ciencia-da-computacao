import graph.enums.EGraphRepresentation;
import graph.GraphManager;
import graph.enums.SearchType;
import graph.representation.AdjacentList;
import graph.representation.AdjacentMatrix;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = null;
	private static EGraphRepresentation graphType;
	private static String inputGraphFilePath;
	private static String outputGraphDirectory;

	public static void main(String[] args) {
		System.out.println("### Gerador de grafos ###\n");

		scanner = new Scanner(System.in);
		inputGraphFilePath = "src/files/input/graph_with_weight.txt";
		outputGraphDirectory = "src/files/output/";

		System.out.println("OBS: OS ARQUIVOS PADRÃO SÃO LOCALIZADOS NOS DIRETÓRIOS 'src/files/input' E 'src/files/output' DO PROJETO");
		System.out.print("Deseja alterar os diretórios padrão do programa para outro diretório?\n" +
				"1 - Sim\n" +
				"2 - Não\n" +
				"Digite a opção: "
		);
		var directoryOption = scanner.nextInt();

		if(directoryOption == 1){
			updateDirectories();
		} else{
			System.out.println();
			System.out.println("Diretório definido com sucesso!\n");
		}

		GraphManager graphManager = updateGraphRepresentation(inputGraphFilePath, outputGraphDirectory);;
		int menuOption = 0;

		do {
			System.out.print("\nOpções: \n" +
					"1 - Alterar representação entre matriz (Matriz/Lista) de adjacência\n" +
					"2 - Alterar diretórios de arquivos do grafo\n" +
					"3 - Gerar resultados do grafo no arquivo de saída\n" +
					"4 - Percorrer o grafo (BFS, DFS)\n" +
					"5 - Gerar componentes conexos\n" +
					"6 - Calcular distância e caminho mínimo entre 2 vertices\n" +
					"7 - Encontrar arvore geradora minima\n" +
					"8 - Calcular distância média\n" +
					"0 - Sair\n" +
					"Sua opção: ");
			menuOption = scanner.nextInt();
			System.out.println();

			try{
				switch (menuOption){
					case 1:
						graphManager = updateGraphRepresentation(inputGraphFilePath, outputGraphDirectory);
						System.out.println("Representação alterada para " + graphType + " de adjacência.");
						break;
					case 2:
						updateDirectories();
						graphManager = updateGraphRepresentation(inputGraphFilePath, outputGraphDirectory);;
						break;
					case 3:
						graphManager.generateGraphOutput();
						System.out.println("Resultados do grafo gerado no arquivo 'output.txt' com sucesso!");
						break;
					case 4:
						System.out.println("Deseja percorrer a árvore com qual método ?");
						System.out.println("1 - DFS");
						System.out.println("2 - BFS");

						System.out.print("Escolha uma opção: ");
						var searchTypeOption = scanner.nextInt();
						var searchType = SearchType.getValue(searchTypeOption);

						graphManager.generateTree(searchType);
						System.out.println("Resultados da árvore no método " + searchType + " gerado com sucesso!");
						break;
					case 5:
						graphManager.showConnectComponents();
						System.out.println("Resultados componentes conexos gerado com sucesso!");
						break;
					case 6:
						System.out.println("Digite o vertice inicial: ");
						var startNode = scanner.nextInt() - 1;

						System.out.println("Digite o vertice final: ");
						var endNode = scanner.nextInt() - 1;
						graphManager.calculateShortestPathFromNode(startNode, endNode);
//						graphManager.showDistanceOfNodes(startNode, endNode);
//						graphManager.showShortestPathFromNode(startNode);
						System.out.println("Resultados de distância e caminho mínimo gerados com sucesso!");
						break;
					case 7:
						graphManager.writeMinimumSpanningTreeToFile();
						System.out.println("Arvore geradora minima gerada em um arquivo com sucesso!");
						break;
					case 8:
						graphManager.getAverageDistance();
						break;
					case 0:
						break;
					default:
						System.out.println("Erro! Opção não existente");
						break;
				}
			} catch (Exception exception){
				System.out.println("\nErro! " + exception.getMessage());
			}
		} while (menuOption != 0);
	}

	private static void updateDirectories() {
		scanner.nextLine();
		System.out.println("\nEx: " +
				"/home/username/example/grafos/grafo_1.txt     // on Unix systems\n" +
				"C:\\Users\\username\\example\\grafos\\grafo_1.txt  // on Windows systems");
		System.out.println("Digite o 'diretório + nome' do arquivo de ENTRADA .txt do grafo: ");
		inputGraphFilePath = scanner.nextLine();

		System.out.println("\n\nEx: " +
				"/home/username/example/grafos/     // on Unix systems\n" +
				"C:\\Users\\username\\example\\grafos\\  // on Windows systems");
		System.out.println("Digite o 'diretório' em que serão gerados os arquivos de SAIDA .txt do grafo: ");
		outputGraphDirectory = scanner.nextLine();

		System.out.println();
		System.out.println("Diretório alterado com sucesso!\n");
	}

	private static GraphManager updateGraphRepresentation(String inputGraphFilePath, String outputGraphDirectory) {
		System.out.println("Qual representação do Grafo utilizar ?");
		System.out.println("1 - Lista");
		System.out.println("2 - Matriz");

		System.out.print("Escolha uma opção: ");
		var graphRepresentationOption = scanner.nextInt();
		graphType = EGraphRepresentation.getValue(graphRepresentationOption);

		switch (graphType){
			case LIST:
				return new GraphManager(new AdjacentList(), inputGraphFilePath, outputGraphDirectory);
			case MATRIX:
				return new GraphManager(new AdjacentMatrix(), inputGraphFilePath, outputGraphDirectory);
			default:
				System.out.println("Erro! Representação não encontrada ou não existe");
		}
		return null;
	}
}
