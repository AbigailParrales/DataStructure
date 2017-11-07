/*
 * Autor: Daniela Abigail Parrales Mejia
 * Matrícula: A01228629
 * 
 * Hash Table*/


public class HashTchain <K,V>{
	private int m;		//The length of the table array
	private int n;		//The slots used in the table
	private static final int INIT_CAPACITY=11;
	private Node<K,V>[] table;

	class Node<K,V>{
		private K K;
		private V V;
		private Node<K,V> next;

		public Node(K K,V V,Node next) {
			this.K=K;
			this.V=V;

			this.next=next;
		}
		
		public Node() {
		}
		
		public V getV() {
			return this.V;
		}
	}
	/**
	 * Constructor with initial capacity of 11
	 */
	public HashTchain() {
		this.m=INIT_CAPACITY;
		this.table=(Node<K,V>[])new Node[m];
		this.n=0;
	}

	/**
	 * Constructor that receives the desired capacity
	 * @param m
	 */
	public HashTchain(int m) {
		this.table=(Node<K,V>[])new Node[m];
		this.m=m;
		this.n=0;
	}

	/**
	 * Multiplication hash function
	 * @param k
	 * @return
	 */
	private int hash(K k) {
		int tmp;
		long A= (long) ((Math.sqrt(5)-1)/2);
		int key= k.hashCode();
		tmp=(int) (Math.floor(this.m*((A*key)%1)));
		return tmp;
	}

	/**
	 * Returns true if the hash table is empty
	 * @return
	 */
	public boolean isEmpty() {
		return n==0;
	}
	
	/**
	 * Returns the value of the node with the given key 
	 * @param key
	 * @return
	 */
	public V get(K key) {
		if(key==null) {
			throw new NullPointerException("Key NIL");
		}
		int i = hash(key);
		for(Node <K,V> x=table[i];x!=null;x=x.next) {
			if(key.equals(x.K)) {
				return x.V;
			}
		}
		return null;
	}
	
	/**
	 * Inserts a node with the given key and the given value
	 * @param key
	 * @param value
	 */
	public void put(K key,V value) {
		if(key==null|value==null) {
			throw new NullPointerException("Key o value NIL");
		}
		int i=hash(key);
		for(Node<K,V> x =table[i];x!=null;x=x.next) {
			if(key.equals(x.K)) {
				x.V=value;
				return;
			}
		}
		table[i]=new Node<K,V>(key,value,table[i]);
	}

	/**
	 * Removes the node with the given key
	 * @param key
	 * @return
	 */
	public V remove(K key) {
		if(key==null) {
			throw new NullPointerException("Key NULL");
		}
		int i=hash(key);
		Node<K,V> aBorrar =table[i];
		Node<K,V> anterior =null;
		
		while(aBorrar.K!=key&&aBorrar.next!=null) {
			anterior=aBorrar;
			aBorrar=aBorrar.next;
		}
		
		if(anterior==null) {
			table[i]=table[i].next;
			aBorrar.next=null;
		}
		
		anterior.next=aBorrar.next;
		aBorrar.next=null;
		
		return aBorrar.V;
	}

	public int getM() {
		return m;
	}
	
	
}
