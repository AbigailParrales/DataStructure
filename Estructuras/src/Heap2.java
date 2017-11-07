import java.util.Arrays;

public class Heap2 {

	public int length;
	public int size;     // Number of elements in heap
	public int[] A;     // The heap array
	public Comparable [] data;	//

	//Constructor
	public Heap2(int length){
		this.size = 0;
		this.length=length;
		this.A=new int[this.length];
		data = new Comparable[this.length];
	}

	//Construct the heap from an array of items.
	public Heap2(int[] array,Comparable[] D){
		System.out.println("******************Constructor******************");

		this.size=array.length;
		this.length = array.length+1;
		System.out.println("Size: "+this.size);
		System.out.println("Length: "+this.length);
		A = new int[array.length+1];
		data = new Comparable[array.length+1];

		System.arraycopy(array, 0, A, 1, array.length);
		System.arraycopy(D, 0, data, 1, array.length);
		System.out.println("Constructor A prev Build Max"+ Arrays.toString(A)+"\n");

		BuidMaxHeap(A,data);
	}

	public void BuidMaxHeap(int[] array,Comparable[] D){
		for (int i = Math.floorDiv(array.length, 2); i > 0; i--){
			MaxHeapify(A,data,i);
		}
	}

	public void MaxHeapify(int[] array,Comparable[] D,int i){
		int l=left(i);
		int r=right(i);
		int largest;

		if(l<=this.size&&(this.A[l]>this.A[i])) {
			largest = l;
		}

		else {
			largest = i;
		}

		if(r<=this.size&&(this.A[r]>this.A[largest])) {
			largest=r;
		}

		if(largest!=i) {
			int tmp_i=this.A[i];
			int tmp_largest=this.A[largest];

			Comparable tmp_iD=this.data[i];
			Comparable tmp_largestD=this.data[largest];

			this.A[i]=tmp_largest;
			this.A[largest]=tmp_i;

			this.data[i]=tmp_largestD;
			this.data[largest]=tmp_iD;
			MaxHeapify(array,this.data, largest);
			
		}
		
	}

	public void HeapSort(int[] array,Comparable[] D) {
		this.BuidMaxHeap(array,D);
		int tmpSize=this.size;
		for(int i=this.size;i>0;i--) {

			int tmp_i=this.A[i];
			int tmp_1=this.A[1];

			Comparable tmp_iD=this.data[i];
			Comparable tmp_1D=this.data[1];

			this.A[i]=tmp_1;
			this.A[1]=tmp_i;

			this.data[i]=tmp_1D;
			this.data[1]=tmp_iD;

			this.size--;	
			MaxHeapify(A,data, 1);
			System.out.println("Array after sorted"+Arrays.toString(this.A)+"\n");
		}
		this.size=tmpSize;
	}

	public void insert(int x,Comparable d){
		System.out.println("---------------Estoy en insert----------------");
		System.out.println("Quiero ingresar "+d+", en la posición "+x);
		
		if(this.size == this.A.length-1) { 
			resize();
		}
		int pos = this.size+1;

		for(; pos > 1 && x>this.A[pos/2]; pos = pos/2 ) {
			this.A[pos] = this.A[pos/2];
			this.data[pos] = this.data[pos/2];
		}
		this.A[pos] = x;
		this.data[pos] = d;

		for (int i = Math.floorDiv(A.length, 2); i > 0; i--){
			MaxHeapify(A,data,i);
		}
		
		this.size++;
		System.out.println("\nKeys post-Insert:"+Arrays.toString(this.A));
		System.out.println("Arreglo post-Insert:"+Arrays.toString(this.data));
	}

	private void resize(){
		int [] old = this.A;
		int[] novo = new int[this.A.length * 2];
		this.length=this.A.length * 2;
		System.arraycopy(old, 0, novo, 0, old.length);
		this.A=novo;

		Comparable [] oldD = this.data;
		Comparable [] novoD = new Comparable[this.A.length * 2];
		System.arraycopy(oldD, 0, novoD, 0, old.length);
		this.data=novoD;

	}
	
	public void reset() {
		int[] tmp=new int[5];
		Comparable[] tmpC=new Comparable[5];
		
		this.A=tmp;
		this.data=tmpC;
		this.size=0;
		this.length=5;
	}

	public String toString(){
		String out = "";
		String outS = "";
		for(int i = 0; i < length; i++) { 
			out += A[i]+" ";
			outS += data[i]+" ";
		}
		String all=out+"\n"+outS;
		return all;
	}

	public int parent(int i) {
		return i/2;
	}

	public int left(int i) {
		if (2*i>=this.length) {
			return 0;
		}
		return 2*i;
	}

	public int right(int i) {
		if (2*i+1>=this.length) {
			return 0;
		}
		return 2*i+1;
	}	
}