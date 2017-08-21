package Ruleta1cnButtons;
import java.awt.Dimension;
import javax.swing.JFrame;

public class HanoiWin_Bt extends JFrame {

	private ComponentsHanoi_Bt components;
	
	public HanoiWin_Bt() {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(900, 700));
		this.setResizable(false);
		this.setVisible(true);
		
		this.components = new ComponentsHanoi_Bt();
		this.add(components); 
		
		this.pack();
	}
	
	public static void main(String[] args) {
		
		HanoiWin_Bt win = new HanoiWin_Bt();
		
	}

}
