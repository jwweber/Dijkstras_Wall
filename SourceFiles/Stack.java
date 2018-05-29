
public class Stack {
	private LinkedList ll;
	public Stack(){
		ll = new LinkedList(null);
	}
	public void push(char label, int id){
		ll.addToFront(label, id);
	}
	public Node pop(){
		return ll.removeFirst();
	}
	public void iterate(){
		ll.iterate();
	}
	public int size(){
		return ll.size();
	}
	public Node getHead(){
		return ll.first();
	}
	public boolean isEmpty(){
		return ll.isEmpty();
	}
}
