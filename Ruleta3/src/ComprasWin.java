import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ComprasWin extends JFrame{

		private ComprasPanel pCompras;
		public boolean visibilidad;
		
		private IngresoPanel ip; 
		
		public ComprasWin(PrincipalWin frame, IngresoWindow iWin) {
		//public ComprasWin() {
			super();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			this.setPreferredSize(new Dimension(1200, 700));
			this.setResizable(false);
			
			this.ip=iWin.pIngreso;
			
			this.pCompras= new ComprasPanel(this.ip);
			this.add(this.pCompras, BorderLayout.CENTER);
			
			this.add(new WastePanel(1200, 150),BorderLayout.NORTH);
			this.add(new WastePanel(1200, 150),BorderLayout.SOUTH);
			
			this.visibilidad=false;
			
			this.pack();
			this.setVisible(visibilidad);
		}
	
	/*public static void main(String[] args) {
		ComprasWin cWin= new ComprasWin();

	}*/

}
