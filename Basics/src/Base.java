import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Base extends JComponent implements Pintable, MouseListener{
	Dimension dim = new Dimension(170,50);
	Point p1,
		  p2;
	
	public Base() {
		super();
		this.addMouseListener(this);
		
		this.p1=  new Point(150,600);
		this.p2=  new Point(220,550);
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(150, 600, this.dim.width, this.dim.height);
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		 System.out.println("estoy en mouseclicked de Base");
		if ((e.getButton() == 1) && (e.getX()>p1.getX())&&(e.getX()<p1.getX())&&(e.getX()<p2.getX())&&(e.getX()>p2.getX())&&(e.getY()<p1.getY())&&(e.getY()<p2.getY())&&(e.getY()>p2.getY())){
		     System.out.println("baseA");
		   }
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
