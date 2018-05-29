import java.util.Map;

public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCaseOne();
		//testCaseTwo();
		//testCaseThree();
		//testCaseFour();
		testCaseFive();
	}
	public static void testCaseOne(){
		Graph g = new Graph();
		g.addVertex('a', 1);
		g.addVertex('b', 2);
		g.addVertex('c', 3);
		g.addVertex('d', 4);
		g.addVertex('e', 5);
		
		g.addBiEdge(1, 'a', 2, 'b',0);
		g.addBiEdge(2, 'b', 3, 'c',0);
		g.addBiEdge(3, 'c', 4, 'd',0);
		g.addBiEdge(4, 'd', 5, 'e',0);
		g.addBiEdge(5, 'e', 1, 'a',0);
		g.addBiEdge(3, 'c', 5, 'e',0);
		g.addBiEdge(2, 'b', 4, 'd',0);
		//g.displayAdjList();
		//g.bfs();
		g.removeBiEdge(1, 'a', 2, 'b');
		//g.bfs();
	}
	public static void testCaseTwo(){
		Graph g = new Graph();
		g.addVertex('a', 1);
		g.addVertex('b', 2);
		g.addVertex('c', 3);
		g.addVertex('d', 4);
		g.addVertex('e', 5);
		g.addVertex('f', 6);
		g.addVertex('g', 7);
		g.addVertex('h', 8);
		g.addVertex('s', 9);
		
		g.addEdge(1, 'a', 2, 'b',0);
		g.addEdge(1, 'a', 9, 's',0);
		g.addEdge(2, 'b', 1, 'a',0);
		g.addEdge(9, 's', 1, 'a',0);
		g.addEdge(9, 's', 3, 'c',0);
		g.addEdge(9, 's', 7, 'g',0);
		g.addEdge(3, 'c', 4, 'd',0);
		g.addEdge(3, 'c', 5, 'e',0);
		g.addEdge(3, 'c', 6, 'f',0);
		g.addEdge(3, 'c', 9, 's',0);
		g.addEdge(4, 'd', 3, 'c',0);
		g.addEdge(5, 'e', 3, 'c',0);
		g.addEdge(5, 'e', 8, 'h',0);
		g.addEdge(6, 'f', 3, 'c',0);
		g.addEdge(6, 'f', 7, 'g',0);
		g.addEdge(7, 'g', 6, 'f',0);
		g.addEdge(7, 'g', 8, 'h',0);
		g.addEdge(7, 'g', 9, 's',0);
		g.addEdge(8, 'h', 5, 'e',0);
		g.addEdge(8, 'h', 7, 'g',0);
		g.displayAdjList();
		//g.bfs(g.getVertexList().search(1));
		g.dfs();
		
	}
	public static void testCaseThree(){
		Graph g = new Graph();
		g.addVertex('a', 1);
		g.addVertex('b', 2);
		g.addVertex('c', 3);
		g.addVertex('d', 4);
		g.addVertex('e', 5);
		g.addVertex('f', 6);
		g.addVertex('g', 7);
		g.addVertex('h', 8);
		g.addVertex('s', 9);
		
		g.addEdge(1, 'a', 2, 'b',10);
		g.addEdge(1, 'a', 9, 's',30);
		g.addEdge(2, 'b', 1, 'a',5);
		g.addEdge(9, 's', 1, 'a',6);
		g.addEdge(9, 's', 3, 'c',14);
		g.addEdge(9, 's', 7, 'g',2);
		g.addEdge(3, 'c', 4, 'd',35);
		g.addEdge(3, 'c', 5, 'e',67);
		g.addEdge(3, 'c', 6, 'f',12);
		g.addEdge(3, 'c', 9, 's',8);
		g.addEdge(4, 'd', 3, 'c',41);
		g.addEdge(5, 'e', 3, 'c',9);
		g.addEdge(5, 'e', 8, 'h',27);
		g.addEdge(6, 'f', 3, 'c',16);
		g.addEdge(6, 'f', 7, 'g',11);
		g.addEdge(7, 'g', 6, 'f',22);
		g.addEdge(7, 'g', 8, 'h',33);
		g.addEdge(7, 'g', 9, 's',15);
		g.addEdge(8, 'h', 5, 'e',23);
		g.addEdge(8, 'h', 7, 'g',29);
		SpanningTree s = g.dijkstra(g.getNode('a'));
		System.out.println(s.printPath(s.getNode(6)));
	}
	public static void testCaseFour(){
		Graph g = new Graph();
		g.addVertex('a', 1);
		g.addVertex('b', 2);
		g.addVertex('c', 3);
		g.addVertex('d', 4);
		g.addVertex('e', 5);
		g.addVertex('f', 6);
		
		g.addBiEdge(1, 'a', 2, 'b',10);
		g.addBiEdge(2, 'b', 3, 'c',6);
		g.addBiEdge(3, 'c', 4, 'd',5);
		g.addBiEdge(4, 'd', 5, 'e',11);
		g.addBiEdge(5, 'e', 6, 'f',3);
		g.addBiEdge(6, 'f', 1, 'a',8);
		
		g.addBiEdge(1, 'a', 5, 'e',2);
		g.addBiEdge(2, 'b', 5, 'e',7);
		g.addBiEdge(2, 'b', 4, 'd',6);
		g.addBiEdge(3, 'c', 6, 'f',1);
		
		SpanningTree s = g.dijkstra(g.getNode('a'));
		System.out.println(s.printPath(s.getNode(4)));
	}
	public static void testCaseFive(){
		Graph g = new Graph();
		for(int i = 1; i <= 25; i++){
			g.addVertex('n', i);
		}
		g.addBiEdge(1, 'n', 2, 'n', 1);		
		g.addBiEdge(2, 'n', 3, 'n', 1);	
		g.addBiEdge(3, 'n', 4, 'n', 1);	
		g.addBiEdge(4, 'n', 5, 'n', 1);
		
		g.addBiEdge(6, 'n', 7, 'n', 1);		
		g.addBiEdge(7, 'n', 8, 'n', 1);	
		g.addBiEdge(8, 'n', 9, 'n', 1);	
		g.addBiEdge(9, 'n', 10, 'n', 1);
		
		g.addBiEdge(11, 'n', 12, 'n', 1);		
		g.addBiEdge(12, 'n', 13, 'n', 1);	
		g.addBiEdge(13, 'n', 14, 'n', 1);	
		g.addBiEdge(14, 'n', 15, 'n', 1);
		
		g.addBiEdge(16, 'n', 17, 'n', 1);		
		g.addBiEdge(17, 'n', 18, 'n', 1);	
		g.addBiEdge(18, 'n', 19, 'n', 1);	
		g.addBiEdge(19, 'n', 20, 'n', 1);
		
		g.addBiEdge(21, 'n', 22, 'n', 1);		
		g.addBiEdge(22, 'n', 23, 'n', 1);	
		g.addBiEdge(23, 'n', 24, 'n', 1);	
		g.addBiEdge(24, 'n', 25, 'n', 1);
		
		
		g.addBiEdge(1, 'n', 6, 'n', 1);		
		g.addBiEdge(6, 'n', 11, 'n', 1);	
		g.addBiEdge(11, 'n', 16, 'n', 1);	
		g.addBiEdge(16, 'n', 21, 'n', 1);
		
		g.addBiEdge(2, 'n', 7, 'n', 1);		
		g.addBiEdge(7, 'n', 12, 'n', 1);	
		g.addBiEdge(12, 'n', 17, 'n', 1);	
		g.addBiEdge(17, 'n', 22, 'n', 1);
		
		g.addBiEdge(3, 'n', 8, 'n', 1);		
		g.addBiEdge(8, 'n', 13, 'n', 1);	
		g.addBiEdge(13, 'n', 18, 'n', 1);	
		g.addBiEdge(18, 'n', 23, 'n', 1);
		
		g.addBiEdge(4, 'n', 9, 'n', 1);		
		g.addBiEdge(9, 'n', 14, 'n', 1);	
		g.addBiEdge(14, 'n', 19, 'n', 1);	
		g.addBiEdge(19, 'n', 24, 'n', 1);
		
		g.addBiEdge(5, 'n', 10, 'n', 1);		
		g.addBiEdge(10, 'n', 15, 'n', 1);	
		g.addBiEdge(15, 'n', 20, 'n', 1);	
		g.addBiEdge(20, 'n', 25, 'n', 1);
		
		g.displayAdjList();
		SpanningTree s = g.dijkstra(g.getNode(8));
		System.out.println(s.printPath(s.getNode(21)));
	}
}
