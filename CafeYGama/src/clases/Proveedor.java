package clases;

public class Proveedor {
	String Nombre;
	String Direccion;
	String Telefono;
	
	public Proveedor(String nombre, String direccion, String telefono) {
		
		Nombre = nombre;
		Direccion = direccion;
		Telefono = telefono;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	@Override
	public String toString() {
		return "Nombre: " + Nombre + ", Direccion: " + Direccion + ", Telefono: " + Telefono;
	}
	
}
