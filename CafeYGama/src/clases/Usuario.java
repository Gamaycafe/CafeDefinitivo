package clases;

//@autor Jaime_Grisol�a

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
	
	
	public Usuario (String nombre, String contrase�a,String dni, String codigoS) {
		
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
	
	public void generar_codigo(){
		  String codigo="";
		  //Declaro las variables del rango num�rico que corresponde al alfabeto en Ascii
		  //Letras may�sculas tenemos que usar el rango 65-90
		  int num1 = 65;
		  int num2 = 95;
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