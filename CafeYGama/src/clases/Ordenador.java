package clases;

public class Ordenador {
	private String Codigo;
	private int Contador;
	
	public Ordenador(String codigo_Ordenador, int contador) {
		
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
