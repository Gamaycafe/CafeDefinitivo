package bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import clases.*;

/**
 * @author Miguel Arada Benavides
 * @version 5/6/2016
 * Clase de bbdd encargada de comunicarse con la base de datos y realizar consultas con la columna Ordenadores.
 **/

/**
 * Esta clase tiene tres atributos: s, c reg
 * Además se ha generado los metodos get y set del atributo Connection (c)
 * Tambien se han realizado cuatro metodos alta, buscarOrdenador,  baja y vector
 */

public class BBDDOrdenador {
	private static Statement s;
	private static Connection c;
	private static ResultSet reg;

	public static Connection getC() {
		return c;
	}

	public static void setC(Connection c) {
		BBDDOrdenador.c = c;
	}


	/**
	 * En el metodo alta crea un nuevo ordeandor en la base de datos.
	 * @param ordenador es de tipo Ordeandor, por por lo tanto le estamos damos la informacion de un ordenador.
	 * @param c es de Tipo Connection, aqui le enviamos la informacion de al base de datos a la que queremos conectarnos.
	 */
	public static void alta(Ordenador ordenador, Connection c){
		String cadena="INSERT INTO ordenadores VALUES('" + ordenador.getCodigo() +"')";

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * En el metodo buscarOrdenador busca un ordenador ya creado en al base de datos.
	 * @param ordenador es de tipo Ordeandor, por por lo tanto le estamos damos la informacion de un ordenador.
	 * @param c es de Tipo Connection, aqui le enviamos la informacion de al base de datos a la que queremos conectarnos.
	 * @return Codigo_Ordenador
	 */
	public static String buscarOrdenador(Ordenador ordenador, Connection c){

		String cadena="SELECT Codigo_Ordenador  FROM ordenadores WHERE Codigo_Ordenador='" +ordenador.getCodigo() +"'";
		try{
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			if ( reg.next()){
				String t=reg.getString(1);
				s.close();
				return t;
			}
			s.close();
			return "";
		}
		catch ( SQLException e){
			return null;
		}
	}

	/**
	 * En el metodo baja borra un ordeandor de la base de datos.
	 * @param ordenador es de tipo Ordeandor, por por lo tanto le estamos damos la informacion de un ordenador.
	 * @param c es de Tipo Connection, aqui le enviamos la informacion de al base de datos a la que queremos conectarnos.
	 */
	public static void baja(Ordenador ordenador, Connection c){
		String cadena="DELETE FROM ordenadores WHERE codigo_ordenador='" + ordenador.getCodigo() +"'";

		try{
			s=c.createStatement();
			s.executeUpdate(cadena);
			s.close();
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * En el metodo vector es una lista de todos los ordenadores que existen en la base de datos.
	 * @param c es de Tipo Connection, aqui le enviamos la informacion de al base de datos a la que queremos conectarnos.
	 * @return vector este metodo nos devuelve
	 */
	public static Vector<Ordenador> vector(Connection c){

		String cadena="SELECT Codigo_Ordenador FROM ordenadores";
		Vector <Ordenador> lista_ordenadores = new Vector<Ordenador>();
		try{
			s=c.createStatement();
			reg=s.executeQuery(cadena);
			while ( reg.next()){

				String codigo=reg.getString(1);

				Ordenador o=new Ordenador (codigo);
				lista_ordenadores.add(o);
			}
			s.close();
			return lista_ordenadores;
		}
		catch ( SQLException e){
			System.out.println(e.getMessage());

			return null;
		}


	}

}