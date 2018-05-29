public class Queue {
	private LinkedList ll;
	public Queue(){
		ll = new LinkedList(null);
	}
	public void enqueue(char label, int id){
		ll.addToRear(label,id);
	}
	public Node dequeue(){
		return ll.removeFirst();
	}
	public Node getHead(){
		return ll.first();
	}
	public void iterate(){
		ll.iterate();
	}
	public int size(){
		return ll.size();
	}
	public boolean isEmpty(){
		return ll.isEmpty();
	}
}
