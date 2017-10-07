
public class HashTable <N>{
	protected int m;		//number of slots....size
	protected double A;

	public linkedList <N>[] table;	//table

	public HashTable(){ 						//Default constructor with
		this.m=5;								//size 20, and
		this.A=(Math.sqrt(5)-1)/2;				//A is the Knuth's suggestion

		this.table= new linkedList [this.m];	//initializes the array of linked lists
		for(int i = 0; i<this.m;i++) {			//this loop, initializes
			this.table[i]= new linkedList<N>();	//each linked list of the array
		}
	}

	public HashTable(int size){					//Constructor with desired size
		this.m=size;
		this.A= (Math.sqrt(5)-1)/2;				//A is the Knuth's suggestion

		this.table= new linkedList [this.m];
		for(int i = 0; i<this.m;i++) {
			this.table[i]= new linkedList<N>();	//Initializes the linked lists
		}
	}

	public int hash(int key) {					//Multiplication hash function
		int tmp=(int) (Math.floor(this.m*((this.A*key)%1)));
		return tmp;
	}

	public void add(int key, N data) {			//Add's the given key's data calling the hash function first for obtaining the index in the table
		int h=this.hash(key);
		this.table[h].add(key,data);
		//System.out.println("Añadiendo "+data+"En el lote: "+h);
	}
	
	public void set(int key, N data) {			//Set's the data in the given key to the new data
		int h=this.hash(key);
		this.table[h].set(key, data);
	}

	public boolean contains(int key) {			//Checks if the hash table contains the given key
		int code=this.hash(key);

		if(this.table[code].contains(key)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void remove(int key) {				//Removes the first node of the list in the slot given by the hashCode of the given key
		this.table[(int) this.hash(key)].removeFirst();
	}

	public String toString() {
		String txt="";
		for(int i=0;i<this.m;i++) {
			txt+="Slot"+ i+"\n"+this.table[i]+"\n";
		}
		return txt;
	}

}
