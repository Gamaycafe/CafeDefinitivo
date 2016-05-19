package clases;

public class Factura {
	private int Numero_Factura;
	private Empleados Codigo_Empleado;
	private Conexion Numero_Conexion;
	private String Importe;
	private String Fecha;
	private int Descuento;
	
	public Factura(int numero_Factura, Empleados codigo_Empleado, 
			Conexion numero_Conexion, String importe, String fecha, int descuento) {
		
		Numero_Factura = numero_Factura;
		Codigo_Empleado = codigo_Empleado;
		Numero_Conexion = numero_Conexion;
		Importe = importe;
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
	
}
