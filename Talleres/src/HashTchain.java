
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
	}

	public HashTchain() {
		this.m=INIT_CAPACITY;
		this.table=(Node<K,V>[])new Node[m];
		this.n=0;
	}

	public HashTchain(int m) {
		this.table=(Node<K,V>[])new Node[m];
		this.m=m;
		this.n=0;
	}

	private int hash(K k) {
		int tmp;
		long A= (long) ((Math.sqrt(5)-1)/2);
		int key= k.hashCode();
		tmp=(int) (Math.floor(this.m*((A*key)%1)));
		return tmp;
	}

	public int size() {
		return this.n;
	}
	
	public int getM() {
		return this.m;
	}
	
	public boolean isEmpty() {
		return n==0;
	}
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
}
