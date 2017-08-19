import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ComponentsHanoi extends JPanel{
	
	public ComponentsHanoi() {
		super();
		this.setPreferredSize(new Dimension(1000, 800));
	}
	
	public void paint(Graphics g){//paint es solo para JFrame
		super.paint(g);
		g.fillRect(400, 350, 20, 200);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
