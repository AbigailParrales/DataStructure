
public class PruebaTchailHash {

	public static void main(String[] args) {
		//int[] keys={0,1,2,3,4,5};
		//String[] names= {"Dany","Aby","Kelly","John","Adrian","Tomy"};
		int[] keys={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		String[] names= {"Dany","Aby","Kelly","John","Adrian","Tomy","Frank","Samy","Kike","Eddy","Sophie","Carlos","Salim","Michael","Sayuri"};

		HashTchain<Integer,String> t= new HashTchain<>();
		for(int i=0;i<t.getM();i++) {
			t.put(keys[i], names[i]);
		}
		System.out.println("Imprimiendo hashTChained");
		System.out.println(t);

		/*
				t.add(0, "Dany");
				t.add(23, "Aby");
				t.add(24, "Kelly");
				t.add(12, "John");
				t.add(21, "Adrian");
				t.add(10, "Tomy");
				t.add(70, "Frank");
				t.add(450, "Samy");
				t.add(03, "Kike");
		 */

	}

}
