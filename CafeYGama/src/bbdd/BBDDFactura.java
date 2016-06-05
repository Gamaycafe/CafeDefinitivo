package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import clases.Factura;

/**
 * @author Miguel Arada Benavides
 * @version 5/6/2016
 * Clase de bbdd encargada de comunicarse con la base de datos y realizar consultas con la columna Factura.
 **/

/**
 * Esta clase tiene tres atributos: s, c, reg
 * Además se ha generado los metodos get y set del atributo Connection (c)
 * También se han realizado un metodo crear
 */

public class BBDDFactura {

	private static Statement s;
	private static Connection c;
	private static ResultSet reg;


	/**
	 * @return c conexion
	 */
	public static Connection getC() {
		return c;
	}

	/**
	 * @param c conexion de la bbdd
	 */
	public static void setC(Connection c) {
		BBDDFactura.c = c;
	}

	/**
	 * @return reg resulado de la consulta de bbdd
	 */
	public static ResultSet getReg() {
		return reg;
	}

	/**
	 * @param reg regresulado de la consulta de bbdd
	 */
	public static void setReg(ResultSet reg) {
		BBDDFactura.reg = reg;
	}


	/**
	 * En el metodo crear creamos un nueva factura en la base de datos.
	 * @param factura es de Tipo Factura, por lo tanto le estamos damos la informacion de un factura.
	 * @param c es de Tipo Connection, aqui le enviamos la informacion de al base de datos a la que queremos conectarnos.
	 */
	public static void crear (Factura factura, Connection c){
		String cadena="INSERT INTO factura VALUES(null,'" + factura.getCodigo_Empleado()+ "','" + factura.getNumero_Conexion().getNumero_Conexion() 
				+ "','"  + factura.getImporte() + "','" + LocalDate.now()+"')"; 


		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}

}