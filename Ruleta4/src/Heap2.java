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
		//System.out.println("____________________________________________________________________");
	}

	public void BuidMaxHeap(int[] array,Comparable[] D){
		//System.out.println("**************************Entré a BuildMaxHeap*************************");
		//System.out.println("Size: "+ this.size);
		//System.out.println("Length: "+A.length);
		//System.out.println("Length received array: "+array.length);
		//System.out.println("Arreglo recibido en BuldMaxHeap "+Arrays.toString(A)+"\n");

		//this.size=array.length;
		
		System.out.println("Size pre for: "+ this.size);
		
		for (int i = Math.floorDiv(array.length, 2); i > 0; i--){
			//System.out.println("i for BMH "+i);
			MaxHeapify(A,data,i);
		}

		/*System.out.println("Size at the end of BuildMaxHeap: "+ this.size);

		System.out.println("A post max heapify del BuildMaxHeap: "+Arrays.toString(A)+"\n");
		System.out.println("================Terminé Buid Max===========");*/
	}

	public void MaxHeapify(int[] array,Comparable[] D,int i){
		/*System.out.println("\n.........................Estoy en Max heapify...............................");
		System.out.println("Arreglo recibido en Heapify"+Arrays.toString(array));
		System.out.println("Arreglo del heap "+Arrays.toString(A));
		System.out.println("i: "+i+"\n");*/

		int l=left(i);
		int r=right(i);
		int largest;

		/*System.out.println("l: "+l);
		System.out.println("r: "+r+"\n");*/

		//if 1
		if(l<=this.size&&(this.A[l]>this.A[i])) {
			//System.out.println("Entre a if1");
			largest = l;
			//System.out.println("largest: "+largest+"\n");
			//System.out.println("Size: "+this.size);
		}

		else {
			//System.out.println("Entre a else");
			largest = i;
			//System.out.println("largest: "+largest+"\n");
			//System.out.println("Size: "+this.size);
		}

		//if2
		if(r<=this.size&&(this.A[r]>this.A[largest])) {
			//System.out.println("Entre a if2");
			largest=r;
			//System.out.println("largest: "+largest+"\n");
			//System.out.println("Size: "+this.size);
		}

		//if intercambio
		if(largest!=i) {
			//System.out.println("Entre a if-intercambio");
			int tmp_i=this.A[i];
			int tmp_largest=this.A[largest];

			Comparable tmp_iD=this.data[i];
			Comparable tmp_largestD=this.data[largest];

			this.A[i]=tmp_largest;
			this.A[largest]=tmp_i;

			this.data[i]=tmp_largestD;
			this.data[largest]=tmp_iD;
			//System.out.println("Size: "+this.size);
			MaxHeapify(array,this.data, largest);
			
		}
		
	}

	public void HeapSort(int[] array,Comparable[] D) {
		//System.out.println("-------------------------------------------------------------------------");
		//System.out.println("\n***************Entré a HeapSort***************************");
		//System.out.println("size: "+this.size);
		//System.out.println("length: "+this.length);
		//this.BuidMaxHeap(array,D);
		//System.out.println("Sigo en HeapSort");
		//System.out.println(Arrays.toString(this.A));
		//System.out.println("size: "+this.size);
		//System.out.println("length: "+this.length);
		//System.out.println("length array: "+this.A.length+"\n");
		for(int i=this.size;i>0;i--) {
			//System.out.println("i Sort: "+i);

			int tmp_i=this.A[i];
			int tmp_1=this.A[1];

			Comparable tmp_iD=this.data[i];
			Comparable tmp_1D=this.data[1];

			//System.out.println("tmp_i: "+tmp_i);
			//System.out.println("tmp_1: "+tmp_1);

			this.A[i]=tmp_1;
			this.A[1]=tmp_i;

			this.data[i]=tmp_1D;
			this.data[1]=tmp_iD;

			//System.out.println("A[i]= "+this.A[i]);
			//System.out.println("A[1]= "+this.A[1]);

			this.size=this.size-1;	


			//System.out.println("size throwed by HeapSort"+this.size);
			//System.out.println(Arrays.toString(this.A));
			MaxHeapify(A,data, 1);
			//System.out.println(Arrays.toString(this.A)+"\n");
		}
		/*System.out.println("size: "+this.size);
		System.out.println("length: "+this.length);
		System.out.println("Arreglo ordenado:"+Arrays.toString(this.A));
		System.out.println("Arreglo ordenado:"+Arrays.toString(this.data));*/
	}

	public void insert(int x,Comparable d){
		/*System.out.println("---------------Estoy en insert----------------");
		System.out.println("Quiero ingresar "+d+", en la posición "+x);
		*/
		if(this.size == this.A.length-1) { 
			resize();
		}
		//System.out.println("Size= "+this.size);
		int pos = this.size+1;

		for(; pos > 1 && x>this.A[pos/2]; pos = pos/2 ) {
			this.A[pos] = this.A[pos/2];
			this.data[pos] = this.data[pos/2];
		}
		//System.out.println("pos= "+pos);
		this.A[pos] = x;
		this.data[pos] = d;
		//-----------------------------------
		/*for(; pos > 1 && x>A[pos/2]; pos = pos/2 )
			A[pos] = A[pos/2];

		A[pos] = x;
		*/
		this.MaxHeapify(A, data, 1);
		this.size++;
		//System.out.println("\nKeys post-Insert:"+Arrays.toString(this.A));
		//System.out.println("Arreglo post-Insert:"+Arrays.toString(this.data));
	}

	private void resize(){
		//System.out.println("\n-------------------Estoy en resize-------------");
		int [] old = this.A;
		int[] novo = new int[this.A.length * 2];
		this.length=this.A.length * 2;
		System.arraycopy(old, 0, novo, 0, old.length);
		this.A=novo;

		Comparable [] oldD = this.data;
		Comparable [] novoD = new Comparable[this.A.length * 2];
		System.arraycopy(oldD, 0, novoD, 0, old.length);
		this.data=novoD;

		/*System.out.println("Heap size: "+this.size);
		System.out.println("Heap lenght: "+this.length);
		System.out.println("Arreglo de keys post resize"+Arrays.toString(this.A));
		System.out.println("Arreglo de keys post resize"+Arrays.toString(this.data)+"\n");*/
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