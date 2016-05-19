package clases;

public class Productos {
	private int Cod_Productos;
	private Proveedor Nombre_Proveedor;
	private String Tipo_de_Productos;
	private int Precio;
	private String Nombre;
	private int Cantidad;
	
	public Productos(int cod_Productos, Proveedor nombre_Proveedor, 
			String tipo_de_Productos, int precio, String nombre, int cantidad) {
		
		Cod_Productos = cod_Productos;
		Nombre_Proveedor = nombre_Proveedor;
		Tipo_de_Productos = tipo_de_Productos;
		Precio = precio;
		Nombre = nombre;
		Cantidad = cantidad;
	}

	public int getCod_Productos() {
		return Cod_Productos;
	}
	public void setCod_Productos(int cod_Productos) {
		Cod_Productos = cod_Productos;
	}

	public Proveedor getNombre_Proveedor() {
		return Nombre_Proveedor;
	}
	public void setNombre_Proveedor(Proveedor nombre_Proveedor) {
		Nombre_Proveedor = nombre_Proveedor;
	}

	public String getTipo_de_Productos() {
		return Tipo_de_Productos;
	}
	public void setTipo_de_Productos(String tipo_de_Productos) {
		Tipo_de_Productos = tipo_de_Productos;
	}

	public int getPrecio() {
		return Precio;
	}
	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Cod_Productos: " + Cod_Productos + ", Nombre_Proveedor: " 
				+ Nombre_Proveedor + ", Tipo_de_Productos: " + Tipo_de_Productos 
				+ ", Precio: " + Precio + ", Nombre: " + Nombre + ", Cantidad: " + Cantidad;
	}
}
