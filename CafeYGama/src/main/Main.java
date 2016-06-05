package main;

/**
 * @author: Jaime_Grisolia
 * @version: 05/06/2016
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import bbdd.*;
import clases.*;
public class Main {

	public static void main(String[] args) throws SQLException {

		boolean error=false;
		LocalTime Horainicio;
		LocalTime Horafinal;
		Usuario u;
		Usuario usu;
		Conexion conexion = null;
		Empleados e;
		String DNI="";
		Ordenador o;
		Ordenador ordenador=null;
		Productos producto = null;
		Factura f=null;
		int elegirPedido=0;
		int opcionEmple=0;
		int opcionInicial=0;
		int opcion=0;
		int opcionE=0;
		int opcionUsuario=0;
		int opcionSocio=0;
		int opcMenu=0;
		int masPedido=0;
		int opcionCiber=0;
		int opcionCafe=0;
		Empleados emple=null;
		double precioProducto=0;
		LocalDate hoy= LocalDate.now();
		String cod_ordena;
		String ordenador_Cod="";

		boolean existe =false;
		boolean registroS=false;
		boolean registroU=false;
		boolean accionRealizada=false;
		emple =new Empleados("3ABC");
		String nif="",passwd="",codigo="",codigoE="";
		Scanner sc = new Scanner(System.in);
		//BaseDatos mibase=new BaseDatos("cibercafe");
		BaseDatosC mibase=new BaseDatosC("mysql-properties.xml");
		String codigOr="";


		/*



		String[] codigos_Ordenador = new String[20];
		String[] codigos_Ordenador_Exitentes = new String[3];
		codigos_Ordenador_Exitentes [0] = "AAA123";
		codigos_Ordenador_Exitentes [1] = "BBB123";
		codigos_Ordenador_Exitentes [2] = "CCC123";

		boolean verificar = false;


		//Ordenador ordenador = new Ordenador();

		for (int i = 0; i < 20; i++) { //Generar los 20 ordenadores
			ordenador.generar_codigo();
			do{
				codigos_Ordenador[i]= ordenador.getCodigo();
				for (int j = 0; j < i; j++) {
					if(codigos_Ordenador[j]==codigos_Ordenador[i]){
						verificar = true;
					}
				}
				for (int j = 0; j < codigos_Ordenador_Exitentes.length; j++) {
					if(codigos_Ordenador_Exitentes[j]==codigos_Ordenador[i]){
						verificar = true;
					}
				}
				if(verificar==true){
					System.out.println("Ese codigo ya existe");
				}
			} while(verificar==true);

			System.out.println(ordenador.getCodigo());

			mibase.abrir(); //Abrimos BBDD
			BBDDOrdenador.alta(ordenador, mibase.getConexion()); //creamos un ordenador
			mibase.cerrar(); //Cerramos BBDD
		}
		 */

		do{
			//ESTE BUCLE SERA UTILIZADO COMO VALIDACION DEL CODIGO DEL ORDENADOR

			System.out.println("Escribe el codigo del ordenador que deseas conectarte");
			codigOr = sc.next();

			ordenador = new Ordenador(codigOr);

			mibase.abrir();//Abrir base de datos
			ordenador_Cod=BBDDOrdenador.buscarOrdenador(ordenador, mibase.getConexion());
			mibase.cerrar();//Cerrar base de datos



			if (ordenador_Cod!=""){
				existe=true;}

		}while(existe==false);



		do{
			//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL PRINCIPIO DEL PROGRAMA
			do{

				opcMenu=0;
				opcionEmple=0;
				opcionInicial=0;
				opcion=0;
				opcionE=0;
				opcionUsuario=0;
				opcionSocio=0;
				registroS=false;
				registroU=false;
				accionRealizada=false;
				System.out.println("---------------------------");
				System.out.println("Bienvenidos a Gama y Cafe");
				System.out.println("---------------------------");
				System.out.println();
				System.out.println("Acceder zona Cliente=>1");
				System.out.println("Acceder zona Empleado=>2");
				System.out.println("Forzar apagado=>3");

				opcionInicial=0;
				opcionInicial=sc.nextInt();


				switch (opcionInicial) {
				case 1:
					do{
						//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA SELECCION DEL TIPO DE CLIENTE
						opcionEmple=0;
						opcionInicial=0;
						opcion=0;
						opcionE=0;
						opcionUsuario=0;
						opcionSocio=0;
						registroS=false;
						registroU=false;
						accionRealizada=false;
						System.out.println("\n1.Conectarse como socio\n2.Conectarse como Usuario \n3.Volver");
						opcion=0;
						opcion=sc.nextInt();
						switch (opcion) {
						case 1: 
							do{

								//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DE SOCIOS
								opcMenu=0;
								registroS=false;
								System.out.println("Zona Socio\n");
								System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Volver");
								opcionSocio=0;
								opcionSocio=sc.nextInt();

								switch (opcionSocio) {
								case 1:

									sc.nextLine();
									do{

										System.out.println("Introduce DNI");
										nif=sc.nextLine();
										System.out.println("Introduce Contrase�a");
										passwd=sc.nextLine();


										u = new Usuario(nif,passwd);

										mibase.abrir();
										//Abrimos BBDD
										codigo=BBDDUsuario.buscarUsuario(u, mibase.getConexion());
										//Buscamos Socio
										mibase.cerrar();
										//Cerramos BBDD
										error=false;

										if (codigo==null||codigo==""){
											System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n\n");
											error=true;
										}

										if (codigo.equals("U")){
											System.out.println("No es Socio\n");
											error=true;
										}
										
									}while(error==true);
									if (codigo!="U"||codigo!=""){
										do{
											//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA ZONA DE PEDIDOS
											opcMenu=0;
											elegirPedido=0;


											mibase.abrir();
											BBDDConexion.iniciar(conexion, u, ordenador, mibase.getConexion());
											mibase.cerrar();

											Horainicio = LocalTime.now();

											f = new Factura("3ABC", conexion, hoy.toString());

											System.out.println("Bienvenido a zona socio");
											System.out.println("////�Qu� desea hacer?\\\\");
											System.out.println("1........ Realizar pedido");
											System.out.println("2.......... Cerrar Sesi�n");
											opcMenu=sc.nextInt();
											switch (opcMenu) {

											case 1:
												elegirPedido=0;

												System.out.println("Elige tu art�culo:");
												System.out.println("1->Agua ");
												System.out.println("2->Cafe ");
												System.out.println("3->Coca-Cola ");
												System.out.println("4->Cerveza");
												System.out.println("5->Palmera de chocolate ");
												System.out.println("6->Croissant ");
												System.out.println("7->Patatuelas ");
												System.out.println("8->Volver ");
												elegirPedido=sc.nextInt();
												sc.nextLine();
												switch(elegirPedido){
												case 1:
													producto =new Productos("AGUA");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido " + precioProducto+ " EUROS, a su factura");

													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 2:
													producto =new Productos("CAFE");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 3:
													producto =new Productos("COCACOLA");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;
												case 4:
													producto =new Productos("CERVEZA");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 5:
													producto =new Productos("PALMERA");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 6:
													producto =new Productos("CROISANT ");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 7:
													producto =new Productos("PATATAS");
													mibase.abrir();
													precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
													mibase.cerrar();
													System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");

													System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
													masPedido=sc.nextInt();
													if(masPedido==1){
														elegirPedido=8;}
													break;

												case 8:
													elegirPedido=8;
													break;
												}


												break;

											}

											f.Importe=f.Importe+precioProducto;

										}while(elegirPedido==8);


										mibase.abrir();
										BBDDConexion.finalizar(conexion, ordenador, mibase.getConexion());
										mibase.cerrar();

										//f.realizar_importe();

										mibase.abrir();
										BBDDFactura.crear(f, mibase.getConexion());
										mibase.cerrar();

										Horafinal = LocalTime.now();
										System.out.println("Debe pagar "+f.Importe+"�");


									}
									break;

								case 2:

									System.out.println("Registro Socio");
									sc.nextLine();
									System.out.println("Introduce Nombre");
									String nombre=sc.nextLine();
									System.out.println("Introduce Contrase�a");
									passwd=sc.nextLine();
									System.out.println("Introduce DNI");
									nif=sc.nextLine();



									u = new Usuario(nombre.toUpperCase(), passwd,nif.toUpperCase(),"");
									u.generar_codigo();//Generamos codigo de socio

									mibase.abrir();
									//Abrimos BBDD
									BBDDUsuario.crear(u, mibase.getConexion());
									//Creamos Socio
									System.out.println(nombre+" ,has sido registrado exitosamente");
									registroS=true;
									mibase.cerrar();
									//Cerramos BBDD

									break;
								}

							}while(registroS==true||opcMenu==2);

							break;
						case 2:  
							do{
								//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DE USUARIO
								elegirPedido=0;
								opcionUsuario=0;
								registroU=false;
								opcMenu=0;
								elegirPedido=0;
								System.out.println("Zona Usuario\n");
								System.out.println("\n1.Iniciar Sesion\n2.Registro \n3.Volver");
								opcionUsuario=sc.nextInt();
								switch (opcionUsuario) {
								case 1:
									System.out.println("Inicio Sesion");
									sc.nextLine();
									System.out.println("Introduce DNI");
									nif=sc.nextLine();
									System.out.println("Introduce Contrase�a");
									passwd=sc.nextLine();
									u = new Usuario(nif,passwd);
									mibase.abrir();
									codigo=BBDDUsuario.buscarUsuario(u, mibase.getConexion());
									mibase.cerrar();

									if (codigo==""){
										System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n");
										opcionUsuario=3;
									}else
										if (codigo.equals("U")){

											System.out.println("Bienvenido a zona usuario");


											do{
												//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA ZONA DE PEDIDOS

												opcMenu=0;
												elegirPedido=0;

												mibase.abrir();
												BBDDConexion.iniciar(conexion, u, ordenador, mibase.getConexion());
												mibase.cerrar();

												Horainicio = LocalTime.now();

												f = new Factura("3ABC", conexion, hoy.toString());

												System.out.println("////�Qu� desea hacer?\\\\");
												System.out.println("1........ Realizar pedido");
												System.out.println("2.......... Cerrar Sesi�n");
												opcMenu=sc.nextInt();
												switch (opcMenu) {

												case 1:
													elegirPedido=0;

													System.out.println("Elige tu art�culo:");
													System.out.println("1->Agua ");
													System.out.println("2->Cafe ");
													System.out.println("3->Coca-Cola ");
													System.out.println("4->Cerveza");
													System.out.println("5->Palmera de chocolate ");
													System.out.println("6->Croissant ");
													System.out.println("7->Patatuelas ");
													System.out.println("8->Volver ");
													elegirPedido=sc.nextInt();
													sc.nextLine();
													switch(elegirPedido){
													case 1:
														producto =new Productos("AGUA");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido " + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}


														break;

													case 2:
														producto =new Productos("CAFE");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;

													case 3:
														producto =new Productos("COCACOLA");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;
													case 4:
														producto =new Productos("CERVEZA");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;

													case 5:
														producto =new Productos("PALMERA");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;

													case 6:
														producto =new Productos("CROISANT");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido " + precioProducto+ " EUROS, a su factura");
														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;

													case 7:
														producto =new Productos("PATATAS");
														mibase.abrir();
														precioProducto=BBDDProductos.realizarPedido(producto, mibase.getConexion());
														mibase.cerrar();
														System.out.println("Se le han a�adido" + precioProducto+ " EUROS, a su factura");

														System.out.println("VA A QUERRER ALGO MAS? (S->1/N->0)");
														masPedido=sc.nextInt();
														if(masPedido==1){
															elegirPedido=8;}
														break;

													case 8:
														elegirPedido=8;
														break;
													}

													break;


												}
												f.Importe=f.Importe+precioProducto;


											}while(elegirPedido==8);

											mibase.abrir();
											BBDDConexion.finalizar(conexion, ordenador, mibase.getConexion());
											mibase.cerrar();

											Horafinal = LocalTime.now();
											//Realizar descuento


											System.out.println("Debe pagar "+f.Importe+"�");
											f =new Factura("3ABC", conexion,hoy.toString());

											//mibase.abrir();
											//BBDDFactura.crear(f, mibase.getConexion());
											//mibase.cerrar();

										}else{

											System.out.println("Usted es socio, Va a ser reedirijido al menu principal");
											opcionUsuario=3;
										}
									break;
								case 2:

									System.out.println("Registro Usuario");
									sc.nextLine();
									System.out.println("Introduce Nombre de usuario");
									String nombre=sc.nextLine();
									System.out.println("Introduce Contrase�a");
									passwd=sc.nextLine();
									System.out.println("Introduce DNI");
									nif=sc.nextLine();

									u = new Usuario(nombre.toUpperCase(), passwd,nif.toUpperCase(),"U");
									//Abrimos BBDD
									mibase.abrir();
									BBDDUsuario.crear(u, mibase.getConexion());
									//Creamos usuario
									System.out.println(nombre+" ,has sido registrado exitosamente como usuario");
									mibase.cerrar();
									//cerramos BBDD
									registroU=true;


									break;
								}

							}while(registroU==true||opcMenu==2);

							mibase.abrir();
							BBDDConexion.finalizar(conexion, ordenador, mibase.getConexion());
							mibase.cerrar();
						}

					}while(opcionSocio==3||opcionUsuario==3);

					break;
				case 2:
					do{
						//ESTE BUCLE SERA UTILIZADO COMO VUELTA A LA SELECCION DEL TIPO DE EMPLEADO

						opcionEmple=0;
						opcionInicial=0;
						opcion=0;
						opcionE=0;
						opcionUsuario=0;
						opcionSocio=0;
						registroS=false;
						registroU=false;
						accionRealizada=false;
						System.out.println("\n1.Conectarse a zona Cafeteria \n2.Conectarse a zona Cibercafe \n3.Conectarse a zona ENCARGADO \n4.Salir");
						opcionE=0;
						opcionE=sc.nextInt();
						switch (opcionE) {
						case 1: 
							do{

								opcionEmple=0;
								opcionCafe=0;
								System.out.println("Zona cafeteria\n");
								System.out.println("\n1.Iniciar Sesion \n2.Salir");
								opcionEmple=sc.nextInt();
								switch (opcionEmple) {
								case 1:



									System.out.println("Iniciando Sesion");
									sc.nextLine();
									System.out.println("Introduce Codigo empleado");
									String codS=sc.nextLine();



									e = new Empleados(codS);

									//abrimos BBDD
									mibase.abrir();
									codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
									//Buscamos empleado en la BBDD
									mibase.cerrar();
									//Cerramos BBDD
									if (codigoE==null)
										System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n");
									else
										if (codigoE.equals("CAFETERIA")||codigoE.equals("ENCARGADO")){

											do{
												opcionCafe=0;
												System.out.println("QUE DESEA CONSULTAR?");
												System.out.println("1-->Gestionar pedidos ");
												System.out.println("2-->Cerrar sesion ");
												opcionCafe=sc.nextInt();
												switch (opcionCafe) {
												case 1:
													System.out.println("Proximamente disponible");
													break;


												}
											}while(opcionCafe==1);

										}else
											System.out.println("Usted no pertenece a la zona CAFETERIA");

									break;

								case 2:
									System.out.println("Estas saliendo");
									break;

								}

							}while(opcionCafe==2);

							break;

						case 2:  
							do{
								opcionEmple=0;
								opcionCiber=0;
								System.out.println("Zona cibercafe\n");
								System.out.println("\n1.Iniciar Sesion \n2.Salir");
								opcionEmple=sc.nextInt();
								switch (opcionEmple) {
								case 1:
									System.out.println("Iniciando Sesion");
									sc.nextLine();
									System.out.println("Introduce Codigo empleado");
									String codS=sc.nextLine();



									e = new Empleados(codS);
									//abrimos base de datos
									mibase.abrir();
									codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
									//Buscamos empleado en la BBDD
									mibase.cerrar();
									//cerramos base de datos

									if (codigoE==null)
										System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n");
									else

										if (codigoE.equals("CIBER")||codigoE.equals("ENCARGADO")){

											do{
												opcionEmple=0;
												opcionCiber=0;
												System.out.println("\nQUE DESEA CONSULTAR?");
												System.out.println("1-->Ver ordenadores ");
												System.out.println("2-->Cobrar usuario ");
												System.out.println("3-->Cerrar sesion ");
												opcionCiber=sc.nextInt();
												switch (opcionCiber) {
												case 1:
													mibase.abrir();
													for (int i = 0; i < BBDDOrdenador.vector(mibase.getConexion()).size(); i++) {
														System.out.println(BBDDOrdenador.vector(mibase.getConexion()).get(i).toString());
													}
													mibase.cerrar();
													break;
												case 2:
													System.out.println("Proximamente disponible");
													break;


												default:
													break;
												}
											}while(opcionCiber!=3);


										}
										else
											System.out.println("Usted no pertenece a la zona CIBER");

									break;


								case 2:
									System.out.println("Estas saliendo");
									break;
								}
							}while(opcionCiber==3);
							break;
						case 3: 
							opcionEmple=0;
							System.out.println("Zona Encargado\n");
							System.out.println("\n1.Iniciar Sesion \n2.Salir");
							opcionEmple=sc.nextInt();
							switch (opcionEmple) {
							case 1:
								System.out.println("Iniciando Sesion");
								sc.nextLine();
								System.out.println("Introduce el CODIGO DEL ENCARGADO");
								String codS=sc.nextLine();



								e = new Empleados(codS);
								//abrimos base de datos
								mibase.abrir();
								codigoE=BBDDEmpleados.buscarEmple(e, mibase.getConexion());
								//Buscamos empleado en la BBDD
								mibase.cerrar();
								//cerramos base de datos
								if (codigoE==null){
									System.out.println("Por motivos t�cnicos no podemos obtener la informaci�n");
								}else
									if (codigoE.equals("ENCARGADO")){
										do{
											//ESTE BUCLE SERA UTILIZADO COMO VUELTA AL MENU DEL ENCARGADO

											accionRealizada=false;
											System.out.println("Bienvenido Se�or Encargado");
											System.out.println("\n1.Dar de alta empleado \n2.Dar de baja empleado\n3.Dar de baja cliente\n4.Dar de baja ordenador \n5.Dar de alta ordenador \n6. Salir");
											opcionEmple=sc.nextInt();
											switch (opcionEmple) {
											case 1:

												sc.nextLine();
												System.out.println("Introduce Nombre");
												String nombreE=sc.nextLine();
												System.out.println("Introduce Apellido");
												String apellidoE=sc.nextLine();
												System.out.println("Introduce DNI");
												nif=sc.nextLine();
												System.out.println("Introduce direccion");
												String direccion=sc.nextLine();
												System.out.println("Introduce telefono");
												String telefono=sc.nextLine();
												System.out.println("Introduce tipo de contrato");
												String Contrato=sc.nextLine();
												System.out.println("Introduce antiguedad");
												int antiguedad=sc.nextInt();
												System.out.println("Introduce sueldo");
												int sueldo=sc.nextInt();
												sc.nextLine();
												System.out.println("Introduce cargo");
												String cargo=sc.nextLine();
												System.out.println("Introduce NSS");
												String NumSS=sc.nextLine();


												e = new Empleados ("",nif,nombreE, apellidoE,direccion,telefono,Contrato, antiguedad,sueldo,cargo,NumSS);
												e.generar_codigo(); //metodo utilizado para generar un codigo aleatorio
												//abrimos base de datos
												mibase.abrir();
												BBDDEmpleados.crear(e, mibase.getConexion());
												//creamos empleado en la BBDD
												System.out.println(nombreE+" ,ha sido usted contratado");
												mibase.cerrar();
												//cerramos base de datos
												accionRealizada=true;

												break;
											case 2:
												sc.nextLine();
												System.out.println("Introduzca codigo del empleado que quiera dar de baja");
												String despido=sc.nextLine();


												e = new Empleados (despido);
												//abrimos base de datos
												mibase.abrir();
												BBDDEmpleados.borrar(e, mibase.getConexion());
												//borramos empleado de BBDD
												System.out.println("El empleado cuyo codigo es " +despido+ " a sido dado de baja");
												mibase.cerrar();
												//cerramos base de datos
												accionRealizada=true;
												break;


											case 3:
												sc.nextLine();
												System.out.println("Introduzca el DNI del cliente que quiera dar de baja");
												DNI=sc.nextLine();
												u = new Usuario(DNI);
												//abrimos base de datos
												mibase.abrir();
												BBDDUsuario.borrar(u, mibase.getConexion());
												//borramos cliente de BBDD
												mibase.cerrar();
												System.out.println("El cliente cuyo DNI es "+DNI+" a sido dado de baja");
												accionRealizada=true;
												break;
											case 4:
												sc.nextLine();
												System.out.println("Introduzca el codigo del ordenador que quiera dar de baja");
												cod_ordena=sc.nextLine();
												o = new Ordenador(cod_ordena);
												//abrimos base de datos
												mibase.abrir();
												BBDDOrdenador.baja(o, mibase.getConexion());
												//borramos cliente de BBDD
												mibase.cerrar();
												System.out.println("El ordenador a sido dado de baja");
												accionRealizada=true;
												break;
											case 5:
												sc.nextLine();
												System.out.println("Introduzca el codigo del ordenador que quiera dar de alta");
												cod_ordena=sc.nextLine();
												o = new Ordenador(cod_ordena);
												//abrimos base de datos
												mibase.abrir();
												BBDDOrdenador.alta(o, mibase.getConexion());
												//borramos cliente de BBDD
												mibase.cerrar();
												System.out.println("El ordenador a sido dado de alta");
												accionRealizada=true;
												break;

											}

										}while(accionRealizada==true);

									}

									else

										System.out.println("\n3...\n2...\n1...\n(SISTEMA APAGANDOSE)...Usted no es el encargado,estamos avisando a la policia en este momento, todo lo que diga puede ser utilizado en su contra...");

								break;
							}
							break;


						default:
							break;
						}
					}while(opcionEmple==2);
				}

			}while(opcion==3||opcionE==4);
		}while(opcionEmple==6);
	}
}