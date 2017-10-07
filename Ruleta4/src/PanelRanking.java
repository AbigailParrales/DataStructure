import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelRanking extends JPanel{

	private JButton btTimeOut;
	private String Place1,
				   Place2,
				   Place3;
	
	public PanelRanking() {
		super();
		this.setPreferredSize(new Dimension(400,500));
		this.setBackground(Color.LIGHT_GRAY);
		
		this.btTimeOut= new JButton("Time Out");
		this.btTimeOut.setPreferredSize(new Dimension(100, 30));
		this.btTimeOut.setForeground(Color.WHITE);
		this.btTimeOut.setBackground(Color.RED);
		this.btTimeOut.setBorderPainted(false);
		//this.btApostar1.addActionListener(this);
		this.add(this.btTimeOut);
		
		this.Place1="Place 1";
		this.Place2="Place 2";
		this.Place3="Place 3";
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
		g.drawString(Place1, 100, 150);
		g.setColor(Color.BLACK);
		g.drawString(Place2, 100, 250);
		g.setColor(Color.BLACK);
		g.drawString(Place3, 100, 350);
	}
}
