package clases;

//import org.omg.CORBA.IMP_LIMIT;

//import clases.*;

/**
 * @author Miguel Arada Benavides
 * 
**/

public class Factura {
	private int Numero_Factura;
	private String Codigo_Empleado;
	private Conexion Numero_Conexion;
	public static double Importe = 0;
	private String Fecha;
	
	public Factura(String codigo_Empleado, 
			Conexion numero_Conexion, String fecha) {
			
		Codigo_Empleado = codigo_Empleado;
		Numero_Conexion = numero_Conexion;
		Fecha = fecha;
	}

	

	public int getNumero_Factura() {
		return Numero_Factura;
	}
	public void setNumero_Factura(int numero_Factura) {
		Numero_Factura = numero_Factura;
	}

	public String getCodigo_Empleado() {
		return Codigo_Empleado;
	}
	public void setCodigo_Empleado(String codigo_Empleado) {
		Codigo_Empleado = codigo_Empleado;
	}

	public Conexion getNumero_Conexion() {
		return Numero_Conexion;
	}
	public void setNumero_Conexion(Conexion numero_Conexion) {
		Numero_Conexion = numero_Conexion;
	}

	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	@Override
	public String toString() {
		return "Numero_Factura: " + Numero_Factura + ", Codigo_Empleado: " 
				+ Codigo_Empleado + ", Numero_Conexion: " + Numero_Conexion 
				+ ", Importe: " + Importe + ", Fecha: " + Fecha;
	}
	
	public double realizar_importe() {
		double tiempoConexion = Numero_Conexion.tiempo(Numero_Conexion.getHora_Inicio(), Numero_Conexion.getHora_Final());
		int euros = 0;
		do{
			tiempoConexion =- 0.5;
			euros += 1;
		} while(tiempoConexion>0);
		
		Importe = Importe + euros;
		return Importe;
	}
	
	public void pedidos(Productos producto){
		Importe += producto.getPrecio();
	}
	
	public void descuento() { // Realizar descuento si el usuario es de tipo socio
			Importe = Importe - (Importe*15/100);
		
	}
}