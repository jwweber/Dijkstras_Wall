
public class MinHeapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCaseOne();
	}
	public static void testCaseOne(){
		MinHeap pq = new MinHeap(8);
		pq.insert(1,2, 6);
		pq.insert(2,4, 3);
		pq.insert(3,6, 88);
		pq.insert(4,8, 76);
		pq.insert(5,10, 55);
		pq.insert(6,12, 43);
		pq.insert(7,14, 16);
		pq.insert(8,16, 25);
		pq.iterate();
		System.out.println();
		pq.buildMinHeap();
		pq.iterate();
		System.out.println();
		pq.heapDecreaseKey(8, 2);
		pq.iterate();
		System.out.println();
		System.out.println(pq.extractMin());
		System.out.println();
		pq.iterate();
		
	}

}
