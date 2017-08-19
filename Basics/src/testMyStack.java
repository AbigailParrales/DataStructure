import java.util.Scanner;

import javax.swing.JOptionPane;

public class testMyStack {

	public static void main(String[] args) {

		myStack myStack= new myStack<Integer>();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Introduzca una de las siguientes opciones: \n"
					+ "1) Insertar\n"
					+ "2) Eliminar\n"
					+ "3) Mostrar el elemento top\n"
					+ "4) Mostrar todo el Stack"
					//+ "---------------------------------------------------------------------\n"
					+ "\n");

			int opcion = Integer.parseInt(sc.nextLine());

			switch (opcion) {
			case 1:
				System.out.println("Introduzca un número"+"\n");
				int num = Integer.parseInt(sc.nextLine());
				myStack.push(num);
				System.out.println("Se introdujo el número: "+num+"\n");
				break;
			case 2:
				if(myStack.isEmpty()) {
					System.out.println("El Stack está vacio"+"\n");
				}
				else {
					myStack.pop();
					System.out.println("Se ha elimidado el elemento top"+"\n");
				}
				break;
			case 3:
				if(myStack.isEmpty()) {
					System.out.println("El Stack está vacio"+"\n");
				}
				else {
					System.out.println("El elemento top es: "+ myStack.peek()+"\n");
				}
				break;
			case 4:
				System.out.println("entré al case 4");
				if(myStack.isEmpty()) {
					System.out.println("El Stack está vacio"+"\n");
				}
				else {
					System.out.println("entré al else del case 4");
					
					myStack.toString();
					//System.out.println("myStack= "+ myStack+"\n");
					
					System.out.println("terminé el else del case 4");
				}  
				//System.out.println(myStack.toString());
				break;
			default:
				break;
			}
		}
	}
}
