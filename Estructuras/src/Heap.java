import java.util.Arrays;

public class Heap {

	public int length;
	public int size;     // Number of elements in heap
	public int[] A;     // The heap array

	//Constructor
	public Heap(int length){
		this.size = 0;
		this.length=length;
		this.A=new int[this.length];
	}

	//Construct the heap from an array of items.
	public Heap(int[] array){

		this.size=array.length;
		this.length = array.length+1;
		A = new int[array.length+1];

		System.arraycopy(array, 0, A, 1, array.length);

		BuidMaxHeap(A);
	}

	public void BuidMaxHeap(int[] array){
		for (int i = Math.floorDiv(array.length, 2); i > 0; i--){
			MaxHeapify(A,i);
		}
	}

	public void MaxHeapify(int[] array,int i){

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

			this.A[i]=tmp_largest;
			this.A[largest]=tmp_i;

			MaxHeapify(array, largest);

		}

	}

	public void HeapSort() {
		int tmpSize=this.size;
		for(int i=this.size;i>0;i--) {

			int tmp_i=this.A[i];
			int tmp_1=this.A[1];

			this.A[i]=tmp_1;
			this.A[1]=tmp_i;

			this.size--;	

			MaxHeapify(A, 1);
		}
		this.size=tmpSize;
	}

	public void insert(int x){
		if(this.size == this.A.length-1) { 
			resize();
		}
		int pos = this.size+1;

		for(; pos > 1 && x>this.A[pos/2]; pos = pos/2 ) {
			this.A[pos] = this.A[pos/2];
		}
		this.A[pos] = x;

		for (int i = Math.floorDiv(A.length, 2); i > 0; i--){
			MaxHeapify(A,i);
		}

		this.size++;
		System.out.println("\nKeys post-Insert:"+Arrays.toString(this.A));
	}

	private void resize(){
		int [] old = this.A;
		int[] novo = new int[this.A.length * 2];
		this.length=this.A.length * 2;
		System.arraycopy(old, 0, novo, 0, old.length);
		this.A=novo;
	}

	public void reset() {
		int[] tmp=new int[5];

		this.A=tmp;
		this.size=0;
		this.length=5;
	}

	public String toString(){
/*		String out = "";
		for(int i = 0; i < length; i++) { 
			out += A[i]+" ";
		}
		String all=out+"\n";
		return all;*/
		return Arrays.toString(this.A);
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

	public int[] getA() {
		return A;
	}	
	
	public static void main(String[] args) {
		int[] a = {9,1,8,2,7,3,6,4,5};
		Heap h = new Heap(a);
		System.out.println(h);
		h.HeapSort();
		System.out.println(h);
	}
	
}