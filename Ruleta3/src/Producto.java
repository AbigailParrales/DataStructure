
public class Producto {
	private String nombre,
				   marca;
	private int precio,
				cantidad;
	
	public Producto(String nombre, String marca, int precio, int cantidad) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public String toString() {
		return "Nombre: "+this.nombre+", Marca: "+ this.marca+ ", Precio: $"+this.precio+", Cantidad: "+ this.cantidad+"piezas";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
}
