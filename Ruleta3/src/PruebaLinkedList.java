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
					+ "6) set\n"
					+ "7) Contains\n"
					+ "----------------------------------");
			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Ingrese el n�mero a insertar");
				int num = Integer.parseInt(sc.nextLine());
				System.out.println("Ingrese la clave del n�mero que ingres�");
				int k = Integer.parseInt(sc.nextLine());
				l.add(num,k);
				System.out.println("Se ha ingresado el n�mero: "+ num);
				break;
			case 2:
				System.out.println("Se est� eliminando el �ltimo elemento agregado");
				l.removeFirst();
				break;
			case 3:
				System.out.println(l);
				System.out.println("Este es el tama�o: "+ l.size);
				break;
			case 4:
				System.out.println("Este es el elemento actual: "+ l.getFirst()+"");
			case 5:
				System.out.println("Ingrese el �ndice del elemento a obtener");
				int index = Integer.parseInt(sc.nextLine());
				if(index<=l.size){
					System.out.println(l.get(index)+"");
				}
				else {
					System.out.println("No existe ese elemento");
				}
				break;
			case 6:
				System.out.println("Ingrese el �ndice del elemento a cambiar");
				int x = Integer.parseInt(sc.nextLine());
				System.out.println("Este era el data anterior: "+ l.get(x)+"\n"
						+ "Ingrese por favor el nuevo data");
				int act = Integer.parseInt(sc.nextLine());
				System.out.println("Actualizando su data");
				l.set(x, act);
				System.out.println("Nueva data: "+l.get(x));
				break;
			case 7:
				System.out.println("Ingrese el �ndice del elemento a obtener");
				int z = Integer.parseInt(sc.nextLine());
				System.out.println(l.contains(z)+"");
				break;
			default:
				break;
			}
		}

	}

}
