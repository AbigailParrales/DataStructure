public class Stack <N>{
	private Node top;

	public Stack(N data) {
		this.top=new Node(data);
	}

	public class Node {
		public N data;
		public Node next;
		public int key;

		public Node (N data) {
			this.key=0;
			this.data=data;
		}
		public Node() {
			this.key=0;
			this.data = null;
			this.next = new Node(null);
		}
	}


	public void push(N data) {
		Node node = new Node(data);

		if (this.isEmpty()) {
			node.next=null;
			this.top=node;
		}
		else {
			node.next=this.top;
			this.top=node;
		}
	}

	public void pop(){
		this.top = this.top.next;
	}

	public N peek() {
		return this.top.data;
	}

	public Boolean isEmpty() {
		return this.top==null;
	}

	public String toString() {
		//		System.out.println("estoy en toString()\n");

		String tmp="";

		//		System.out.println("hice una copia de top");
		Node copy= new Node(null);
		copy=this.top;
		
		/*
		 * txt += x.toString()+""*/

		for(copy=this.top;copy.next!=null;copy=copy.next) {
			//			System.out.println("Estoy en el while");
			tmp+=copy.toString()+""+"\n ";

			//				System.out.println("tmp actualizada= "+ tmp );
			//				System.out.println("nuva data del copy: "+ copy.data+"");
		}

		//		System.out.println("Salí del while");
		//		System.out.println("Este es el tmp que regresaré: "+tmp);
		//		System.out.println("Saliendo de toString()\n");

		return tmp;
	}

}