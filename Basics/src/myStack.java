import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class myStack <N>{
	private Node top;

	public static class Node {
		public Comparable data;
		public Node next;

		public Node (Comparable data) {
			this.data=data;
		}

		public Node() {
			this.data = "";
			this.next = new Node(0);
		}


	}

	public void push(Comparable data) {
		Node node = new Node(data);
		if (this.isEmpty()) {
			//System.out.println("estoy en el if del push");
			node.next=null;
			this.top=node;
		}
		else {
			//System.out.println("estoy en el else del push");

			//System.out.println("haciendo el top el nuevo next de node");

			node.next=this.top;

			//System.out.println("haciendo top igual a node");

			this.top=node;
			//System.out.println("este es el elemento top: "+ this.top);
		}
	}

	public void pop(){
		this.top = this.top.next;
	}

	public Comparable peek() {
		return this.top.data;
	}

	public Boolean isEmpty() {
		return this.top==null;
	}

	public String toString() {
		System.out.println("estoy en toString()\n");

		String tmp="";

		System.out.println("hice una copia de top");
		Node copy= new Node(0);
		copy=this.top;

		while (copy!=null){
			System.out.println("Estoy en el while");
			tmp+=copy.data+", ";
			if(copy.next==null) {
				break;
			}
			else {
				copy=copy.next;
				System.out.println("tmp actualizada= "+ tmp );
				System.out.println("nuva data del copy: "+ copy.data+"");
			}
		}

		System.out.println("Salí del while");
		System.out.println("Este es el tmp que regresaré: "+tmp);
		System.out.println("Saliendo de toString()\n");

		return tmp;
	}

}