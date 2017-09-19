public class linkedList <N>{
	private Node current;
	int size;
	
	public class Node {
		public N data;
		public Node next;
		public int key;

		public Node (N data,int key) {
			this.key=key;
			this.data=data;
		}
		public Node(int key) {
			this.key=key;
			this.data = null;
		}
	}

	//Constructores
	public linkedList() {
		this.current=new Node(1);
		this.current.next=new Node(0);
	}

	public linkedList(N data) {
		this.current=new Node(data,1);
		this.current.next=new Node(0);
	}
	
	
	//Insertar en la cabeza
	public void add(N data) {
		Node node = new Node(data,this.current.key+1);

		node.next=this.current;
		this.current=node;
		
		this.size++;
	}
	
	/*
	//Insertar en el índice
		public void add(int index,N data) {
			Node node = new Node(data);

			node.next=this.current;
			this.current=node;
		}
	*/

	//Regresa la cabeza
	public N getFirst() {
		return this.current.data;
	}
	
	//Regresar elemento
	public N get(int index) {
		
		Node tmp = new Node(0);
		tmp = this.current;
		
		while (tmp.next.key!=index) {
			tmp=tmp.next;
		}
		
		return tmp.data;
	}
	
	//Elimina el elemento mas reciente
	public void removeFirst(){
		if(this.isEmpty()) {
			System.out.println("Ya no hay elementos a eliminar");
		}
		else{
			this.current = this.current.next;
		}
	}

	public Boolean isEmpty() {
		return this.current==null;
	}

	public String toString() {
		String tmp="";

		Node copy= new Node(0);
		copy=this.current;
		
		for(copy=this.current;copy.next.next!=null;copy=copy.next) { 
			System.out.println(copy.data+"");
		}

		return tmp;
	}
	
	/*public boolean isDañada() {
		Node copy= new Node(null);
		copy=this.current;
		int i=0;
		
		for(copy=this.current;copy.next!=null;copy=copy.next) {
			i++;
		}
				
		if(i==this.size) {
			
		}
		else {
			
		}
	}*/
	
	/*public static void main(String[] args) {
		linkedList <Integer> L = new linkedList<Integer>();
		System.out.println("creé la lista" +L);
		
		L.add(1);
		System.out.println("añadí un elemento");
		System.out.println(L);
		System.out.println(L);
		
		L.add(2);
		System.out.println("añadí un elemento");
		System.out.println(L);
		System.out.println(L);

		L.add(3);
		System.out.println("añadí un elemento");
		System.out.println(L);
		System.out.println(L);
		
		System.out.println(L.getFirst()+"");
		
		
		
	}*/
	

}