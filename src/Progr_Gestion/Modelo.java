package Progr_Gestion;

import java.awt.Choice;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.UnitValue;


public class Modelo 
{
	//CONEXIÓN CON LA BASE DE DATOS
	
	//Drivers 
		String driver = "com.mysql.cj.jdbc.Driver";
		// Indicamos la dirección donde se encuentra la base de datos. 
		String url = "jdbc:mysql://localhost:3306/gestionprograma"; 
		// Introducimos el usuario por medio del cual se hará la conexión 
		String login = "root";
		// Indicamos la contraseña que tiene dicha base de datos. 
		String password = "Holacaracola"; 
		String sentencia = "";
		Connection connection = null; 
		Statement statement = null; 
		ResultSet rs = null;

	// Conexion con la base de datos
		public Connection conectar()
			{
				// Cargar los controladores para el acceso a la base de datos.
				try
					{
						Class.forName(driver); 
						System.out.println("La conexion es correcta");
					}
				catch (ClassNotFoundException cnfe)
					{
						System.out.println("Se ha producido un error al cargar el Driver");
					}
				// Establecen la conexión con la base de datos, gestionPrograma
				try
					{
						connection = DriverManager.getConnection(url, login, password);
					}
				
				catch (SQLException sqle)
					{
						System.out.println("Se ha producido un error al conectar con la base de datos: " + sqle.getMessage());
					}
				
				return connection;
			}

	//INICIAR SESIÓN
		
		public String iniciar(Connection connection, String datoNombre, String datoClave)
			{
				String resultado = ""; 
				Statement statement = null; 
				ResultSet rs = null; 
				sentencia = "SELECT * FROM Usuarios WHERE nombreUsuario='" + datoNombre + "' AND contraseniaUsuario = '" + datoClave + "';";
			
				
				/* Se pretende realizar una busqueda del usuario en la base de datos. Para ello se compara las. 
				 * credenciales introducidas para el usuario con la existentes en la base de datosSi ate some extrae 
				 * dicho usuario en administrador o básico
				 */
						try
							{
								statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								rs = statement.executeQuery (sentencia);
								String admin = "Admin"; 
								String basic = "Basic";
								
								if(rs.next())
									{
										String tipo = rs.getString("tipoUsuario");
										
										if(tipo.equals(admin))
											{
												resultado = admin;
											}
										else if (tipo.equals(basic))
											{
												resultado = basic;
											}
									}
								else
									{
										System.out.println("error");
									}
							}
						catch (SQLException sqle)
							{
								System.out.println(sqle.getMessage());
							}
						
						return resultado;
			}
		
	//CERRAR CONEXIÓN BASE DE DATOS
		public void desconected(Connection connection)
			{
				try
					{
						if(connection!=null)
						{
							connection.close();
							System.out.println("Se cerro la conexion");
						}
					}
				catch (SQLException error)
					{
						System.out.println(error.getMessage());
					}
			}
//AYUDA-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		public void ayuda (Connection connection)
			{
				try
					{
						Runtime.getRuntime().exec("hh.exe ayuda.chm");
					}
				catch (IOException e)
					{
						e.printStackTrace();
					}
			}
		
//FICHERO LOG ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		public void ficheroLog (String usuario, String sentenciaLog)
			{
				Date hora = new Date();
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				
				try
					{
						// Destino de los datos
						FileWriter fw = new FileWriter("movimientos.log", true);
						// Buffer de escritura
						BufferedWriter bw = new BufferedWriter(fw);
						// Objeto para la escritura
						PrintWriter salida = new PrintWriter(bw);
						//Guardamos la primera línea
						salida.print("[" + formato.format(hora) + "][" + usuario + "][" + sentenciaLog + "] \n");
						
						//Cerrar el objeto salida, el objeto bw y el fw
						salida.close();
						bw.close();
						fw.close();
					}
				catch(IOException i)
					{
						System.out.println("Se produjo un error de Archivo");
					}
			}
		
//EMPLEADO--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		//ALTA EMPLEADO (genérico)
			public String crear(Connection connection, String crearTelefonoEmpleado, String crearDniEmpleado, String crearNombreEmpleado, String crearDireccionEmpleado, String crearApellidosEmpleado)
				{
					String altaEmpleadoOk = ""; 
					String OK = "correcto";
					Statement statement = null; 
					sentencia = "INSERT INTO Empleados (telefonoEmpleado, dniEmpleado, nombreEmpleado, direccionEmpleado, apellidosEmpleado) VALUES ('"+crearTelefonoEmpleado+"', '"+crearDniEmpleado+"', '"+crearNombreEmpleado+"', '"+crearDireccionEmpleado+"', '"+crearApellidosEmpleado+"');";
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
							altaEmpleadoOk = OK;
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return altaEmpleadoOk;
				}
			//OBTENER idEmpleadoFK para enlazar con las tablas conductores y administrativos
			public String enlazar(Connection connection)
				{
				//con esta sentencia pretendemos coger solo el idEmpleado del último empleaao creado, que es el mismo que estamos introduciendo en la tabla de conductores o administrativos.
				sentencia = "SELECT idEmpleado from Empleados order by idEmpleado desc limit 1;";
				String listadoId = "";
				ResultSet rs = null;
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							rs = statement.executeQuery(sentencia); 
							
							while(rs.next())
								{
									listadoId = listadoId + rs.getInt("idEmpleado");
								}
						}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
					return listadoId;
				}
			//ALTA DEL EMPLEADO EN LA TABLA DE ADMINISTRATIVO
			public void crearAdministrativo(Connection connection, String titulo, String idioma, String idNumero)
			{
				Statement statement = null; 
				sentencia = "INSERT INTO Administrativos (tituloAdministrativo, idiomaAdministrativo, idEmpleadoFK) VALUES ('"+titulo+"', '"+idioma+"', '"+idNumero+"');";
				
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						statement.executeUpdate(sentencia);
						System.out.println("se ha realizado el alta de administrativo");
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
						
					}
			}
			//ALTA DEL EMPLEADO EN LA TABLA DE CONDUCCIÓN
			public void crearConductor(Connection connection, String carnet, String idNumero)
			{
				Statement statement = null; 
				sentencia = "INSERT INTO Conductores (carnetConducirConductor, idEmpleadoFK) VALUES ('"+carnet+"', '"+idNumero+"');";
				
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						statement.executeUpdate(sentencia);
						System.out.println("se ha realizado el alta de conductor");
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
						
					}
			}
	
		//BAJA EMPLEADO
			public String eliminarEmpleado (Connection connection, String seleccionado)
				{
					String borrarEmpleado = ""; 
					String OK = "correcto"; 
					sentencia = "DELETE FROM Empleados WHERE idEmpleado='"+seleccionado+"'";
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
							borrarEmpleado = OK;
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return borrarEmpleado;
				}

		//RELLENAR DESPLEGABLE PARA BAJA EMPLEADOS
			public Choice borrar(Connection connection, Choice choEmpleado)
				{
					Statement statement = null; 
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Empleados");
							
							choEmpleado.removeAll();
							
							while(rs.next())
								{
									choEmpleado.add(rs.getString("idEmpleado")+"-"+rs.getString("nombreEmpleado")+"-"+rs.getString("apellidosEmpleado")+"-"+rs.getString("dniEmpleado"));
								}
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return choEmpleado;
				}
	
		//SELECCIONAR UN EMPLEADO PARA MODIFICARLO
			public Choice elegirEmpleadoModificar(Connection connection, Choice choModificarEmpleado)
				{
					Statement statement = null; 
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Empleados;");
							
							choModificarEmpleado.removeAll(); 
							
							while(rs.next())
								{
									choModificarEmpleado.add(rs.getString("idEmpleado")+" / "+rs.getString("nombreEmpleado")+" / "+rs.getString("apellidosEmpleado")+" / "+rs.getString("dniEmpleado")+" / ");
								}
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return choModificarEmpleado;
				}
			//RELLENAR TEXTFIELD CON DATOS EMPLEADO PARA MODIFICAR
			public String rellenarTextModificarGeneral(Connection connection, String idSeleccionado)
			{
				Statement statement = null; 
				String rellenarTxt = "";
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT telefonoEmpleado, dniEmpleado, nombreEmpleado, direccionEmpleado, apellidosEmpleado FROM Empleados WHERE idEmpleado='"+idSeleccionado+"'");
						
						 
						
						while(rs.next())
							{
								rellenarTxt = rellenarTxt +	rs.getString("nombreEmpleado")+" / "+rs.getString("apellidosEmpleado")+" / "+rs.getString("dniEmpleado")+" / "+rs.getString("telefonoEmpleado")+" / "+rs.getString("direccionEmpleado")+" / ";
							}
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return rellenarTxt;
			}
			//RELLENAR TXTFIELD ESPECIFICO ADMINISTRATIVO
			public String rellenarTextModificarAdministrativo(Connection connection, String idSeleccionadoFK)
			{
				Statement statement = null; 
				String rellenarTxtAdministrativo = "";
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT idiomaAdministrativo, tituloAdministrativo FROM Administrativos WHERE idEmpleadoFK='"+idSeleccionadoFK+"'");

						while(rs.next())
							{
								rellenarTxtAdministrativo = rellenarTxtAdministrativo +	rs.getString("idiomaAdministrativo")+" / "+rs.getString("tituloAdministrativo")+" / ";
							}
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return rellenarTxtAdministrativo;
			}
			
			//RELLENAR TXTFIELD ESPECIFICO CONDUCTOR
			public String rellenarTextModificarConductor(Connection connection, String idSeleccionadoFK)
			{
				Statement statement = null; 
				String rellenarTxtConductor = "";
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT carnetConducirConductor FROM Conductores WHERE idEmpleadoFK='"+idSeleccionadoFK+"'");
							while(rs.next())
								{
									rellenarTxtConductor = rellenarTxtConductor + rs.getString("carnetConducirConductor")+" / ";
								}
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return rellenarTxtConductor;
			}
			
		//MODIFICAR EMPLEADO
			public String empleadoSeleccionadoEspecifico(Connection connection, String numeroEmpleado, String seleccionadoTelefono, String seleccionadoDni, String seleccionadoNombre, String seleccionadoDireccion, String seleccionadoApellido)
				{
					String empleadoModificado = ""; 
					String OK = "correcto";
					sentencia = "UPDATE Empleados SET telefonoEmpleado='"+seleccionadoTelefono+"', dniEmpleado='"+seleccionadoDni+"', nombreEmpleado='"+seleccionadoNombre+"', direccionEmpleado='"+seleccionadoDireccion+"', apellidosEmpleado='"+seleccionadoApellido+"' WHERE idEmpleado='"+numeroEmpleado+"'";
					
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate(sentencia);
							
							empleadoModificado = OK;
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return empleadoModificado;
				}
			
			//MODIFICAR EMPLEADO PARTE GENERALIZACIÓN CONDUCTORES
			public String empleadoSeleccionadoEspecificoConductor(Connection connection, String numeroEmpleado, String seleccionadoConductor)
				{
					String empleadoModificadoConductor = ""; 
					String OK = "correcto";
					sentencia = "UPDATE Conductores SET carnetConducirConductor='"+seleccionadoConductor+"' WHERE idEmpleadoFK='"+numeroEmpleado+"'";
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate(sentencia);
							
							empleadoModificadoConductor = OK;
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return empleadoModificadoConductor;
				}
			
			//MODIFICAR EMPLEADO PARTE GENERALIZACIÓN ADMNISTRATIVOS
			public String empleadoSeleccionadoEspecificoAdministrativo(Connection connection, String numeroEmpleado, String seleccionadoTitulo, String seleccionadoIdioma)
				{
					String empleadoModificadoAdminis = ""; 
					String OK = "correcto";
					sentencia = "UPDATE Administrativos SET tituloAdministrativo='"+seleccionadoTitulo+"', idiomaAdministrativo='"+seleccionadoIdioma+"' WHERE idEmpleadoFK='"+numeroEmpleado+"'";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate(sentencia);
							
							empleadoModificadoAdminis = OK;
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return empleadoModificadoAdminis;
				}
			
		//CONSULTA EMPLEADO
			public String consultaEmpleado()
				{
					String listado = "";
					ResultSet rs = null;
					sentencia = "SELECT * FROM Empleados";
						
						try
							{
								statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
								rs = statement.executeQuery(sentencia); 
								
								while(rs.next())
									{
										listado = listado + rs.getInt("idEmpleado") + "/" + rs.getString("nombreEmpleado") + "/" + rs.getString("apellidosEmpleado") + "/" + rs.getString("direccionEmpleado") + "/" + rs.getString("telefonoEmpleado") + "/"+ "\n";
									}
								
							}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return(listado);
				}
			
			
			//CONSULTA EMPLEADO CONDUCTOR
				public String consultaEmpleadoConductores()
					{
						String listadoConductor = "";
						ResultSet rs = null;
						sentencia = "SELECT nombreEmpleado, apellidosEmpleado, dniEmpleado, direccionEmpleado, telefonoEmpleado, carnetConducirConductor FROM Conductores JOIN Empleados WHERE Conductores.idEmpleadoFk=Empleados.idEmpleado";
							
							try
								{
									statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
									rs = statement.executeQuery(sentencia); 
									
									while(rs.next())
										{
										listadoConductor = listadoConductor + rs.getString("nombreEmpleado") + "/" + rs.getString("apellidosEmpleado") + "/" + rs.getString("dniEmpleado") + "/" + rs.getString("direccionEmpleado") + "/"+ rs.getString("telefonoEmpleado") + "/" + rs.getString("carnetConducirConductor") + "/" + "\n";
										}
									
								}
						
						catch (SQLException sqle)
							{
								System.out.println(sqle.getMessage());
							}
						return(listadoConductor);
					}
				
				//CONSULTA EMPLEADO ADMINISTRATIVO
					public String consultaEmpleadoAdministrativos()
						{
							String listadoAdministrativo = "";
							ResultSet rs = null;
							sentencia = "SELECT nombreEmpleado, apellidosEmpleado, dniEmpleado, direccionEmpleado, telefonoEmpleado, tituloAdministrativo, idiomaAdministrativo FROM Administrativos JOIN Empleados WHERE Administrativos.idEmpleadoFk=Empleados.idEmpleado";
								
								try
									{
										statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
										rs = statement.executeQuery(sentencia); 
										
										while(rs.next())
											{
											listadoAdministrativo = listadoAdministrativo + rs.getString("nombreEmpleado") + "/" + rs.getString("apellidosEmpleado") + "/" + rs.getString("dniEmpleado") + "/" + rs.getString("direccionEmpleado") + "/"+ rs.getString("telefonoEmpleado") + "/" + rs.getString("tituloAdministrativo") + "/" +rs.getString("idiomaAdministrativo") + "/" + "\n";
											}
										
									}
							
							catch (SQLException sqle)
								{
									System.out.println(sqle.getMessage());
								}
							return(listadoAdministrativo);
						}
					
		//EXPORTAR CONSULTA A PDF	
			public String exportPdf(Connection connection, String dato, String datoConductores, String datoAdministrativo)
				{
					String consultaError = ""; 
					String error = "Error"; 
					String DEST = "Consulta.pdf";
					String[] separarDatos = dato.split("/");
					String[] separarDatosConductores = datoConductores.split("/");
					String[] separarDatosAdministrativos = datoAdministrativo.split("/");
					sentencia = "se ha exportado a pdf Empleados";
					
					try
						{
							//srear la impresora 
							PdfWriter writer = new PdfWriter(DEST); 
							
							// Crear el documento 
							PdfDocument pdf = new PdfDocument (writer); 
							
							//El contenido del documento y además determinamos el formato de folio(tamaño) y su orientación
							Document document = new Document (pdf, PageSize.A4.rotate());
							
							// Crear una fuente para la cabecera de las columnas de la tabla además, añadiendo tipo de letra en negrita 
							PdfFont fuente = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
							
							
							//Añadir alementos antes documento 
							document.add(new Paragraph("Consulta Empleados").setFont(fuente).setFontSize(20));
							
							float[] anchoColumna = {1, 2, 3, 3, 2}; 
							
							//Crear tabla y numero de columnas que tendrá
							Table tabla = new Table(UnitValue.createPercentArray(anchoColumna));
							
							//Nombre de las cabeceras, de la tabla 
							tabla.addCell(new Paragraph("ID").setFont(fuente)); 
							tabla.addCell(new Paragraph ("Nombre").setFont(fuente)); 
							tabla.addCell(new Paragraph("Apellidos").setFont(fuente)); 
							tabla.addCell(new Paragraph ("Dirección"). setFont(fuente)); 
							tabla.addCell(new Paragraph ("Teléfono").setFont(fuente));
							
							//Bucle para recorrer el array y obtener todos los datos e ir introduciendolos en las celdas 
							for(int i = 0; i < separarDatos.length; i++)
								{
									//Crear una celda por cada elemento encontrado en el array y añadirle el contenido encontrado 
									tabla.addCell(separarDatos[i]);
								}
									
							//Añadir la tabla al documento 
							document.add(tabla); 
							
							//Añadir al documento la tabla conductores con los datos de los empleados
							document.add(new Paragraph("Consulta Empleados Conductores").setFont(fuente).setFontSize(15));
							
							float[] anchoColumnaConductores = {1, 2, 2, 2, 2, 2}; 
							
							//Crear tabla y numero de columnas que tendrá 
							Table tablaConductores = new Table(UnitValue.createPercentArray(anchoColumnaConductores));
							
							//Nombre de las cabeceras, de la tabla 
							tablaConductores.addCell(new Paragraph ("Nombre").setFont(fuente)); 
							tablaConductores.addCell(new Paragraph("Apellidos").setFont(fuente)); 
							tablaConductores.addCell(new Paragraph("DNI").setFont(fuente)); 
							tablaConductores.addCell(new Paragraph ("Dirección"). setFont(fuente)); 
							tablaConductores.addCell(new Paragraph ("Teléfono").setFont(fuente));
							tablaConductores.addCell(new Paragraph("Carnet Conducir").setFont(fuente)); 
							
							//Bucle para recorrer el array y obtener todos los datos e ir introduciendolos en las celdas 
							for(int i = 0; i < separarDatosConductores.length; i++)
								{
									//Crear una celda por cada elemento encontrado en el array y añadirle el contenido encontrado 
								tablaConductores.addCell(separarDatosConductores[i]);
								}
							//Añadir la tabla de conductores al documento 
							document.add(tablaConductores); 
							
							//Añadir al documento la tabla administrativos con los datos de los empleados
							document.add(new Paragraph("Consulta Empleados Administrativos").setFont(fuente).setFontSize(15));
							
							float[] anchoColumnaAdministrativos = {1, 2, 2, 2, 2, 1, 1}; 
							
							//Crear tabla y numero de columnas que tendrá 
							Table tablaAdmininstrativos = new Table(UnitValue.createPercentArray(anchoColumnaAdministrativos));
							
							//Nombre de las cabeceras, de la tabla 
							tablaAdmininstrativos.addCell(new Paragraph ("Nombre").setFont(fuente)); 
							tablaAdmininstrativos.addCell(new Paragraph("Apellidos").setFont(fuente)); 
							tablaAdmininstrativos.addCell(new Paragraph ("DNI"). setFont(fuente));
							tablaAdmininstrativos.addCell(new Paragraph ("Dirección"). setFont(fuente)); 
							tablaAdmininstrativos.addCell(new Paragraph ("Teléfono").setFont(fuente));
							tablaAdmininstrativos.addCell(new Paragraph("Título").setFont(fuente)); 
							tablaAdmininstrativos.addCell(new Paragraph("Idioma").setFont(fuente));
							
							//Bucle para recorrer el array y obtener todos los datos e ir introduciendolos en las celdas 
							for(int i = 0; i < separarDatosAdministrativos.length; i++)
								{
									//Crear una celda por cada elemento encontrado en el array y añadirle el contenido encontrado 
								tablaAdmininstrativos.addCell(separarDatosAdministrativos[i]);
								}
							//Añadir la tabla de administrativos al documento 
							document.add(tablaAdmininstrativos); 
							
							//Cerrar el documento 
							document.close(); 
							
							// Abrir automáticamente el archivo pdf cuando se pulse el botón 
							Desktop.getDesktop() .open(new File(DEST));
						}
					catch (IOException e)
							{
								e.printStackTrace();
								
								// Si hay algun error, Tanzan el dialogo con el texto para que el usuario sepa que hay un error 
								consultaError = error;
							} 
						return(consultaError);
				}

//CAMIONES-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//ALTA CAMIÓN
		public String crearCamion (Connection connection, String crearCapacidadCamion, String crearMarcaCamion, String crearAnioCompraCamion, String crearMatriculaCamion, String crearModeloCamion)
			{
				String altaCamionOk = ""; 
				String OK = "correcto";
				Statement statement = null; 
				sentencia = "INSERT INTO Camiones (capacidadCamion, marcaCamion, anioCompraCamion, matriculaCamion, modeloCamion) VALUES ('"+crearCapacidadCamion+"', '"+crearMarcaCamion+"', '"+crearAnioCompraCamion+"', '"+crearMatriculaCamion+"', '"+crearModeloCamion+"');";
				
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
							
							altaCamionOk = OK;
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
				return altaCamionOk;
			}

	//RELLENAR DESPLEGABLE PARA BAJA
		public Choice borrarCamion (Connection connection, Choice choCamion)
			{
				Statement statement = null; 
				
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Camiones");

							choCamion.removeAll();
							
							while(rs.next())
								{
									choCamion.add(rs.getInt("idCamion")+"-"+rs.getInt("capacidadCamion")+"-"+rs.getString("marcaCamion")+"-"+rs.getString("matriculaCamion"));
								}
								
						}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return choCamion;
			}
		
	//BAJA CAMIÓN
		public String eliminarCamion (Connection connection, String seleccionadoCamion)
			{
				String borrarCamion = ""; 
				String OK = "correcto"; 
				sentencia = "DELETE FROM Camiones WHERE idCamion='"+seleccionadoCamion+"'";
					
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate(sentencia);
							
							borrarCamion = OK;
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());	
						}
				return borrarCamion;
			}
		
	//MODIFICAR CAMIÓN RELLENAR DESPLEGABLE
		public Choice elegirCamionModificar (Connection connection, Choice choModificarCamion)
			{
				Statement statement = null; 
				
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Camiones");
							
							choModificarCamion.removeAll();
							
							while(rs.next())
								{
									choModificarCamion.add(rs.getInt("idCamion")+" / "+rs.getInt("capacidadCamion")+" / "+rs.getString("marcaCamion")+" / "+rs.getString("matriculaCamion"));
								}
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
				return choModificarCamion;
			}
		
	//MODIFICAR CAMION
		public String camionSelecionarCapacidad(Connection connection, String seleccionadoCapacidad, String nuevaCapacidad)
			{
				String capacidadElegida = ""; 
				String OK = "correcto";
				sentencia = "UPDATE Camiones SET capacidadCamion='"+nuevaCapacidad+"' WHERE idCamion='"+seleccionadoCapacidad+"'";
				
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
							
							capacidadElegida = OK;
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return capacidadElegida;
			}
		
	//CONSULTA CAMION
		public String consultaCamion()
			{
				String listadoCamion = ""; 
				ResultSet rs = null;
				sentencia = "SELECT * FROM Camiones";
				
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
						rs = statement.executeQuery(sentencia);
						
							while(rs.next())
								{
									listadoCamion = listadoCamion + rs.getInt("idCamion") + "/" + rs.getInt("capacidadCamion") + "/" + rs.getString("marcaCamion") + "/" + rs.getInt("anioCompraCamion") + "/" + rs.getString("matriculaCamion") + "/" + rs.getString("modeloCamion") + "/" + "\n";
								}
							
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return(listadoCamion);
			}
	
	//EXPORTAR PDF
		public String exportarPdfCamion (Connection connection, String datoCamion)
			{
				String consultaErrorCamion = "";
				String errorCamion = "Error"; 
				String DESTII = "Consulta.pdf";
				String[] separarDatosCamion = datoCamion.split("/"); 
				sentencia = "se ha exportado a pdf camiones";
					
					try 
					{ 
						//crear la impresora
						PdfWriter writerCamion = new PdfWriter(DESTII);
						 
						// Crear el documento 
						PdfDocument pdfCamion = new PdfDocument (writerCamion);
						
						 //El contenido del documento 
						Document document = new Document (pdfCamion);
						
						// Crear una fuente para la cabecera de las columnas de la tabla, además añadienda trina de letra en negnita
						PdfFont fuenteCamion = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
						
						//Añadir elementos al documento 
						document.add(new Paragraph("Consulta Camiones").setFont(fuenteCamion).setFontSize(20));
						
						float[] anchoColumnaCamion = {1, 2, 3, 3, 2, 2};
						
						// Crear tabla y numero de columnas que tendra 
						Table tablaCamion = new Table(UnitValue.createPercentArray (anchoColumnaCamion));
						
						// Nombre de las cabeceras de la tabla 
						tablaCamion.addCell(new Paragraph ("ID").setFont(fuenteCamion)); 
						tablaCamion.addCell(new Paragraph("Capacidad").setFont(fuenteCamion)); 
						tablaCamion.addCell(new Paragraph("Marca").setFont(fuenteCamion)); 
						tablaCamion.addCell(new Paragraph("Año Compra").setFont(fuenteCamion)); 
						tablaCamion.addCell(new Paragraph ("Matrícula").setFont(fuenteCamion)); 
						tablaCamion.addCell(new Paragraph ("Modelo").setFont(fuenteCamion));
						
						//Bucle para recorrer el array y obtener todos los datos e in introduciendolos en las celdas, 
						for(int i = 0; i < separarDatosCamion.length; i++)
							{
								//Crear una calda para cada elemento encontrado en el array y añadintre el contenido encontrado 
								tablaCamion.addCell(separarDatosCamion[i]);
							}
						//Añadir la tabla al documento 
						document.add(tablaCamion); 
						
						// cercar el documento
						document.close(); 
						
						//Abrir automáticamente el archivo pdf cuando se pulse el botón 
						Desktop.getDesktop() .open(new File(DESTII));
					}					
				catch (IOException e)
					{
						e.printStackTrace(); 
						// Si hay alun error, lanzar el dialogo com el texto para que el usuario scena que hay un error 
						consultaErrorCamion = errorCamion;
					}
				
				return(consultaErrorCamion);
			}

//EXPLOSIVOS----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//ALTA EXPLOSIVOS 
		public String crearExplosivo(Connection connection, String crearTonelajeExplosivo, String crearTipoExplosivo, String crearPrecioExplosivo, String numeroCliente)
			{
				String altaExplosivoOk = "";
				String OK = "correcto";
				Statement statement = null; 
				sentencia = "INSERT INTO Explosivos (tonelajeExplosivo, tipoExplosivo, precioExplosivo, idClienteFK) VALUES ('"+crearTonelajeExplosivo+"', '"+crearTipoExplosivo+"', '"+crearPrecioExplosivo+"', '"+numeroCliente+"');";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
						
							altaExplosivoOk = OK;
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return altaExplosivoOk;
			}
		
	//SELECCIONAR CLIENTE PARA RELACIONARLO CON EL EXPLOSIVO
		public Choice seleccionarClienteExplosivo(Connection connection, Choice choClienteExplosivo)
		{
			Statement statement = null; 
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT idCliente, nombreCliente, telefonoCliente, correoElectronicoCliente FROM Clientes");
							
						choClienteExplosivo.removeAll();
						
						while(rs.next())
							{
								choClienteExplosivo.add(rs.getInt("idCliente")+"-"+rs.getString("nombreCliente")+"-"+rs.getString("telefonoCliente")+"-"+rs.getString("correoElectronicoCliente"));
							}
					}
			
			catch (SQLException sqle)
				{
					System.out.println(sqle.getMessage());
				}
			return choClienteExplosivo;	
		}

	//RELLENAR DESPLEGABLE PARA BAJA EXPLOSIVO
		public Choice borrarExplosivo(Connection connection, Choice choExplosivo)
			{
				Statement statement = null; 
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Explosivos");
								
							choExplosivo.removeAll();
							
							while(rs.next())
								{
									choExplosivo.add(rs.getInt("idExplosivo")+"-"+rs.getInt("tonelajeExplosivo")+"-"+rs.getString("tipoExplosivo"));
								}
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return choExplosivo;	
			}

	//BAJA EXPLOSIVO
		public String eliminarExplosivo(Connection connection, String seleccionadoExplosivo)
			{
				String bajaExplosivo = ""; 
				String OK = "correcto";
				sentencia = "DELETE FROM Explosivos WHERE idExplosivo='" + seleccionadoExplosivo + "'";
				
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
						statement.executeUpdate(sentencia);
						
						bajaExplosivo = OK;
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return bajaExplosivo;
			}
		
	//MODIFICAR EXPLOSIVOS RELLENAR DESPLEGABLE
		public Choice elegirExplosivoModificar (Connection connection, Choice choModificarExplosivo, String numeroCliente)
			{
				Statement statement = null; 
				
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Explosivos WHERE idClienteFK = '"+numeroCliente+"'");
							
							
							while(rs.next())
								{
									choModificarExplosivo.add(rs.getInt("idExplosivo")+" / "+rs.getInt("tonelajeExplosivo")+" / "+rs.getString("tipoExplosivo")+" / "+rs.getString("precioExplosivo"));
								}
						}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
					
				return choModificarExplosivo;
			}
		
	//MODIFICAR RELLENAR DESPLEGABLE DEL CLIENTE
		public Choice clienteRelacionado (Connection connection, Choice choClienteSeleccionado, String numeroCliente)
		{
			Statement statement = null; 
		
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT * FROM Clientes WHERE idCliente'"+numeroCliente+"'");
						
						choClienteSeleccionado.removeAll();
						
						while(rs.next())
							{
								choClienteSeleccionado.add(rs.getInt("idCliente")+"-"+rs.getString("nombreCliente")+"-"+rs.getString("telefonoCliente")+"-"+rs.getString("correoElectronicoCliente"));
							}
						
					}
			catch (SQLException sqle)
				{
					System.out.println(sqle.getMessage());
				}
			return choClienteSeleccionado;
		}
		
	//MODIFICAR  EXPLOSIVOS
		public String explosivoSeleccionarModificar (Connection connection, String seleccionadoId, String nuevoTonelaje, String nuevoTipo,String nuevoPrecio)
			{
				String precioElegido = ""; 
				String OK = "correcto";
				sentencia = "UPDATE Explosivos SET tonelajeExplosivo='"+nuevoTonelaje+"', tipoExplosivo='"+nuevoTipo+"', precioExplosivo='"+nuevoPrecio+"' WHERE idExplosivo='"+seleccionadoId+"'";
					
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							statement.executeUpdate(sentencia);
							
							precioElegido = OK;
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return precioElegido;
			}
		
	//CONSULTA EXPLOSIVOS
		public String consultaExplosivo()
			{
				String listadoExplosivo = ""; 
				ResultSet rs = null; 
				sentencia = "select idExplosivo, tonelajeExplosivo, tipoExplosivo, precioExplosivo, direccionCliente, nombreCliente, correoElectronicoCliente, telefonoCliente, codigoPostalCliente FROM Explosivos JOIN Clientes WHERE Clientes.idCliente = Explosivos.idClienteFK ORDER BY idClienteFK";
				
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							rs = statement.executeQuery(sentencia); 
							
							while(rs.next())
								{
									listadoExplosivo = listadoExplosivo + rs.getInt("idExplosivo") + "/" + rs.getInt("tonelajeExplosivo") + "/" + rs.getString("tipoExplosivo") + "/" + rs.getString("precioExplosivo") + "/" +rs.getString("nombreCliente") + "/" +rs.getString("direccionCliente") + "/" +rs.getString("correoElectronicoCliente") + "/" +rs.getString("telefonoCliente") + "/" +rs.getString("codigoPostalCliente") + "/" + "\n";
								}		
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return(listadoExplosivo);
			}
		
	//EXPORTAR PDF EXPLOSIVOS
		public String exportarPdfExplosivo(Connection connection, String datoExplosivo)
			{
				String consultaErrorExplosivo = ""; 
				String errorExplosivo = "Error"; 
				String DESTIII = "Consulta Explosivo.pdf";
				sentencia = "se ha exportado pdf explosivo";
				
				String[] separarDatosExplosivo = datoExplosivo.split("/"); 
				
					try 
					{ 
						//crear la impresora
						PdfWriter writerExplosivo = new PdfWriter(DESTIII); 
						
						//Crear el documento 
						PdfDocument pdfExplosivo = new PdfDocument (writerExplosivo); 
						
						//El contenido del documento 
						Document document = new Document (pdfExplosivo, PageSize.A4.rotate());
				
						//Crear una fuente para la cabecera de las columnas de la tabla, además añadiendo tipo de letra en negrita 
						PdfFont fuenteExplosivo = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
				
						//Añadir elementos al documento 
						document.add(new Paragraph("Consulta Explosivos").setFont(fuenteExplosivo).setFontSize(20));
				
						float[] anchoColumnaExplosivo = {1, 2, 2, 2, 2, 2, 2, 2, 2}; 
						
						// Crear tabla y numero de columnas que tendra 
						Table tablaExplosivo = new Table(UnitValue.createPercentArray(anchoColumnaExplosivo)); 
						
						//Nombre de las cabeceras de la tabla 
						tablaExplosivo.addCell(new Paragraph ("ID").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph("Tonelaje").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph("Tipo").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph ("Precio").setFont(fuenteExplosivo));
						tablaExplosivo.addCell(new Paragraph ("Nombre").setFont(fuenteExplosivo));
						tablaExplosivo.addCell(new Paragraph ("Dirección").setFont(fuenteExplosivo));
						tablaExplosivo.addCell(new Paragraph ("Correo Electrónico").setFont(fuenteExplosivo));
						tablaExplosivo.addCell(new Paragraph ("Teléfono").setFont(fuenteExplosivo));
						tablaExplosivo.addCell(new Paragraph ("Código Postal").setFont(fuenteExplosivo));
						//Bucle para recorrer el array yobtener todos los dates e in introduciendalos en las celidas
						for(int i = 0; i < separarDatosExplosivo.length; i++)
							{
								//crear una calda non cada elementa encontrado en el array y añadinita el contenido encontrado
								tablaExplosivo.addCell(separarDatosExplosivo[i]);
							}
						
						//Añadir la tabla al documento 
						document.add(tablaExplosivo); 
						
						//Cerrar el documento 
						document.close(); 
						
						//Abrir automáticamente el archivo dite cuando se pulse el botón 
						Desktop.getDesktop() .open(new File(DESTIII));
					}
				catch(IOException e)
					{
					
						e.printStackTrace(); 
						//Si hay alaún error, lanzar el dialogo con el texto para que el usuario sena que hay un error 
						
						consultaErrorExplosivo = errorExplosivo;
					}
				return(consultaErrorExplosivo);
			}
		
	//ALTA CLIENTE
			public String crearCliente (Connection connection, String crearDireccionCliente , String crearNombreCliente, String crearCorreoElectronicoCliente, String crearTelefonoCliente, String crearCodigoPostalCliente)
				{
					String altaClienteOk = ""; 
					String OK = "correcto";
					Statement statement = null; 
					sentencia = "INSERT INTO Clientes (direccionCliente, nombreCliente, correoElectronicoCliente, telefonoCliente, codigoPostalCliente) VALUES ('"+crearDireccionCliente+"', '"+crearNombreCliente+"', '"+crearCorreoElectronicoCliente+"', '"+crearTelefonoCliente+"', '"+crearCodigoPostalCliente+"');";
						
						try
							{
								statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								statement.executeUpdate(sentencia);
									
								altaClienteOk = OK;
							}
						catch (SQLException sqle)
							{
								System.out.println(sqle.getMessage());
							}
					return altaClienteOk;
				}
			
	//RELLENAR DESPLEGABLE PARA BAJA CLIENTE
			public Choice borrarCliente (Connection connection, Choice choCliente)
				{
					Statement statement = null; 
					
						try
							{
								statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								rs = statement.executeQuery("SELECT * FROM Clientes");

								choCliente.removeAll();
								
								while(rs.next())
									{
										choCliente.add(rs.getInt("idCliente")+"-"+rs.getString("direccionCliente")+"-"+rs.getString("nombreCliente")+"-"+rs.getInt("telefonoCliente"));
									}
									
							}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return choCliente;
				}
			
		//BAJA CLIENTE
			public String eliminarCliente (Connection connection, String seleccionadoCliente)
				{
					String borrarCliente = ""; 
					String OK = "correcto"; 
					sentencia = "DELETE FROM Clientes WHERE idCliente='"+seleccionadoCliente+"'";
						
						try
							{
								statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
								statement.executeUpdate(sentencia);
								
								borrarCliente = OK;
							}
						catch (SQLException sqle)
							{
								System.out.println(sqle.getMessage());	
							}
					return borrarCliente;
				}

		//SELECCIONAR UN CLIENTE PARA MODIFICARLO
			public Choice elegirClienteModificar(Connection connection, Choice choModificarCliente)
				{
					Statement statement = null; 
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							rs = statement.executeQuery("SELECT * FROM Clientes;");
							
							choModificarCliente.removeAll(); 
							
							while(rs.next())
								{
								choModificarCliente.add(rs.getString("idCliente")+" / "+rs.getString("nombreCliente")+" / "+rs.getString("telefonoCliente")+" / "+rs.getString("correoElectronicoCliente")+" / ");
								}
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return choModificarCliente;
				}
			//RELLENAR TEXTFIELD CON DATOS CLIENTE PARA MODIFICAR
			public String rellTextModiCliente(Connection connection, String idSeleccionadoCliente)
			{
				Statement statement = null; 
				String rellenarTxt = "";
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
						rs = statement.executeQuery("SELECT direccionCliente, nombreCliente, CorreoElectronicoCliente, telefonoCliente, codigoPostalCliente FROM Clientes WHERE idCliente='"+idSeleccionadoCliente+"'");
						
						while(rs.next())
							{
								rellenarTxt = rellenarTxt +	rs.getString("nombreCliente")+" / "+rs.getString("direccionCliente")+" / "+rs.getString("CorreoElectronicoCliente")+" / "+rs.getString("telefonoCliente")+" / "+rs.getString("codigoPostalCliente")+" / ";
							}
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return rellenarTxt;
			}
			
		//MODIFICAR CLIENTE
			public String modificarCliente(Connection connection, String numeroCliente, String direccionCliente, String nombreCliente, String correoElectronicoCliente, String telefonoCliente, String codigoPostalCliente)
				{
					String clienteModificado = ""; 
					String OK = "correcto";
					sentencia = "UPDATE Clientes SET direccionCliente='"+direccionCliente+"', nombreCliente='"+nombreCliente+"', correoElectronicoCliente='"+correoElectronicoCliente+"', telefonoCliente='"+telefonoCliente+"', codigoPostalCliente='"+codigoPostalCliente+"' WHERE idCliente='"+numeroCliente+"'";
					
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate(sentencia);
							
							clienteModificado = OK;
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return clienteModificado;
				}
		
		//CONSULTA EXPLOSIVOS
			public String consultaCliente()
				{
					String listadoCliente = ""; 
					ResultSet rs = null; 
					sentencia = "SELECT * FROM Clientes";
					
						try
							{
								statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
								rs = statement.executeQuery(sentencia); 
								
								while(rs.next())
									{
										listadoCliente = listadoCliente + rs.getInt("idCliente") + "/" + rs.getString("nombreCliente") + "/" + rs.getString("direccionCliente") + "/" + rs.getString("correoElectronicoCliente") + "/" + rs.getString("telefonoCliente") + "/" + rs.getString("codigoPostalCliente") + "/" + "\n";
									}		
							}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return(listadoCliente);
				}
		//EXPORTAR PDF CLIENTES
			public String exportarPdfCliente(Connection connection, String datoCliente)
				{
					String consultaErrorCliente = ""; 
					String errorCliente = "Error"; 
					String DESTIV = "Consulta Cliente.pdf";
					sentencia = "se ha exportado pdf cliente";
					
					String[] separarDatosCliente = datoCliente.split("/"); 
					
						try 
						{ 
							//crear la impresora
							PdfWriter writerCliente = new PdfWriter(DESTIV); 
							
							//Crear el documento 
							PdfDocument pdfCliente = new PdfDocument (writerCliente); 
							
							//El contenido del documento 
							Document document = new Document (pdfCliente);
					
							//Crear una fuente para la cabecera de las columnas de la tabla, además añadiendo tipo de letra en negrita 
							PdfFont fuenteCliente = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
					
							//Añadir elementos al documento 
							document.add(new Paragraph("Consulta Clientes").setFont(fuenteCliente).setFontSize(20));
					
							float[] anchoColumnaCliente = {1, 2, 2, 3, 2, 2}; 
							
							// Crear tabla y numero de columnas que tendra 
							Table tablaCliente = new Table(UnitValue.createPercentArray(anchoColumnaCliente)); 
							
							//Nombre de las cabeceras de la tabla 
							tablaCliente.addCell(new Paragraph ("ID").setFont(fuenteCliente)); 
							tablaCliente.addCell(new Paragraph("Nombre").setFont(fuenteCliente)); 
							tablaCliente.addCell(new Paragraph("Dirección").setFont(fuenteCliente)); 
							tablaCliente.addCell(new Paragraph ("Correo Electrónico").setFont(fuenteCliente));
							tablaCliente.addCell(new Paragraph ("Telefono").setFont(fuenteCliente));
							tablaCliente.addCell(new Paragraph ("Código Postal").setFont(fuenteCliente));
					
							//Bucle para recorrer el array yobtener todos los dates e in introduciendalos en las celidas
							for(int i = 0; i < separarDatosCliente.length; i++)
								{
									//crear una calda non cada elementa encontrado en el array y añadinita el contenido encontrado
									tablaCliente.addCell(separarDatosCliente[i]);
								}
							
							//Añadir la tabla al documento 
							document.add(tablaCliente); 
							
							//Cerrar el documento 
							document.close(); 
							
							//Abrir automáticamente el archivo dite cuando se pulse el botón 
							Desktop.getDesktop() .open(new File(DESTIV));
						}
					catch(IOException e)
						{
						
							e.printStackTrace(); 
							//Si hay alaún error, lanzar el dialogo con el texto para que el usuario sena que hay un error 
							
							consultaErrorCliente = errorCliente;
						}
					return(consultaErrorCliente);
				}
			
}
