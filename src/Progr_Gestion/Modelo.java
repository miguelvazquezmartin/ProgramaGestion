package Progr_Gestion;

import java.awt.Choice;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
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
						System.out.println("La conexión es correcta");
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
				String resultado = ""; Statement statement = null; 
				ResultSet rs = null; 
				sentencia = "SELECT * FROM Usuarios WHERE nombreUsuario='"+datoNombre+"' AND contraseniaUsuario = '"+datoClave+"';";
				
				/* Se pretende aveniaguar y realizar una busqueda del usuario en la base de datos. Para ello se compara las. 
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
									
									connection.close();
							}
						catch (SQLException sqle)
							{
								System.out.println(sqle.getMessage());
							}
						
						return resultado;
			}
		
//EMPLEADO--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
		//ALTA EMPLEADO
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
		
		//BAJA EMPLEADO
			public String eliminarEmpleado (Connection connection, String seleccionado)
				{
					String borrarEmpleado = ""; 
					String OK = "correcto"; 
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate("DELETE FROM Empleados WHERE idEmpleado='"+seleccionado+"'");
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
					Statement statement = null; sentencia = "SELECT * FROM Empleados";
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
							
							choEmpleado.removeAll();
							
							while(rs.next())
								{
									choEmpleado.add(rs.getInt("idEmpleado")+"-"+rs.getString("dniEmpleado")+"-"+rs.getString("nombreEmpleado")+"-"+rs.getString("apellidosEmpleado"));
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
					sentencia = "SELECT * FROM Empleados";
					
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
							
							choModificarEmpleado.removeAll(); 
							
							while(rs.next())
								{
									choModificarEmpleado.add(rs.getInt("idEmpleado")+" / "+rs.getString("dniEmpleado")+" / "+rs.getString("nombreEmpleado")+" / "+rs.getString("apellidosEmpleado"));
								}
						}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return choModificarEmpleado;
				}
			
		//MODIFICAR TELEFONO EMPLEADO
			public String empleadoSeleccionadoTelefono(Connection connection, String seleccionadoTelefono, String nuevoTelefono)
				{
					String telefonoElegido = ""; String OK = "correcto";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate("UPDATE Empleados SET telefonoEmpleado='"+nuevoTelefono+"' WHERE idEmpleado='"+seleccionadoTelefono+"'");
							
							telefonoElegido = OK;
						}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return telefonoElegido;
				}
					
		//MODIFICAR DIRECCIÓN EMPLEADO
			public String empleadoSeleccionadaDireccion (Connection connection, String seleccionadaDireccion, String nuevaDireccion)
				{
					String direccionElegida = ""; 
					String OK = "correcto";
					
						try
							{
								statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
								statement.executeUpdate("UPDATE Empleados SET direccionEmpleado= '"+nuevaDireccion+"' WHERE idEmpleado='"+seleccionadaDireccion+"'");
								
								direccionElegida = OK;
							}
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return direccionElegida;
				}
			
		//CONSULTA EMPLEADO
			public String consultaEmpleado()
				{
					String listado = "";
					ResultSet rs = null;
						
						try
							{
								statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
								rs = statement.executeQuery("SELECT * FROM Empleados"); 
								
								while(rs.next())
									{
										listado = listado + rs.getInt("idEmpleado") + "/" + rs.getString("nombreEmpleado") + "/" + rs.getString("apellidosEmpleado") + "/" + rs.getString("direccionEmpleado") + "/" + rs.getString("telefonoEmpleado") + "/" + "\n";
									}
								
							}
					
					catch (SQLException sqle)
						{
							System.out.println(sqle.getMessage());
						}
					return(listado);
				}
				
		//EXPORTAR CONSULTA A PDF	
			public String exportPdf(Connection connection, String dato)
				{
					String consultaError = ""; 
					String error = "Error"; 
					String DEST = "Consulta.pdf";
					String[] separarDatos = dato.split("/");
					
					try
						{
							//srear la impresora 
							PdfWriter writer = new PdfWriter(DEST); 
							
							// Crear el documento 
							PdfDocument pdf = new PdfDocument (writer); 
							
							//El contenido del documento 
							Document document = new Document (pdf);
							
							// Crear una fuente para la cabecera de las columnas de la tabla además, añadiendo tipo de letra en negrita 
							PdfFont fuente = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
							
							//Añadir alementos ante documento 
							document.add(new Paragraph());
							
							float[] anchoColumna = {1, 2, 3, 3, 2}; 
							
							//Crear tabla y numero de solumnas que tendra 
							Table tabla = new Table(UnitValue.createPercentArray(anchoColumna));
							
							//Nombre de las sabeceras, de la tabla 
							tabla.addCell(new Paragraph("ID").setFont(fuente)); 
							tabla.addCell(new Paragraph ("Nombre").setFont(fuente)); 
							tabla.addCell(new Paragraph("Apellidos").setFont(fuente)); 
							tabla.addCell(new Paragraph ("Dirección"). setFont(fuente)); 
							tabla.addCell(new Paragraph ("Teléfono").setFont(fuente));
							
							//Bucle para recorrer el array y obtener todos los datos e ir introduciendolos en las celdas 
							for(int i = 0; i < separarDatos.length; i++)
								{
									//srear una selda por cada elemento encontrado en el array y añadirle el contenido encontrado 
									tabla.addCell(separarDatos[i]);
								}
									
							//Añadir la tabla al documento 
							document.add(tabla); 
							
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
				sentencia = "SELECT * FROM Camiones";
				
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
							
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
					
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							statement.executeUpdate("DELETE FROM Camiones WHERE idCamion='"+seleccionadoCamion+"'");
							
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
				Statement statement = null; sentencia = "SELECT * FROM Camiones";
				
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
							
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
				String capacidadElegida = ""; String OK = "correcto";
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate("UPDATE Camiones SET capacidadCamion='"+nuevaCapacidad+"' WHERE idCamion='"+seleccionadoCapacidad+"'");
							
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
				String listadoCamion = ""; ResultSet rs = null;
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
						rs = statement.executeQuery("SELECT * FROM Camiones");
						
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
						document.add(new Paragraph());
						
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
		public String crearExplosivo(Connection connection, String crearTonelajeExplosivo, String crearTipoExplosivo, String crearPrecioExplosivo)
			{
				String altaExplosivoOk = "";
				String OK = "correcto";
				Statement statement = null; 
				sentencia = "INSERT INTO Explosivos (tonelajeExplosivo, tipoExplosivo, precioExplosivo) VALUES ('"+crearTonelajeExplosivo+"', '"+crearTipoExplosivo+"', '"+crearPrecioExplosivo+"');";
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

	//RELLENAR DESPLEGABLE PARA BAJA EXPLOSIVO
		public Choice borrarExplosivo(Connection connection, Choice choExplosivo)
			{
				Statement statement = null; sentencia = "SELECT * FROM Explosivos";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
								
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
				String bajaExplosivo = ""; String OK = "correcto";
				try
					{
						statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
						statement.executeUpdate("DELETE FROM Explosivos WHERE idExplosivo='"+seleccionadoExplosivo+"'");
						
						bajaExplosivo = OK;
					}
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return bajaExplosivo;
			}
		
	//MODIFICAR EXPLOSIVOS RELLENAR DESPLEGABLE
		public Choice elegirExplosivoModificar (Connection connection, Choice choModificarExplosivo)
			{
				Statement statement = null; 
				sentencia = "SELECT * FROM Explosivos";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							rs = statement.executeQuery(sentencia);
							
							choModificarExplosivo.removeAll();
							
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
		
	//MODIFICAR TONELAJE EXPLOSIVOS
		public String explosivoSelecionarTonelaje (Connection connection, String seleccionadoTonelaje, String nuevoTonelaje)
			{
				String tonelajeElegido = ""; String OK = "correcto";
					try
						{
							statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
							statement.executeUpdate("UPDATE Explosivos SET tonelajeExplosivo='"+nuevoTonelaje+"' WHERE idExplosivo='"+seleccionadoTonelaje+"'");
							
							tonelajeElegido = OK;
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return tonelajeElegido;
			}
		
	//MODIFICAR TONELAJE EXPLOSIVOS
		public String explosivoSeleccionarPrecio (Connection connection, String seleccionadoPrecio, String nuevoPrecio)
			{
				String precioElegido = ""; String OK = "correcto";
					
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet .CONCUR_READ_ONLY);
							statement.executeUpdate("UPDATE Explosivos SET precioExplosivo='"+nuevoPrecio+"' WHERE idExplosivo='"+seleccionadoPrecio+"'");
							
							precioElegido = OK;
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return precioElegido;
			}
		
	//CONSULTA LAPLUSIVUS
		public String consultaExplosivo()
			{
				String listadoExplosivo = ""; 
				ResultSet rs = null; 
				
					try
						{
							statement = connection.createStatement(ResultSet. TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
							rs = statement.executeQuery("SELECT * FROM Explosivos"); 
							
							while(rs.next())
								{
									listadoExplosivo = listadoExplosivo + rs.getInt("idExplosivo") + "/" + rs.getInt("tonelajeExplosivo") + "/" + rs.getString("tipoExplosivo") + "/" + rs.getString("precioExplosivo") + "/" + "\n";
								}		
						}
				
				catch (SQLException sqle)
					{
						System.out.println(sqle.getMessage());
					}
				return(listadoExplosivo);
			}
		
	//EXPORTAR PDF
		public String exportarPdfExplosivo(Connection connection, String datoExplosivo)
			{
				String consultaErrorExplosivo = ""; 
				String errorExplosivo = "Error"; 
				String DESTIII = "Consulta Explosivo.pdf";
				
				String[] separarDatosExplosivo = datoExplosivo.split("/"); 
				
					try 
					{ 
						//crear la impresora
						PdfWriter writerExplosivo = new PdfWriter(DESTIII); 
						
						//Crear el documento 
						PdfDocument pdfExplosivo = new PdfDocument (writerExplosivo); 
						
						//El contenido del documento 
						Document document = new Document (pdfExplosivo);
				
						//Crear una fuente para la cabecera de las columnas de la tabla, además añadiendo tipo de letra en negrita 
						PdfFont fuenteExplosivo = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
				
						//Añadir elementos al documento 
						document.add(new Paragraph());
				
						float[] anchoColumnaExplosivo = {1, 2, 3, 2}; 
						
						// Crear tabla y numero de columnas que tendra 
						Table tablaExplosivo = new Table(UnitValue.createPercentArray(anchoColumnaExplosivo)); 
						
						//Nombre de las cabeceras de la tabla 
						tablaExplosivo.addCell(new Paragraph ("ID").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph("Tonelaje").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph("Tipo").setFont(fuenteExplosivo)); 
						tablaExplosivo.addCell(new Paragraph ("Precio").setFont(fuenteExplosivo));
				
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
}
