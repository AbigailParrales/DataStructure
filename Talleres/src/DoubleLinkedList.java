import java.util.NoSuchElementException;

public class DoubleLinkedList <N>{
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


	public Boolean isEmpty() {
		return this.first==null;
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
		this.first=node;
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
			//Node <N> t;
			tmp.prev.next=tmp.next;
			//tmp.next;
			this.size--;
			return tmp.data;
		}
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
	
	/*public boolean contains(int index) {
		try {
			if(index>=0&&this.get(index)!=null) {
				return true;
			}
			else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
	}*/

	/*//Actualiza el elemento en el indice indicado
	public void set(int index,N data) {

		Node tmp = new Node(0);
		tmp = this.first;

		while (tmp.key!=index) {
			tmp=tmp.next;
		}

		tmp.data=data;
	}*/

	/*//Regresar elemento
		public N get(N data) {

			Node tmp = new Node(0);
			tmp = this.first;

			while (tmp.next.key!=) {
				tmp=tmp.next;
			}

			return tmp.data;
		}*/

	/*public String toString() {
		String tmp="";

		Node <N>copy= new Node<N>();
		copy=this.first;

		for(copy=this.first;copy.next.next!=null;copy=copy.next) { 
			tmp+=("Código: "+copy.key+", "+copy.data+"\n");
		}

		return tmp;
	}*/
}