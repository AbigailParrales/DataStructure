import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Mid extends JComponent implements Pintable, MouseListener{

	private Dimension dim= new Dimension(130,50);
	Point p1,
	      p2;
	Color color;

	public Mid() {
		super();
		this.addMouseListener(this);
		
		this.p1=  new Point(170,550);
		this.p2=  new Point(300,500);
		
		this.color=new Color(255, 51, 153);
		
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(this.color);
		g.fillRect(170, 550, this.dim.width, this.dim.height);		
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		// TODO Auto-generated method stub
		
	} 

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("estoy en mouseclicked de Mid");
		if ((e.getButton() == 1) && (e.getX()>p1.getX())&&(e.getX()<p1.getX())&&(e.getX()<p2.getX())&&(e.getX()>p2.getX())&&(e.getY()<p1.getY())&&(e.getY()<p2.getY())&&(e.getY()>p2.getY())) {
		      System.out.println("estoy en Mid");
		   }
	}

	@Override
	public void seleccionar() {
		this.color=new Color(204,51,204);
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
