package bbdd;
 
/**
 * @author: Victor_Alvarez
 * @version: 04/06/2016
 */
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.*;
 
import clases.Conexion;
import clases.Ordenador;
import clases.Usuario;
 
public class BBDDConexion {
 
    //Campos de la clase
     
    private static Statement s;
    private static Connection c;
    private static ResultSet reg;
 
     
     
    public static Connection getC() {
        return c;
    }
 
    public static void setC(Connection c) {
        BBDDConexion.c = c;
    }
     
     
    /**
     * Este método está en desuso.
     */
     
    public static void crear(Conexion conexion, Connection c){
     
     
        String cadena="INSERT INTO conexion VALUES('" + conexion.getCodigo_Ordenador() + "','" + conexion.getUsuario() 
                + "','" + conexion.getHora_Inicio() + "','" + conexion.getHora_Final() +"')";   
 
        try{
            s=c.createStatement();
            s.executeUpdate(cadena);
            s.close();
        }
        catch ( SQLException e){
            System.out.println(e.getMessage());
        }
    }//Cierre del método
     
     
    /**
     * Este método se utilizará para crear e iniciar la conexión de un ordenador, guardando la hora en la que se accede a él.
     */
     
    public static void iniciar(Conexion conexion, Usuario usuario, Ordenador ordenador, Connection c){
        String cadena="INSERT INTO conexion VALUES( null,'" + ordenador.getCodigo() + "','"  + LocalTime.now() + "', 0,'" + usuario.getDNI() 
        + "')";
         
        try{
            s=c.createStatement();
            s.executeUpdate(cadena);
            s.close();
            }
            catch ( SQLException e){
                System.out.println(e.getMessage());
            }
    }//Cierre del método
     
     
    /**
     * Este método se utilizará para finalizar la conexión de un ordenador, guardando la hora en la que se cierra sesión.
     */
     
    public static void finalizar(Conexion conexion, Ordenador ordenador,Connection c){
        String cadena="UPDATE conexion SET Hora_Final ='" + LocalTime.now() +
                "'WHERE Codigo_Ordenador ='" + ordenador.getCodigo() + "'";
         
        try{
            s=c.createStatement();
            s.executeUpdate(cadena);
            s.close();
            }
            catch ( SQLException e){
                System.out.println(e.getMessage());
            }
    }//Cierre del método
     
     
    /**
     * Este método está en desuso.
     */
     
    public static int getNumeroConexion(Connection c){
        String cadena="SELECT MAX(Numero_Conexion) FROM conexion";
         
        try{
            s=c.createStatement();
            reg=s.executeQuery(cadena);
            if (reg.next()){
                return reg.getInt(1);
            }
            s.close();
            return 0;
            }
            catch ( SQLException e){
                System.out.println(e.getMessage());
                return -1;
            }
    }//Cierre del método
     
}//Cierre de la clase