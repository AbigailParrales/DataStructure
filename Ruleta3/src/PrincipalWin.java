import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class PrincipalWin extends JFrame{
	public viewPanel vPane;
	public WastePanel wPaneA;
	public WastePanel wPaneB;
	
	PrincipalWin(){
		super(); 
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setPreferredSize(new Dimension(1200, 700));
		this.setResizable(false);
		
		this.wPaneA = new WastePanel(1200, 200);
		this.add(this.wPaneA,BorderLayout.NORTH);
		
		this.vPane= new viewPanel(this);
		this.add(this.vPane, BorderLayout.CENTER);
		
		this.wPaneB = new WastePanel(1200, 200);
		this.add(this.wPaneB, BorderLayout.SOUTH);
		
		this.setVisible(true);
		this.pack();
	}


	public static void main(String[] args) {
		new PrincipalWin();
	}
}