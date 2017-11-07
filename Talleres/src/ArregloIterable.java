import java.util.Iterator;

public class ArregloIterable implements Iterator<Integer> {
	private int datos[];

	public ArregloIterable(int datos[]) {
		this.datos=datos;
	}
	
	public Iterator<Integer> iterator(){
		return new ArregloIterable(this.datos);
	}
	
	/*public static class ArregloIterador implements Iterator<Integer>{

		private int pos;
		private int datos[];
		
		public ArregloIterador(int datos[]) {
			pos=0;
			this.datos=datos;
		}
		
		@Override
		public boolean hasNext() {
			return pos<this.datos.length;
		}

		@Override
		/*public Integer next() {
			if(!hasNext()) {
				
			}
			return ;
		}*/
		
	
	
	
	
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		ArregloIterable tablaIter=new ArregloIterable(arr);
		Iterator<Integer> it = tablaIter.iterator();
		System.out.println("Recorrido on el iterador de la clase");
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("Con for-each, ya que es iterable");
		/*for(Integer num:tablaIter) {
			System.out.println(num);
		}*/
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

}
