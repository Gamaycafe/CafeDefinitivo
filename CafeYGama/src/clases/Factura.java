package clases;

import clases.*;

/**
 * @author Miguel Arada Benavides
 * 
**/

public class Factura {
	private int Numero_Factura;
	private Empleados Codigo_Empleado;
	private Conexion Numero_Conexion;
	private double Importe;
	private String Fecha;
	private int Descuento;
	
	public Factura(Empleados codigo_Empleado, 
			Conexion numero_Conexion, String fecha, int descuento) {
		
		Numero_Factura++;	
		Codigo_Empleado = codigo_Empleado;
		Numero_Conexion = numero_Conexion;
		Fecha = fecha;
		Descuento = descuento;
	}

	public int getNumero_Factura() {
		return Numero_Factura;
	}
	public void setNumero_Factura(int numero_Factura) {
		Numero_Factura = numero_Factura;
	}

	public Empleados getCodigo_Empleado() {
		return Codigo_Empleado;
	}
	public void setCodigo_Empleado(Empleados codigo_Empleado) {
		Codigo_Empleado = codigo_Empleado;
	}

	public Conexion getNumero_Conexion() {
		return Numero_Conexion;
	}
	public void setNumero_Conexion(Conexion numero_Conexion) {
		Numero_Conexion = numero_Conexion;
	}

	public double getImporte() {
		return Importe;
	}
	public void setImporte(Double importe) {
		Importe = importe;
	}

	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public int getDescuento() {
		return Descuento;
	}
	public void setDescuento(int descuento) {
		Descuento = descuento;
	}

	@Override
	public String toString() {
		return "Numero_Factura: " + Numero_Factura + ", Codigo_Empleado: " 
				+ Codigo_Empleado + ", Numero_Conexion: " + Numero_Conexion 
				+ ", Importe: " + Importe + ", Fecha: " + Fecha + ", Descuento: "
				+ Descuento;
	}
	
	public double realizar_importe() {
		double importe = 0;
		
		return importe;
	}
}