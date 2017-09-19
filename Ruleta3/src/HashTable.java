
public class HashTable <N>{
	private int m;		//number of sluts
	private linkedList <N>[] table;	//table
	
	public HashTable(){
		this.m=20;
		this.table= new linkedList [this.m];
		for(int i = 0; i<this.m;i++) {
			this.table[i]= new linkedList<N>();
		}
	}
	
	public HashTable(int size){
		this.m=size;
		this.table= new linkedList [this.m];
		for(int i = 0; i<this.m;i++) {
			this.table[i]= new linkedList<N>();
		}
	}
	
	public void add(int key, N data) {
		table[this.hash(key)].add(data);
	}
	
	public int hash(int key) {
		long A= (long) ((Math.sqrt(5)-1)/2);
		int tmp=(int) (this.m*(Math.floorMod((A*key),(long) 1.0)));
		return tmp;
	}
}
