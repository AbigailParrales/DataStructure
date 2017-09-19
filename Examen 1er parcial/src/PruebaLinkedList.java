import java.util.Scanner;

public class PruebaLinkedList {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		linkedList <Integer> l = new linkedList<Integer>();

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Probando la lista doblemente ligada\n"
					+ "introduzca una de las siguientes opciones: \n"
					+ "1) Insertar\n"
					+ "2) Delete\n"
					+ "3) Imprimir lista\n"
					+ "4) Ver actual\n"
					+ "5) getElement\n"
					+ "----------------------------------");
			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Ingrese el número a insertar");
				int num = Integer.parseInt(sc.nextLine());
				l.add(num);
				System.out.println("Se ha ingresado el número: "+ num);
				break;
			case 2:
				System.out.println("Se está eliminando el último elemento agregado");
				l.removeFirst();
				break;
			case 3:
				System.out.println(l);
				System.out.println("Este es el tamaño: "+ l.size);
				break;
			case 4:
				System.out.println("Este es el elemento actual: "+ l.getFirst()+"");
			case 5:
				System.out.println("Ingrese el índice del elemento a obtener");
				int index = Integer.parseInt(sc.nextLine());
				if(index<=l.size){
					System.out.println(l.get(index)+"");
				}
				else {
					System.out.println("No existe ese elemento");
				}

			default:
				break;
			}
		}

	}

}
