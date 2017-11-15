import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class hexaConverter {

	public void toHex(String letra) {
		String conc = "";
		String help = "";
		String s="";
		String sCurrentLine= "";

		BufferedReader br = null;
		FileReader fr = null;

		try {
			fr = new FileReader(new File("C:\\Users\\Daniela Parrales\\Documents\\Escuela\\Universidad\\3er Semestre\\Laboratorio de sistemas digitales\\Fonts\\"+letra+".txt"));
			br = new BufferedReader(fr);
			while ((sCurrentLine = br.readLine()) != null) {
				s+=sCurrentLine;
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
		conc = s.substring(0, 3);
		help = Integer.toHexString(Integer.parseInt(conc));
		for (int i=4; i<512; i+=4) {
			conc = s.substring(i, i+3);
			help += Integer.toHexString(Integer.parseInt(conc));
		}
		System.out.println(help);
	}


	public static void main(String[] args) {
		hexaConverter hex = new hexaConverter();
		hex.toHex("L");
	}

}
