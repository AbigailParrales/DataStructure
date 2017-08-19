import java.util.Scanner;

import javax.swing.JOptionPane;

public class testMyStack {

	public static void main(String[] args) {

		myStack myStack= new myStack<Integer>();

		Scanner sc = new Scanner(System.in);

		System.out.println("Introduzca una de las siguientes opciones: \n"
				+ "1) Insertar\n"
				+ "2) Eliminar\n"
				+ "3) Mostrar el elemento top\n"
				+ "4) Mostrar todo el Stack");

		int opcion = Integer.parseInt(sc.nextLine());

		switch (opcion) {
		case 1:
			System.out.println("Introduzca un número");
			int num = Integer.parseInt(sc.nextLine());
			System.out.println("Se introdujo el número");
			break;
		case 2:
			if(myStack.isEmpty()) {
				System.out.println("El Stack está vacio");
			}
			else {
				myStack.pop();
				System.out.println("Se ha elimidado el elemento top");
			}
			break;
		case 3:
			if(myStack.isEmpty()) {
				System.out.println("El Stack está vacio");
			}
			else {
				System.out.println("El elemento top es: "+ myStack.peek());
			}
			break;
		case 4:
			if(myStack.isEmpty()) {
				System.out.println("El Stack está vacio");
			}
			else {
				String tmp="";
				//for(int i = 0;i>myStack.length;i++) {

			}

			break;
		default:
			break;
		}
	}
}
