package clases;

public class Factura {
	int Numero_Factura;
	Empleados Codigo_Empleado;
	Conexion Numero_Conexion;
	String Importe;
	String Fecha;
	
	public Factura(int numero_Factura, String importe, String fecha) {
		
		Numero_Factura = numero_Factura;
		Importe = importe;
		Fecha = fecha;
	}
	
	public int getNumero_Factura() {
		return Numero_Factura;
	}
	public void setNumero_Factura(int numero_Factura) {
		Numero_Factura = numero_Factura;
	}
	public String getImporte() {
		return Importe;
	}
	public void setImporte(String importe) {
		Importe = importe;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "Numero_Factura: " + Numero_Factura + ", Importe: " + Importe + ", Fecha: " + Fecha;
	}
	
}
