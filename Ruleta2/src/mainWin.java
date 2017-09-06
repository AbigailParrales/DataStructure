import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class mainWin extends JFrame{
	Reproductor rep;
	playBar plyBr;
	panelCanciones cns;
	
	public mainWin() {
		super();
		
		this.setPreferredSize(new Dimension(1000, 800));
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.rep = new Reproductor();
		this.add(this.rep, BorderLayout.WEST);

		this.cns = new panelCanciones(this.rep);
		this.add(this.cns, BorderLayout.CENTER);
		
		this.plyBr = new playBar(this.rep);
		this.add(this.plyBr, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		mainWin win = new mainWin();
		
	}

}
