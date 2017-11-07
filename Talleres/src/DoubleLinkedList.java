/*
 * Autor: Daniela Abigail Parrales Mejía
 * Matrícula: A01228629*/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList <N> implements Iterable<N>{
	private Node<N> first;
	private Node<N> last;
	private int size;

	private static class Node <N>{
		private N data;
		public Node<N> next;
		public Node<N> prev;

		public Node (N data,Node<N> next,Node<N> prev) {
			this.data=data;
			this.next=next;
			this.prev=prev;
		}

		public Node () {
		}
	}

	/**
	 * Constructor
	 */
	public DoubleLinkedList() {
		this.first=new Node<N>();
		this.first=this.last;
		this.size=0;
	}

	/**
	 * Constructor
	 * @param first
	 * @param last
	 * @param size
	 */
	public DoubleLinkedList(Node<N> first,Node<N> last,int size) {
		this.first=first;
		this.first=last;
		this.size=size;
	}

	/**
	 * Returns true if the list has 0 elements
	 * @return
	 */
	public Boolean isEmpty() {
		return this.first==null;
	}

	/**
	 * Returns the number of elements in the list
	 * @return
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Returns true if the item is in the list, otherwise it returns false
	 * @param item
	 * @return
	 */
	public boolean contains(N item) {
		if(this.isEmpty()) {
			throw new NoSuchElementException("List Empty");
		}
		Node <N> tmp = new Node();
		tmp=this.first;
		while(tmp!=null) {
			if(tmp==item) {
				return true;
			}
			else{
				tmp=tmp.next;
			}
		}
		return false;
	}

	/**
	 * Returns the data in the node located in the given index 
	 * @param index
	 * @return
	 */
	public N get(int index) {
		if(this.isEmpty()||index<0||index>=this.size) {
			throw new NoSuchElementException("Index not valid");
		}
		else if(index==0) {
			return this.getFirst();
		}
		else if(index==this.size-1) {
			return this.getLast();
		}
		Node <N> tmp = new Node();
		tmp=this.first;
		for(int i=0;i<index;i++) {
			tmp=tmp.next;
		}
		return tmp.data;
	}
	

	/**
	 * Return the first element data
	 * @return
	 */
	public N getFirst() {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.first.data;
	}

	/**
	 * Return the last element data
	 * @return
	 */
	public N getLast() {
		if(this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.last.data;
	}
	
	/**
	 * Returns the index where the given item its located
	 * @param item
	 * @return
	 */
	public int indexOf(N item) {
		if(this.isEmpty()||item==null) {
			throw new NoSuchElementException("Item not valid");
		}
		Node <N> tmp = new Node();
		tmp=this.first;
		int index=0;
		while(tmp!=null) {
			if(tmp.data==item) {
				return index;
			}
			else{
				tmp=tmp.next;
			}
			index++;
		}
		return -1;
	}
	
	/**
	 * Insert first
	 * @param data
	 */
	public void addFirst(N data) {
		Node <N> node = new Node<N>(data,this.first,null);
		if(this.isEmpty()) {
			this.last=node;
		}
		else {
			this.first.prev=node;
		}
		this.first=node;
		this.size++;
	}

	/**
	 * Add's the given data to the last position 
	 * @param data
	 */
	public void addLast(N data) {
		Node <N> node = new Node<N>(data,null,this.last);
		if(this.isEmpty()) {
			this.addFirst(data);
		}
		else {
			this.last.next=node;
			this.last=node;
			this.size++;
		}
	}

	/**
	 * Add's the given data in the given index
	 * @param index
	 * @param data
	 */
	public void add(int index,N data) {
		if(index>this.size||index<0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		else if(index==0){
			this.addFirst(data);
		}
		else if(index==this.size){
			this.addLast(data);
		}
		else{
			Node <N> tmp=this.first;
			for(int i=0; i<index;i++) {
				tmp=tmp.next;
			}
			Node <N> node = new Node<N>(data,tmp,tmp.prev);
			tmp.prev=node;
			node.prev.next=node;
			this.size++;
		}

	}


	/**
	 * Removes the first element
	 */
	public N removeFirst(){
		if(this.isEmpty()) {
			return null;
		}
		else if(this.size==1) {
			Node <N> tmp = this.first;
			this.first=null;
			this.last=this.first;
			this.size--;
			return tmp.data;
		}
		else{
			Node <N> tmp = this.first;
			this.first = tmp.next;
			this.first.prev=null;
			this.size--;
			return tmp.data;
		}
	}

	/**
	 * Removes the first element
	 */
	public N removeLast(){
		if(this.isEmpty()) {
			return null;
		}
		else if(this.size==1) {
			Node <N> tmp = this.first;
			this.first=null;
			this.last=this.first;
			this.size--;
			return tmp.data;
		}
		else{
			Node <N> tmp = this.last;
			this.last = tmp.prev;
			this.last.next=null;
			this.size--;
			return tmp.data;
		}
	}

	/**
	 * Removes the first element
	 * @param index
	 * @return
	 */
	public N remove(int index){
		if(this.isEmpty()||index==this.size||index<0) {
			return null;
		}
		else if(index==0){
			return this.removeFirst();
		}
		else if(index==this.size){
			return this.removeLast();
		}
		else{
			Node <N> tmp=this.first;
			for(int i=0; i<index;i++) {
				tmp=tmp.next;
			}
			Node <N> t;
			tmp.prev.next=tmp.next;
			tmp.next.prev=tmp.prev;
			this.size--;
			return tmp.data;
		}
	}

	@Override
	public Iterator<N> iterator() {
		return new DLIterator<>(this.first);
	}

	public static class DLIterator<N> implements Iterator<N>{
		int pos;
		Node<N> first;
		Node<N> current;
		Node<N> lastReturned;

		public DLIterator(Node<N> nodo) {
			this.current = nodo;
			this.lastReturned=null;
		}

		@Override
		public boolean hasNext() {
			return this.current!=null;
		}

		@Override
		public N next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			this.lastReturned=this.current;
			this.current=this.current.next;
			return this.lastReturned.data;
		}

		@Override
		public void remove() {
			throw new NoSuchElementException("Not implemented yet");
		}
	}

	/**
	 * Returns the list in a string
	 */
	public String toString() {
		StringBuilder tmp=new StringBuilder();
		Node <N>copy= new Node<N>();
		copy=this.first;
		for(int i=0;i<this.size;i++) { 
			tmp.append("Pos: "+i+"  Content: "+copy.data+"\n");
			copy=copy.next;
		}

		return tmp.toString();
	}


	public static void main(String[] args) {
		DoubleLinkedList<String> l= new DoubleLinkedList<>();
		l.addFirst("estás?\n");
		l.addFirst("¿Cómo ");
		l.addFirst("Hola ");
		l.addFirst("w");
		Iterator<String> it=l.iterator();
		System.out.println("Printing");
		for(String palabra: l) {
			System.out.println(palabra);
		}
		
		//System.out.println(l.contains("3"));
		
		System.out.println(l.size());
		
		System.out.println("pos 0: "+l.get(0));
		System.out.println("pos 1: "+l.get(1));
		System.out.println("pos 2: "+l.get(2));
		System.out.println("pos 3: "+l.get(3));
		
		System.out.println("Hola is in index: "+l.indexOf("¿cómo"));
		
		System.out.println(l);
	}
}