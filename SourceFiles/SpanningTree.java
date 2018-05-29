
public class SpanningTree {
	private int count;
	private stNode head;
	public SpanningTree(){
		head = null;
		count  = 0;
	}
	public void add(int data, stNode p){
		stNode node = new stNode();
		if(count == 0){
			node.p = null;
		}
		else{
			node.p = p;
		}
		node.data = data;
		count++;
		node.next = head;
		head = node;
	}
	
	
	public void displayAllPaths(){
		stNode current = head;
		while(current != null){
			printPath(current);
			current = current.next;
		}
	}
	
	public Stack printPath(stNode node){
		Stack s = new Stack();
		stNode current = node;
		while(current != null){
			//System.out.println(current.data);
			s.push('q',current.data);
			current = current.p;
		}
		//System.out.println();
		return s;
	}
	
	public stNode getNode(int data){
		stNode current = head;
		while(current.data != data){
			current = current.next;
		}
		return current;
	}
	
	public int getCount(){
		return count;
	}
	
	private static class stNode{
		private stNode p;
		private int data;
		private stNode next;
	}
}
