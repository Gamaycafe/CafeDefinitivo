package clases;

public class Usuario {
	private String Codigo_Socio;
	private String DNI;
	private String Nombre;
	private String Contraseña;
	
	public Usuario(String dni, String nombre, String contraseña) {
		
		Codigo_Socio = null;
		DNI = dni;
		Nombre = nombre;
		Contraseña = contraseña;
	}

	public String getCodigo_Socio() {
		return Codigo_Socio;
	}
	public void setCodigo_Socio(String codigo_Socio) {
		Codigo_Socio = codigo_Socio;
	}

	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Codigo_Socio: " + Codigo_Socio + ", DNI: " + DNI + ", Nombre: " 
				+ Nombre + ", Contraseña: " + Contraseña;
	}
	
	
	
}
