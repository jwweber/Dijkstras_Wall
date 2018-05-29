
public class MinHeap {
	private String[] A;
	private int heapSize;
	public MinHeap(int n){
		A = new String[n+1];
		heapSize = n;
	}
	public int getNodeNum(int i){
		int num = Integer.parseInt(A[i].substring(0,A[i].indexOf(" ")));
		return num;
	}
	public int getNodeKey(int i){
		Integer num = Integer.parseInt(A[i].substring(A[i].indexOf(" ")+1));
		return Integer.valueOf(num);
	}
	private int parent(int i){
		return i/2;
	}
	private int left(int i){
		return 2*i;
	}
	private int right(int i){
		return (2*i) + 1;
	}
	private void minHeapify(int i){
		int smallest;
		int l = left(i);
		int r = right(i);
		int keyl;
		int keyi = getNodeKey(i);; 
		int keyr;
		//Run into out of bounds exception without handling these node keys first
		if((l <= heapSize)){
			keyl = getNodeKey(i);
		}
		else{
			keyl = 0;
		}
		if((r <= heapSize)){
			keyr = getNodeKey(r);
		}
		else{
			keyr = 0;
		}
		if(l <= heapSize && (getNodeKey(l) < getNodeKey(i))){
			smallest = l;
		}
		else{
			smallest = i;
		}
		if(r <= heapSize && getNodeKey(r) < getNodeKey(smallest)){
			smallest = r;
		}
		if(smallest != i){
			exchange(A, i, smallest);
			minHeapify(smallest);
		}
	}
	public void buildMinHeap(){
		for(int i = (A.length/2); i >= 1; i--){
			minHeapify(i);
		}
	}
	private void exchange(String[] A, int i, int j){
		String temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	public void insert(int index, int id, int key){
		String val;
		val = id + " " + key;
		A[index] = val;
	}
	public int min(){
		return getNodeNum(1);
	}
	public int extractMin(){
		if(heapSize < 1){
			System.out.println("Error: heap underflow");
		}
		int min = getNodeNum(1);
		A[1] = A[heapSize];
		heapSize--;
		minHeapify(1);
		//retruns node id of first position
		return min;
	}
	private int findIndex(int id){
		int index = -1;
		for(int i = 1; i <= heapSize; i++){
			if(getNodeNum(i) == id){
				index = i;
			}
		}
		return index;
	}
	public void heapDecreaseKey(int id, int key){
		int i = findIndex(id);
		if (key > getNodeKey(i)){
			System.out.println("Error: new key is larger than current key");
		}
		A[i] = id + " " +key;
		while(i > 1 && getNodeKey(parent(i)) > getNodeKey(i)){
			exchange(A,i,parent(i));
			i = parent(i);
		}
	}
	public void iterate(){
		for(int i = 1; i <= heapSize;++i){
			System.out.println(A[i]);
		}
	}
	public boolean isEmpty(){
		return (heapSize == 0);
	}
	public boolean inList(int data){
		boolean b = false;
		for(int i = 1; i <= heapSize; i++){
			if(data == getNodeNum(i)){
				b = true;
			}
		}
		return b;
	}
}
