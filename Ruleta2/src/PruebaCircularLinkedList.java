import java.util.Scanner;

public class PruebaCircularLinkedList {

	public static void main(String[] args) {
		myCincularLinkedList<Integer> list = new myCincularLinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("Probando la lista circular doblemente ligada\n"
					+ "introduzca una de las siguientes opciones: \n"
					+ "1) Insertar\n"
					+ "2) Delete\n"
					+ "3) Imprimir lista\n"
					+ "4) Avanzar\n"
					+ "5) Regresar\n"
					+ "----------------------------------");
			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Ingrese el número a insertar");
				int num = Integer.parseInt(sc.nextLine());
				list.insert(num);
				System.out.println("Se ha ingresado el número: "+ num);
				break;
			case 2:
				System.out.println("Se está eliminando el último elemento agregado");
				list.delete();
				break;
			case 3:
				System.out.println(list);
				break;
			case 4:
				System.out.println(list.next());
				break;
			case 5:
				System.out.println(list.back());
				break;
			default:
				break;
			}
		}
	}

}
