package clases;

public class Ordenador {
	private String Codigo;
	private int Contador;
	
	public Ordenador(int contador) {
		//subir
		String codigo_Ordenador="";
			//declaro las variables del rango numérico que corresponde al alfabeto en Ascii
			//Letras mayúsculas tenemos que usar el rango 65-90
			int num1 = 65;
			int num2 = 95;
			char c = 0;
			
			for (int i=1; i<=3; i++){
				int numAleatorio = (int)Math.floor(Math.random()*(num2 -num1)+num1);
				c = (char)numAleatorio;
				codigo_Ordenador = codigo_Ordenador + c;
			}
			for (int i=1; i<=3; i++){
				int numAleatorio = (int)Math.floor(Math.random()*(9 -0)+0);
				codigo_Ordenador = codigo_Ordenador + numAleatorio;
			}
		Codigo = codigo_Ordenador;
		Contador = contador;
	}

	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo_Ordenador) {
		Codigo = codigo_Ordenador;
	}

	public int getContador() {
		return Contador;
	}
	public void setContador(int contador) {
		Contador = contador;
	}

	@Override
	public String toString() {
		return "Codigo_Ordenador: " + Codigo + ", Contador: " + Contador;
	}
	
}
