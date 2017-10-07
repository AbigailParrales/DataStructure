
public class PruebaHashTable {

	public static void main(String[] args) {
		
		HashTable<Comparable> t= new HashTable<Comparable>(5);
		
		//System.out.println(t);
		
		t.add(2, "Dany");
		t.add(23, "Aby");
		t.add(24, "Kelly");
		t.add(12, "John");
		t.add(21, "Adrian");
		t.add(10, "Tomy");
		t.add(70, "Frank");
		t.add(450, "Samy");
		t.add(3, "Kike");
		
		System.out.println(t);
		
		System.out.println("Contains element 2?: "+ t.contains(2));
		System.out.println("Contains element 3?: "+ t.contains(3));
		
		t.set(2, "Gely");
		
		System.out.println(t);		
	}

}
