package Ruleta1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Base extends JComponent implements Pintable{
	Dimension dim = new Dimension(170,50);
	Point p1;
	Color color;
	
	private int elementosStack;
	
	public Base() {
		super();
		//this.addMouseListener(this);
		
		this.p1=  new Point(150,600);
		
		this.color=new Color(0, 255, 255);
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(this.color);
		
		if(this.elementosStack==0) {
			g.fillRect(this.p1.x, this.p1.y, this.dim.width, this.dim.height);
		}
		else if(this.elementosStack==1) {
			g.fillRect(this.p1.x, this.p1.y-50, this.dim.width, this.dim.height);
		}
		else if(this.elementosStack==2) {
		g.fillRect(this.p1.x, this.p1.y-100, this.dim.width, this.dim.height);
		}
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		this.p1.setLocation(x, y);
	}

	@Override
	public void seleccionar() {
		this.color=new Color(0, 102, 255);
		this.repaint();
	}

	public int getElementosStack() {
		return elementosStack;
	}

	public void setElementosStack(int elementosStack) {
		this.elementosStack = elementosStack;
	}

}
