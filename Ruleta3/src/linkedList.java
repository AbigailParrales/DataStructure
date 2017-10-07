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
		this.size=0;
	}

	public linkedList(N data,int key) {
		this.current=new Node(data,key);
		this.current.next=new Node(0);
		this.size=0;
	}


	//Insertar en la cabeza
	public void add(int key,N data) {
		Node node = new Node(data,key);

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
		Node tmp = this.current;

		while (tmp!=null&&tmp.key!=index) {
			tmp=tmp.next;
		}

		return tmp.data;
	}

	public boolean contains(int index) {
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
	}

	//Actualiza el elemento en el indice indicado
	public void set(int index,N data) {

		Node tmp = new Node(0);
		tmp = this.current;

		while (tmp.key!=index) {
			tmp=tmp.next;
		}

		tmp.data=data;
	}

	/*//Regresar elemento
	public N get(N data) {

		Node tmp = new Node(0);
		tmp = this.current;

		while (tmp.next.key!=) {
			tmp=tmp.next;
		}

		return tmp.data;
	}*/

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
			tmp+=("Código: "+copy.key+", "+copy.data+"\n");
		}

		return tmp;
	}
}