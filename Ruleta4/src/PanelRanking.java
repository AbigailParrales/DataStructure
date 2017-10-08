import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelRanking extends JPanel implements ActionListener{

	private JButton btTimeOut;
	private String Place1,
				   Place2,
				   Place3;
	private PanelControles pc;
	
	public PanelRanking(PanelControles pc) {
		super();
		this.setPreferredSize(new Dimension(400,500));
		this.setBackground(Color.LIGHT_GRAY);
		
		this.btTimeOut= new JButton("Time Out");
		this.btTimeOut.setPreferredSize(new Dimension(100, 30));
		this.btTimeOut.setForeground(Color.WHITE);
		this.btTimeOut.setBackground(Color.RED);
		this.btTimeOut.setBorderPainted(false);
		this.btTimeOut.addActionListener(this);
		this.add(this.btTimeOut);
		
		this.Place1="Place 1";
		this.Place2="Place 2";
		this.Place3="Place 3";
		
		this.pc=pc;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.ORANGE);
		g.fillRect(100, 150, 200, 50);
		g.setColor(Color.WHITE);
		g.fillRect(100, 250, 200, 50);
		g.setColor(Color.BLUE);
		g.fillRect(100, 350, 200, 50);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.BOLD,44));
		g.drawString(Place1, 130, 190);
		g.setColor(Color.BLACK);
		g.drawString(Place2, 130, 290);
		g.setColor(Color.BLACK);
		g.drawString(Place3, 130, 390);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btTimeOut) {
			try {
				System.out.println("Time Out");
				this.pc.getA().HeapSort(this.pc.getA().A, this.pc.getA().data);
				System.out.println("Size"+this.pc.getA().size+"\n"+this.pc.getA());
				System.out.println("Place 1: "+this.Place1());
				System.out.println("Place 2: "+this.Place2());
				System.out.println("Place 3: "+this.Place3());
				this.repaint();
				this.pc.setTfPlayer1();
				this.pc.setTfPlayer2();
				this.pc.setTfPlayer3();
				this.pc.getA().reset();
			} catch (ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(this, "Input Invalido");	
				this.pc.setTfPlayer1();
				this.pc.setTfPlayer2();
				this.pc.setTfPlayer3();
				this.pc.getA().reset();
			}
		}
		
	}
	
	public String Place1() {
		this.Place1=""+ this.pc.getA().data[this.pc.getA().size];
		return this.Place1;
	}
	
	public String Place2() {
		String tmpPlace=""+ this.pc.getA().data[this.pc.getA().size-1];
		if(this.Place1.compareTo(tmpPlace)!=0) {
			this.Place2=tmpPlace;
		}
		else {
			for(int i=this.pc.getA().size-1;(((tmpPlace.compareTo(this.Place1)!=0))||i>0);i--) {
				this.Place2=(String) this.pc.getA().data[i];
			}
		}
		return this.Place2;
	}
	
	public String Place3() {
		String tmpPlace=""+ this.pc.getA().data[this.pc.getA().size-2];
		if((this.Place1.compareTo(tmpPlace)!=0)&&(this.Place2.compareTo(tmpPlace)!=0)) {
			this.Place2=tmpPlace;
		}
		else {
			for(int i=this.pc.getA().size-2;(((tmpPlace.compareTo(this.Place1)!=0)&&(tmpPlace.compareTo(this.Place2)!=0))||i>0);i--) {
				this.Place2=(String) this.pc.getA().data[i];
			}
		}
		
		return this.Place3;
	}
}
