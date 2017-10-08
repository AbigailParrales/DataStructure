import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaPrin extends JFrame{
	private PanelControles pc;
	private PanelRanking pr;

	public VentanaPrin() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(700, 500));
		this.setResizable(false);
		
		this.pc= new PanelControles();
		this.pr= new PanelRanking(this.pc);
		
		this.add(pc,BorderLayout.WEST);
		this.add(pr,BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		VentanaPrin win = new VentanaPrin();
	}

}
