
public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue q = new Queue();
		q.enqueue('a', 1);
		q.enqueue('b', 2);
		q.enqueue('c', 3);
		q.enqueue('d', 4);
		q.enqueue('e', 5);
		q.iterate();
		System.out.println(q.getHead().label);
		System.out.println();
		q.dequeue();
		q.iterate();
		System.out.println(q.getHead().label);
		System.out.println();
		q.dequeue();
		q.iterate();
		System.out.println(q.getHead().label);
		q.enqueue('f',6);
		q.iterate();
		System.out.println(q.getHead().label);
	}

}
