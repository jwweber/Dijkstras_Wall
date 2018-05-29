
public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCaseOne();
		//testCaseTwo();
		testCaseThree();
	}
	public static void testCaseOne(){
		LinkedList ll1 = new LinkedList(null);
		ll1.addToFront('a', 1);
		ll1.addToFront('b', 2);
		ll1.addToFront('c', 3);
		ll1.addToFront('d', 4);
		ll1.addToFront('e', 5);
		ll1.iterate();
		ll1.removeTarget('e');
		System.out.println("head: "+ll1.first().label);
		System.out.println();;
		ll1.iterate();
		ll1.removeTarget('a');
		System.out.println("tail: "+ll1.last().label);
		System.out.println();;
		ll1.iterate();
		ll1.addToRear('f', 6);
		ll1.addToRear('g', 7);
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		System.out.println();
		ll1.iterate();
		ll1.removeTarget('f');
		ll1.removeTarget('c');
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		System.out.println();
		ll1.iterate();
		ll1.removeAll();
		ll1.iterate();
	}
	public static void testCaseTwo(){
		Graph gr = new Graph();
		LinkedList ll1 = new LinkedList(gr);
		Node a = new Node(gr);
		a.id = 1;
		a.label = 'a';
		Node b = new Node(gr);
		b.id = 2;
		b.label = 'b';
		Node c = new Node(gr);
		c.id = 3;
		c.label = 'c';
		Node d = new Node(gr);
		d.id = 4;
		d.label = 'd';
		Node e = new Node(gr);
		e.id = 5;
		e.label = 'e';
		Node f = new Node(gr);
		f.id = 6;
		f.label = 'f';
		Node g = new Node(gr);
		g.id = 7;
		g.label = 'g';
		ll1.addToFront(a);
		ll1.addToFront(b);
		ll1.addToFront(c);
		ll1.addToFront(d);
		ll1.addToFront(e);
		System.out.println("Size = "+ll1.size());
		ll1.iterate();
		ll1.removeTarget('e');
		System.out.println("Size = "+ll1.size());
		System.out.println("head: "+ll1.first().label);
		System.out.println();;
		ll1.iterate();
		ll1.removeTarget('a');
		System.out.println("Size = "+ll1.size());
		System.out.println("tail: "+ll1.last().label);
		System.out.println();;
		ll1.iterate();
		ll1.addToRear(f);
		ll1.addToRear(g);
		System.out.println("Size = "+ll1.size());
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		System.out.println();
		ll1.iterate();
		ll1.removeTarget('f');
		ll1.removeTarget('c');
		System.out.println("Size = "+ll1.size());
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		System.out.println();
		ll1.iterate();
		System.out.println();
		ll1.removeFirst();
		System.out.println("Size = "+ll1.size());
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		
		ll1.iterate();
		System.out.println();
		ll1.removeLast();
		System.out.println("Size = "+ll1.size());
		System.out.println("tail: "+ll1.last().label);
		System.out.println("head: "+ll1.first().label);
		ll1.iterate();
		
	}
	public static void testCaseThree(){
		Graph gr = new Graph();
		LinkedList ll1 = new LinkedList(gr);
		Node a = new Node(gr);
		a.id = 1;
		a.label = 'a';
		Node b = new Node(gr);
		b.id = 2;
		b.label = 'b';
		Node c = new Node(gr);
		c.id = 3;
		c.label = 'c';
		Node d = new Node(gr);
		d.id = 4;
		d.label = 'd';
		Node e = new Node(gr);
		e.id = 5;
		e.label = 'e';
		Node f = new Node(gr);
		f.id = 6;
		f.label = 'f';
		Node g = new Node(gr);
		g.id = 7;
		g.label = 'g';
		ll1.addToFront(a);
		ll1.addToFront(b);
		ll1.addToFront(c);
		ll1.addToFront(d);
		ll1.addToFront(e);
		ListIterator it = ll1.iterator();
		while(it.hasNext()){
			System.out.println(it.next().label);
			
		}
		System.out.println();
		System.out.println(ll1.search(3).label);
		
	}
}
