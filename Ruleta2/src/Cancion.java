import java.io.FileInputStream;
import java.io.FileNotFoundException;

//Estas son librerias que exporté de http://www.javazoom.net/javalayer/sources.html
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Cancion {
		public String route;
		FileInputStream is;
		Player player;
		
		public Cancion(String route) {
			this.route=route;
			try {
				this.is = new FileInputStream(route);
				this.player = new Player(this.is);
			} 
			catch (FileNotFoundException | JavaLayerException e) {
				System.out.println("Archivo no encontrado");
			}
		}
		
		public void playSong() {
			try {
				this.player.play();
			} catch (JavaLayerException e) {
				System.out.println("Error al reproducir");
			}
		}
}
