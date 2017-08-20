import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Top extends JComponent implements Pintable, MouseListener{
	
	private Dimension dim=new Dimension(90,50);
	Point p1,
    	  p2;
	Color color;
	
	public Top() {
		super(); 
		this.addMouseListener(this);
		
		this.p1=  new Point(190,500);
		this.p2=  new Point(280,450);
		
		this.color = new Color(255, 255, 51);
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(this.color);
		g.fillRect(190, 500, this.dim.width, this.dim.height);
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("estoy en mouseclicked de Top");
		if ((e.getButton() == 1) && (e.getX()>p1.getX())&&(e.getX()<p1.getX())&&(e.getX()<p2.getX())&&(e.getX()>p2.getX())&&(e.getY()<p1.getY())&&(e.getY()<p2.getY())&&(e.getY()>p2.getY())) {
		      System.out.println("estoy en Top");
		   }
	}
	
	@Override
	public void seleccionar() {
		System.out.println("Estoy en seleccionar Top");
		this.color=new Color(255,204,0);
		
	}
	
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
