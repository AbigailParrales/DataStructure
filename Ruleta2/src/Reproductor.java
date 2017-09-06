import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Reproductor extends JPanel{

	protected JLabel cover;
	protected String accion;

	protected myCincularLinkedList<Cancion> list = new myCincularLinkedList<Cancion>();

	public Reproductor() {
		super();
		this.setPreferredSize(new Dimension(400, 300));
		this.setBackground(new Color(255,153,0));

		this.cover= new JLabel(new ImageIcon("Image.png"));
		this.cover.setPreferredSize(new Dimension(200, 250));
		this.add(this.cover);

	}

	public void agregarCancion(String cancionSel) { //agrega la canción clickada a la lista
		switch (cancionSel) {
		case "born_again":
			System.out.println("c1");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Music\\J-US - Born Again 01 - Erga Sua Voz (Legenda ptBr e Esp).mp3"));
			break;
		case "feeling_low":
			System.out.println("c2");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Downloads\\Musica\\varios\\Feeling Low.mp3"));
			//this.list.next().playSong();
		case "r45":
			System.out.println("c3");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Downloads\\Musica\\varios\\Victorious One.mp3"));
			break;
		case "rivers_and_robots":
			System.out.println("c4");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Downloads\\Musica\\varios\\Rivers  Robots   Shepherd Of My Soul.mp3"));
			break;
		case "love_never_fails":
			System.out.println("c5");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Downloads\\Musica\\varios\\Here I am in Your Grace_ J US Live Worship_Love Never Fails_02.mp3"));
			break;
		case "the_art_of_celebration":
			System.out.println("c6");
			this.list.insert(new Cancion("C:\\Users\\Daniela Parrales\\Downloads\\Musica\\varios\\Rend Collective   Free As A Bird.mp3"));
			break;
		default:
			break;
		}

		System.out.println(this.list);
		this.repaint();

	}

	public void ejecutarAccion(String accion) { //detecta la acción que recibe el playBar y la manda ejecutar 
		if (accion.equals("back")) {
			this.list.back().playSong();
		}
		else if (accion.equals("play")) {
			this.list.actual.data.playSong();
		}
		else if (accion.equals("forward")) {
			this.list.next().playSong();
		}

	}

}
