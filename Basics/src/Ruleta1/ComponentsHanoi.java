package Ruleta1;
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

	private myStack<Pintable> torreSel;
	private myStack<Pintable> torreSource;
	private myStack<Pintable> torreDestiny;

	private Base baseA;
	private Mid midA;
	private Top topA;
	private puntoCiego Bp1,
	Bp2,
	Bp3,
	Bp4,
	Bp5;



	public ComponentsHanoi() {
		super();
		this.setPreferredSize(new Dimension(1000, 750));
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);

		this.Bp1 = new puntoCiego();
		this.Bp2 = new puntoCiego();
		this.Bp3 = new puntoCiego();
		
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
		this.baseA.setElementosStack(this.B.getElements());
		this.B.push(baseA);

		this.midA = new Mid();
		this.midA.setElementosStack(this.B.getElements());
		this.B.push(midA);

		this.topA = new Top();
		this.topA.setElementosStack(this.B.getElements());
		this.B.push(topA);

		
		/*this.baseA = new Base();
		this.baseA.setElementosStack(this.C.getElements());
		this.C.push(baseA);

		this.midA = new Mid();
		this.midA.setElementosStack(this.C.getElements());
		this.C.push(midA);

		this.topA = new Top();
		this.topA.setElementosStack(this.C.getElements());
		this.C.push(topA);*/
		
		/*
		 * this.baseA = new Base();
		this.baseA.setElementosStack(this.A.getElements());
		this.A.push(baseA);

		this.midA = new Mid();
		this.midA.setElementosStack(this.A.getElements());
		this.A.push(midA);

		this.topA = new Top();
		this.topA.setElementosStack(this.A.getElements());
		this.A.push(topA);*/

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
			System.out.println("\nClick en la torre A\n");
		}

		else if ((e.getX()<600)&&(e.getX()>370)&&(e.getY()<400)) {
			this.torreSel=this.B;
			System.out.println("\nClick en la torre B\n");
		}

		else if ((e.getX()>600)&&(e.getY()>400)) {
			this.torreSel=this.C;
			System.out.println("\nClick en la torre C\n");
		}

		this.seleccionarTorre(this.torreSel);
		this.repaint();
	}


	public void seleccionarTorre(myStack<Pintable> torreSel) {
		System.out.println("Entré a seleccionar Torre\n");

		if(this.torreSource.peek().equals(Bp1)||this.torreSource==null) {

			this.torreSource=torreSel;
			this.torreSel=null;
			this.torreDestiny=null;

			System.out.println("Entré a seleccionar origen");
			System.out.println("Esta es la torre source: "+ this.torreSource+" \n");

			if(this.torreSource.equals(this.A)) {
				System.out.println("Torre A seleccionada");
				this.A.seleccionar();
				this.repaint();
			}
			else if(this.torreSource.equals(this.B)) {
				System.out.println("Torre B seleccionada");	
				this.B.seleccionar();
				this.repaint();
			}
			else if(this.torreSource.equals(this.C)) {
				System.out.println("Torre C seleccionada");
				this.C.seleccionar();
				this.repaint();
			}
		}

		else {

			this.torreDestiny=torreSel;
			this.torreSel=null;

			System.out.println("Entré a seleccionar destino");
			System.out.println("Esta es la torre destino: "+ this.torreDestiny+""+"\n");


			if(this.torreDestiny.equals(this.A)) {
				System.out.println("Torre A seleccionada");
				this.A.seleccionar();
				this.repaint();
			}
			else if(this.torreDestiny.equals(this.B)) {
				System.out.println("Torre B seleccionada");	
				this.B.seleccionar();
				this.repaint();
			}
			else if(this.torreDestiny.equals(this.C)) {
				System.out.println("Torre C seleccionada");
				this.C.seleccionar();
				this.repaint();
			}

			this.move();
			this.repaint();
		}
	}

	public void move() {
		System.out.println("Entré a move");

		if(this.torreDestiny.equals(this.A)) {
			System.out.println("Torre A seleccionada como destino");

			if(this.torreSource.equals(this.B)) {
				this.A.push(this.B.peek());
				this.B.pop();
				System.out.println("Moví B->A");
			}
			else if(this.torreSource.equals(this.C)) {
				this.A.push(this.C.peek());
				this.C.pop();
				System.out.println("Moví C->A");
			}
		}

		else if(this.torreDestiny.equals(this.B)) {
			System.out.println("Torre B seleccionada como destino");
			
			if(this.torreSource.equals(this.A)) {
				this.B.push(this.A.peek());
				this.A.pop();
				System.out.println("Moví A->B");
			}
			else if(this.torreSource.equals(this.C)) {
				this.B.push(this.C.peek());
				this.C.pop();
				System.out.println("Moví C->B");
			}
		}

		else if(this.torreDestiny.equals(this.C)) {
			System.out.println("Torre C seleccionada como destino");

			if(this.torreSource.equals(this.A)){
				this.C.push(this.A.peek());
				this.A.pop();
				System.out.println("Moví A->C");
			}
			else if(this.torreSource.equals(this.B)) {
				this.C.push(this.B.peek());
				this.B.pop();
				System.out.println("Moví B->C");
			}
		}
		
		//this.torreSource=null;
		
		System.out.println("A"+this.A+"");
		System.out.println("B"+this.B+"");
		System.out.println("C"+this.C+"");
		
		this.repaint();
		System.out.println("Terminé move\n");
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
