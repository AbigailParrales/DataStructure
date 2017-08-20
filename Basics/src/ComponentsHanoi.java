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
		this.addMouseListener(this);

		this.A = new myStack<Pintable>();
		this.B = new myStack<Pintable>();
		this.C = new myStack<Pintable>();

		this.baseA = new Base();
		this.A.push(baseA);

		this.midA = new Mid();
		this.A.push(midA);

		this.topA = new Top();
		this.A.push(topA);
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.RED);
		
		g.fillRect(370, 0, 5, 750);
		g.fillRect(600, 0, 5, 750);
		g.fillRect(0, 400, 1000, 5);		

		g.setColor(Color.BLACK);
		g.fillRect(225, 450, 20, 200);
		g.fillRect(725, 450, 20, 200);
		g.fillRect(475, 150, 20, 200);

		this.baseA.pintate(g);

		this.A.pintate(g);
		this.B.pintate(g);
		this.C.pintate(g);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Estoy en el listener de componentes");
		System.out.println("x= "+e.getX());
		System.out.println("y= "+e.getY());
		
		if ((e.getX()<370)&&(e.getY()>400)) {
			System.out.println("Estoy en la torre A");
		}
		
		if ((e.getX()<600)&&(e.getX()>370)&&(e.getY()<400)) {
			System.out.println("Estoy en la torre B");
		}
		
		if ((e.getX()>600)&&(e.getY()>400)) {
			System.out.println("Estoy en la torre C");
		}

/*		if ((e.getX()>150)&(e.getX()<220)&(e.getY()<600)&(e.getY()>550)){
			System.out.println("Entré al if");
			System.out.println("baseA");
		}
*/
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
