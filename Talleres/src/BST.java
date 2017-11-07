
public class BST <K extends Comparable <K>,V>{
	private BSTNode root;

	private class BSTNode{
		K key;
		V val;
		BSTNode right,left;

		public BSTNode(K key,V val) {
			this.key=key;
			this.val=val;
		}

		public String toString() {
			return "["+key+"-"+val+"]";
		}
	}

	public boolean isEmpty() {
		return this.root==null;
	}

	public void put(K key,V value) {
		int comp;
		BSTNode nodo = this.root;
		BSTNode tmp = null;

		while(nodo != null) {
			tmp = nodo;
			comp = key.compareTo(nodo.key);
			if(comp<0) {
				nodo=nodo.left;
			}
			else if(comp>0) {
				nodo=nodo.right;
			}
			else if(comp==0) {
				nodo.val=value;
				return ;
			}
		}

		if(tmp==null) {
			this.root= new BSTNode(key, value);
		}
		else {
			if(key.compareTo(tmp.key)>0) {
				tmp.right=new BSTNode(key, value);
			}
			else {
				tmp.left=new BSTNode(key, value);
			}
		}
	}

	public void add(K key,V val) {
		if(isEmpty()) {
			this.root= new BSTNode(key, val);
		}
		else {
			add(key,val,this.root);
		}
	}

	private void add(K key, V val, BST<K, V>.BSTNode nodo) {
		if(nodo!=null) {
			if(key.compareTo(nodo.key)>0) {
				if (nodo.right!=null) {
					add(key, val, nodo.right);
				}
				else {
				nodo.right=new BSTNode(key, val);
				}
			}
			else if(key.compareTo(nodo.key)<0) {
				if (nodo.left!=null) {
					add(key, val, nodo.left);
				}
				else {
				nodo.left=new BSTNode(key, val);
				}
			}
			else if(key.compareTo(nodo.key)==0){
				nodo.val=val;
			}
		}
	}

	private BSTNode sucesor(BSTNode nodo) {
		BSTNode actual;
		BSTNode anterior;
		if(nodo.left==null&&nodo.right==null) {
			nodo = null;
		}
		else if(nodo.right==null){
			nodo = nodo.left;
		}
		else if(nodo.left==null) {
			nodo = nodo.right;
		}
		else{
			actual = nodo.right;
			anterior = null;
			while (actual.left!=null) {
				anterior=actual;
				actual=actual.left;
			}
			nodo.val=actual.val;
			if(anterior==null) {
				nodo.right=actual.right;
			}
			else {
				anterior.left=actual.right;
			}
			nodo=actual;
		}
		return nodo;
	}

	public boolean remove(K key) {
		if(isEmpty()) {
			throw new NullPointerException("Empty Tree");
		}
		else {
			BSTNode actual,anterior;
			actual=this.root;
			anterior=this.root;
			boolean encontrado=false;
			while(actual!=null&&!encontrado) {
				if(actual.key.equals(key)) {
					encontrado=true;
				}
				else {
					anterior=actual;
					if(actual.key.compareTo(key)>0) {
						actual=actual.left;
					}
					else {
						actual=actual.right;
					}
				}
			}
			if(actual==null) {
				return false;
			}
			else if(encontrado) {
				if(actual==this.root) {
					BSTNode tmp=sucesor(this.root);
					this.root.key=tmp.key;
					this.root.val=tmp.val;
					tmp.key=null;
					tmp.val=null;
				}
				else if(anterior.key.compareTo(key)>0) {
					anterior.left=sucesor(actual);
				}
				else if(anterior.key.compareTo(key)<0) {
					anterior.right=sucesor(actual);
				}
			}
			return true;
		}
	}

	public String inorder() {
		if (this.root!=null) {
			return inorder(this.root);
		}
		else
			return "";
	}

	private String inorder(BSTNode x) {
		String salida="";
		if(x.left!=null) {
			salida += inorder(x.left) + "";
		}
		salida+=x.key+", ";
		if(x.right!=null) {
			salida += "" + inorder(x.right);
		}
		return salida;
	}
	
	public String preorder() {
		if (this.root!=null) {
			return preorder(this.root);
		}
		else
			return "";
	}

	private String preorder(BSTNode x) {
		String salida="";
		salida+=x.key+", ";
		if(x.left!=null) {
			salida += preorder(x.left) + "";
		}
		if(x.right!=null) {
			salida += "" + preorder(x.right);
		}
		return salida;
	}
	
	public String postorder() {
		if (this.root!=null) {
			return postorder(this.root);
		}
		else
			return "";
	}

	private String postorder(BSTNode x) {
		String salida="";
		if(x.left!=null) {
			salida += postorder(x.left) + "";
		}
		if(x.right!=null) {
			salida += "" + postorder(x.right);
		}
		salida+=x.key+", ";
		return salida;
	}

	public static void main(String[] args) {
		BST<Integer,String> bT= new BST<Integer,String>();
		bT.add(5, "E");
		bT.add(1, "A");
		bT.add(6, "F");
		bT.add(2, "B");
		bT.add(7, "G");
		bT.add(3, "C");
		bT.add(8, "H");
		bT.add(4, "D");
		
		bT.add(9, "I");
		bT.add(12, "L");
		bT.add(10, "J");
		bT.add(13, "M");
		bT.add(11, "K");
		bT.add(14, "N");
		bT.add(15, "O");
		
		System.out.println(bT.inorder());
		System.out.println(bT.preorder());
		System.out.println(bT.postorder());
		//bT.remove(5);
		//System.out.println(bT.inorder());
		
	}
}