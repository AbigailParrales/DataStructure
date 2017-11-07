import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class BTree {
	private int t;
	private BNode root;

	private class BNode{
		boolean ifLeaf;
		int n;
		int[]x;
		int[]c;

		public BNode(int t) {
			this.ifLeaf=false;
			this.n=0;
			this.x= new int[2*t];	//keys
			this.c= new int[2*t];	//children
		}
	}

	public BTree(int t) {
		this.t=t;
		this.root=null;
	}

	private File write_disk(BNode nodo) {
		BufferedWriter writer = null;
		File f= new File("C:\\Users\\Daniela Parrales\\Documents\\GitHub\\DataStructure\\Talleres\\TextFiles_tmp\\"+nodo.x[0]+".ptr");
		try {
			writer = new BufferedWriter(new FileWriter(f));
			writer.write(nodo.ifLeaf+"\n");
			writer.write(nodo.n+"\n");
			writer.write(nodo.c[0]+".ptr\n");
			for(int i=0;i<nodo.n+1;i++) {
				writer.write(nodo.x[i]+".key\n");
				writer.write(nodo.c[i+1]+".ptr\n");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				// Close the writer regardless of what happens...
				writer.close();
			} 
			catch (Exception e) {
			}
		}
		return f;
	}

	private BNode read_disk(File archivo) {
		int[] x_tmp=new int[10];	//keys...key
		int[] c_tmp=new int[10];	//children...ptr
		String linea="";

		try {
			BufferedReader bf = new BufferedReader(new FileReader(archivo));
			int i=0;
			int even=0;
			int odd=0;
			String []separada=new String[10];
			while((linea=bf.readLine())!=null){
				System.out.println("Linea: "+i+"---- "+linea);
				
				if(i>1) {
					
					if (i%2==0) {//even
						separada=linea.split(".ptr");
						System.out.println("Separated .ptr: "+Arrays.toString(separada));
						c_tmp[even]=Integer.parseInt(separada[0]);
						even++;
					}
					else if(i%2!=0) {//odd
						separada=linea.split(".key");
						System.out.println("Separated .key: "+Arrays.toString(separada));
						x_tmp[odd]=Integer.parseInt(separada[0]);
						odd++;
					}
				}
				i++;
			}
			System.out.println(".ptr: "+Arrays.toString(c_tmp));
			System.out.println(".key: "+Arrays.toString(x_tmp));
			bf.close();
			
		} 
		catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado"+e);
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("Error al intentar leer el archivo"+e);
		}
		

	}

}
