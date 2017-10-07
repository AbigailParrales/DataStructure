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

public class ComprasPanel extends JPanel implements ActionListener{
	private Label lbTitle,
				  lbCode;
	private JTextField tfCode;
	
	private JButton btBuscar;
	
	private HashTable<Producto> t;
	
	public ComprasPanel(IngresoPanel ip) {
		super();
		
		this.setPreferredSize(new Dimension(1000, 600));
		this.setBackground(Color.WHITE);
		
		this.lbTitle= new Label("Ingrese el código del producto que está buscando");
		this.lbTitle.setPreferredSize(new Dimension(1050, 85));
		this.lbTitle.setFont(new Font("Arial",Font.BOLD,44));
		this.add(this.lbTitle);
		
		this.lbCode = new Label("Código de producto");
		this.lbCode.setPreferredSize(new Dimension(225,40));
		this.lbCode.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbCode);

		this.tfCode = new JTextField(30);
		this.tfCode.setPreferredSize(new Dimension(850,20));
		this.add(this.tfCode);
		
		this.btBuscar= new JButton("Buscar");
		this.btBuscar.setPreferredSize(new Dimension(700, 70));
		this.btBuscar.addActionListener(this);
		this.add(this.btBuscar);
		
		this.t=ip.getT();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btBuscar) {
			int tmp=this.t.hash(Integer.parseInt(this.tfCode.getText()));
			System.out.println(tmp);
			int k= Integer.parseInt(this.tfCode.getText());
			System.out.println(k);
			JOptionPane.showMessageDialog(this, "El producto que busca es el siguiente: "+this.t.table[tmp].get(Integer.parseInt(this.tfCode.getText())));
			int cantidad =Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad a comprar"));
			int piezas=this.t.table[tmp].get(Integer.parseInt(this.tfCode.getText())).getCantidad();
			
			if((piezas-cantidad)>=0) {
				int total=cantidad*(this.t.table[tmp].get(Integer.parseInt(this.tfCode.getText())).getPrecio());
				this.t.table[tmp].get(Integer.parseInt(this.tfCode.getText())).setCantidad(piezas-cantidad);
				JOptionPane.showMessageDialog(this, "El total es: "+ total+"\n Las piezas actuales del producto seleccionado son: "+this.t.table[tmp].get(Integer.parseInt(this.tfCode.getText())).getCantidad());
			}
			else {
				JOptionPane.showMessageDialog(this, "No hay suficientes piezas");
				this.tfCode.setText("");
			}
		}
	}
}
