import java.util.ArrayList;

public class CincularLinkedList <N>{
	public Node sentinel;
	public Node actual;

	public class Node{
		public N data;
		public Node next;
		public Node prev;
		
		public Node(N data){
			this.next=this.prev=null;
			this.data=data;
		}
		
	}

	//Constructor
	public CincularLinkedList() {
		this.sentinel= new Node(null);
		this.sentinel.next=this.sentinel.prev=this.sentinel;
		this.actual=this.sentinel;
	}

	//Insert
	public void insert(N data) {//Inserta a la derecha del sentinela
		Node x = new Node(data);
		
		x.next=this.actual.next;
		x.prev=this.actual;
		
		this.actual.next.prev=x;
		this.actual.next=x;
		
		this.actual=x;
	}

	//Deletion
	public void delete() {//Borra el elemento de la derecha del sentinela
		if (this.actual==this.sentinel) {
			System.out.println("Underflow");
		}
		else {
			this.actual.prev.next=this.actual.next;
			this.actual.next.prev=this.actual.prev;
			
			this.actual=this.actual.next;
		}
	}

	//toString
	public String toString() {
		
		System.out.println("Entré a toString");
		
		String txt="";
		Node x= new Node(null);
			
		for (x=sentinel.next; x!=sentinel; x=x.next) {//recorre la lista
			txt += x.toString()+""+"\n";//concatena los strings
		}
	
		return txt;
	}

	//mueve el nodo actual a la derecha y regresa el nodo siguiente
	//Usar para recorrer el arreglo para la 
	//función de avanzar y regresar en el reproductor 
	public N next() {
		if(this.actual.next != sentinel) {
			this.actual= this.actual.next;
			return this.actual.data;
		}
		else {
			this.actual= this.actual.next.next;
			return this.actual.data;
		}
	}
	
	//Regresar
	public N back() {
		if(this.actual.prev != sentinel) {
			this.actual= this.actual.prev;
			return this.actual.data;
		}
		else {
			this.actual= this.actual.prev.prev;
			return this.actual.data;
		}
	}
	
	public N actual() {//regresa el dato almacenado en el nodo actual
		return this.actual.data;
	}

}
