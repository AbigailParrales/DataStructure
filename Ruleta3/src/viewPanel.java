import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class viewPanel extends JPanel implements ActionListener{
	private JButton btIngreso,
				   btCompra;
	private Label title;
	private PrincipalWin pWin;
	private IngresoWindow iWin;
	private ComprasWin cWin;
	
	private boolean principal,
					ingreso,
					compras;
	
	viewPanel(PrincipalWin pWin){
		super();
		this.principal=true;
		this.ingreso=false;
		this.compras=false;
		
		this.pWin=pWin;
		this.iWin=new IngresoWindow(pWin);
		this.cWin=new ComprasWin(pWin,iWin);
		
		this.setPreferredSize(new Dimension(1200, 300));
		this.setBackground(Color.pink);	
		
		this.title = new Label("Bienvenido, seleccione la acción a realizar");
		this.title.setFont(new Font("Arial", Font.BOLD,46));
		this.title.setForeground(Color.WHITE);
		this.title.setBackground(Color.pink);
		this.title.setPreferredSize(new Dimension(950,200));
		this.add(this.title);
		
		this.btIngreso = new JButton("Ingreso");
		this.btIngreso.setFont(new Font("Arial",Font.BOLD,36));
		this.btIngreso.setPreferredSize(new Dimension(300, 60));
		this.btIngreso.setForeground(Color.WHITE);
		this.btIngreso.setBackground(Color.pink);
		this.btIngreso.setBorderPainted(false);
		this.btIngreso.addActionListener(this);
		this.add(this.btIngreso);
		
		this.btCompra = new JButton("Compra");
		this.btCompra.setFont(new Font("Arial",Font.BOLD,36));
		this.btIngreso.setPreferredSize(new Dimension(300, 60));
		this.btCompra.setForeground(Color.WHITE);
		this.btCompra.setBackground(Color.PINK);
		this.btCompra.setBorderPainted(false);
		this.btCompra.addActionListener(this);
		this.add(this.btCompra);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btIngreso) {
			this.ingreso=true;
			this.principal=false;
			this.iWin.setVisible(this.ingreso);
			this.pWin.setVisible(this.principal);
		}
		else if(e.getSource()==this.btCompra) {
			this.ingreso=false;
			this.principal=false;
			this.compras=true;
			this.cWin.setVisible(this.compras);
			this.pWin.setVisible(this.principal);
		}
	}
}
