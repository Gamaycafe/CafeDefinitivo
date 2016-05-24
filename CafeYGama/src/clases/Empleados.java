package clases;

//@autor Jaime_Grisolía

public class Empleados {
	private String Codigo_Empleado;
	private String DNI;
	private String Nombre;
	private String Apellido;
	private String Direccion;
	private String Telefono;
	private String Tipo_de_Contacto;
	private int Antigüedad;
	private int Sueldo;
	private String Cargo;
	private String Numero_SS;

	public Empleados(String codigo_Empleado, String dNI, String nombre, 
			String apellido, String direccion, String telefono, 
			String tipo_de_Contacto, int antigüedad, int sueldo, 
			String cargo, String numero_SS) {

		Codigo_Empleado = codigo_Empleado;
		DNI = dNI;
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		Telefono = telefono;
		Tipo_de_Contacto = tipo_de_Contacto;
		Antigüedad = antigüedad;
		Sueldo = sueldo;
		Cargo = cargo;
		Numero_SS = numero_SS;
	}

	public Empleados(String codigo_Empleado) {

		Codigo_Empleado = codigo_Empleado;

	}

	public String getCodigo_Empleado() {
		return Codigo_Empleado;
	}
	public void setCodigo_Empleado(String codigo_Empleado) {
		Codigo_Empleado = codigo_Empleado;
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

	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
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

	public String getTipo_de_Contacto() {
		return Tipo_de_Contacto;
	}
	public void setTipo_de_Contacto(String tipo_de_Contacto) {
		Tipo_de_Contacto = tipo_de_Contacto;
	}

	public int getAntigüedad() {
		return Antigüedad;
	}
	public void setAntigüedad(int antigüedad) {
		Antigüedad = antigüedad;
	}

	public int getSueldo() {
		return Sueldo;
	}
	public void setSueldo(int sueldo) {
		Sueldo = sueldo;
	}

	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getNumero_SS() {
		return Numero_SS;
	}
	public void setNumero_SS(String numero_SS) {
		Numero_SS = numero_SS;
	}

	@Override
	public String toString() {
		return "Codigo_Empleado: " + Codigo_Empleado + ", DNI: " + DNI + ", Nombre: " 
				+ Nombre + ", Apellido: " + Apellido + ", Direccion: " + Direccion 
				+ ", Telefono: " + Telefono + ", Tipo_de_Contacto: " 
				+ Tipo_de_Contacto + ", Antigüedad: " + Antigüedad + ", Sueldo: " 
				+ Sueldo + ", Cargo: " + Cargo + ", Numero_SS: " + Numero_SS;
	}

	public void generar_codigo(){
		String codigo="";
		//Declaro las variables del rango numérico que corresponde al alfabeto en Ascii
		//Letras mayúsculas tenemos que usar el rango 65-90
		int num1 = 65;
		int num2 = 95;
		char c = 0;
		// Realizamos el proceso 3 veces, generando una letra alatoria y la concatenamos a la cadena total llamada codigo_Ordeandor
		int numAleatorio1 = (int)Math.floor(Math.random()*(9 -0)+0);
		codigo += numAleatorio1;
		for (int i=1; i<=3; i++){
			int numAleatorio2 = (int)Math.floor(Math.random()*(num2 -num1)+num1);
			c = (char)numAleatorio2;
			codigo += c;
		}
		// Realizamos el proceso 3 veces, generando un numero alatorio y la concatenamos a la cadena total llamada codigo_Ordeandor



		setCodigo_Empleado(codigo);
	}
}
