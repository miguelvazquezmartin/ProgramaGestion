package Progr_Gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class Controlador implements WindowListener, ActionListener
{
	inicioSesion vista1; 
	pantallaMenu vista2;
	Modelo modelo;
	
	Connection conexion = null;
	
	
	Controlador(inicioSesion v1, pantallaMenu v2, Modelo m)
	{
		//otra forma de llamarlos
			this.vista1= v1;
			this.vista2= v2;
			this.modelo= m;
		
		
		
		
		//Listener pantalla Inicio Sesión
			v1.vista1.addWindowListener(this);
			v1.btnIniciar.addActionListener(this);
			v1.dialogoLogin.addWindowListener(this);
			v1.btnVolver.addActionListener(this);
		
		
		//Listener de las diferentes pantallas del programa
			v2.vista2.addWindowListener(this); 
			v2.frmAltaEmpleado.addWindowListener(this); 
			v2.frmAltaCamion.addWindowListener(this); 
			v2.frmAltaExplosivo.addWindowListener(this);
			v2.frmBajaEmpleado.addWindowListener(this); 
			v2.frmBajaCamion.addWindowListener(this);
			v2.frmBajaExplosivo.addWindowListener(this); 
			v2.frmModificarEmpleado.addWindowListener(this);
			v2.frmModificarTelefonoEmpleado.addWindowListener(this);
			v2.frmModificarDireccionEmpleado.addWindowListener(this);
			v2.frmModificarCapacidadCamion.addWindowListener(this);
			v2.frmModificarTonelajeExplosivo.addWindowListener(this);
			v2.frmModificarPrecioExplosivo.addWindowListener(this);
			v2.frmModificarCamion.addWindowListener(this);
			v2.frmModificarExplosivo.addWindowListener(this); 
			v2.frmConsultaEmpleado.addWindowListener(this); 
			v2.frmConsultaCamion.addWindowListener(this); 
			v2.frmConsultaExplosivo.addWindowListener(this);
			
		//EMPLEADOS 
			
			//Alta
				v2.mniAltaEmpleado.addActionListener(this);
				v2.btnAltaEmpleado.addActionListener(this);
				v2.btnCorrectoAltaEmpleadoVolver.addActionListener(this);
				v2.btnErrorAltaEmpleadoVolver.addActionListener(this);
				v2.btnVolverGeneralAltaEmpleado.addActionListener(this);
			
			//Baja
				v2.mniBajaEmpleado.addActionListener(this);
				v2.btnBajaEmpleado.addActionListener(this);
				v2.btnCorrectoBajaEmpleadoVolver.addActionListener(this);
				v2.btnErrorBajaEmpleadoVolver.addActionListener(this);
				v2.btnVolverGeneralBajaEmpleado.addActionListener(this);
				v2.btnSiSeguroEmpleadoBaja.addActionListener(this);
				v2.btnNoSeguroEmpleadoBaja.addActionListener(this);
			
			//Modificación
				v2.mniModificacionEmpleado.addActionListener(this);
				v2.btnModVolEmpleado.addActionListener(this);
				v2.btnModVolDialogoCorrectaEmpleado.addActionListener(this);
				v2.btnModificarEmpleado.addActionListener(this);
				v2.btnModTelefonoEmpleado.addActionListener(this);
				v2.btnModDireccionEmpleado.addActionListener(this);
				v2.btnModVolDialogoErrorEmpleado.addActionListener(this);
				v2.btnVolModTelEmpleado.addActionListener(this);
				v2.btnVolModDirEmpleado.addActionListener(this);
				
			//Consulta
				v2.mniConsultaEmpleado.addActionListener(this);
				v2.frmConsultaEmpleado.addWindowListener(this);
				v2.btnPdfEmpleado.addActionListener(this);
				v2.btnVolverConsultaEmpleado.addActionListener(this);
				v2.btnExportMalEmpleado.addActionListener(this);
		
		//CAMIONES
				
			//Alta
				v2.mniAltaCamion.addActionListener(this); 
				v2.btnAltaCamion.addActionListener(this); 
				v2.btnCorrectoAltaCamionVolver.addActionListener(this);
				v2.btnVolverGeneralAltaCamion.addActionListener(this);
				v2.btnErrorAltaCamionVolver.addActionListener(this);
			
			//Baja
				v2.mniBajaCamion.addActionListener(this); 
				v2.btnBajaCamion.addActionListener(this); 
				v2.btnCorrectoBajaCamionVolver.addActionListener(this); 
				v2.btnErrorBajaCamionVolver.addActionListener(this); 
				v2.btnVolverGeneralBajaCamion.addActionListener(this); 
				v2.btnSiSeguroCamionBaja.addActionListener(this); 
				v2.btnNoSeguroCamionBaja.addActionListener(this);
				
			//Modificacion
				v2.mniModificacionCamion.addActionListener(this);
				v2.btnModVolCamion.addActionListener(this); 
				v2.btnModVolDialogoCorrectaCamion.addActionListener(this); 
				v2.btnModificarCamion.addActionListener(this);
				v2.btnModCapacidadCamion.addActionListener(this);
				v2.btnModVolDialogoErrorCamion.addActionListener(this); 
				v2.btnVolModCapCamion.addActionListener(this);
				
			//Consulta
				v2.mniConsultaCamion.addActionListener(this); 
				v2.frmConsultaCamion.addWindowListener(this); 
				v2.btnPdfCamion.addActionListener(this); 
				v2.btnVolverConsultaCamion.addActionListener(this); 
				v2.btnExportMalCamion.addActionListener(this);
				
		//EXPLOSIVOS
				
			//Alta
				v2.mniAltaExplosivo.addActionListener(this); 
				v2.btnAltaExplosivo.addActionListener(this);
				v2.btnCorrectoAltaExplosivoVolver.addActionListener(this);
				v2.btnVolverGeneralAltaExplosivo.addActionListener(this); 
				v2.btnErrorAltaExplosivoVolver.addActionListener(this);
				
			//Baja
				v2.mniBajaExplosivo.addActionListener(this); 
				v2.btnBajaExplosivo.addActionListener(this); 
				v2.btnCorrectoBajaExplosivoVolver.addActionListener(this);
				v2.btnErrorBajaExplosivoVolver.addActionListener(this); 
				v2.btnVolverGeneralBajaExplosivo.addActionListener(this);
				v2.btnSiSeguroExplosivoBaja.addActionListener(this);
				v2.btnNoSeguroExplosivoBaja.addActionListener(this);
				
			//Modificacion
				v2.mniModificacionExplosivo.addActionListener(this); 
				v2.btnModVolExplosivo.addActionListener(this); 
				v2.btnModVolDialogoCorrectaExplosivo.addActionListener(this);
				v2.btnModificarExplosivo.addActionListener(this); 
				v2.btnModTonelajeExplosivo.addActionListener(this); 
				v2.btnModPrecioExplosivo.addActionListener(this); 
				v2.btnModVolDialogoErrorExplosivo.addActionListener(this); 
				v2.btnVolModTonExplosivo.addActionListener(this);
				v2.btnVolModPreExplosivo.addActionListener(this);
				
			//Consulta
				v2.mniConsultaExplosivo.addActionListener(this);
				v2.frmConsultaExplosivo.addWindowListener(this); 
				v2.btnPdfExplosivo.addActionListener(this); 
				v2.btnVolverConsultaExplosivo.addActionListener(this);
				v2.btnExportMalExplosivo.addActionListener(this);
	}


	@Override
	public void windowOpened(WindowEvent e) 
	{
		
		
	}


	@Override
	public void windowClosing(WindowEvent e) 
		{
			System.exit(0);
		}


	@Override
	public void windowClosed(WindowEvent e) 
	{
		
		
	}


	@Override
	public void windowIconified(WindowEvent e) 
	{
		
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) 
	{
		
		
	}


	@Override
	public void windowActivated(WindowEvent e) 
	{
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) 
	{
		
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		//Boton iniciar sesion conectado con la base de datos
		if(e.getSource().equals(this.vista1.btnIniciar))
			{
				conexion = this.modelo.conectar(); 
				String validar = this.modelo.iniciar(conexion, this.vista1.nombreUsuario.getText(), this.vista1.contraseniaUsuario.getText());
				
				if(validar.equals("Admin"))
					{
						this.vista1.setVisible(false); 
						this.vista2.setVisible(true);
					}
				else if (validar.equals("Basic"))
					{
						this.vista1.setVisible(false); this.vista2.setVisible(true); 
						this.vista2.mniBajaEmpleado.setEnabled(false); 
						this.vista2.mniBajaCamion.setEnabled(false); 
						this.vista2.mniBajaExplosivo.setEnabled(false); 
						this.vista2.mniModificacionEmpleado.setEnabled(false); 
						this.vista2.mniModificacionCamion.setEnabled(false); 
						this.vista2.mniModificacionExplosivo.setEnabled(false);
					}
				else
					{
						this.vista1.dialogoLogin.setVisible(true);
					}
			}	

	//Volver desde el diálogo de error inicio sesión usuario
		if(e.getSource().equals(this.vista1.btnVolver))
			{
				this.vista1.dialogoLogin.setVisible(false);
				this.vista1.setVisible(true); 
				this.vista1.nombreUsuario.setText(""); 
				this.vista1.contraseniaUsuario.setText("");
			}
		
	// Lanzar ventana Alta Empleado
		if(e.getSource().equals(this.vista2.mniAltaEmpleado))
			{
				this.vista2.setVisible(false); 
				this.vista2.dialogoBajaEmpleadoBien.setVisible(false); 
				this.vista2.frmAltaEmpleado.setVisible(true);
			}
		
	//Volver desde la ventana de Alta de empleado
		if(e.getSource().equals(this.vista2.btnVolverGeneralAltaEmpleado))
			{
				this.vista2.frmAltaEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}
		
	//Funcionalidad ALTA EMPLEADO 
		if(e.getSource().equals(this.vista2.btnAltaEmpleado))
			{
				conexion = this.modelo.conectar();
				String altaEmpleadook = this.modelo.crear(conexion, vista2.txtTelefonoEmpleado.getText(), vista2.txtDniEmpleado.getText(), vista2.txtNombreEmpleado.getText(), vista2.txtDireccionEmpleado.getText(), vista2.txtApellidosEmpleado.getText()); 
		
				if(altaEmpleadook.equals("correcto"))
					{
						this.vista2.dialogoAltaEmpleadoBien.setVisible(true);
					}	
				else
					{
						this.vista2.dialogoAltaEmpleadoMal.setVisible(true);
					}
			}
		
	//Volver desde el diálogo de alta correcta de empleado
		if(e.getSource().equals(this.vista2.btnCorrectoAltaEmpleadoVolver))
			{
				this.vista2.dialogoAltaEmpleadoBien.setVisible(false); 
				this.vista2.frmAltaEmpleado.setVisible(false);
				this.vista2.setVisible(true);
				this.vista2.txtTelefonoEmpleado.setText("");
				this.vista2.txtDniEmpleado.setText("");
				this.vista2.txtNombreEmpleado.setText(""); 
				this.vista2.txtDireccionEmpleado.setText(""); 
				this.vista2.txtApellidosEmpleado.setText("");
			}
		
	//Volver desde el diálogo de error alta empleado
		if(e.getSource().equals(this.vista2.btnErrorAltaEmpleadoVolver))
			{
				this.vista2.dialogoAltaEmpleadoMal.setVisible(false); 
				this.vista2.frmAltaEmpleado.setVisible(true);
			}

	//Lanzar ventana BAJA de EMPLEADO
		if(e.getSource().equals(this.vista2.mniBajaEmpleado))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmBajaEmpleado.setVisible(true);
			}
	
	//Volver desde ventana de baja empleado
		if(e.getSource().equals(this.vista2.btnVolverGeneralBajaEmpleado))
			{
				this.vista2.frmBajaEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Dialogo sí está seguro de borrar al empleado
		if(e.getSource().equals(this.vista2.btnBajaEmpleado))
			{
				this.vista2.dlgSeguroEmpleadoBaja.setVisible(true);
			}
	
	//Rellenar el desplegable para elegir al empleado que desea borrar
		if(e.getSource().equals(this.vista2.mniBajaEmpleado))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.choEmpleado = (this.modelo.borrar(conexion, this.vista2.choEmpleado));
			}
	
	//Funcionalidad BAJA EMPLEADO
		if(e.getSource().equals(this.vista2.btnSiSeguroEmpleadoBaja))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionado = this.vista2.choEmpleado.getSelectedItem().split("-"); 
				String borrarEmpleado = this.modelo.eliminarEmpleado(conexion, seleccionado[0]);
				
				if(borrarEmpleado.equals("correcto"))
					{
						this.vista2.frmBajaEmpleado.setVisible(false); 
						this.vista2.dlgSeguroEmpleadoBaja.setVisible(false); 
						this.vista2.dialogoBajaEmpleadoBien.setVisible(true);
					}					
				else
					{
						this.vista2.frmBajaEmpleado.setVisible(false); 
						this.vista2.dlgSeguroEmpleadoBaja.setVisible(false); 
						this.vista2.dialogoBajaEmpleadoMal.setVisible(true);
					}
			}
		
	// Volver desde el diálogo de baja correcta del empleado
		if(e.getSource().equals(this.vista2.btnCorrectoBajaEmpleadoVolver))
			{
				this.vista2.dialogoBajaEmpleadoBien.setVisible(false);
				this.vista2.dlgSeguroEmpleadoBaja.setVisible(false);
				this.vista2.setVisible(true);
			}

	//Volver desde el diálogo de pregunta seguridad baja empleado
		if(e.getSource().equals(this.vista2.btnNoSeguroEmpleadoBaja))
			{
				this.vista2.dlgSeguroEmpleadoBaja.setVisible(false); 
				this.vista2.frmBajaEmpleado.setVisible(true);
			}
		
	//Volver desde el diálogo de error en la baja del usuario
		if(e.getSource().equals(this.vista2.btnErrorBajaEmpleadoVolver))
			{
				this.vista2.dialogoBajaEmpleadoMal.setVisible(false); 
				this.vista2.dlgSeguroEmpleadoBaja.setVisible(false);
				this.vista2.frmBajaEmpleado.setVisible(true);
			}
		
	//Lanzar ventana MODIFICACIÓN EMPLEADO
		if(e.getSource().equals(this.vista2.mniModificacionEmpleado))
			{
				this.vista2.frmModificarEmpleado.setVisible(true); 
				this.vista2.setVisible(false); 
				conexion = this.modelo.conectar(); 
				this.vista2.choModificarEmpleado = this.modelo.elegirEmpleadoModificar(conexion, this.vista2.choModificarEmpleado);
			}

	//Lanzar pantalla modificación teléfono empleado
		if(e.getSource().equals(this.vista2.btnModificarEmpleado) && this.vista2.choSeleccionarCampo.getSelectedItem().equals("Teléfono"))
			{
				this.vista2.frmModificarEmpleado.setVisible(false);
				this.vista2.frmModificarTelefonoEmpleado.setVisible(true);
			}
		
	//Volver desde ventana modificar empleado
		if(e.getSource().equals(this.vista2.btnModVolEmpleado))
			{
				this.vista2.frmModificarEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Funcionalidad MODIFICAR TELÉFONO EMPLEADO
		if(e.getSource().equals(this.vista2.btnModTelefonoEmpleado))
			{	
				conexion = this.modelo.conectar(); 
				String[] seleccionadoTelefono = this.vista2.choModificarEmpleado.getSelectedItem().split(" / "); 
				String telefonoElegido = this.modelo.empleadoSeleccionadoTelefono(conexion, seleccionadoTelefono[0], vista2.txtNuevoTelefonoEmpleado.getText());
				
				if (telefonoElegido.equals("correcto"))
					{
						this.vista2.frmModificarTelefonoEmpleado.setVisible(false); 
						this.vista2.dlgModCorrectaEmpleado.setVisible(true);
					}
				else
					{
						this.vista2.frmModificarTelefonoEmpleado.setVisible(false); 
						this.vista2.dlgModErrorEmpleado.setVisible(true);
					}
			}
		
	// Volver a modificación desde modificar teléfono empleado
		if(e.getSource().equals(this.vista2.btnVolModTelEmpleado))
			{
				this.vista2.txtNuevoTelefonoEmpleado.setText(""); 
				this.vista2.dlgModCorrectaEmpleado.setVisible(false); 
				this.vista2.frmModificarEmpleado.setVisible(true);
			}
	

	// Lanzar pantalla modificación dirección del empleado 
		if(e.getSource().equals(this.vista2.btnModificarEmpleado) && this.vista2.choSeleccionarCampo.getSelectedItem().equals("Dirección"))
			{
				this.vista2.frmModificarEmpleado.setVisible(false);
				this.vista2.frmModificarDireccionEmpleado.setVisible(true);
			}

	//Funcionalidad MODIFICAR DIRECCIÓN EMPLEADO
		if(e.getSource().equals(this.vista2.btnModDireccionEmpleado))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadaDireccion = this.vista2.choModificarEmpleado.getSelectedItem().split(" / "); 
				String direccionElegida = this.modelo.empleadoSeleccionadaDireccion(conexion, seleccionadaDireccion[0], vista2.txtNuevaDireccionEmpleado.getText());
				
				if(direccionElegida.equals("correcto"))
					{
						this.vista2.frmModificarDireccionEmpleado.setVisible(false);
						this.vista2.dlgModCorrectaEmpleado.setVisible(true);
					}
				else
					{
						this.vista2.frmModificarDireccionEmpleado.setVisible(false); 
						this.vista2.dlgModErrorEmpleado.setVisible(true);
					}
			}

	//Volver a modificar desde modificar dirección del empleado
		if(e.getSource().equals(this.vista2.btnVolModDirEmpleado))
			{
				this.vista2.txtNuevaDireccionEmpleado.setText(""); 
				this.vista2.frmModificarDireccionEmpleado.setVisible(false); 
				this.vista2.frmModificarEmpleado.setVisible(true);
			}
		
	//Volver desde el diálogo de modificación correcta
		if(e.getSource().equals(this.vista2.btnModVolDialogoCorrectaEmpleado))
			{
				this.vista2.dlgModCorrectaEmpleado.setVisible(false); 
				this.vista2.frmModificarEmpleado.setVisible(true);
			}

	//Volver desde el diálogo de modificación errónea
		if(e.getSource().equals(this.vista2.btnModVolDialogoErrorEmpleado))
			{
				this.vista2.dlgModErrorEmpleado.setVisible(false); 
				this.vista2.frmModificarTelefonoEmpleado.setVisible(true);
			}
		
	//Lanzar ventana de CONSULTA EMPLEADO
		if(e.getSource().equals(this.vista2.mniConsultaEmpleado))
			{
				this.vista2.setVisible(false);  
				this.vista2.frmConsultaEmpleado.setVisible(true);
				
			}
	
	//Volver desde ventana de consulta empleado
		if(e.getSource().equals(this.vista2.btnVolverConsultaEmpleado))
			{
				this.vista2.frmConsultaEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Funcionalidad CONSULTA EMPLEADO
		if(e.getSource().equals(this.vista2.mniConsultaEmpleado))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.txaListadoEmpleado.setText(""); 
				String consulta = this.modelo.consultaEmpleado();
				this.vista2.txaListadoEmpleado.append(consulta);
			}

	//Función del botón EXPORTAR PDF
		if (e.getSource().equals(this.vista2.btnPdfEmpleado))
			{
				conexion = this.modelo.conectar(); 
				String datos = this.modelo.consultaEmpleado(); 
				String consultaError = this.modelo.exportPdf(conexion, datos); 
				
				//Diálogo si ha habido un error al exportar el documento 
				if(consultaError.equals("error"))
					{
						this.vista2.dialogoExportPdfMalEmpleado.setVisible(true);
					}
			}

	//Volver al menu de consultas si ha habido algún error al exportar el pdf empleado
		if(e.getSource().equals(this.vista2.btnExportMalEmpleado))
			{
				this.vista2.dialogoExportPdfMalEmpleado.setVisible(false); 
				this.vista2.frmConsultaEmpleado.setVisible(true);
			}

//CAMIONES --------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Ventana ALTA CAMION
		if(e.getSource().equals(this.vista2.mniAltaCamion))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmAltaCamion.setVisible(true);
			}

	//Volver desde alta camión
		if(e.getSource().equals(this.vista2.btnVolverGeneralAltaCamion))
			{
				this.vista2.frmAltaCamion.setVisible(false);
				this.vista2.setVisible(true);
			}

	//Función ALTA CAMIÓN 
		if(e.getSource().equals(this.vista2.btnAltaCamion))
			{
				conexion = this.modelo.conectar();
				String altaCamionOk = this.modelo.crearCamion(conexion, vista2.txtCapacidadCamion.getText(), vista2.txtMarcaCamion.getText(), vista2.txtAnioCompraCamion.getText(), vista2.txtMatriculaCamion.getText(), vista2.txtModeloCamion.getText());
				if(altaCamionOk.equals("correcto"))
					{
					this.vista2.dialogoAltaCamionBien.setVisible(true);
					}
				else
					{
						this.vista2.dialogoAltaCamionMal.setVisible(true);
					}
			}
		
	//Volver desde diálogo de correcto alta Camión
		if(e.getSource().equals(this.vista2.btnCorrectoAltaCamionVolver))
			{
				this.vista2.dialogoAltaCamionBien.setVisible(false); 
				this.vista2.frmAltaCamion.setVisible(false); 
				this.vista2.setVisible(true); 
				this.vista2.txtCapacidadCamion.setText(""); 
				this.vista2.txtMarcaCamion.setText(""); 
				this.vista2.txtAnioCompraCamion.setText(""); 
				this.vista2.txtMatriculaCamion.setText(""); 
				this.vista2.txtModeloCamion.setText("");
			}
		
	//Volver desde el diálogo error alta camión
		if(e.getSource().equals(this.vista2.btnErrorAltaCamionVolver))
			{
				this.vista2.dialogoAltaCamionMal.setVisible(false); 
				this.vista2.frmAltaCamion. setVisible(true);
			}
		
	//Ventana BAJA CAMION
		if(e.getSource().equals(this.vista2.mniBajaCamion))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmBajaCamion.setVisible(true);
			}
		
	//Volver desde baja camión 
		if(e.getSource().equals(this.vista2.btnVolverGeneralBajaCamion))
			{
				this.vista2.frmBajaCamion.setVisible(false);
				this.vista2.setVisible(true);
			}
		
	//Diálogo preguntar sí está seguro de borrar el camión
		if(e.getSource().equals(this.vista2.btnBajaCamion))
			{
				this.vista2.dlgSeguroCamionBaja.setVisible(true);
			}
		
	//Rellenar el desplegable de selección para el camión a borrar
		if(e.getSource().equals(this.vista2.mniBajaCamion))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.choCamion = (this.modelo.borrarCamion(conexion, this.vista2.choCamion));
			}
		
	//Función BAJA CAMIÓN
		if(e.getSource().equals(this.vista2.btnSiSeguroCamionBaja))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoCamion = this.vista2.choCamion.getSelectedItem().split(""); 
				String borrarCamion = this.modelo.eliminarCamion(conexion, seleccionadoCamion[0]);
				
				if(borrarCamion.equals("correcto"))
					{
						this.vista2.frmBajaCamion.setVisible(false); 
						this.vista2.dlgSeguroCamionBaja.setVisible(false); 
						this.vista2.dialogoBajaCamionBien.setVisible(true);
					}
				else
					{
						this.vista2.frmBajaCamion.setVisible(false); 
						this.vista2.dlgSeguroCamionBaja.setVisible(false); 
						this.vista2.dialogoBajaCamionMal.setVisible(true);
					}
			
			}
		
	//Diálogo baja camión correcta
		if(e.getSource().equals(this.vista2.btnCorrectoBajaCamionVolver))
			{
				this.vista2.dialogoBajaCamionBien.setVisible(false); 
				this.vista2.dlgSeguroCamionBaja.setVisible(false); 
				this.vista2.setVisible(true);
			}
		
	// Volver a la ventana de baja camión desde el diálogo seguridad baja camión
		if(e.getSource().equals(this.vista2.btnNoSeguroCamionBaja))
			{
				this.vista2.dlgSeguroCamionBaja.setVisible(false); 
				this.vista2.dialogoBajaCamionMal.setVisible(false);
				this.vista2.frmBajaCamion.setVisible(true);	
			}
		
	//Volver desde diálogo error baja camión
		if(e.getSource().equals(this.vista2.btnErrorBajaCamionVolver))
			{
				this.vista2.dialogoBajaCamionMal.setVisible(false); 
				this.vista2.dlgSeguroCamionBaja.setVisible(false); 
				this.vista2.frmBajaCamion.setVisible(true);
			}
		
//MODIFICAR CAMIONES
	
	// Lanzar ventana Modificación Camión y rellenar el desplegable
		if(e.getSource().equals(this.vista2.mniModificacionCamion))
			{
				this.vista2.frmModificarCamion.setVisible(true); 
				this.vista2.setVisible(false); 
				conexion = this.modelo.conectar(); 
				this.vista2.choModificarCamion = (this.modelo.elegirCamionModificar(conexion, this.vista2.choModificarCamion));
			}
		
	// Lanzar ventana MODIFICAR CAPACIDAD
		if(e.getSource().equals(this.vista2.btnModificarCamion) && this.vista2.choSeleccionarCampoCamion.getSelectedItem().equals("Capacidad"))
			{
				this.vista2.frmModificarCamion.setVisible(false);
				this.vista2.frmModificarCapacidadCamion.setVisible(true);
			}
		
	//Funcionalidad MODIFICAR CAPACIDAD CAMIÓN
		if(e.getSource().equals(this.vista2.btnModCapacidadCamion))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoCapacidad = this.vista2.choModificarCamion.getSelectedItem().split(" / "); 
				String capacidadElegida = this.modelo.camionSelecionarCapacidad(conexion, seleccionadoCapacidad[0], this.vista2.txtNuevoCapacidadCamion.getText());
					
				if(capacidadElegida.equals("correcto"))
					{
						this.vista2.frmModificarCapacidadCamion.setVisible(false); 
						this.vista2.dlgModCorrectaCamion.setVisible(true);
					}
				else
					{
						this.vista2.frmModificarCapacidadCamion.setVisible(false); 
						this.vista2.dlgModErrorCamion.setVisible(true);
					}
			}
		
	//Volver a modificar desde el diálogo de modificar capacidad camión
		if(e.getSource().equals(this.vista2.btnVolModCapCamion))
			{
				this.vista2.txtNuevoCapacidadCamion.setText("");
				this.vista2.frmModificarCapacidadCamion.setVisible(false); 
				this.vista2.frmModificarCamion.setVisible(true);
			}
		
	// Volver desde ventana de modificar camión
		if(e.getSource().equals(this.vista2.btnModVolCamion))
			{
				this.vista2.frmModificarCamion.setVisible(false); 
				this.vista2.setVisible(true);
			}
		
	//Volver desde el diálogo de modificación correcta de camion
		if(e.getSource().equals(this.vista2.btnModVolDialogoCorrectaCamion))
			{
				this.vista2.dlgModCorrectaCamion.setVisible(false);
				this.vista2.frmModificarCamion.setVisible(true);
			}
		
	//Volver desde el diálogo de error al modificar camión
		if(e.getSource().equals(this.vista2.btnModVolDialogoErrorCamion))
			{
				this.vista2.dlgModErrorCamion.setVisible(false); 
				this.vista2.frmModificarCapacidadCamion.setVisible(true);
			}
		
//CONSULTA CAMIONES
	
	//Lanzar ventana CONSULTA CAMION
		if(e.getSource().equals(this.vista2.mniConsultaCamion))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmConsultaCamion.setVisible(true);
			}
		
	// Volver desde consulta de camión
		if(e.getSource().equals(this.vista2.btnVolverConsultaCamion))
			{
				this.vista2.frmConsultaCamion.setVisible(false);
				this.vista2.setVisible(true);
			}

	//Funcionalidad CONSULTA CAMIÓN
		if(e.getSource().equals(this.vista2.mniConsultaCamion))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.txalistadoCamion.setText(""); 
				String consultaCam = this.modelo.consultaCamion(); 
				this.vista2.txalistadoCamion.append(consultaCam);
			}

	//Función EXPORTAR PDF CAMIÓN
		if(e.getSource().equals(this.vista2.btnPdfCamion))
			{
			conexion = this.modelo.conectar(); 
			String datosCamion = this. modelo.consultaCamion();
			String consultaErrorCamion = this.modelo.exportarPdfCamion(conexion, datosCamion); 
			//ventana dialogo si ha habido un error al exportar el documento 
				if(consultaErrorCamion.equals("error"))
					{
						this.vista2.dialogoExportPdfMalCamion.setVisible(true);
					}
			}

	//Volver desde el diálogo ha habido un error al exportar pdf camión
		if(e.getSource().equals(this.vista2.btnExportMalCamion))
			{
				this.vista2.dialogoExportPdfMalCamion.setVisible(false);
				this.vista2.frmConsultaCamion.setVisible(true);
			}

//EXPLOSIVOS-------------------------------------------------------------------------------------------------------------------------------------------------------------

	//Ventana ALTA EXPLOSIVOS
		if(e.getSource().equals(this.vista2.mniAltaExplosivo))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmAltaExplosivo. setVisible(true);
			}

	// Volver desde ventana alta explosivos
		if(e.getSource().equals(this.vista2.btnVolverGeneralAltaExplosivo))
			{
				this.vista2.frmAltaExplosivo.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Función ALTA EXPLOSIVOS
		if(e.getSource().equals(this.vista2.btnAltaExplosivo))
			{
				conexion = this.modelo.conectar();
				String altaExplosivoOk = this.modelo.crearExplosivo(conexion, this.vista2.txtTonelajeExplosivo.getText(), this.vista2.txtTipoExplosivo.getText(), this.vista2.txtPrecioExplosivo.getText()); 
				if(altaExplosivoOk.equals("correcto"))
					{
						this.vista2.frmAltaExplosivo.setVisible(false); 
						this.vista2.dialogoAltaExplosivoBien.setVisible(true);
					}
				else
					{
						this.vista2.frmAltaExplosivo.setVisible(false); 
						this.vista2.dialogoAltaExplosivoMal.setVisible(true);
					}
			}

	// Vovler desde diálogo de correcto alta explosivo
		if(e.getSource().equals(this.vista2.btnCorrectoAltaExplosivoVolver))
			{
				this.vista2.dialogoAltaExplosivoBien.setVisible(false); 
				this.vista2.frmAltaExplosivo.setVisible(false); 
				this.vista2.setVisible(true); 
				this.vista2.txtTonelajeExplosivo.setText("");
				this.vista2.txtTipoExplosivo.setText(""); 
				this.vista2.txtPrecioExplosivo.setText("");
			}

	//Volver desde el diálogo de error alta Explosivo
		if(e.getSource().equals(this.vista2.btnErrorAltaExplosivoVolver))
			{
				this.vista2.dialogoAltaExplosivoMal.setVisible(false); 
				this.vista2.frmAltaExplosivo. setVisible(true);
			}
		
	//Ventana BAJA EXPLOSIVO
		if(e.getSource().equals(this.vista2.mniBajaExplosivo))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmBajaExplosivo.setVisible(true);
			}

	//Volver desde ventana baja explosivo
		if(e.getSource().equals(this.vista2.btnVolverGeneralBajaExplosivo))
			{
				this.vista2.frmBajaExplosivo.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Diálogo preguntar si está seguro de borrar explosivo
		if(e.getSource().equals(this.vista2.btnBajaExplosivo))
			{
				this.vista2.dlgSeguroExplosivoBaja.setVisible(true);
			}

	//Rellenar desplegable para selección de explosivo a borrar
		if(e.getSource().equals(this.vista2.mniBajaExplosivo))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.choExplosivo = (this.modelo.borrarExplosivo(conexion, this.vista2.choExplosivo));
			}

	//Función BAJA EXPLOSIVO
		if(e.getSource().equals(this.vista2.btnSiSeguroExplosivoBaja))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoExplosivo = this.vista2.choExplosivo.getSelectedItem().split(""); 
				String bajaExplosivo = this.modelo.eliminarExplosivo(conexion, seleccionadoExplosivo[0]);
			
				if(bajaExplosivo.equals("correcto"))
					{
						this.vista2.frmBajaExplosivo.setVisible(false); 
						this.vista2.dlgSeguroExplosivoBaja.setVisible(false);
						this.vista2.dialogoBajaExplosivoBien.setVisible(true);
					}
				else
					{
						this.vista2.frmBajaExplosivo.setVisible(false); 
						this.vista2.dlgSeguroExplosivoBaja.setVisible(false); 
						this.vista2.dialogoBajaExplosivoMal.setVisible(true);
					}
			}

	//Volver desde diálogo baja explosivo correcta
		if(e.getSource().equals(this.vista2.btnCorrectoBajaExplosivoVolver))
			{
				this.vista2.dialogoBajaExplosivoBien.setVisible(false); 
				this.vista2.dlgSeguroExplosivoBaja.setVisible(false);
				this.vista2.setVisible(true);
			}

	//Volver desde diálogo seguridad borrar explosivo
		if(e.getSource().equals(this.vista2.btnNoSeguroExplosivoBaja))
			{
				this.vista2.dlgSeguroExplosivoBaja.setVisible(false);
				this.vista2.dialogoBajaExplosivoMal.setVisible(false); 
				this.vista2.frmBajaExplosivo. setVisible(true);
			}

	//Volver desde diálogo error baja explosivo
		if(e.getSource().equals(this.vista2.btnErrorBajaExplosivoVolver))
			{
				this.vista2.dialogoBajaExplosivoMal.setVisible(false); 
				this.vista2.dlgSeguroExplosivoBaja.setVisible(false);
				this.vista2.frmBajaExplosivo. setVisible(true);
			}

//MODIFICAR EXPLOSIVOS
	
	//Lanzar ventana Modificación explosivos y rellenar el desplegable
		if(e.getSource().equals(this.vista2.mniModificacionExplosivo))
			{
				this.vista2.frmModificarExplosivo.setVisible(true); 
				this.vista2.setVisible(false); 
				conexion = this.modelo.conectar(); 
				this.vista2.choModificarExplosivo = (this.modelo.elegirExplosivoModificar(conexion, this.vista2.choModificarExplosivo));
			}

	// Lanzar ventana MODIFICAR TONELAJE 
		if(e.getSource().equals(this.vista2.btnModificarExplosivo) && this.vista2.choSeleccionarCampoExplosivo.getSelectedItem().equals("Tonelaje"))
			{
				this.vista2.frmModificarExplosivo.setVisible(false); 
				this.vista2.frmModificarTonelajeExplosivo.setVisible(true);
			}

	//Funcionalidad MODIFICAR TONELAJE
		if(e.getSource().equals(this.vista2.btnModTonelajeExplosivo))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoTonelaje = this.vista2.choModificarExplosivo.getSelectedItem().split("/"); 
				String tonelajeElegido = this.modelo.explosivoSelecionarTonelaje(conexion, seleccionadoTonelaje[0], this.vista2.txtNuevoTonelajeExplosivo.getText());
					
				if(tonelajeElegido.equals("correcto"))
					{
						this.vista2.frmModificarTonelajeExplosivo.setVisible(false); 
						this.vista2.dlgModCorrectaExplosivo.setVisible(true);
					}
				else
					{
						this.vista2.frmModificarTonelajeExplosivo.setVisible(false); 
						this.vista2.dlgModErrorExplosivo.setVisible(true);
					}	
			}
		
	//Volver desde ventana de modificación del tonelaje
		if(e.getSource().equals(this.vista2.btnVolModTonExplosivo))
			{
				this.vista2.txtNuevoTonelajeExplosivo.setText("");
				this.vista2.frmModificarTonelajeExplosivo.setVisible(false); 
				this.vista2.frmModificarExplosivo.setVisible(true);
			}
		
	//Volver desde ventana de modificación de explosivos
		if(e.getSource().equals(this.vista2.btnModVolExplosivo))
			{
				this.vista2.frmModificarExplosivo.setVisible(false);
				this.vista2.setVisible(true);
			}
		
	//Volver desde diálogo modificación explosivo correcta
		if(e.getSource().equals(this.vista2.btnModVolDialogoCorrectaExplosivo))
			{
				this.vista2.dlgModCorrectaExplosivo.setVisible(false); 
				this.vista2.frmModificarExplosivo. setVisible(true);
			}
		
	//Volver desde diálogo modificación explosivo error
		if(e.getSource().equals(this.vista2.btnModVolDialogoErrorExplosivo))
			{
				this.vista2.dlgModErrorExplosivo.setVisible(false); 
				this.vista2.frmModificarTonelajeExplosivo. setVisible(true);
			}
		
	//Lanzar ventana MODIFICR PRECIO 
		if(e.getSource().equals(this.vista2.btnModificarExplosivo) && this.vista2.choSeleccionarCampoExplosivo.getSelectedItem().equals("Precio"))
			{
				this.vista2.frmModificarExplosivo.setVisible(false);
				this.vista2.frmModificarPrecioExplosivo.setVisible(true);
			}
		
	//Funcionalidad MODIFICAR PRECIO
		if(e.getSource().equals(this.vista2.btnModPrecioExplosivo))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoPrecio = this.vista2.choModificarExplosivo.getSelectedItem().split(" / "); 
				String precioElegido = this.modelo.explosivoSeleccionarPrecio(conexion, seleccionadoPrecio[0], this.vista2.txtNuevoPrecioExplosivo.getText());
					if (precioElegido.equals("correcto"))
						{
							this.vista2.frmModificarPrecioExplosivo.setVisible(false);
							this.vista2.dlgModCorrectaExplosivo.setVisible(true);
						}
					else
						{
							this.vista2.frmModificarPrecioExplosivo.setVisible(false); 
							this.vista2.dlgModErrorExplosivo. setVisible(true);
						}
					
			}
		
	//Volver a modificar desde modificar precio
		if(e.getSource().equals(this.vista2.btnVolModPreExplosivo))
			{
				this.vista2.txtNuevoPrecioExplosivo.setText(""); 
				this.vista2.frmModificarPrecioExplosivo. setVisible(false); 
				this.vista2.frmModificarExplosivo.setVisible(true);
			}
		
//CONSULTA EXPLOSIVOS
		
	//Lanzar ventana CONSULTA EXPLOSIVOS
		if(e.getSource().equals(this.vista2.mniConsultaExplosivo))
			{
				this.vista2.setVisible(false); 
				this.vista2.frmConsultaExplosivo.setVisible(true);
			}
		
	//Volver desde ventana de consulta explosivo
		if(e.getSource().equals(this.vista2.btnVolverConsultaExplosivo))
			{
				this.vista2.frmConsultaExplosivo.setVisible(false); 
				this.vista2.setVisible(true);
			}
		
	//Funcionalidad CONSULTA EXPLOSIVOS
		if(e.getSource().equals(this.vista2.mniConsultaExplosivo))
			{
				conexion = this.modelo.conectar(); 
				this.vista2.txalistadoExplosivo.setText(""); 
				String consultaExp = this.modelo.consultaExplosivo(); 
				this.vista2.txalistadoExplosivo.append(consultaExp);
			}
		
	//Función EXPORTAR PDF EXPLOSIVO
		if(e.getSource().equals(this.vista2.btnPdfExplosivo))
			{
				conexion = this.modelo.conectar(); 
				String datosExplosivo = this.modelo.consultaExplosivo();
				String consultaErrorExplosivo = this.modelo.exportarPdfExplosivo(conexion, datosExplosivo); 
				//ventana diálogo si ha habido un error al exportar el documento 
				if(consultaErrorExplosivo.equals("error"))
					{
						this.vista2.dialogoExportPdfMalExplosivo.setVisible(true);
					}
			}
	
	//Volver desde el diálogo error al exportar documento pdf explosivo
		if(e.getSource().equals(this.vista2.btnExportMalExplosivo))
			{
				this.vista2.dialogoExportPdfMalExplosivo.setVisible(false);
				this.vista2.frmConsultaExplosivo.setVisible(true);
			}
	}

}
	
	


