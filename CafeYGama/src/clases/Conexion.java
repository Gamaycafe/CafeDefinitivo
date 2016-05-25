package clases;

import java.time.Duration;
import java.time.LocalTime;

import bbdd.*;

public class Conexion {
	private int Numero_Conexion;
	private Usuario Codigo_Socio;
	private Ordenador Codigo_Ordenador;
	private String Hora_Inicio;
	private String Hora_Final;
	
	public Conexion(int numero_Conexion, Usuario codigo_Socio, 
			Ordenador codigo_Ordenador, String hora_Inicio, String hora_Final) {
		
		Numero_Conexion = numero_Conexion;
		Codigo_Socio = codigo_Socio;
		Codigo_Ordenador = codigo_Ordenador;
		Hora_Inicio = hora_Inicio;
		Hora_Final = hora_Final;
	}
	
	public int getNumero_Conexion() {
		return Numero_Conexion;
	}
	public void setNumero_Conexion(int numero_Conexion) {
		Numero_Conexion = numero_Conexion;
	}
	
	public Usuario getCodigo_Socio() {
		return Codigo_Socio;
	}
	public void setCodigo_Socio(Usuario codigo_Socio) {
		Codigo_Socio = codigo_Socio;
	}
	
	public Ordenador getCodigo_Ordenador() {
		return Codigo_Ordenador;
	}
	public void setCodigo_Ordenador(Ordenador codigo_Ordenador) {
		Codigo_Ordenador = codigo_Ordenador;
	}
	
	public String getHora_Inicio() {
		return Hora_Inicio;
	}
	public void setHora_Inicio(String hora_Inicio) {
		Hora_Inicio = hora_Inicio;
	}
	
	public String getHora_Final() {
		return Hora_Final;
	}
	public void setHora_Final(String hora_Final) {
		Hora_Final = hora_Final;
	}
	
	@Override
	public String toString() {
		return "Numero_Conexion: " + Numero_Conexion + ", Codigo_Socio: " 
				+ Codigo_Socio + ", Codigo_Ordenador: "+ Codigo_Ordenador 
				+ ", Hora_Inicio: " + Hora_Inicio + ", Hora_Final: " + Hora_Final;
	}
	
	public static long tiempo(LocalTime Hora_Inicio, LocalTime Hora_Final) {
		Duration tiempo=Duration.between(Hora_Final,Hora_Inicio);
		long horas=tiempo.toHours();
		return horas;
	}
	
}
