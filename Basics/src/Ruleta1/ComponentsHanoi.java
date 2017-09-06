package Ruleta1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ComponentsHanoi extends JPanel implements MouseListener{

	private myStack<Pintable> A;
	private myStack<Pintable> B;
	private myStack<Pintable> C;

	private myStack<Pintable> torreSel;
	private myStack<Pintable> torreSource;
	private myStack<Pintable> torreDestiny;

	private Base baseA;
	private Mid midA;
	private Top topA;
	private puntoCiego Bp1;

	/*private int elementosA;
	private int elementosB;
	private int elementosC;*/

	public ComponentsHanoi() {
		super();
		this.setPreferredSize(new Dimension(1000, 750));
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);

		this.Bp1 = new puntoCiego();
		
		this.A = new myStack<Pintable>(Bp1);
		this.A.agregarCoordenada(150, 600);
		
		
		this.B = new myStack<Pintable>(Bp1);
		this.B.agregarCoordenada(400, 300);
		
		
		this.C = new myStack<Pintable>(Bp1);
		this.C.agregarCoordenada(650, 600);
		

		this.torreSel= new myStack<Pintable>(Bp1);
		this.torreSource=new myStack<Pintable>(Bp1);
		this.torreDestiny=new myStack<Pintable>(Bp1);

		this.baseA = new Base();
		this.A.push(baseA);

		this.midA = new Mid();
		this.A.push(midA);

		this.topA = new Top();
		this.A.push(topA);

		/*this.elementosA=this.A.getElements();
		this.elementosB=this.B.getElements();
		this.elementosC=this.C.getElements();
		
		System.out.println("Elementos en A= "+this.elementosA);
		System.out.println("Elementos en B= "+this.elementosB);
		System.out.println("Elementos en C= "+this.elementosC);	*/
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

		this.A.pintate(g);
		this.B.pintate(g);
		this.C.pintate(g);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if ((e.getX()<370)&&(e.getY()>400)) {
			this.torreSel=this.A;
		}

		else if ((e.getX()<600)&&(e.getX()>370)&&(e.getY()<400)) {
			this.torreSel=this.B;
		}

		else if ((e.getX()>600)&&(e.getY()>400)) {
			this.torreSel=this.C;
		}

		this.seleccionarTorre(this.torreSel);
		this.repaint();
		
	}


	public void seleccionarTorre(myStack<Pintable> torreSel) {

		if(this.torreSource.peek().equals(Bp1)||this.torreSource==null) {

			this.torreSource=torreSel;
			this.torreSel=null;
			this.torreDestiny=null;

			if(this.torreSource.equals(this.A)) {
				this.A.seleccionar();
				this.repaint();
			}
			else if(this.torreSource.equals(this.B)) {
				this.B.seleccionar();
				this.repaint();
			}
			else if(this.torreSource.equals(this.C)) {
				this.C.seleccionar();
				this.repaint();
			}
			
		}

		else {

			this.torreDestiny=torreSel;
			this.torreSel=null;

			if(this.torreDestiny.equals(this.A)) {
				this.A.seleccionar();
				this.repaint();
			}
			else if(this.torreDestiny.equals(this.B)) {
				this.B.seleccionar();
				this.repaint();
			}
			else if(this.torreDestiny.equals(this.C)) {
				this.C.seleccionar();
				this.repaint();
			}
			
			this.move();
			
			this.repaint();
		}
		
	}

	public void move() {
		if(this.torreDestiny.equals(this.A)) {

			if(this.torreSource.equals(this.B)) {
				this.A.push(this.B.peek());
				this.B.pop();
			}
			else if(this.torreSource.equals(this.C)) {
				this.A.push(this.C.peek());
				this.C.pop();
			}
		}
		else if(this.torreDestiny.equals(this.B)) {
			
			if(this.torreSource.equals(this.A)) {
				this.B.push(this.A.peek());
				this.A.pop();
			}
			else if(this.torreSource.equals(this.C)) {
				this.B.push(this.C.peek());
				this.C.pop();
			}
		}
		else if(this.torreDestiny.equals(this.C)) {

			if(this.torreSource.equals(this.A)){
				this.C.push(this.A.peek());
				this.A.pop();
			}
			else if(this.torreSource.equals(this.B)) {
				this.C.push(this.B.peek());
				this.B.pop();
			}
		}
		this.repaint();
		this.torreSel=null;
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
