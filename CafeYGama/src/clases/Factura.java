package clases;

//import org.omg.CORBA.IMP_LIMIT;

//import clases.*;

/**
 * @author Miguel Arada Benavides
 * Clase Factura es donde guardamos las variables de la tabla Factura
 * Atributos: Numero_Factura, Codigo_Empleado, Numero_Conexion, Importe, Fecha
 * Metodos: 
 * contructor 
 * gets y set de todos los atributos
 * toString para generar una cadena con toda la informacion
 * realizar_importe realiza el improte con el tiempo que lleva en al conexion y lo suma al improte
 * pedidos le pasa el producto y de hay coge el precio del producto y se lo suma a importe
 * descuento realiza el descuento si es de tipo socio, y el descuento es de 15 %
 **/

public class Factura {
	private int Numero_Factura;
	private String Codigo_Empleado;
	private Conexion Numero_Conexion;
	private double Importe = 0;
	private String Fecha;

	/**
	 * @param codigo_Empleado empleado que realiza la factura
	 * @param numero_Conexion conexion que realiza la factura
	 * @param fecha cada dode le apsamos la fecha en la que realizamos la fatura
	 */
	public Factura(String codigo_Empleado, 
			Conexion numero_Conexion, String fecha) {

		Codigo_Empleado = codigo_Empleado;
		Numero_Conexion = numero_Conexion;
		Fecha = fecha;
	}


	/**
	 * @return Importe precio que debe pagar el cliente
	 */
	public double getImporte() {
		return Importe;
	}
	/**
	 * @param importe precio que debe pagar el cliente
	 */
	public void setImporte(double importe) {
		Importe = importe;
	}

	/**
	 * @return Numero_Factura numero de la factura
	 */
	public int getNumero_Factura() {
		return Numero_Factura;
	}
	/**
	 * @param numero_Factura numero de la factura
	 */
	public void setNumero_Factura(int numero_Factura) {
		Numero_Factura = numero_Factura;
	}
	/**
	 * @return Codigo_Empleado empelado que realiza la factura
	 */
	public String getCodigo_Empleado() {
		return Codigo_Empleado;
	}
	/**
	 * @param codigo_Empleado empelado que realiza la factura
	 */
	public void setCodigo_Empleado(String codigo_Empleado) {
		Codigo_Empleado = codigo_Empleado;
	}
	/**
	 * @return Numero_Conexion conexion que realiza la factura
	 */
	public Conexion getNumero_Conexion() {
		return Numero_Conexion;
	}
	/**
	 * @param numero_Conexion conexion que realiza la factura
	 */
	public void setNumero_Conexion(Conexion numero_Conexion) {
		Numero_Conexion = numero_Conexion;
	}
	/**
	 * @return Fecha fecha de la factura
	 */
	public String getFecha() {
		return Fecha;
	}
	/**
	 * @param fecha fecha de la factura
	 */
	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	/**
	 * @return cadena con al informacion de todos los atributos
	 */
	@Override
	public String toString() {
		return "Numero_Factura: " + Numero_Factura + ", Codigo_Empleado: " 
				+ Codigo_Empleado + ", Numero_Conexion: " + Numero_Conexion 
				+ ", Importe: " + Importe + ", Fecha: " + Fecha;
	}

	/**
	 * @return importe precio que debe pagar el cliente
	 */
	public double realizar_importe() {
		double tiempoConexion = Numero_Conexion.Duracion();
		Importe += tiempoConexion * 0.03;
		System.out.println("Tiempo conexion: "+tiempoConexion);
		//Importe +=30;
		return Importe;
	}

	public void pedidos(Productos producto){
		Importe += producto.getPrecio();
	}

	public void descuento() { // Realizar descuento si el usuario es de tipo socio
		Importe = Importe - (Importe*15/100);

	}
}
