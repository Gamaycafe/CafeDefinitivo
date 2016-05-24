package clases;

//@autor Jaime_Grisolía

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
	}
	
	
	public Usuario (String nombre, String contraseña,String dni, String codigoS) {
		
		Codigo_Socio = codigoS;
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
	public void setDNI(String DNI) {
		DNI = DNI;
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
	
	public void generar_codigo(){
		  String codigo="";
		  //Declaro las variables del rango numérico que corresponde al alfabeto en Ascii
		  //Letras mayúsculas tenemos que usar el rango 65-90
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