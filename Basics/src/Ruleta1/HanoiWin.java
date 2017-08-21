package Ruleta1;
import java.awt.Dimension;
import javax.swing.JFrame;

public class HanoiWin extends JFrame {

	private ComponentsHanoi components;
	
	public HanoiWin() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(1000, 750));
		this.setResizable(false);
		this.setVisible(true);
		
		this.components = new ComponentsHanoi();
		this.add(components); 
		
		this.pack();
	}
	
	public static void main(String[] args) {
		
		HanoiWin win = new HanoiWin();
		
	}

}
