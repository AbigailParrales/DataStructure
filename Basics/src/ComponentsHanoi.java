import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class ComponentsHanoi extends JPanel implements MouseListener{
	
	private myStack<Pintable> A;
	private myStack<Pintable> B;
	private myStack<Pintable> C;
	
	private Base baseA;
	private Mid midA;
	private Top topA;
	
	public ComponentsHanoi() {
		super();
		this.setPreferredSize(new Dimension(1000, 750));
		this.setBackground(Color.WHITE);
		
		this.A = new myStack<Pintable>();
		this.B = new myStack<Pintable>();
		this.C = new myStack<Pintable>();
		
		this.baseA = new Base();
		this.addMouseListener(this.baseA);
		this.A.push(baseA);
		
		this.midA = new Mid();
		this.addMouseListener(this.midA);
		this.A.push(midA);
		
		this.topA = new Top();
		this.addMouseListener(this.topA);
		this.A.push(topA);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.fillRect(225, 450, 20, 200);
		g.fillRect(725, 450, 20, 200);
		g.fillRect(475, 250, 20, 200);
		
		this.baseA.pintate(g);
		
		this.A.pintate(g);
		this.B.pintate(g);
		this.C.pintate(g);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Estoy en el listener de componentes");
		
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
