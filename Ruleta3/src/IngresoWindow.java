import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IngresoWindow extends JFrame{
	public IngresoPanel pIngreso;
	public boolean visibilidad;
	
	public IngresoWindow(PrincipalWin frame) {
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setPreferredSize(new Dimension(1200, 700));
		this.setResizable(false);
		
		this.pIngreso= new IngresoPanel();
		this.add(this.pIngreso, BorderLayout.CENTER);
		
		this.add(new WastePanel(1200, 150),BorderLayout.NORTH);
		this.add(new WastePanel(1200, 150),BorderLayout.SOUTH);
		
		this.visibilidad=false;
		
		this.pack();
		this.setVisible(visibilidad);
	}

	/*public static void main(String[] args) {
		IngresoWindow iWin = new IngresoWindow();
	}
	*/
}
