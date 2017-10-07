import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class IngresoPanel extends JPanel implements ActionListener{
	private Label lbTitle,
	lbCode,
	lbNombreProducto,
	lbCantidad,
	lbMarca,
	lbPrecio;
	private JTextField tfNombreProducto,
	tfCode,
	tfCantidad,
	tfMarca,
	tfPrecio;

	private JButton btIngresar;

	private HashTable<Producto> t;

	//protected Inventario stock;

	public IngresoPanel() {
		super();

		this.setPreferredSize(new Dimension(1000, 600));
		this.setBackground(Color.WHITE);

		this.lbTitle= new Label("Ingreso de nuevos productos");
		this.lbTitle.setPreferredSize(new Dimension(1050, 85));
		this.lbTitle.setFont(new Font("Arial",Font.BOLD,70));
		this.add(this.lbTitle);

		this.lbNombreProducto = new Label("Nombre de producto");
		this.lbNombreProducto.setPreferredSize(new Dimension(225,40));
		this.lbNombreProducto.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbNombreProducto);

		this.tfNombreProducto = new JTextField(30);
		this.tfNombreProducto.setPreferredSize(new Dimension(850,20));
		this.add(this.tfNombreProducto);

		this.lbCode = new Label("Código de producto");
		this.lbCode.setPreferredSize(new Dimension(225,40));
		this.lbCode.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbCode);

		this.tfCode = new JTextField(30);
		this.tfCode.setPreferredSize(new Dimension(850,20));
		this.add(this.tfCode);

		this.lbCantidad = new Label("Cantidad de productos");
		this.lbCantidad.setPreferredSize(new Dimension(225,40));
		this.lbCantidad.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbCantidad);

		this.tfCantidad = new JTextField(30);
		this.tfCantidad.setPreferredSize(new Dimension(850,20));
		this.add(this.tfCantidad);

		this.lbMarca = new Label("Marca de producto");
		this.lbMarca.setPreferredSize(new Dimension(225,40));
		this.lbMarca.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbMarca);

		this.tfMarca = new JTextField(30);
		this.tfMarca.setPreferredSize(new Dimension(850,20));
		this.add(this.tfMarca);

		this.lbPrecio = new Label("Precio de producto");
		this.lbPrecio.setPreferredSize(new Dimension(225,40));
		this.lbPrecio.setFont(new Font("Arial",Font.BOLD,20));
		this.add(this.lbPrecio);

		this.tfPrecio = new JTextField(30);
		this.tfPrecio.setPreferredSize(new Dimension(850,20));
		this.add(this.tfPrecio);

		this.btIngresar= new JButton("Ingresar producto");
		this.btIngresar.setPreferredSize(new Dimension(700, 70));
		this.btIngresar.addActionListener(this);
		this.add(this.btIngresar);

		//this.stock= new Inventario();


		this.setT(new HashTable<>(5));
		this.getT().add(0, new Producto("Rufles", "Sabritas", 11, 400));
		this.getT().add(2, new Producto("Churrumais", "Sabritas", 9, 400));
		this.getT().add(4, new Producto("Chetos", "Sabritas", 10, 400));

		this.getT().add(1, new Producto("J7", "Samsumg", 3000, 30));
		this.getT().add(3, new Producto("iPhone X", "Apple", 30000, 10));
		this.getT().add(5, new Producto("Inspiron 15", "Dell", 15000, 30));
		this.getT().add(7, new Producto("GL62 7RD-434MX", "MSI", 30000, 7));
		this.getT().add(9, new Producto("Galaxy", "Samsumg", 3000, 30));

		this.getT().add(11, new Producto("Skinny high rise jeans", "Levis", 800, 30));
		this.getT().add(16, new Producto("Mocasines Veronica", "Naturalizer Women's Veronica Penny Loafer", 2000, 30));



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btIngresar) {
			try {
				int code=Integer.parseInt(this.tfCode.getText());
				int hash=this.getT().hash(code);

				System.out.println("Código del elemento: "+code);
				System.out.println("Contains element: "+ this.getT().contains(code));

				System.out.println(this.getT().table[hash]);
				System.out.println("Contains element: "+ this.getT().contains(3));

				if(this.getT().contains(code)) {
					System.out.println("Estoy en el caso contains==true");
					this.getT().set(code, new Producto(this.tfNombreProducto.getText(), this.tfMarca.getText(), Integer.parseInt(this.tfPrecio.getText()), Integer.parseInt(this.tfCantidad.getText())));
				}
				else {
					this.getT().add(Integer.parseInt(this.tfCode.getText()), new Producto(this.tfNombreProducto.getText(), this.tfMarca.getText(), Integer.parseInt(this.tfPrecio.getText()), Integer.parseInt(this.tfCantidad.getText())));
					JOptionPane.showMessageDialog(this, "El producto recien agredado es el siguiente:\n"
							+ "Código: "+ this.tfCode.getText()+"\n"
							+ "Nombre:"+this.tfNombreProducto.getText()+"\n"
							+ "Marca: "+this.tfMarca.getText()+"\n"
							+ "Precio: $"+this.tfPrecio.getText()+"\n"
							+ "Cantidad: "+this.tfCantidad.getText() +"\n");
				}

				this.tfCode.setText("");
				this.tfNombreProducto.setText("");
				this.tfMarca.setText("");
				this.tfPrecio.setText("");
				this.tfCantidad.setText("");

				System.out.println("Estado de la hash:\n"+ this.getT());
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "Input inválido");
				this.tfCode.setText("");
				this.tfNombreProducto.setText("");
				this.tfMarca.setText("");
				this.tfPrecio.setText("");
				this.tfCantidad.setText("");
			} catch (HeadlessException e1) {
				JOptionPane.showMessageDialog(this, "Input inválido");
				this.tfCode.setText("");
				this.tfNombreProducto.setText("");
				this.tfMarca.setText("");
				this.tfPrecio.setText("");
				this.tfCantidad.setText("");
			}
		}
	}

	public HashTable<Producto> getT() {
		return t;
	}

	public void setT(HashTable<Producto> t) {
		this.t = t;
	}
}
