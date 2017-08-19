
public class myStack <N>{
	private Node top;
	private int length;
	
	public static class Node {
		public int key;
		public Comparable data;
		public Node next;
		
		public Node (Comparable data) {
			this.data=data;
		}
}

	public void push(Comparable data) {
		Node node = new Node(data);
		node.next= top;
		length++;
	}
	
	public void pop(){
		top = top.next;
	}
	
	public Node peek() {
		return top;
	}
	
	public Boolean isEmpty() {
		return top==null;
	}
	
	public String toString() {
		String tmp="";
		Node copy= new Node(0);
		
		for(int i = 0;i>length;i++) {
			tmp+=top.data;
			
		}
		
		return null;
	}
	
}