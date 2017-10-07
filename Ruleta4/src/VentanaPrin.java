import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaPrin extends JFrame{

	public VentanaPrin() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(700, 500));
		this.setResizable(false);
		
		this.add(new PanelControles(),BorderLayout.WEST);
		this.add(new PanelRanking(),BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		VentanaPrin win = new VentanaPrin();
	}

}
