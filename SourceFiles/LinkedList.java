import java.awt.Color;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.JPanel;



public class LinkedList implements Iterable{

	private int size;
	private Node head;
	private Node tail;

	private Graph g;
	
	public LinkedList(Graph g) {
		size = 0;
		head = tail = null;
		this.g = g;
	}
	public Node search(char label){
		Node current = head;
		while(current.label != label){
			current = current.next;
		}
		return current;
	}
	public Node search(int id){
		Node current = head;
		while(current.id != id){
			current = current.next;
		}
		return current;
	}
	public Node addToFront(char label, int id) {
		Node node = new Node(g);
		node.label = label;
		node.id = id;
		node.next = head;
		head = node;
		size ++;
		if (size == 1) {
			tail = head;
		}
		return node;
	}
	public Node addToFront(Node x) {
		x.next = head;
		head = x;
		size ++;
		if (size == 1) {
			tail = head;
		}
		return x;
	}
	public Node addToRear(char label, int id) {
		Node node;
		if (isEmpty()) {
			node = addToFront(label, id);
		}
		else {
			node = new Node(g);
			node.label = label;
			node.id = id;
			node.next = null;
			tail.next = node;
			tail = node;
			size ++;
		}
		return node;
	}
	public Node addToRear(Node x) {
		Node node;
		if (isEmpty()) {
			node = addToFront(x);
		}
		else {
			node = x;
			node.next = null;
			tail.next = node;
			tail = node;	
			size++;
		}
		return node;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size <= 0);
	}

	public Node removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		Node x = head;
		head = head.next;
		size --;
		if (isEmpty()) {
			tail = null;
		}
		if (size == 1) {
			tail = head;
		}
		return x;
	}
	
	public Node removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		Node x = tail;
		if (size == 1) {
			x = removeFirst();
		}
		else {
			Node newLast = head;
			while (newLast.next != tail) {
				newLast = newLast.next;
			}
			tail = newLast;
			tail.next = null;
			size --;
		}
		return x;
	}
	
	public Node removeTarget(int id){
		if(isEmpty()){
			throw new NoSuchElementException("Empty list");
		}
		Node ret;
		
		if (size == 1 || head.id == id) {
			ret = removeFirst();
		}
		else if(tail.id == id){
			ret = removeLast();
		}
		else{
			ret = head;
			while(ret.next.id != id){
				ret = ret.next;
			}
			ret.next = ret.next.next;
			ret = ret.next;
			size--;
		}
		return ret;
	}
	
	public Node removeTarget(char label){
		if(isEmpty()){
			throw new NoSuchElementException("Empty list");
		}
		Node ret;
		
		if (size == 1 || head.label == label) {
			ret = removeFirst();
		}
		else if(tail.label == label){
			ret = removeLast();
		}
		else{
			ret = head;
			while(ret.next.label != label){
				ret = ret.next;
			}
			ret.next = ret.next.next;
			ret = ret.next;
			size--;
		}
		return ret;
	}
	
	public Node first() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		return head;
	}
	
	public Node last() {
		if (isEmpty()) {
			throw new NoSuchElementException("Empty list");
		}
		return tail;
	}
	public void removeAll(){
		head = tail = null;
		size = 0;
	}
	public void iterate(){
		if(isEmpty()){
			System.out.println("Empty list");
		}
		Node current = head;
		if(head == null && tail == null){
			System.out.println("List is empty");
		}
		while(current != null){
			System.out.println(current.id + " " + current.label);
			current=current.next;
		}
	}
	public void colorAllGray(){
		Node current = head;
		while(current != null){
			if(current.isWalledCheck()){
				if(current.id -1 != 0 && current.id -1 != 33 && current.id -1 != 66 && current.id -1 != 99 && current.id -1 != 132 
						&& current.id -1 != 165 && current.id -1 != 198 && current.id -1 != 231 && current.id -1 != 264 && current.id -1 != 297 
						&& current.id -1 != 330 && current.id -1 != 363 && current.id -1 != 396 && current.id -1 
						!= 429 && current.id -1 != 462 && current.id -1 != 495){
					g.setBiWeight(current.id, current.id-1, 1);
				}
				if(current.id +1 != 34 && current.id +1 != 67 && current.id +1 != 100 && current.id +1 != 133 
						&& current.id +1 != 166 && current.id +1 != 199 && current.id +1 != 232 && current.id +1 != 265 && current.id +1 != 298 
						&& current.id +1 != 331 && current.id +1 != 364 && current.id +1 != 397 
						&& current.id +1 != 430 && current.id +1 != 463 && current.id +1 != 496 && current.id +1 != 529){
					g.setBiWeight(current.id, current.id+1, 1);
				}
				if(current.id - 33 > 0){
					g.setBiWeight(current.id, current.id-33, 1);
				}
				if(current.id + 33 <= 528){
					g.setBiWeight(current.id, current.id+33, 1);
				}
			}
			current.changeState(1);
			current.toggleWalled();
			current.getBox().setBackground(Color.LIGHT_GRAY);
			current.nodeValide();
			current = current.next;
		}
	}
	public ListIterator iterator() {
		return new ListIterator(head);
	}
}
