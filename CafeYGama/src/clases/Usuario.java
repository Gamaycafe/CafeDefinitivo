package clases;

/**
 * @author: Jaime_Grisolia
 * @version: 05/06/2016
 */


public class Usuario {
	private String Codigo_Socio;
	private String DNI;
	private String Nombre;
	private String Contrase�a;
	
	/**
     * Constructor para la busqueda de un cliente en la BBDD
     * @param dni, contrase�a DNI y CONTRASE�A seran usados para buscar un cliente con esos datos
     */
	public Usuario(String dni, String contrase�a) {
		
		Codigo_Socio = null;
		DNI = dni;
		Nombre = null;
		Contrase�a = contrase�a;
	} //Cierre del constructor
	
	/**
     * Constructor para la eliminacion de un cliente en la BBDD
     * @param dni dni sera usado para eliminar un cliente con esos datos
     */
	public Usuario(String dni) {
		
		Codigo_Socio = null;
		DNI = dni;
		Nombre = null;
		Contrase�a = null;
	} //Cierre del constructor
	/**
     * Constructor para la creacion de un nuevo usuario
     * @param nombre, contrase�a, dni, codigoS Estos datos, excepto codigoS seran metidos por teclado y utilizados para crear un nuevo USUARIO o SOCIO, dependiendo lo que elija el cliente
     */
	public Usuario (String nombre, String contrase�a,String dni, String codigos) {
		
		Codigo_Socio = codigos;
		DNI = dni;
		Nombre = nombre;
		Contrase�a = contrase�a;
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
	
	
	/**
     * M�todo que genera un codigo aleatorio para los clientes que sera usado posteriormente para distingir un usuario de un socio
     */
	public void generar_codigo(){
		  String codigo="";
		  //Declaro las variables del rango num�rico que corresponde al alfabeto en Ascii
		  //Letras may�sculas tenemos que usar el rango 65-90
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