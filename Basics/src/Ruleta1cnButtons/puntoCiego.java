package Ruleta1cnButtons;
import java.awt.Color;
import java.awt.Graphics;

public class puntoCiego implements Pintable{

	@Override
	public void pintate(Graphics g) {
		g.setColor(Color.WHITE);
		g.drawLine(0,0,1,1);
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void seleccionar() {
		// TODO Auto-generated method stub
		
	}

}
