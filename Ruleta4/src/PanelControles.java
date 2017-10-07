import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelControles extends JPanel{
	
	private JButton btApostar1,
					btApostar2,
					btApostar3;
	
	private Label lbPlayer1,
				  lbPlayer2,
	              lbPlayer3;

	private JTextField tfPlayer1,
	  				   tfPlayer2,
	  				   tfPlayer3;
	
	public PanelControles() {
		super();
		this.setPreferredSize(new Dimension(300,500));
		this.setBackground(Color.WHITE);

		//Player1
		this.lbPlayer1= new Label("      Player1");
		this.lbPlayer1.setPreferredSize(new Dimension(300, 50));
		this.lbPlayer1.setFont(new Font("Arial",Font.BOLD,44));
		this.lbPlayer1.setForeground(Color.BLACK);
		this.add(this.lbPlayer1);
		
		this.tfPlayer1 = new JTextField(20);
		this.tfPlayer1.setPreferredSize(new Dimension(150,20));
		this.add(this.tfPlayer1);
		
		this.btApostar1= new JButton("Apostar");
		this.btApostar1.setPreferredSize(new Dimension(90, 30));
		this.btApostar1.setForeground(Color.BLACK);
		this.btApostar1.setBackground(Color.YELLOW);
		this.btApostar1.setBorderPainted(false);
		//this.btApostar1.addActionListener(this);
		this.add(this.btApostar1);
		
		//Player2
		this.lbPlayer2= new Label("      Player2");
		this.lbPlayer2.setPreferredSize(new Dimension(300, 50));
		this.lbPlayer2.setFont(new Font("Arial",Font.BOLD,44));
		this.lbPlayer2.setForeground(Color.BLACK);
		this.add(this.lbPlayer2);
		
		this.tfPlayer2 = new JTextField(20);
		this.tfPlayer2.setPreferredSize(new Dimension(150,20));
		this.add(this.tfPlayer2);
		
		this.btApostar2= new JButton("Apostar");
		this.btApostar2.setPreferredSize(new Dimension(90, 30));
		this.btApostar2.setForeground(Color.BLACK);
		this.btApostar2.setBackground(Color.YELLOW);
		this.btApostar2.setBorderPainted(false);
		//this.btApostar2.addActionListener(this);
		this.add(this.btApostar2);
		
		//Player3
		this.lbPlayer3= new Label("      Player3");
		this.lbPlayer3.setPreferredSize(new Dimension(300, 50));
		this.lbPlayer3.setFont(new Font("Arial",Font.BOLD,44));
		this.lbPlayer3.setForeground(Color.BLACK);
		this.add(this.lbPlayer3);
		
		this.tfPlayer3 = new JTextField(20);
		this.tfPlayer3.setPreferredSize(new Dimension(150,20));
		this.add(this.tfPlayer3);
		
		this.btApostar3= new JButton("Apostar");
		this.btApostar3.setPreferredSize(new Dimension(90, 30));
		this.btApostar3.setForeground(Color.BLACK);
		this.btApostar3.setBackground(Color.YELLOW);
		this.btApostar3.setBorderPainted(false);
		//this.btApostar3.addActionListener(this);
		this.add(this.btApostar3);
		
	}
}
