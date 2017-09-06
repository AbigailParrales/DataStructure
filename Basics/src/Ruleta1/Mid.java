package Ruleta1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Mid extends JComponent implements Pintable{

	private Dimension dim= new Dimension(130,50);
	Point p1;
	Color color;
	
	private int elementosStack;

	public Mid() {
		super();
		
		this.p1=  new Point(170,550);
		
		this.color=new Color(255, 51, 153);
		
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(this.color);
		g.fillRect(this.p1.x+20, this.p1.y-(50*elementosStack), this.dim.width, this.dim.height);		
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		this.p1.setLocation(x, y);
	} 

	@Override
	public void seleccionar() {
		this.color=new Color(204,51,204);
	}

	public int getElementosStack() {
		return elementosStack;
	}

	public void setElementosStack(int elementosStack) {
		this.elementosStack = elementosStack;
	}
	

}
