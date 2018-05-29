//Note: Adjacency LIsts and Queues should only contain copies of nodes. Use getNode to obtain VertexList node
//Use only local list iterators
public class Graph {
	private LinkedList vertexList;
	private BinarySearchTree weights;
	private char[] color;
	private int[] parent;
	private int[] distance;
	private int[] discovery;
	private int[] finish;
	private int time;
	private int numEdges;
	private boolean canPlace;
	public Graph(){
		vertexList = new LinkedList(this);
		numEdges = 0;
		weights = new BinarySearchTree();
		canPlace = true;
	}
	public void setCanPlace(){
			canPlace = true;
	}
	public void disableCanPlace(){
		canPlace = false;
	}
	public boolean getCanPlace(){
		return canPlace;
	}
	public int numNodes(){
		return vertexList.size();
	}
	public Node addVertex(char label, int id){
		Node n =  vertexList.addToRear(label, id);
		n.ll = new LinkedList(this);
		return n;
	}
	public Node getNode(int id){
		return vertexList.search(id);
	}
	public Node getNode(char label){
		return vertexList.search(label);
	}
	public void graphColorAllGray(){
		vertexList.colorAllGray();
	}
	public void addEdge(int idSource, char labelSource, int idDest, char labelDest, int weight){
		Node n = vertexList.search(idSource);
		n.ll.addToRear(labelDest, idDest);
		numEdges++;
		weights.treeInsert("("+idSource+","+idDest+")", weight);
	}
	public void addBiEdge(int id1, char label1, int id2, char label2, int weight){
		addEdge(id1,label1,id2,label2, weight);
		addEdge(id2,label2,id1,label1, weight);
	}
	public void removeEdge(int id1, char label1, int id2, char label2){
		vertexList.search(id1).ll.removeTarget(id2);
		numEdges--;
		weights.treeDelete("("+id1+","+id2+")");
	}
	public void removeBiEdge(int id1, char label1, int id2, char label2){
		removeEdge(id1, label1, id2, label2);
		removeEdge(id2, label2, id1, label1);
	}
	public Node removeVertex(char label, int id){
		vertexList.search(id).ll.removeAll();
		return vertexList.removeTarget(id);
	}
	public int getWeight(int id1, int id2){
		return weights.nodeValue(weights.treeSearch(weights.getRoot(),"("+id1+","+id2+")"));
	}
	public void setWeight(int id1, int id2, int newKey){
		weights.treeDelete("("+id1+","+id2+")");
		weights.treeInsert("("+id1+","+id2+")",newKey);
	}
	public void setBiWeight(int id1, int id2, int newKey){
		setWeight(id1,id2,newKey);
		setWeight(id2,id1,newKey);
	}
	public LinkedList getVertexList(){
		return vertexList;
	}
	public void displayAdjList(){
		Node x = vertexList.first();
		while(x != null){
			System.out.println("Vertex: "+x.id+" "+x.label);
			System.out.println("Adjacent Vertices:");
			x.ll.iterate();
			x = x.next;
		}
		System.out.println();
	}
	public void bfs(Node s){
		Node u,v;
		ListIterator itadj;
		color = new char[vertexList.size() + 1];
		parent = new int[vertexList.size() + 1];
		distance = new int[vertexList.size() + 1];
		for(int i = 1; i <= vertexList.size();++i){
			color[i] = 'w';
			distance[i] = 999999;
			parent[i] = 0;
		}
		color[s.id] = 'g';
		distance[s.id] = 0;
		parent[s.id] = -1;
		Queue q = new Queue();
		System.out.println("visit "+s.label+" "+s.id);
		q.enqueue(s.label,s.id);
		while(!q.isEmpty()){
			u = getNode(q.dequeue().id);
			itadj = u.ll.iterator();
			while(itadj.hasNext()){
				v = itadj.next();
				if(color[v.id] == 'w'){
					color[v.id] = 'g';
					distance[v.id] = distance[u.id] + 1;
					parent[v.id] = u.id;
					q.enqueue(v.label, v.id);
					System.out.println("visit "+v.label+" "+v.id);
				}
			}
			color[u.id] = 'b';
		}
		System.out.println("Node Parent Distance Color");
		for(int i = 1; i <= vertexList.size(); ++i){
			System.out.println(i+"    "+parent[i]+"         "+distance[i]+"      "+color[i]);
		}
	}
	//must use local iterators
	public void dfs(){
		color = new char[vertexList.size() + 1];
		parent = new int[vertexList.size()+1];
		discovery = new int[vertexList.size()+1];
		finish = new int[vertexList.size()+1];
		for(int i = 1; i <= vertexList.size();++i){
			parent[i] = -1;
			color[i] = 'w';
		}
		time = 0;
		Node x;
		ListIterator itLoc = vertexList.iterator();
		while(itLoc.hasNext()){
			x = getNode(itLoc.next().id);
			if(color[x.id] == 'w'){
				dfsVisit(x);
			}
		}
		System.out.println("Node Parent Disc Finish Color");
		for(int i = 1; i <= vertexList.size(); i++){
			System.out.println(i+"    "+parent[i]+"         "+discovery[i]+"      "+finish[i]+"         "+color[i]);
		}
	}
	public void dfsVisit(Node x){
		Node u = getNode(x.id);
		Node v;
		color[u.id] = 'g';
		discovery[u.id] = time;
		time++;
		System.out.println("Visit "+u.id+" "+u.label);
		ListIterator itadjLoc = u.ll.iterator();
		while(itadjLoc.hasNext()){
			v = getNode(itadjLoc.next().id);
			if(color[v.id] == 'w'){
				parent[v.id] = u.id;
				dfsVisit(v);
			}
		}
		color[u.id] = 'b';
		finish[u.id] = time;
		time++;
	}
	public SpanningTree dijkstra(Node src){
		ListIterator itadj;
		Node u,v;
		parent = new int[vertexList.size() + 1];
		distance = new int[vertexList.size() + 1];
		for(int i = 1; i <= vertexList.size();++i){
			distance[i] = 999999;
			parent[i] = -1;
		}
		distance[src.id] = 0;
		SpanningTree S = new SpanningTree();
		MinHeap pq = new MinHeap(vertexList.size());
		for(int i = 1; i <= vertexList.size();i++){
			pq.insert(i,i, distance[i]);
		}
		pq.buildMinHeap();
		while(!pq.isEmpty()){
			u = getNode(pq.extractMin());
			if(S.getCount() == 0){
				S.add(u.id,null);
			}
			else{
				S.add(u.id,S.getNode(parent[u.id]));
			}
			itadj = u.ll.iterator();
			while(itadj.hasNext()){
				v = getNode(itadj.next().id);
				if((distance[v.id] > (distance[u.id] + getWeight(u.id,v.id))) && pq.inList(v.id)){
					distance[v.id] = distance[u.id] + getWeight(u.id,v.id);
					parent[v.id] = u.id;
					pq.heapDecreaseKey(v.id,distance[v.id]);
				}
			}
		}
		return S;
	}
}
