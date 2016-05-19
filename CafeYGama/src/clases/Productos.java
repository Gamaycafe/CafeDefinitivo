package clases;

public class Productos {
	int Cod_Productos;
	Proveedor Nombre_Proveedor;
	String Tipo_de_Productos;
	int Precio;
	String Nombre;
	int Descuento;
	
	public Productos(int cod_Productos, int precio, String nombre, int descuento) {
		
		Cod_Productos = cod_Productos;
		Precio = precio;
		Nombre = nombre;
		Descuento = descuento;
	}

	public int getCod_Productos() {
		return Cod_Productos;
	}

	public void setCod_Productos(int cod_Productos) {
		Cod_Productos = cod_Productos;
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

	public int getDescuento() {
		return Descuento;
	}

	public void setDescuento(int descuento) {
		Descuento = descuento;
	}

	@Override
	public String toString() {
		return "Cod_Productos: " + Cod_Productos + ", Tipo_de_Productos: " + Tipo_de_Productos + ", Precio: "
				+ Precio + ", Nombre: " + Nombre + ", Descuento: " + Descuento;
	}
	
}
