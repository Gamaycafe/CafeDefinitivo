package clases;

public class Usuario {
	private String Codigo_Socio;
	private String DNI;
	private String Nombre;
	private String Contrase�a;
	
	public Usuario(String dni, String contrase�a) {
		
		Codigo_Socio = null;
		DNI = dni;
		Nombre = null;
		Contrase�a = contrase�a;
	}
	
	
	public Usuario (String nombre,String dni, String contrase�a, String codigoS) {
		
		Codigo_Socio = codigoS;
		DNI = dni;
		Nombre = nombre;
		Contrase�a = contrase�a;
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
	public void setDNI(String DNI) {
		DNI = DNI;
	}

	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getContrase�a() {
		return Contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		Contrase�a = contrase�a;
	}

	@Override
	public String toString() {
		return "Codigo_Socio: " + Codigo_Socio + ", DNI: " + DNI + ", Nombre: " 
				+ Nombre + ", Contrase�a: " + Contrase�a;
	}
	
	
	
}