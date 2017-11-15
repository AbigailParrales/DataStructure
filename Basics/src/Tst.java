import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Tst {

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(new File("C:\\Users\\Daniela Parrales\\Desktop\\A.txt"));
			br = new BufferedReader(fr);

			String sCurrentLine;
			String s="";

			while ((sCurrentLine = br.readLine()) != null) {
				s+=sCurrentLine;
				System.out.println(s); 
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}
