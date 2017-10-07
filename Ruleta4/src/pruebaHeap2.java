import java.util.Arrays;

public class pruebaHeap2 {

	public static void main(String[] args) {
			//Heap2 h=new Heap2(4);
			int[] a = {4,7,7,7,5,0,2,3,5,1};
			Comparable[] info = {"A","B","C","D","E","F","G","H","I","J"};
			
			//System.out.println("Length"+a.length);
			Heap2 h=new Heap2(a,info);
			//h.insert(1, "A");
			//h.insert(2, "B");
			//h.insert(3, "C");
			
			System.out.println(h+"\n");
			System.out.println("Size of: "+h.size);
			System.out.println("Length: "+h.length+"\n");
			System.out.println("****************************Insert 1*****************************");
			h.insert(6,"Aby");
			
			System.out.println("Arreglo de keys"+Arrays.toString(h.A));
			System.out.println("Arreglo de data"+Arrays.toString(h.data));
			
			/*h.HeapSort(h.A,h.data);
			System.out.println("...........................Post HeapSort.............");
			System.out.println("Arreglo de keys"+Arrays.toString(h.A));
			System.out.println("Arreglo de data"+Arrays.toString(h.data));*/
		
			System.out.println("\n****************************Insert 2******************************");
			h.insert(10, "Ich");
			
			System.out.println("Arreglo de keys"+Arrays.toString(h.A));
			System.out.println("Arreglo de data"+Arrays.toString(h.data));
			
			h.HeapSort(h.A,h.data);
			System.out.println("...........................Post HeapSort.............");
			System.out.println("Arreglo de keys"+Arrays.toString(h.A));
			System.out.println("Arreglo de data"+Arrays.toString(h.data));
			
		}
	}
