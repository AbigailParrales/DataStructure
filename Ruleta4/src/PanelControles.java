import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelControles extends JPanel implements ActionListener{
	
	private JButton btApostar1,
					btApostar2,
					btApostar3;
	
	private Label lbPlayer1,
				  lbPlayer2,
	              lbPlayer3;

	private JTextField tfPlayer1,
	  				   tfPlayer2,
	  				   tfPlayer3;
	
	private Heap2 A;
	
	private int total;
	
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
		this.btApostar1.addActionListener(this);
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
		this.btApostar2.addActionListener(this);
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
		this.btApostar3.addActionListener(this);
		this.add(this.btApostar3);
		
		this.A=new Heap2(10);
		
		this.total=0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==this.btApostar1) {
				this.A.insert(Integer.parseInt(this.tfPlayer1.getText()),"Player 1");
				this.total+=Integer.parseInt(this.tfPlayer1.getText());
				System.out.println("Total: "+this.total);
			}
			else if(e.getSource()==this.btApostar2) {
				this.A.insert(Integer.parseInt(this.tfPlayer2.getText()),"Player 2");
				this.total+=Integer.parseInt(this.tfPlayer2.getText());
				System.out.println("Total: "+this.total);
			}
			else if(e.getSource()==this.btApostar3) {
				this.A.insert(Integer.parseInt(this.tfPlayer3.getText()),"Player 3");
				this.total+=Integer.parseInt(this.tfPlayer3.getText());
				System.out.println("Total: "+this.total);
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "Input invalido");
			if(e.getSource()==this.btApostar1) {
				this.tfPlayer1.setText("");
			}
			else if(e.getSource()==this.btApostar2) {
				this.tfPlayer2.setText("");
			}
			else if(e.getSource()==this.btApostar3) {
				this.tfPlayer3.setText("");
			}
			System.out.println("Total: "+this.total);
		}
	}

	public Heap2 getA() {
		return this.A;
	}

	public String getTfPlayer1() {
		return tfPlayer1.getText();
	}

	public void setTfPlayer1() {
		this.tfPlayer1.setText("");;
	}

	public String getTfPlayer2() {
		return tfPlayer2.getText();
	}

	public void setTfPlayer2() {
		this.tfPlayer2.setText("");;
	}

	public String getTfPlayer3() {
		return tfPlayer3.getText();
	}

	public void setTfPlayer3() {
		this.tfPlayer3.setText("");;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
	
}
