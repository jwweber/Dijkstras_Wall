import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator implements Iterator {
	private Node current;
	
	public ListIterator(Node start) {
		current = start;
	}
	
	@Override
	public boolean hasNext() {
		return (current != null);
	}

	@Override
	public Node next() {
		if (!hasNext()) {
			throw new NoSuchElementException("No more elements");
		}
		Node ret = current;
		current = current.next;
		return ret;
	}

	@Override
	public void remove() {
		// Do Nothing			
	}
	
}