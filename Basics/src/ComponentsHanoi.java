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
	private puntoCiego Bp1;
	private puntoCiego Bp2;

	private String torreSel;
	private String torreSource;
	private String torreDestiny;

	public ComponentsHanoi() {
		super();
		this.setPreferredSize(new Dimension(1000, 750));
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		
		this.A = new myStack<Pintable>();
		this.B = new myStack<Pintable>();
		this.C = new myStack<Pintable>();
		
		this.Bp1 = new puntoCiego();
		this.B.push(Bp1);
		
		this.Bp2 = new puntoCiego();
		this.C.push(Bp2);
		
		this.baseA = new Base();
		this.A.push(baseA);

		this.midA = new Mid();
		this.A.push(midA);

		this.topA = new Top();
		this.A.push(topA);

		this.torreSel="";
		this.torreSource="";
		this.torreDestiny="";
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
		System.out.println("Estoy en el listener de componentes");
		System.out.println("x= "+e.getX());
		System.out.println("y= "+e.getY());

		if ((e.getX()<370)&&(e.getY()>400)) {
			this.torreSel="A";
			System.out.println("Estoy en la torre A");
		}

		else if ((e.getX()<600)&&(e.getX()>370)&&(e.getY()<400)) {
			this.torreSel="B";
			System.out.println("Estoy en la torre B");
		}

		else if ((e.getX()>600)&&(e.getY()>400)) {
			this.torreSel="C";
			System.out.println("Estoy en la torre C");
		}

		this.seleccionarTorre(this.torreSel);
	}


	public void seleccionarTorre(String torreSel) {

		if(this.torreSource==null) {
			this.torreSource=torreSel;
			this.torreSel="";
			this.torreDestiny="";

			System.out.println("Seleccionando origen");

			switch (torreSource) {
			case "A":
				System.out.println("Torre A seleccionada");
				this.A.seleccionar();
				this.repaint();
				break;
			case "B":
				System.out.println("Torre B seleccionada");	
				this.B.seleccionar();
				break;
			case "C":
				System.out.println("Torre C seleccionada");
				this.C.seleccionar();
				break;

			default:
				break;
			}
		}

		else if(this.torreSource!=null) {

			System.out.println("Seleccionando destino");

			this.torreDestiny=torreSel;
			this.torreSel="";
			this.torreSource="";

			switch (torreDestiny) {
			case "A":
				System.out.println("Torre A seleccionada");
				this.A.seleccionar();
				this.repaint();
				break;
			case "B":
				System.out.println("Torre B seleccionada");	
				this.B.seleccionar();
				break;
			case "C":
				System.out.println("Torre C seleccionada");
				this.C.seleccionar();
				break;

			default:
				break;
			}
		}


	}

	public void move() {
		if (this.torreSource!=null) {
			System.out.println("moviendo la inf");
			switch (this.torreDestiny) {
			
			case "A":
				System.out.println("Torre A seleccionada como destino");
				switch (this.torreSource) {
				case "B":	
					this.A.push(this.B.peek());
					this.B.pop();
					break;
				case "C":
					this.A.push(this.C.peek());
					this.C.pop();
					break;
				default:
					break;
				}
				
				this.repaint();
				break;
				
			case "B":
				System.out.println("Torre B seleccionada como destino");
				switch (this.torreSource) {
				case "A":	
					this.B.push(this.A.peek());
					this.A.pop();
					break;
				case "C":
					this.B.push(this.C.peek());
					this.C.pop();
					break;
				default:
					break;
				}
				
				this.repaint();
				break;
				
			case "C":
				System.out.println("Torre C seleccionada como destino");
				switch (this.torreSource) {
				case "A":	
					this.C.push(this.A.peek());
					this.A.pop();
					break;
				case "B":
					this.C.push(this.B.peek());
					this.B.pop();
					break;
				default:
					break;
				}
				
				this.repaint();
				break;

			default:
				break;
			}
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
