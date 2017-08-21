package Ruleta1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class Top extends JComponent implements Pintable{
	
	private Dimension dim=new Dimension(90,50);
	private Point p1;
	private int elementosStack;
	
	Color color;
	
	public Top() {
		super(); 
		
		this.p1=  new Point(190,500);
		this.color = new Color(255, 255, 51);
		
		//this.elementosStack
	}
	
	@Override
	public void pintate(Graphics g) {
		g.setColor(this.color);
		
		if(this.elementosStack==0) {
			g.fillRect(this.p1.x+40,this.p1.y, this.dim.width, this.dim.height);
		}
		else if(this.elementosStack==1) {
			g.fillRect(this.p1.x+40,this.p1.y-50, this.dim.width, this.dim.height);
		}
		else if(this.elementosStack==2) {
		g.fillRect(this.p1.x+40,this.p1.y-100, this.dim.width, this.dim.height);
		}
		//g.fillRect(190, 500, this.dim.width, this.dim.height);
	}

	public int getElementosStack() {
		return elementosStack;
	}

	public void setElementosStack(int elementosStack) {
		this.elementosStack = elementosStack;
	}

	@Override
	public void agregarCoordenada(int x, int y) {
		this.p1.setLocation(x, y);
	}

	
	@Override
	public void seleccionar() {
		//System.out.println("Estoy en seleccionar Top");
		this.color=new Color(255,204,0);
	}
	

}
