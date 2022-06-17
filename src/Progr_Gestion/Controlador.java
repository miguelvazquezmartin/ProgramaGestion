package Progr_Gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class Controlador implements WindowListener, ActionListener, ItemListener
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
			v2.frmAltaCliente.addWindowListener(this);
			v2.frmBajaEmpleado.addWindowListener(this); 
			v2.frmBajaCamion.addWindowListener(this);
			v2.frmBajaExplosivo.addWindowListener(this);
			v2.frmBajaCliente.addWindowListener(this);
			v2.frmModificarEmpleado.addWindowListener(this);
			v2.frmModificarEspecificoEmpleado.addWindowListener(this);
			v2.frmModificarEspecificoCliente.addWindowListener(this);
			v2.frmModificarCliente.addWindowListener(this);
			v2.frmModificarCapacidadCamion.addWindowListener(this);
			v2.frmModificarExplosivoAvanzado.addWindowListener(this);
			v2.frmModificarCamion.addWindowListener(this);
			v2.frmModificarExplosivo.addWindowListener(this); 
			v2.frmConsultaEmpleado.addWindowListener(this); 
			v2.frmConsultaCamion.addWindowListener(this); 
			v2.frmConsultaExplosivo.addWindowListener(this);
			v2.frmConsultaCliente.addWindowListener(this);
			v2.frmInformacion.addWindowListener(this);
			v2.frmPreAltaEmpleado.addWindowListener(this);
			
			
		
		//AYUDA
			
			//Ayuda
				v2.mniAyuda.addActionListener(this);
				v2.mniInform.addActionListener(this);
				v2.mniFichero.addActionListener(this);
				v2.btnVolverInformacion.addActionListener(this);
				
		//EMPLEADOS 
			
			//Alta
				
				v2.mniAltaEmpleado.addActionListener(this);
				v2.btnAltaEmpleado.addActionListener(this);
				v2.btnCorrectoAltaEmpleadoVolver.addActionListener(this);
				v2.btnErrorAltaEmpleadoVolver.addActionListener(this);
				v2.btnVolverGeneralAltaEmpleado.addActionListener(this);
				v2.btnVolverPreAltaEmpleado.addActionListener(this);
				v2.btnPreAltaEmpleado.addActionListener(this);
			
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
				v2.btnModEspecificoEmpleado.addActionListener(this);
				v2.btnModVolDialogoErrorEmpleado.addActionListener(this);
				v2.btnVolModEspEmpleado.addActionListener(this);
				
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
				v2.choModificarExplosivo.addItemListener(this);
				v2.btnModTonelajeExplosivo.addActionListener(this); 
				v2.btnModVolDialogoErrorExplosivo.addActionListener(this); 
				v2.btnVolModTonExplosivo.addActionListener(this);
				
			//Consulta
				v2.mniConsultaExplosivo.addActionListener(this);
				v2.frmConsultaExplosivo.addWindowListener(this); 
				v2.btnPdfExplosivo.addActionListener(this); 
				v2.btnVolverConsultaExplosivo.addActionListener(this);
				v2.btnExportMalExplosivo.addActionListener(this);
			
		//CLIENTES
				
			//Alta 
				
				v2.mniAltaCliente.addActionListener(this); 
				v2.btnAltaCliente.addActionListener(this); 
				v2.btnCorrectoAltaClienteVolver.addActionListener(this);
				v2.btnVolverGeneralAltaCliente.addActionListener(this);
				v2.btnErrorAltaClienteVolver.addActionListener(this);
				
			//Baja 
				
				v2.mniBajaCliente.addActionListener(this);
				v2.btnBajaCliente.addActionListener(this);
				v2.btnCorrectoBajaClienteVolver.addActionListener(this);
				v2.btnErrorBajaClienteVolver.addActionListener(this);
				v2.btnVolverGeneralBajaCliente.addActionListener(this);
				v2.btnSiSeguroClienteBaja.addActionListener(this);
				v2.btnNoSeguroClienteBaja.addActionListener(this);
			
			//Modificación
				
				v2.mniModificacionCliente.addActionListener(this);
				v2.btnModVolCliente.addActionListener(this);
				v2.btnModVolDialogoCorrectaCliente.addActionListener(this);
				v2.btnModificarCliente.addActionListener(this);
				v2.btnModificarClienteNuevo.addActionListener(this);
				v2.btnModVolDialogoErrorCliente.addActionListener(this);
				v2.btnVolModCliente.addActionListener(this);
		
			//Consulta
				v2.mniConsultaCliente.addActionListener(this); 
				v2.frmConsultaCliente.addWindowListener(this); 
				v2.btnPdfCliente.addActionListener(this); 
				v2.btnVolverConsultaCliente.addActionListener(this); 
				v2.btnExportMalCliente.addActionListener(this);
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
						this.vista2.mniConsultaEmpleado.setEnabled(false);
						this.vista2.mniConsultaCamion.setEnabled(false);
						this.vista2.mniConsultaExplosivo.setEnabled(false);
					}
				else
					{
						this.vista1.dialogoLogin.setVisible(true);
					}
				this.modelo.desconected(conexion);
			}	

	//Volver desde el diálogo de error inicio sesión usuario
		if(e.getSource().equals(this.vista1.btnVolver))
			{
				this.vista1.dialogoLogin.setVisible(false);
				this.vista1.setVisible(true); 
				this.vista1.nombreUsuario.setText(""); 
				this.vista1.contraseniaUsuario.setText("");
			}
		
	//Ventana AYUDA
		if(e.getSource().equals(this.vista2.mniAyuda))
			{
				this.modelo.ayuda(conexion);
				this.modelo.desconected(conexion);
			}
		
	//Ventana INFORMACIÓN
		if(e.getSource().equals(this.vista2.mniInform))
			{
				this.vista2.frmInformacion.setVisible(true);
				this.vista2.setVisible(false);
			}
		
	//Volver ventana INFORMACIÓN
		if(e.getSource().equals(this.vista2.btnVolverInformacion))
		{
			this.vista2.frmInformacion.setVisible(false);
			this.vista2.setVisible(true);
		}
		
	//Ventana Fichero.Log
		if(e.getSource() != null)
			{
				this.modelo.ficheroLog(this.vista1.nombreUsuario.getText(), this.modelo.sentencia);
			}
		
	// Lanzar ventana de Pre Alta Empleado
		if(e.getSource().equals(this.vista2.mniAltaEmpleado))
			{
				this.vista2.setVisible(false);  
				this.vista2.frmPreAltaEmpleado.setVisible(true);
			}
		
	//Volver desde la ventana de Pre Alta de empleado
		if(e.getSource().equals(this.vista2.btnVolverPreAltaEmpleado))
			{
				this.vista2.frmPreAltaEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}
	//Lanzar pantalla ALTA EMPLEADO 
		if(e.getSource().equals(this.vista2.btnPreAltaEmpleado))
			{
				this.vista2.frmPreAltaEmpleado.setVisible(false);
				this.vista2.frmAltaEmpleado.setVisible(true);	
			//Según la selección de tipo de empleado, se habilitan unos textfields u otros
				//Habilita los textfields para Administrativos
				if(this.vista2.choTipoEmpleado.getSelectedItem().equals("Administrativo"))
					{
						this.vista2.txtIdiomaAdministrativo.setEnabled(true);
						this.vista2.txtTituloAdministrativo.setEnabled(true);
						this.vista2.txtCarnetConducirConductor.setEnabled(false);
					}
				//Habilita los textfields para los conductores
				else if ( this.vista2.choTipoEmpleado.getSelectedItem().equals("Conductor"))
					{
						this.vista2.txtIdiomaAdministrativo.setEnabled(false);
						this.vista2.txtTituloAdministrativo.setEnabled(false);
						this.vista2.txtCarnetConducirConductor.setEnabled(true);
					}
			}		
		
	//Volver desde la ventana de Pre Alta de empleado
		if(e.getSource().equals(this.vista2.btnVolverGeneralAltaEmpleado))
			{
				this.vista2.frmAltaEmpleado.setVisible(false); 
				this.vista2.frmPreAltaEmpleado.setVisible(true); 
			}
		
	//Funcionalidad ALTA EMPLEADO 
		if(e.getSource().equals(this.vista2.btnAltaEmpleado))
			{
				//conectar con la base de datos y el método crear. 
				conexion = this.modelo.conectar();
				String altaEmpleadoOk = this.modelo.crear(conexion, vista2.txtTelefonoEmpleado.getText(), vista2.txtDniEmpleado.getText(), vista2.txtNombreEmpleado.getText(), vista2.txtDireccionEmpleado.getText(), vista2.txtApellidosEmpleado.getText());
				
				if(altaEmpleadoOk.equals("correcto"))
					{
					//si el método ha funcionado correctamente, lanza la ventana de dialogo de alta correcta
						this.vista2.dialogoAltaEmpleadoBien.setVisible(true);
						//Para dar de alta al mismo tiempo al empleado en las tablas de conductores o administrativos, enlazamos con el FK obteniendo el idEmpleado
						String idNumero = this.modelo.enlazar(conexion);
						System.out.println(idNumero);
						
						//si el elemento seleccionado es el del conductor, lanza el método de alta conductor, por el contrario lanza el de administrativo
						if(this.vista2.choTipoEmpleado.getSelectedItem().equals("Conductor"))
							{
								conexion = this.modelo.conectar();
								this.modelo.crearConductor(conexion, vista2.txtCarnetConducirConductor.getText(), idNumero);
							}
						if(this.vista2.choTipoEmpleado.getSelectedItem().equals("Administrativo"))
							{
								conexion = this.modelo.conectar();
								this.modelo.crearAdministrativo(conexion, vista2.txtTituloAdministrativo.getText(), vista2.txtIdiomaAdministrativo.getText(), idNumero);
							}
					}	
				else
					{
						this.vista2.dialogoAltaEmpleadoMal.setVisible(true);
					}
			this.modelo.desconected(conexion);
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
				this.vista2.txtCarnetConducirConductor.setText("");
				this.vista2.txtTituloAdministrativo.setText("");
				this.vista2.txtIdiomaAdministrativo.setText("");
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
				this.vista2.dlgSeguroEmpleadoBaja.setVisible(false);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
				
			}
		
		//Lanzar pantalla modificación especifico empleado
			if(e.getSource().equals(this.vista2.btnModificarEmpleado))
				{
					this.vista2.frmModificarEmpleado.setVisible(false);
					this.vista2.frmModificarEspecificoEmpleado.setVisible(true); 
					//utilizo este array para obtener el numero de idEmpleado, así pasarselo posteriormente al modelo y poder relacionar los datos entre las tablas
					String[] cogerIdEmpleado = this.vista2.choModificarEmpleado.getSelectedItem().split(" / ");
					conexion = this.modelo.conectar();
					//obtengo todos los datos del empleado seleccionado en el choice
					String rellenarHueco = this.modelo.rellenarTextModificarGeneral(conexion, cogerIdEmpleado[0]);
					String[] seleccionadoGeneral = rellenarHueco.split(" / ");
					this.vista2.txtTelefonoEmpleadoModificar.setText(seleccionadoGeneral[3]); 
					this.vista2.txtDniEmpleadoModificar.setText(seleccionadoGeneral[2]);
					this.vista2.txtNombreEmpleadoModificar.setText(seleccionadoGeneral[0]);
					this.vista2.txtDireccionEmpleadoModificar.setText(seleccionadoGeneral[4]);
					this.vista2.txtApellidosEmpleadoModificar.setText(seleccionadoGeneral[1]);
					//obtengo los datos de la tabla de administrativo comparando el id EMpleado obtenido con el idEmpleadoFK de la tabla 
					String rellenarHuecoAdministrativo = this.modelo.rellenarTextModificarAdministrativo(conexion, cogerIdEmpleado[0]);
					String[] seleccionadoAdministrativo = rellenarHuecoAdministrativo.split(" / ");
					//obtengo los datos de la tabla de administrativo comparando el id EMpleado obtenido con el idEmpleadoFK de la tabla 
					String rellenarHuecoConductor = this.modelo.rellenarTextModificarConductor(conexion, cogerIdEmpleado[0]);
					String[] seleccionadoConductor = rellenarHuecoConductor.split(" / ");
					//Si no obtengo datos del array de administrativos quiere decir que el empleado es conductor
					if (seleccionadoAdministrativo[0].isEmpty() || seleccionadoAdministrativo[1].isEmpty())
						{
							this.vista2.txtTipoEmpleadoModificar.setText("Conductor");
							this.vista2.txtTipoEmpleadoModificar.setEnabled(false);
							this.vista2.txtIdiomaAdministrativoModificar.setEnabled(false);
							this.vista2.txtTituloAdministrativoModificar.setEnabled(false);
							this.vista2.txtCarnetConducirConductorModificar.setEnabled(true);
							this.vista2.txtCarnetConducirConductorModificar.setText(seleccionadoConductor[0]);
						}
					//Si no obtengo datos del array de conductores quiere decir que el empleado es administrativo
					if(seleccionadoConductor[0].isEmpty())
						{
							this.vista2.txtTipoEmpleadoModificar.setText("Administrativo");
							this.vista2.txtTipoEmpleadoModificar.setEnabled(false);
							this.vista2.txtCarnetConducirConductorModificar.setEnabled(false);
							this.vista2.txtIdiomaAdministrativoModificar.setEnabled(true);
							this.vista2.txtTituloAdministrativoModificar.setEnabled(true);
							this.vista2.txtIdiomaAdministrativoModificar.setText(seleccionadoAdministrativo[0]);
							this.vista2.txtTituloAdministrativoModificar.setText(seleccionadoAdministrativo[1]);
						}
					this.modelo.desconected(conexion);
				}
		
	//Volver desde ventana modificar empleado
		if(e.getSource().equals(this.vista2.btnModVolEmpleado))
			{
				this.vista2.frmModificarEmpleado.setVisible(false); 
				this.vista2.setVisible(true);
			}

	//Funcionalidad MODIFICAR TELÉFONO EMPLEADO
		if(e.getSource().equals(this.vista2.btnModEspecificoEmpleado))
			{	
				conexion = this.modelo.conectar();  
				String[] seleccionadoEspecifico = this.vista2.choModificarEmpleado.getSelectedItem().split(" / ");
				String modEspecifico = this.modelo.empleadoSeleccionadoEspecifico(conexion, seleccionadoEspecifico[0], this.vista2.txtTelefonoEmpleadoModificar.getText(), this.vista2.txtDniEmpleadoModificar.getText(), this.vista2.txtNombreEmpleadoModificar.getText(), this.vista2.txtDireccionEmpleadoModificar.getText(), this.vista2.txtApellidosEmpleadoModificar.getText());
				
				if (modEspecifico.equals("correcto"))
					{
						if(this.vista2.txtTipoEmpleadoModificar.getText().equals("Conductor"))
							{
								this.modelo.empleadoSeleccionadoEspecificoConductor(conexion, seleccionadoEspecifico[0], vista2.txtCarnetConducirConductorModificar.getText());
							}
						if(this.vista2.txtTipoEmpleadoModificar.getText().equals("Administrativo"))
							{
								this.modelo.empleadoSeleccionadoEspecificoAdministrativo(conexion, seleccionadoEspecifico[0], vista2.txtTituloAdministrativoModificar.getText(), this.vista2.txtIdiomaAdministrativoModificar.getText());
							}
						this.vista2.frmModificarEspecificoEmpleado.setVisible(false); 
						this.vista2.dlgModCorrectaEmpleado.setVisible(true);
					}
				else
					{
						this.vista2.frmModificarEspecificoEmpleado.setVisible(false); 
						this.vista2.dlgModErrorEmpleado.setVisible(true);
					}
				this.modelo.desconected(conexion);
			}
		
	// Volver a modificación desde modificar específica empleado
		if(e.getSource().equals(this.vista2.btnVolModEspEmpleado))
			{
				this.vista2.txtTelefonoEmpleadoModificar.setText(""); 
				this.vista2.txtDniEmpleadoModificar.setText("");
				this.vista2.txtNombreEmpleadoModificar.setText("");
				this.vista2.txtDireccionEmpleadoModificar.setText("");
				this.vista2.txtApellidosEmpleadoModificar.setText("");
				this.vista2.txtTipoEmpleadoModificar.setText("");
				this.vista2.txtIdiomaAdministrativoModificar.setText("");
				this.vista2.txtTituloAdministrativoModificar.setText("");
				this.vista2.txtCarnetConducirConductorModificar.setText("");
				this.vista2.frmModificarEspecificoEmpleado.setVisible(false); 
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
				this.vista2.frmModificarEspecificoEmpleado.setVisible(true);
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
				this.vista2.txaListadoEmpleadoConductores.setText(""); 
				String consultaConductores = this.modelo.consultaEmpleadoConductores();
				this.vista2.txaListadoEmpleadoConductores.append(consultaConductores);	
				this.vista2.txaListadoEmpleadoAdministrativos.setText(""); 
				String consultaAdministrativos = this.modelo.consultaEmpleadoAdministrativos();
				this.vista2.txaListadoEmpleadoAdministrativos.append(consultaAdministrativos);	
				this.modelo.desconected(conexion);
			}

	//Función del botón EXPORTAR PDF
		if (e.getSource().equals(this.vista2.btnPdfEmpleado))
			{
				conexion = this.modelo.conectar(); 
				String datos = this.modelo.consultaEmpleado(); 
				String datosConductores = this.modelo.consultaEmpleadoConductores(); 
				String datosAdministrativos = this.modelo.consultaEmpleadoAdministrativos(); 
				String consultaError = this.modelo.exportPdf(conexion, datos, datosConductores, datosAdministrativos); 
				
				//Diálogo si ha habido un error al exportar el documento 
				if(consultaError.equals("error"))
					{
						this.vista2.dialogoExportPdfMalEmpleado.setVisible(true);
					}
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
			
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
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
				this.vista2.frmAltaExplosivo.setVisible(true);
				conexion = this.modelo.conectar(); 
				this.vista2.choClienteExplosivo = (this.modelo.seleccionarClienteExplosivo(conexion, this.vista2.choClienteExplosivo));
				this.modelo.desconected(conexion);
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
				String[] seleccionClienteExplosivo = this.vista2.choClienteExplosivo.getSelectedItem().split("-");
				String altaExplosivoOk = this.modelo.crearExplosivo(conexion, this.vista2.txtTonelajeExplosivo.getText(), this.vista2.txtTipoExplosivo.getText(), this.vista2.txtPrecioExplosivo.getText(), seleccionClienteExplosivo[0]); 
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
			}

	//Función BAJA EXPLOSIVO
		if(e.getSource().equals(this.vista2.btnSiSeguroExplosivoBaja))
			{
				conexion = this.modelo.conectar(); 
				String[] seleccionadoExplosivo = this.vista2.choExplosivo.getSelectedItem().split("-"); 
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
				this.modelo.desconected(conexion);
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
				this.vista2.choClienteSeleccionado = (this.modelo.seleccionarClienteExplosivo(conexion, this.vista2.choClienteSeleccionado));
				this.modelo.desconected(conexion);
			}

	// Lanzar ventana MODIFICAR AVANZADA
		if(e.getSource().equals(this.vista2.btnModificarExplosivo))
			{
				this.vista2.frmModificarExplosivo.setVisible(false); 
				this.vista2.frmModificarExplosivoAvanzado.setVisible(true);
				conexion = this.modelo.conectar(); 
				String[] seleccionarExplosivoModificar = this.vista2.choClienteSeleccionado.getSelectedItem().split("-"); 
				this.vista2.choModificarExplosivo = this.modelo.elegirExplosivoModificar(conexion, this.vista2.choModificarExplosivo, seleccionarExplosivoModificar[0]);	
				this.modelo.desconected(conexion);
			}
		
	//Funcionalidad MODIFICAR avanzado
		if(e.getSource().equals(this.vista2.btnModTonelajeExplosivo))
			{
				
			}
		
	//Volver desde ventana de modificación avanzada
		if(e.getSource().equals(this.vista2.btnVolModTonExplosivo))
			{
				
				this.vista2.frmModificarExplosivoAvanzado.setVisible(false); 
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
				this.vista2.frmModificarExplosivoAvanzado. setVisible(true);
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
				this.modelo.desconected(conexion);
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
				this.modelo.desconected(conexion);
			}
	
	//Volver desde el diálogo error al exportar documento pdf explosivo
		if(e.getSource().equals(this.vista2.btnExportMalExplosivo))
			{
				this.vista2.dialogoExportPdfMalExplosivo.setVisible(false);
				this.vista2.frmConsultaExplosivo.setVisible(true);
			}
		
//CLIENTES-------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Ventana ALTA CLIENTE
			if(e.getSource().equals(this.vista2.mniAltaCliente))
				{
					this.vista2.setVisible(false); 
					this.vista2.frmAltaCliente.setVisible(true);
				}

		//Volver desde alta cliente
				if(e.getSource().equals(this.vista2.btnVolverGeneralAltaCliente))
					{
						this.vista2.frmAltaCliente.setVisible(false);
						this.vista2.setVisible(true);
					}

			//Función ALTA CLIENTE
				if(e.getSource().equals(this.vista2.btnAltaCliente))
					{
						conexion = this.modelo.conectar();
						String altaClienteOk = this.modelo.crearCliente(conexion, vista2.txtDireccionCliente.getText(), vista2.txtNombreCliente.getText(), vista2.txtCorreoElectronicoCliente.getText(), vista2.txtTelefonoCliente.getText(), vista2.txtCodigoPostalCliente.getText());
						if(altaClienteOk.equals("correcto"))
							{
								this.vista2.dialogoAltaClienteBien.setVisible(true);
							}
						else
							{
								this.vista2.dialogoAltaClienteMal.setVisible(true);
							}
						this.modelo.desconected(conexion);
					}
				
			//Volver desde diálogo de correcto alta Cliente
				if(e.getSource().equals(this.vista2.btnCorrectoAltaClienteVolver))
					{
						this.vista2.txtDireccionCliente.setText(""); 
						this.vista2.txtNombreCliente.setText(""); 
						this.vista2.txtCorreoElectronicoCliente.setText(""); 
						this.vista2.txtTelefonoCliente.setText(""); 
						this.vista2.txtCodigoPostalCliente.setText(""); 
						this.vista2.dialogoAltaClienteBien.setVisible(false); 
						this.vista2.frmAltaCliente.setVisible(false); 
						this.vista2.setVisible(true); 	
					}
				
			//Volver desde el diálogo error alta cliente
				if(e.getSource().equals(this.vista2.btnErrorAltaClienteVolver))
					{
						this.vista2.dialogoAltaClienteMal.setVisible(false); 
						this.vista2.frmAltaCliente.setVisible(true);
					}
				
			//Lanzar ventana BAJA de Cliente
				if(e.getSource().equals(this.vista2.mniBajaCliente))
					{
						this.vista2.setVisible(false); 
						this.vista2.dlgSeguroClienteBaja.setVisible(false);
						this.vista2.frmBajaCliente.setVisible(true);
					}
			
			//Volver desde ventana de baja cliente
				if(e.getSource().equals(this.vista2.btnVolverGeneralBajaCliente))
					{
						this.vista2.frmBajaCliente.setVisible(false); 
						this.vista2.setVisible(true);
					}

			//Dialogo sí está seguro de borrar al cliente
				if(e.getSource().equals(this.vista2.btnBajaCliente))
					{
						this.vista2.dlgSeguroClienteBaja.setVisible(true);
					}
			
			//Rellenar el desplegable para elegir al cliente que desea borrar
				if(e.getSource().equals(this.vista2.mniBajaCliente))
					{
						conexion = this.modelo.conectar(); 
						this.vista2.choCliente = (this.modelo.borrarCliente(conexion, this.vista2.choCliente));
						this.modelo.desconected(conexion);
					}
			
			//Funcionalidad BAJA CLIENTE
				if(e.getSource().equals(this.vista2.btnSiSeguroClienteBaja))
					{
						conexion = this.modelo.conectar(); 
						String[] seleccionadoCliente = this.vista2.choCliente.getSelectedItem().split("-"); 
						String borrarCliente = this.modelo.eliminarCliente(conexion, seleccionadoCliente[0]);
						
						if(borrarCliente.equals("correcto"))
							{
								this.vista2.frmBajaCliente.setVisible(false); 
								this.vista2.dlgSeguroClienteBaja.setVisible(false); 
								this.vista2.dialogoBajaClienteBien.setVisible(true);
							}					
						else
							{
								this.vista2.frmBajaCliente.setVisible(false); 
								this.vista2.dlgSeguroClienteBaja.setVisible(false); 
								this.vista2.dialogoBajaClienteMal.setVisible(true);
							}
						this.modelo.desconected(conexion);
					}
				
			// Volver desde el diálogo de baja correcta del cliente
				if(e.getSource().equals(this.vista2.btnCorrectoBajaClienteVolver))
					{
						this.vista2.dialogoBajaClienteBien.setVisible(false);
						this.vista2.dlgSeguroClienteBaja.setVisible(false);
						this.vista2.setVisible(true);
					}

			//Volver desde el diálogo de pregunta seguridad baja cliente
				if(e.getSource().equals(this.vista2.btnNoSeguroClienteBaja))
					{
						this.vista2.dlgSeguroClienteBaja.setVisible(false); 
						this.vista2.frmBajaCliente.setVisible(true);
					}
				
			//Volver desde el diálogo de error en la baja del cliente
				if(e.getSource().equals(this.vista2.btnErrorBajaClienteVolver))
					{
						this.vista2.dialogoBajaClienteMal.setVisible(false); 
						this.vista2.dlgSeguroClienteBaja.setVisible(false);
						this.vista2.frmBajaCliente.setVisible(true);
					}
				
				//Lanzar ventana MODIFICACIÓN CLIENTE
				if(e.getSource().equals(this.vista2.mniModificacionCliente))
					{
						this.vista2.frmModificarCliente.setVisible(true); 
						this.vista2.setVisible(false); 
						conexion = this.modelo.conectar(); 
						this.vista2.choModificarCliente = this.modelo.elegirClienteModificar(conexion, this.vista2.choModificarCliente);
						this.modelo.desconected(conexion);
						
					}
				
				//Lanzar pantalla modificación especifico Cliente
					if(e.getSource().equals(this.vista2.btnModificarCliente))
						{
							this.vista2.frmModificarCliente.setVisible(false);
							this.vista2.frmModificarEspecificoCliente.setVisible(true); 
							//utilizo este array para obtener el numero de idCliente, así pasarselo posteriormente al modelo y poder relacionar los datos entre las tablas
							String[] cogerIdCliente = this.vista2.choModificarCliente.getSelectedItem().split(" / ");
							conexion = this.modelo.conectar();
							//obtengo todos los datos delCliente seleccionado en el choice
							String rellenarHueco = this.modelo.rellTextModiCliente(conexion, cogerIdCliente[0]);
							String[] seleccionado = rellenarHueco.split(" / ");
							this.vista2.txtDireccionClienteModificar.setText(seleccionado[1]); 
							this.vista2.txtNombreClienteModificar.setText(seleccionado[0]);
							this.vista2.txtCorreoElectronicoClienteModificar.setText(seleccionado[2]);
							this.vista2.txtTelefonoClienteModificar.setText(seleccionado[3]);
							this.vista2.txtCodigoPostalClienteModificar.setText(seleccionado[4]);
							this.modelo.desconected(conexion);
						}
				
			//Volver desde ventana modificar cliente
				if(e.getSource().equals(this.vista2.btnModVolCliente))
					{
						this.vista2.frmModificarCliente.setVisible(false); 
						this.vista2.setVisible(true);
					}

			//Funcionalidad MODIFICAR CLIENTE
				if(e.getSource().equals(this.vista2.btnModificarClienteNuevo))
					{	
						conexion = this.modelo.conectar();  
						String[] seleccionadoCliente = this.vista2.choModificarCliente.getSelectedItem().split(" / ");
						String modCliente = this.modelo.modificarCliente(conexion, seleccionadoCliente[0], this.vista2.txtDireccionClienteModificar.getText(), this.vista2.txtNombreClienteModificar.getText(), this.vista2.txtCorreoElectronicoClienteModificar.getText(), this.vista2.txtTelefonoClienteModificar.getText(), this.vista2.txtCodigoPostalClienteModificar.getText());
						
						if (modCliente.equals("correcto"))
							{
								this.vista2.frmModificarEspecificoCliente.setVisible(false); 
								this.vista2.dlgModCorrectaCliente.setVisible(true);
							}
						else
							{
								this.vista2.frmModificarEspecificoCliente.setVisible(false); 
								this.vista2.dlgModErrorCliente.setVisible(true);
							}
						this.modelo.desconected(conexion);
					}
				
			// Volver a modificación desde modificar específica cliente
				if(e.getSource().equals(this.vista2.btnVolModEspEmpleado))
					{
						this.vista2.txtDireccionClienteModificar.setText(""); 
						this.vista2.txtNombreClienteModificar.setText("");
						this.vista2.txtCorreoElectronicoClienteModificar.setText("");
						this.vista2.txtTelefonoClienteModificar.setText("");
						this.vista2.txtCodigoPostalClienteModificar.setText("");
						this.vista2.frmModificarEspecificoCliente.setVisible(false); 
						this.vista2.frmModificarCliente.setVisible(true);
					}
			
			//Volver desde el diálogo de modificación correcta
				if(e.getSource().equals(this.vista2.btnModVolDialogoCorrectaCliente))
					{
						this.vista2.dlgModCorrectaCliente.setVisible(false); 
						this.vista2.frmModificarCliente.setVisible(true);
					}

			//Volver desde el diálogo de modificación errónea
				if(e.getSource().equals(this.vista2.btnModVolDialogoErrorEmpleado))
					{
						this.vista2.dlgModErrorCliente.setVisible(false); 
						this.vista2.frmModificarEspecificoCliente.setVisible(true);
					}
				
		//CONSULTA CAMIONES
				
			//Lanzar ventana CONSULTA CLIENTE
				if(e.getSource().equals(this.vista2.mniConsultaCliente))
					{
						this.vista2.setVisible(false); 
						this.vista2.frmConsultaCliente.setVisible(true);
					}
					
			// Volver desde consulta de cliente
				if(e.getSource().equals(this.vista2.btnVolverConsultaCliente))
					{
						this.vista2.frmConsultaCliente.setVisible(false);
						this.vista2.setVisible(true);
					}

			//Funcionalidad CONSULTA CAMIÓN
				if(e.getSource().equals(this.vista2.mniConsultaCliente))
					{
						conexion = this.modelo.conectar(); 
						this.vista2.txalistadoCliente.setText(""); 
						String consultaClien = this.modelo.consultaCliente(); 
						this.vista2.txalistadoCliente.append(consultaClien);
						this.modelo.desconected(conexion);
					}
		
			//Función EXPORTAR PDF CLIENTES
				if(e.getSource().equals(this.vista2.btnPdfCliente))
					{
						conexion = this.modelo.conectar(); 
						String datosCliente = this.modelo.consultaCliente();
						String consultaErrorCliente = this.modelo.exportarPdfCliente(conexion, datosCliente); 
						//ventana diálogo si ha habido un error al exportar el documento 
						if(consultaErrorCliente.equals("error"))
							{
								this.vista2.dialogoExportPdfMalCliente.setVisible(true);
							}
						this.modelo.desconected(conexion);
					}
			
			//Volver desde el diálogo error al exportar documento pdf cliente
				if(e.getSource().equals(this.vista2.btnExportMalCliente))
					{
						this.vista2.dialogoExportPdfMalCliente.setVisible(false);
						this.vista2.frmConsultaCliente.setVisible(true);
					}
	}

	@Override
	public void itemStateChanged(ItemEvent ie) 
	{
		if(ie.getSource().equals(this.vista2.choModificarExplosivo))
			{
				this.vista2.txtTonelajeExplosivoModificar.setText("");
				this.vista2.txtTipoExplosivoModificar.setText("");
				this.vista2.txtPrecioExplosivoModificar.setText("");
				conexion = this.modelo.conectar(); 
				String[] seleccionarExplosivoModificar = this.vista2.choClienteSeleccionado.getSelectedItem().split("-"); 
				this.vista2.choModificarExplosivo = this.modelo.elegirExplosivoModificar(conexion, this.vista2.choModificarExplosivo, seleccionarExplosivoModificar[0]);
				String[] explosivoElegido = this.vista2.choModificarExplosivo.getSelectedItem().split(" / "); 
				this.vista2.txtTonelajeExplosivoModificar.setText(explosivoElegido[1]);
				this.vista2.txtTipoExplosivoModificar.setText(explosivoElegido[2]);
				this.vista2.txtPrecioExplosivoModificar.setText(explosivoElegido[3]);	
				this.modelo.desconected(conexion);
			}
			
	}
	 

}
	
	


