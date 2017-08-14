
public class myStack <N extends Comparable<N>>{

	
	private static class Node {
		private Comparable data;
		private Node next;
		private Node (Comparable data) {
			this.data=data;
		}
	}
	
	public Node top;
	
	public void push(Comparable data) {
		Node node = new Node(data);
		node.next= top;
	}
	
	public Comparable pop(){
		Comparable data = top.data;
		top = top.next;
		return data;
	}
	
	public Node peek() {
		return top;
	}
	
	public Boolean isEmpty() {
		return top==null;
	}
	
}