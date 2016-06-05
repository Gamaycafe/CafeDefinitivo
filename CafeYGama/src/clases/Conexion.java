package clases;
 
/**
 * @author: Victor_Alvarez
 * @version: 04/06/2016
 */
 
import java.time.Duration;
import java.time.LocalTime;
 
//import bbdd.*;
 
public class Conexion {
     
    //Campos de la clase
     
    private int Numero_Conexion;
    private Usuario usuario;
    private Ordenador Codigo_Ordenador;
    private LocalTime Hora_Inicio;
    private LocalTime Hora_Final;
    private String Dni;
     
     
    /**
     * Constructor cuya finalidad es llevar la cuenta de el tiempo que dura una conexión.
     * @param Usuario, codigo_Ordenador, usuario.getDNI
     */
     
    public Conexion(Usuario Usuario, 
            Ordenador codigo_Ordenador) {
         
        usuario = Usuario;
        Codigo_Ordenador = codigo_Ordenador;
        Dni = usuario.getDNI();
    }//Cierre del constructor
     
     
    public int getNumero_Conexion() {
        return Numero_Conexion;
    }
    public void setNumero_Conexion(int numero_Conexion) {
        Numero_Conexion = numero_Conexion;
    }
     
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario Usuario) {
        usuario = Usuario;
    }
     
    public Ordenador getCodigo_Ordenador() {
        return Codigo_Ordenador;
    }
    public void setCodigo_Ordenador(Ordenador codigo_Ordenador) {
        Codigo_Ordenador = codigo_Ordenador;
    }
     
    public LocalTime getHora_Inicio() {
        return Hora_Inicio;
    }
    public void setHora_Inicio(LocalTime hora_Inicio) {
        Hora_Inicio = hora_Inicio;
    }
     
    public LocalTime getHora_Final() {
        return Hora_Final;
    }
    public void setHora_Final(LocalTime hora_Final) {
        Hora_Final = hora_Final;
    }
     
    @Override
    public String toString() {
        return "Numero_Conexion: " + Numero_Conexion + ", Usuario: "
                + usuario + ", Codigo_Ordenador: "+ Codigo_Ordenador 
                + ", Hora_Inicio: " + Hora_Inicio + ", Hora_Final: " + Hora_Final;
    }
     
     
    /**
     * Método que coge los tiempos en que se inicia y se finaliza la conexion..
     ** @return El tiempo que ha estado conectado el ordenador, que es enviado a la factura.
     */
     
    public static double tiempo(LocalTime Hora_Inicio, LocalTime Hora_Final) {
        Duration tiempo=Duration.between(Hora_Inicio,Hora_Final);
        double horas=tiempo.toMinutes();
        return horas;
    }
     
}//Cierre de la clase