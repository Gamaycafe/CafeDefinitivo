package clases;

/**
 * @author Miguel Arada Benavides
 * Clase Ordenador es donde guardamos las variables de la tabla Ordeandor
**/

public class Ordenador {
	private String Codigo;
	
	public Ordenador() {
		Codigo = null;
	}

	public Ordenador(String codigo){
		Codigo=codigo;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo_Ordenador) {
		Codigo = codigo_Ordenador;
	}


	@Override
	public String toString() {
		return "Codigo_Ordenador: " + Codigo;
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
		for (int i=1; i<=3; i++){
			int numAleatorio = (int)Math.floor(Math.random()*(9 -0)+0);
			codigo += numAleatorio;
		}
		setCodigo(codigo);
	}
}