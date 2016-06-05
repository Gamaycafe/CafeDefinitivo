package clases;

/**
 * @author: Jaime_Grisolia
 * @version: 05/06/2016
 */


public class Usuario {
	private String Codigo_Socio;
	private String DNI;
	private String Nombre;
	private String Contraseña;

	
	public Usuario(String dni, String contraseña) {

		Codigo_Socio = null;
		DNI = dni;
		Nombre = null;
		Contraseña = contraseña;
	} //Cierre del constructor

	
	public Usuario(String dni) {

		Codigo_Socio = null;
		DNI = dni;
		Nombre = null;
		Contraseña = null;
	} //Cierre del constructor

	public Usuario (String nombre, String contraseña,String dni, String codigos) {

		Codigo_Socio = codigos;
		DNI = dni;
		Nombre = nombre;
		Contraseña = contraseña;
	} //Cierre del constructor

	public String getCodigo_Socio() {
		return Codigo_Socio;
	}
	public void setCodigo_Socio(String codigo_Socio) {
		Codigo_Socio = codigo_Socio;
	}

	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dni) {
		DNI = dni;
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


	/**
	 * Método que genera un codigo aleatorio para los clientes que sera usado posteriormente para distingir un usuario de un socio
	 */
	public void generar_codigo(){
		String codigo="";
		//Declaro las variables del rango numérico que corresponde al alfabeto en Ascii
		//Letras mayúsculas tenemos que usar el rango 65-90
		int num1 = 65;
		int num2 = 90;
		char c = 0;
		// Realizamos el proceso 3 veces, generando una letra alatoria y la concatenamos a la cadena total llamada codigo_Ordeandor
		for (int i=1; i<=3; i++){
			int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
			c = (char)numAleatorio;
			codigo += c;
		}
		// Realizamos el proceso 3 veces, generando un numero alatorio y la concatenamos a la cadena total llamada codigo_Ordeandor

		int numAleatorio = (int)Math.floor(Math.random()*(9 -0)+0);
		codigo += numAleatorio;

		setCodigo_Socio(codigo);
	}

}