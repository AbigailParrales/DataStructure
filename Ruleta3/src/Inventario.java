
public class Inventario {
	public HashTable<Producto> t;
	
	public Inventario() {
		this.t = new HashTable<Producto>(5);
		
		//System.out.println(this.t);
	}
	
	public static void main(String[] args) {
		Inventario i=new Inventario();
		
		i.t.add(0, new Producto("Rufles", "Sabritas", 11, 400));
		i.t.add(2, new Producto("Churrumais", "Sabritas", 9, 400));
		i.t.add(4, new Producto("Chetos", "Sabritas", 10, 400));
		
		i.t.add(1, new Producto("J7", "Samsumg", 3000, 30));
		i.t.add(3, new Producto("iPhone X", "Apple", 30000, 10));
		i.t.add(5, new Producto("Inspiron 15", "Dell", 15000, 30));
		i.t.add(7, new Producto("GL62 7RD-434MX", "MSI", 30000, 7));
		i.t.add(9, new Producto("Galaxy", "Samsumg", 3000, 30));
		
		i.t.add(11, new Producto("Skinny high rise jeans", "Levis", 800, 30));
		i.t.add(16, new Producto("Mocasines Veronica", "Naturalizer Women's Veronica Penny Loafer", 2000, 30));
		
		
		
		int keyP=3;
		
		System.out.println(i.t);
		
		int h = i.t.hash(keyP);
		
		System.out.println(i.t.table[h].contains(keyP));
		
		i.t.set(3, new Producto("Estuche", "MSI", 30000, 7));
		
		System.out.println(i.t);
	
	}
	
}
