package Ruleta1;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class myStack <N> implements Pintable{
	private Node top;
	private Point P0;

	public myStack(N data) {
		this.top=new Node(data);
		this.P0=new Point();
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

		while (copy!=null){
			//			System.out.println("Estoy en el while");
			tmp+=copy.data+", ";
			if(copy.next==null) {
				break;
			}
			else {
				copy=copy.next;
				//				System.out.println("tmp actualizada= "+ tmp );
				//				System.out.println("nuva data del copy: "+ copy.data+"");
			}
		}

		//		System.out.println("Salí del while");
		//		System.out.println("Este es el tmp que regresaré: "+tmp);
		//		System.out.println("Saliendo de toString()\n");

		return tmp;
	}

	@Override
	public void pintate(Graphics g) {
		ArrayList<N> tmp= new ArrayList<N>();

		Node copy= new Node(null);
		copy=this.top;

		while (copy!=null){
			tmp.add(copy.data);

			if(copy.next==null) {
				break;
			}
			else {
				copy=copy.next;
			}		
		}

		//System.out.println("Elementos en el stack: "+tmp+"");

		for(int i = 0; i<tmp.size();i++) {
			if(i==0) {
				((Pintable) tmp.get(i)).agregarCoordenada(this.P0.x, this.P0.y-100);
			}
			else if(i==1) {
				((Pintable) tmp.get(i)).agregarCoordenada(this.P0.x, this.P0.y-50);
			}
			else if(i==2) {
				((Pintable) tmp.get(i)).agregarCoordenada(this.P0.x, this.P0.y);
			}
			((Pintable) tmp.get(i)).pintate(g);
		}
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		this.P0.setLocation(x, y);
	}

	@Override
	public void seleccionar() {
		//System.out.println("Estoy en seleccionar de myStack");
		((Pintable) this.top.data).seleccionar();
	}


}