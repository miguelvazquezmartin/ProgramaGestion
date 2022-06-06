package Progr_Gestion;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.TextField;

public class pantallaMenu 
{
	private static final int CENTER = 0;

	Frame vista2 = new Frame("Menú Principal");
	
	//ALTA EMPLEADOS (objetos)
	
		Frame frmAltaEmpleado = new Frame("Alta nuevo Empleado");
		Label lblTelefonoEmpleado = new Label("Teléfono Empleado"); 
		Label lblDniEmpleado = new Label("DNI del Empleado"); 
		Label lblNombreEmpleado = new Label("Nombre del Empleado"); 
		Label lblDireccionEmpleado = new Label("Dirección del Empleado"); 
		Label lblApellidosEmpleado = new Label("Apellidos del Empleado"); 
		Label lblCorrectAltaEmpleado = new Label("Se ha realizado el alta"); 
		Label lblErrorAltaEmpleado = new Label("Se ha producido un error en el alta"); 
		TextField txtTelefonoEmpleado = new TextField(20); 
		TextField txtDniEmpleado = new TextField(20); 
		TextField txtNombreEmpleado = new TextField(20);
		TextField txtDireccionEmpleado = new TextField(20); 
		TextField txtApellidosEmpleado = new TextField(20); 
		Dialog dialogoAltaEmpleadoBien = new Dialog(frmAltaEmpleado, "Correcto");
		Dialog dialogoAltaEmpleadoMal = new Dialog(frmAltaEmpleado, "Error"); 
		Button btnAltaEmpleado = new Button("Crear Empleado"); 
		Button btnCorrectoAltaEmpleadoVolver = new Button("Aceptar"); 
		Button btnErrorAltaEmpleadoVolver = new Button("Volver"); 
		Button btnVolverGeneralAltaEmpleado = new Button("Volver");
		
	//BAJA EMPLEADOS (obietos)
		
		Frame frmBajaEmpleado = new Frame("Baja Empleado"); 
		Choice choEmpleado = new Choice(); 
		Label lblCorrectBajaEmpleado = new Label("Se ha realizado la baja"); 
		Label lblErrorBajaEmpleado = new Label("se ha producido un error en la baja");
		Label lblSeguroEmpleadoBaja = new Label("Estás seguro?");
		Dialog dialogoBajaEmpleadoBien = new Dialog(frmBajaEmpleado, "Correcto"); 
		Dialog dialogoBajaEmpleadoMal = new Dialog(frmBajaEmpleado, "Error"); 
		Dialog dlgSeguroEmpleadoBaja = new Dialog(frmBajaEmpleado, "¿Seguro?", true); 
		Button btnBajaEmpleado = new Button("Borrar Empleado"); 
		Button btnCorrectoBajaEmpleadoVolver = new Button("Volver"); 
		Button btnErrorBajaEmpleadoVolver = new Button("Volver"); 
		Button btnVolverGeneralBajaEmpleado = new Button("Volver"); 
		Button btnSiSeguroEmpleadoBaja = new Button ("Si");
		Button btnNoSeguroEmpleadoBaja = new Button("No");
		
	//MODIFICAR EMPLEADOS (objetos)
		
		Frame frmModificarEmpleado = new Frame ("Modificar Empleado"); 
		Choice choModificarEmpleado = new Choice();
		Choice choSeleccionarCampo = new Choice(); 
		Label lblChoSelecEmpleado = new Label("Selecciona el empleado"); 
		Label lblChoSelecCampo = new Label("Selecciona el campo"); 
		Button btnModificarEmpleado = new Button("Modificar");
		Button btnModVolEmpleado = new Button("Volver"); 
		Dialog dlgModCorrectaEmpleado = new Dialog(frmModificarEmpleado, "Correcto"); 
		Label lblModCorrectaEmpleado = new Label("Modificación realizada con éxito");
		Dialog dlgModErrorEmpleado = new Dialog(frmModificarEmpleado, "Error");
		Label lblModErrorEmpleado = new Label("Hubo un error en la modificación"); 
		Button btnModVolDialogoCorrectaEmpleado = new Button("Aceptar");
		Button btnModVolDialogoErrorEmpleado = new Button("Volver");

		//Ventana Modificación telefono Empleado (objetos) 
		Frame frmModificarTelefonoEmpleado = new Frame ("Modificar teléfono"); 
		Label lblNuevoTelefonoEmpleado = new Label("Introduce el nuevo teléfono"); 
		TextField txtNuevoTelefonoEmpleado = new TextField(10);
		Button btnModTelefonoEmpleado = new Button("Modificar");
		Button btnVolModTelEmpleado = new Button("Volver");
		
		//Ventana Modificación Dirección Empleado (objetos) 
		Frame frmModificarDireccionEmpleado = new Frame ("Modificar Dirección"); 
		Label lblNuevaDireccionEmpleado = new Label("Introduce la nueva dirección"); 
		TextField txtNuevaDireccionEmpleado = new TextField(10); 
		Button btnModDireccionEmpleado = new Button("Modificar"); 
		Button btnVolModDirEmpleado = new Button ("Volver");
		
	//CONSULTA EMPLEADOS (objetos)
		
		Frame frmConsultaEmpleado = new Frame("Consulta Empoleados"); 
		TextArea txaListadoEmpleado = new TextArea(10, 40); 
		Button btnPdfEmpleado = new Button("Exportar a PDF");
		Button btnVolverConsultaEmpleado = new Button("Volver");
		Dialog dialogoExportPdfMalEmpleado = new Dialog(frmConsultaEmpleado, "Error");
		Label lblExportPdfEmpleadoMal = new Label("Ha habido un error"); 
		Button btnExportMalEmpleado = new Button("Aceptar");
	
	//ALTA CAMIONES (objetos)
		
		Frame frmAltaCamion = new Frame("Alta Camiones");
		Label lblCapacidadCamion = new Label("Capacidad del Camión");
		Label lblMarcaCamion = new Label("Marca del Camión"); 
		Label lblAnioCompraCamion = new Label("Año de Compra del Camión"); 
		Label lblMatriculaCamion = new Label("Matrícula del Camión"); 
		Label lblModeloCamion = new Label("Modelo del Camión"); 
		Label lblCorrectAltaCamion = new Label("Se ha realizado el alta");
		Label lblErrorAltaCamion = new Label("se ha producido un error en el alta"); 
		TextField txtCapacidadCamion = new TextField(15); 
		TextField txtMarcaCamion = new TextField (15);
		TextField txtAnioCompraCamion = new TextField(15); 
		TextField txtMatriculaCamion = new TextField(15); 
		TextField txtModeloCamion = new TextField(15); 
		Dialog dialogoAltaCamionBien = new Dialog(frmAltaCamion, "Correcto"); 
		Dialog dialogoAltaCamionMal = new Dialog(frmAltaCamion, "Error"); 
		Button btnAltaCamion = new Button("Crear Camion");
		Button btnCorrectoAltaCamionVolver = new Button("Aceptar"); 
		Button btnErrorAltaCamionVolver = new Button("Volver"); 
		Button btnVolverGeneralAltaCamion = new Button("Volver");
		
	//BAJA CAMIONES (objetos)
		
		Frame frmBajaCamion = new Frame("Baja Camion"); 
		Choice choCamion = new Choice(); 
		Label lblCorrectBajaCamion = new Label("se ha realizado la baja");
		Label lblErrorBajaCamion = new Label("se ha producido un error en la baja");
		Label lblSeguroCamionBaja = new Label("¿Estás seguro de borrar?"); 
		Dialog dialogoBajaCamionBien = new Dialog(frmBajaCamion, "Correcto"); 
		Dialog dialogoBajaCamionMal = new Dialog(frmBajaCamion, "Error"); 
		Dialog dlgSeguroCamionBaja = new Dialog(frmBajaCamion, "¿Seguro?", true); 
		Button btnBajaCamion = new Button("Borrar Camion");
		Button btnCorrectoBajaCamionVolver = new Button("Aceptar");
		Button btnErrorBajaCamionVolver = new Button("Volver"); 
		Button btnVolverGeneralBajaCamion = new Button("Volver"); 
		Button btnSiSeguroCamionBaja = new Button("Si");
		Button btnNoSeguroCamionBaja = new Button("No");
		
	//MODIFICACION CAMIONES (objetos)
	
		Frame frmModificarCamion = new Frame ("Modificar Camión"); 
		Choice choModificarCamion = new Choice(); 
		Choice choSeleccionarCampoCamion = new Choice();
		Label lblChoSelecCamion = new Label("Selecciona el Camión"); 
		Label lblChoSelecCampoCamion = new Label("Selecciona el campo"); 
		Button btnModificarCamion = new Button("Modificar"); 
		Button btnModVolCamion = new Button("Volver"); 
		Dialog dlgModCorrectaCamion = new Dialog(frmModificarCamion, "Correcto");
		Label lblModCorrectaCamion = new Label("Modificacion realizada correctamente");
		Dialog dlgModErrorCamion = new Dialog(frmModificarCamion, "Error"); 
		Label lblModErrorCamion = new Label("Hubo un error en la modificación"); 
		Button btnModVolDialogoCorrectaCamion = new Button("Aceptar"); 
		Button btnModVolDialogoErrorCamion = new Button("Volver");
		
		//Ventana Modificación Capacidad Camión (objetos) 
		Frame frmModificarCapacidadCamion = new Frame("Modificar Capacidad"); 
		Label lblNuevoCapacidadCamion = new Label("Introduce la nueva capacidad"); 
		TextField txtNuevoCapacidadCamion = new TextField(10); 
		Button btnModCapacidadCamion = new Button("Modificar");
		Button btnVolModCapCamion = new Button("Volver");
		
	//CONSULTA CAMIONES (obejtos)
		
		Frame frmConsultaCamion = new Frame("Consulta Camiones"); 
		TextArea txalistadoCamion = new TextArea(10, 40); 
		Button btnPdfCamion = new Button("Exportar a PDF");
		Button btnVolverConsultaCamion = new Button("Volver");
		
		Dialog dialogoExportPdfMalCamion = new Dialog(frmConsultaCamion, "Error"); 
		Label lblExportPdfCamionMal = new Label("Ha habido un error");
		Button btnExportMalCamion = new Button("Aceptar");
	
	//ALTA EXPLOSIVOS (objetos)
		
		Frame frmAltaExplosivo = new Frame("Alta Explosivos"); 
		Label lblTonelajeExplosivo = new Label("Tonelaje (kg)"); 
		Label lblTipoExplosivo = new Label("Tipo"); 
		Label lblPrecioExplosivo = new Label("Precio"); 
		Label lblCorrectAltaExplosivo = new Label("Se ha realizado el alta"); 
		Label lblErrorAltaExplosivo = new Label("Se ha producido un error en el alta"); 
		TextField txtTonelajeExplosivo = new TextField(15); 
		TextField txtTipoExplosivo = new TextField(15); 
		TextField txtPrecioExplosivo = new TextField(15); 
		Dialog dialogoAltaExplosivoBien = new Dialog(frmAltaExplosivo, "Correcto"); 
		Dialog dialogoAltaExplosivoMal = new Dialog(frmAltaExplosivo, "Error");
		Button btnAltaExplosivo = new Button("Crear Explosivo"); 
		Button btnCorrectoAltaExplosivoVolver = new Button("Aceptar"); 
		Button btnErrorAltaExplosivoVolver = new Button("Volver");
		Button btnVolverGeneralAltaExplosivo = new Button("Volver");
	
	//BAJA EXPLOSIVOS (objetos)
		Frame frmBajaExplosivo = new Frame("Baja Explosivo"); 
		Choice choExplosivo = new Choice();
		Label lblCorrectBajaExplosivo = new Label("Se ha realizado la baja");
		Label lblErrorBajaExplosivo = new Label("Se ha producido un error en la baja"); 
		Label lblSeguroExplosivoBaja = new Label("¿Estás segurgo?");
		Dialog dialogoBajaExplosivoBien = new Dialog(frmBajaExplosivo, "Correcto");
		Dialog dialogoBajaExplosivoMal = new Dialog(frmBajaExplosivo, "Error"); 
		Dialog dlgSeguroExplosivoBaja = new Dialog(frmBajaExplosivo, "¿Seguro?", true); 
		Button btnBajaExplosivo = new Button ("Borrar Explosivo");
		Button btnCorrectoBajaExplosivoVolver = new Button("Aceptar"); 
		Button btnErrorBajaExplosivoVolver = new Button("Volver");
		Button btnVolverGeneralBajaExplosivo = new Button("Volver");
		Button btnSiSeguroExplosivoBaja = new Button("Si"); 
		Button btnNoSeguroExplosivoBaja = new Button("NO");
				
	//MODIFICACION EXPLOSIVOS (objetos)
				
		Frame frmModificarExplosivo = new Frame ("Modificar explosivo"); 
		Choice choModificarExplosivo = new Choice(); 
		Choice choSeleccionarCampoExplosivo = new Choice(); 
		Label lblChoSelecExplosivo = new Label("Selecciona el explosivo"); 
		Label lblChoSelecCampoExplosivo = new Label("Selecciona el campo"); 
		Button btnModificarExplosivo = new Button("Modificar"); 
		Button btnModVolExplosivo = new Button("Volver");
		Dialog dlgModCorrectaExplosivo = new Dialog(frmModificarExplosivo, "Correcto");
		Label lblModCorrectaExplosivo = new Label("Modificación realizada correctamente");
		Dialog dlgModErrorExplosivo = new Dialog(frmModificarExplosivo, "Error");
		Label lblModErrorExplosivo = new Label("Hubo un error en la modificación");
		Button btnModVolDialogoCorrectaExplosivo = new Button("Aceptar");
		Button btnModVolDialogoErrorExplosivo = new Button("Volver");
				
		//Ventana Modificación TONELAJE (objetos) 
		Frame frmModificarTonelajeExplosivo = new Frame("Modificar tonelaje"); 
		Label lblNuevoTonelajeExplosivo = new Label("Introduce el nuevo tonelaje");
		TextField txtNuevoTonelajeExplosivo = new TextField(10); 
		Button btnModTonelajeExplosivo = new Button("Modificar");
		Button btnVolModTonExplosivo = new Button("Volver");
		
		//Ventana Modificación PRECIO (objetos) 
		Frame frmModificarPrecioExplosivo = new Frame("Modificar precio");
		Label lblNuevoPrecioExplosivo = new Label("Introduce el nuevo precio"); 
		TextField txtNuevoPrecioExplosivo = new TextField(10);
		Button btnModPrecioExplosivo = new Button("Modificar"); 
		Button btnVolModPreExplosivo = new Button("Volver");
	
	//CONSULTA EXPLOSIVOS (objetos)
		
		Frame frmConsultaExplosivo = new Frame("Consulta Explosivos"); 
		TextArea txalistadoExplosivo = new TextArea(10, 40); 
		Button btnPdfExplosivo = new Button("Exportar a PDF");
		Button btnVolverConsultaExplosivo = new Button("Volver");
		Dialog dialogoExportPdfMalExplosivo = new Dialog(frmConsultaExplosivo, "Error"); 
		Label lblExportPdfExplosivoMal = new Label("Ha habido un error");
		Button btnExportMalExplosivo = new Button("Aceptar");
		
	//MENU BAR VENTANA PRINCIPAL
		
		MenuBar mnBar = new MenuBar();
		Menu mnuEmpleados = new Menu("Empleados");
		MenuItem mniAltaEmpleado = new MenuItem("Alta");
		MenuItem mniBajaEmpleado = new MenuItem("Baja");
		MenuItem mniModificacionEmpleado = new MenuItem("Modificación");
		MenuItem mniConsultaEmpleado = new MenuItem("Consulta");
		Menu mnuCamiones = new Menu("Camiones"); 
		MenuItem mniAltaCamion = new MenuItem("Alta");
		MenuItem mniBajaCamion = new MenuItem("Baja"); 
		MenuItem mniModificacionCamion = new MenuItem("Modificación"); 
		MenuItem mniConsultaCamion= new MenuItem("Consulta");
		Menu mnuExplosivos = new Menu("Explosivos"); 
		MenuItem mniAltaExplosivo = new MenuItem("Alta");
		MenuItem mniBajaExplosivo = new MenuItem("Baja"); 
		MenuItem mniModificacionExplosivo = new MenuItem("Modificación"); 
		MenuItem mniConsultaExplosivo = new MenuItem("Consulta");
		

		public pantallaMenu()
		{
			//Añadir los objetos a las ventanas correspondientes
		
		//MENÚ BAR
			vista2.setLayout(new FlowLayout());
			
			mnuEmpleados.add(mniAltaEmpleado);
			mnuEmpleados.add(mniBajaEmpleado); 
			mnuEmpleados.add(mniModificacionEmpleado); 
			mnuEmpleados.add(mniConsultaEmpleado);
			mnBar.add(mnuEmpleados);
			mnuCamiones.add(mniAltaCamion);
			mnuCamiones.add(mniBajaCamion); 
			mnuCamiones.add(mniModificacionCamion); 
			mnuCamiones.add(mniConsultaCamion); 
			mnBar.add(mnuCamiones);
			mnuExplosivos.add(mniAltaExplosivo); 
			mnuExplosivos.add(mniBajaExplosivo);
			mnuExplosivos.add(mniModificacionExplosivo);
			mnuExplosivos.add(mniConsultaExplosivo); 
			mnBar.add(mnuExplosivos);
			vista2.setMenuBar(mnBar); 
			vista2.setSize(250, 150); 
			vista2.setResizable(false); 
			vista2.setLocationRelativeTo(null);
			
//EMPLEADOS-------------------------------------------------------------------------------------------
		
		//ALTA EMPLEADO
			
			frmAltaEmpleado.setLayout(new FlowLayout()); 
			frmAltaEmpleado.add(lblTelefonoEmpleado);
			frmAltaEmpleado.add(txtTelefonoEmpleado);
			frmAltaEmpleado.add(lblDniEmpleado); 
			frmAltaEmpleado.add(txtDniEmpleado); 
			frmAltaEmpleado.add(lblNombreEmpleado); 
			frmAltaEmpleado.add(txtNombreEmpleado); 
			frmAltaEmpleado.add(lblDireccionEmpleado);
			frmAltaEmpleado.add(txtDireccionEmpleado); 
			frmAltaEmpleado.add(lblApellidosEmpleado); 
			frmAltaEmpleado.add(txtApellidosEmpleado); 
			frmAltaEmpleado.add(lblCorrectAltaEmpleado); 
			frmAltaEmpleado.add(lblErrorAltaEmpleado); 
			frmAltaEmpleado.add(btnAltaEmpleado); 
			frmAltaEmpleado.add(btnCorrectoAltaEmpleadoVolver); 
			frmAltaEmpleado.add(btnErrorAltaEmpleadoVolver); 
			frmAltaEmpleado.add(btnVolverGeneralAltaEmpleado);
			frmAltaEmpleado.setVisible(false); 
			frmAltaEmpleado.setSize(400,210); 
			frmAltaEmpleado.setLocationRelativeTo(null); 
			frmAltaEmpleado.setResizable(false);
			
			//Diálogo alta correcta 
			this.dialogoAltaEmpleadoBien.setLayout(new FlowLayout());
			this.dialogoAltaEmpleadoBien.add(lblCorrectAltaEmpleado); 
			this.dialogoAltaEmpleadoBien.add(btnCorrectoAltaEmpleadoVolver);
			this.dialogoAltaEmpleadoBien.setSize(180,70); 
			this.dialogoAltaEmpleadoBien.setResizable(false); 
			this.dialogoAltaEmpleadoBien.setLocationRelativeTo(null); 
			this.dialogoAltaEmpleadoBien.setUndecorated(true); 
			this.dialogoAltaEmpleadoBien.setBackground(Color.GRAY);
			
			
			//Diálogo error en el alta 
			this.dialogoAltaEmpleadoMal.setLayout(new FlowLayout()); 
			this.dialogoAltaEmpleadoMal.add(lblErrorAltaEmpleado);
			this.dialogoAltaEmpleadoMal.add(btnErrorAltaEmpleadoVolver);
			this.dialogoAltaEmpleadoMal.setSize(230,70); 
			this.dialogoAltaEmpleadoMal.setResizable(false); 
			this.dialogoAltaEmpleadoMal.setLocationRelativeTo(null); 
			this.dialogoAltaEmpleadoMal.setUndecorated(true);
			this.dialogoAltaEmpleadoMal.setBackground(Color.GRAY);
			
			
		//BAJA EMPLEADO
			
			frmBajaEmpleado.setLayout(new FlowLayout()); 
			frmBajaEmpleado.add(choEmpleado); 
			choEmpleado.add("Elige al Empleado que quiere borrar"); 
			frmBajaEmpleado.add(lblCorrectBajaEmpleado); 
			frmBajaEmpleado.add(lblErrorBajaEmpleado); 
			frmBajaEmpleado.add(btnBajaEmpleado); 
			frmBajaEmpleado.add(btnCorrectoBajaEmpleadoVolver); 
			frmBajaEmpleado.add(btnErrorBajaEmpleadoVolver); 
			frmBajaEmpleado.add(btnVolverGeneralBajaEmpleado); 
			frmBajaEmpleado.add(btnSiSeguroEmpleadoBaja); 
			frmBajaEmpleado.add(btnNoSeguroEmpleadoBaja);
			frmBajaEmpleado.setSize(250, 100); 
			frmBajaEmpleado.setResizable(false); 
			frmBajaEmpleado.setLocationRelativeTo(null); 
			frmBajaEmpleado.setVisible(false);
			
			//Diálogo baja empleado correcta
			this.dialogoBajaEmpleadoBien.setLayout(new FlowLayout());
			this.dialogoBajaEmpleadoBien.add(lblCorrectBajaEmpleado); 
			this.dialogoBajaEmpleadoBien.add(btnCorrectoBajaEmpleadoVolver);
			this.dialogoBajaEmpleadoBien.setSize(180,70); 
			this.dialogoBajaEmpleadoBien.setResizable(false);
			this.dialogoBajaEmpleadoBien.setLocationRelativeTo(null); 
			this.dialogoBajaEmpleadoBien.setUndecorated(true); 
			this.dialogoBajaEmpleadoBien.setBackground(Color.GRAY);
			
			
			//Diálogo error en la baia empleado 
			this.dialogoBajaEmpleadoMal.setLayout(new FlowLayout());
			this.dialogoBajaEmpleadoMal.add(lblErrorBajaEmpleado);
			this.dialogoBajaEmpleadoMal.add(btnErrorBajaEmpleadoVolver);
			this.dialogoBajaEmpleadoMal.setSize(280,70); 
			this.dialogoBajaEmpleadoMal.setResizable(false); 
			this.dialogoBajaEmpleadoMal.setLocationRelativeTo(null); 
			this.dialogoBajaEmpleadoMal.setUndecorated(true); 
			this.dialogoBajaEmpleadoMal.setBackground(Color.GRAY);
			
			
			//Pregunta si esta seguro de BORRAR al Empleado
			this.dlgSeguroEmpleadoBaja.setLayout(new FlowLayout()); 
			this.dlgSeguroEmpleadoBaja.add(lblSeguroEmpleadoBaja);
			this.dlgSeguroEmpleadoBaja.add(btnSiSeguroEmpleadoBaja); 
			this.dlgSeguroEmpleadoBaja.add(btnNoSeguroEmpleadoBaja);
			this.dlgSeguroEmpleadoBaja.setSize(110,70);
			this.dlgSeguroEmpleadoBaja.setResizable(false); 
			this.dlgSeguroEmpleadoBaja.setLocationRelativeTo(null); 
			this.dlgSeguroEmpleadoBaja.setUndecorated(true); 
			this.dlgSeguroEmpleadoBaja.setBackground (Color.GRAY);
			
			
		//MODIFICACIAR EMPLEADO
			
			frmModificarEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));
			frmModificarEmpleado.add(lblChoSelecEmpleado); 
			frmModificarEmpleado.add(choModificarEmpleado); 
			frmModificarEmpleado.add(lblChoSelecCampo); 
			frmModificarEmpleado.add(choSeleccionarCampo); 
			choSeleccionarCampo.add("Teléfono"); 
			choSeleccionarCampo.add("Dirección"); 
			frmModificarEmpleado.add(btnModificarEmpleado); 
			frmModificarEmpleado.add(btnModVolEmpleado);
			frmModificarEmpleado.setSize(280,150); 
			frmModificarEmpleado.setResizable(false); 
			frmModificarEmpleado.setLocationRelativeTo(null); 
			frmModificarEmpleado. setVisible(false);
			
			//MODIFICAR TELEFONO EMPLEADO
			
			frmModificarTelefonoEmpleado.setLayout(new FlowLayout()); 
			frmModificarTelefonoEmpleado.add(lblNuevoTelefonoEmpleado); 
			frmModificarTelefonoEmpleado.add(txtNuevoTelefonoEmpleado); 
			frmModificarTelefonoEmpleado.add(btnModTelefonoEmpleado); 
			frmModificarTelefonoEmpleado.add(btnVolModTelEmpleado); 
			frmModificarTelefonoEmpleado.setSize(300,130); 
			frmModificarTelefonoEmpleado.setResizable(false); 
			frmModificarTelefonoEmpleado.setLocationRelativeTo(null); 
			frmModificarTelefonoEmpleado.setVisible(false);
			
			//MODIFICAR DIRECCION EMPLEADO
			
			frmModificarDireccionEmpleado.setLayout(new FlowLayout()); 
			frmModificarDireccionEmpleado.add(lblNuevaDireccionEmpleado);
			frmModificarDireccionEmpleado.add(txtNuevaDireccionEmpleado); 
			frmModificarDireccionEmpleado.add(btnModDireccionEmpleado); 
			frmModificarDireccionEmpleado.add(btnVolModDirEmpleado); 
			frmModificarDireccionEmpleado.setSize(300, 100); 
			frmModificarDireccionEmpleado.setResizable(false); 
			frmModificarDireccionEmpleado.setLocationRelativeTo(null); 
			frmModificarDireccionEmpleado.setVisible(false);
			
			//Diálogo modificación correcta empleado 
			this.dlgModCorrectaEmpleado.setLayout(new FlowLayout()); 
			this.dlgModCorrectaEmpleado.add(lblModCorrectaEmpleado);
			this.dlgModCorrectaEmpleado.add(btnModVolDialogoCorrectaEmpleado);
			this.dlgModCorrectaEmpleado.setSize(180,70); 
			this.dlgModCorrectaEmpleado.setResizable(false); 
			this.dlgModCorrectaEmpleado.setLocationRelativeTo(null);
			this.dlgModCorrectaEmpleado.setUndecorated(true);
			this.dlgModCorrectaEmpleado.setBackground(Color.GRAY);
			
			
			//Diálogo modificación error empleado 
			this.dlgModErrorEmpleado.setLayout(new FlowLayout());
			this.dlgModErrorEmpleado.add(lblModErrorEmpleado); 
			this.dlgModErrorEmpleado.add(btnModVolDialogoErrorEmpleado);
			this.dlgModErrorEmpleado.setSize(180,70); 
			this.dlgModErrorEmpleado.setResizable(false); 
			this.dlgModErrorEmpleado.setLocationRelativeTo(null);
			this.dlgModErrorEmpleado.setUndecorated(true); 
			this.dlgModErrorEmpleado.setBackground(Color.GRAY);
			
			
		//CONSULTA EMPLEADOS
			
			frmConsultaEmpleado.setLayout(new FlowLayout()); 
			frmConsultaEmpleado.add(txaListadoEmpleado); 
			frmConsultaEmpleado.add(btnPdfEmpleado); 
			frmConsultaEmpleado.add(btnVolverConsultaEmpleado);
			frmConsultaEmpleado.setSize(480, 250); 
			frmConsultaEmpleado.setResizable(false); 
			frmConsultaEmpleado.setLocationRelativeTo(null); 
			frmConsultaEmpleado.setVisible(false);
			
			
			//Diálogo error exportar pdf 
			this.dialogoExportPdfMalEmpleado.setLayout(new FlowLayout());
			this.dialogoExportPdfMalEmpleado.add(lblExportPdfEmpleadoMal);
			this.dialogoExportPdfMalEmpleado.add(btnExportMalEmpleado);
			this.dialogoExportPdfMalEmpleado.setSize(180, 70);
			this.dialogoExportPdfMalEmpleado.setResizable(false); 
			this.dialogoExportPdfMalEmpleado.setLocationRelativeTo(null); 
			this.dialogoExportPdfMalEmpleado.setUndecorated(true); 
			this.dialogoExportPdfMalEmpleado.setBackground(Color.GRAY);
			
//CAMIONES-----------------------------------------------------------------------------------------------------------------------------------
			
		//ALTA CAMIONES
			
			frmAltaCamion.setLayout(new FlowLayout());
			frmAltaCamion.add(lblCapacidadCamion);
			frmAltaCamion.add(txtCapacidadCamion); 
			frmAltaCamion.add(lblMarcaCamion); 
			frmAltaCamion.add(txtMarcaCamion); 
			frmAltaCamion.add(lblAnioCompraCamion); 
			frmAltaCamion.add(txtAnioCompraCamion); 
			frmAltaCamion.add(lblMatriculaCamion); 
			frmAltaCamion.add(txtMatriculaCamion); 
			frmAltaCamion.add(lblModeloCamion); 
			frmAltaCamion.add(txtModeloCamion); 
			frmAltaCamion.add(btnAltaCamion); 
			frmAltaCamion.add(btnCorrectoAltaCamionVolver); 
			frmAltaCamion.add(btnVolverGeneralAltaCamion);
			frmAltaCamion.setSize(400,220); 
			frmAltaCamion.setResizable(false); 
			frmAltaCamion.setLocationRelativeTo(null); 
			frmAltaCamion.setVisible(false);
			
			//Dialogo alta correcta camión 
			this.dialogoAltaCamionBien.setLayout(new FlowLayout()); 
			this.dialogoAltaCamionBien.add(lblCorrectAltaCamion);
			this.dialogoAltaCamionBien.add(btnCorrectoAltaCamionVolver);
			this.dialogoAltaCamionBien.setSize(180,70);
			this.dialogoAltaCamionBien.setResizable(false); 
			this.dialogoAltaCamionBien.setLocationRelativeTo(null); 
			this.dialogoAltaCamionBien.setUndecorated(true); 
			this.dialogoAltaCamionBien.setBackground(Color.GRAY);
			
			
			//Diálogo error en el alta camion 
			this.dialogoAltaCamionMal.setLayout(new FlowLayout()); 
			this.dialogoAltaCamionMal.add(lblErrorAltaCamion); 
			this.dialogoAltaCamionMal.add(btnErrorAltaCamionVolver);
			this.dialogoAltaCamionMal.setSize(200,70); 
			this.dialogoAltaCamionMal.setResizable(false); 
			this.dialogoAltaCamionMal.setLocationRelativeTo(null); 
			this.dialogoAltaCamionMal.setUndecorated(true); 
			this.dialogoAltaCamionMal.setBackground(Color.GRAY);
			
			
		//BAJA CAMIONES
			
			frmBajaCamion.setLayout(new FlowLayout());
			frmBajaCamion.add(choCamion); 
			choCamion.add("Elige el Camión que quiere borrar"); 
			frmBajaCamion.add(lblCorrectBajaCamion); 
			frmBajaCamion.add(lblErrorBajaCamion); 
			frmBajaCamion.add(btnBajaCamion); 
			frmBajaCamion.add(btnCorrectoBajaCamionVolver);
			frmBajaCamion.add(btnErrorBajaCamionVolver); 
			frmBajaCamion.add(btnVolverGeneralBajaCamion); 
			frmBajaCamion.add(btnSiSeguroCamionBaja); 
			frmBajaCamion.add(btnNoSeguroCamionBaja);
			frmBajaCamion.setSize(250, 100); 
			frmBajaCamion.setResizable(false); 
			frmBajaCamion.setLocationRelativeTo(null); 
			frmBajaCamion.setVisible(false);
			
			//Diálogo baja camión correcta 
			this.dialogoBajaCamionBien.setLayout(new FlowLayout()); 
			this.dialogoBajaCamionBien.add(lblCorrectBajaCamion); 
			this.dialogoBajaCamionBien.add(btnCorrectoBajaCamionVolver);
			this.dialogoBajaCamionBien.setSize(180,70); 
			this.dialogoBajaCamionBien.setResizable(false); 
			this.dialogoBajaCamionBien.setLocationRelativeTo(null); 
			this.dialogoBajaCamionBien.setUndecorated(true); 
			this.dialogoBajaCamionBien.setBackground(Color.GRAY);
			
			
			//Diálogo error baja camión 
			this.dialogoBajaCamionMal.setLayout(new FlowLayout());
			this.dialogoBajaCamionMal.add(lblErrorBajaCamion); 
			this.dialogoBajaCamionMal.add(btnErrorBajaCamionVolver);
			this.dialogoBajaCamionMal.setSize(288,70);
			this.dialogoBajaCamionMal.setResizable(false);
			this.dialogoBajaCamionMal.setLocationRelativeTo(null); 
			this.dialogoBajaCamionMal.setUndecorated(true); 
			this.dialogoBajaCamionMal.setBackground(Color.GRAY);
			
			
			//Pregunta si está seguro de BORRAR al camión 
			this.dlgSeguroCamionBaja.setLayout(new FlowLayout()); 
			this.dlgSeguroCamionBaja.add(lblSeguroCamionBaja); 
			this.dlgSeguroCamionBaja.add(btnSiSeguroCamionBaja); 
			this.dlgSeguroCamionBaja.add(btnNoSeguroCamionBaja);
			this.dlgSeguroCamionBaja.setSize(150,70); 
			this.dlgSeguroCamionBaja.setResizable(false); 
			this.dlgSeguroCamionBaja.setLocationRelativeTo(null); 
			this.dlgSeguroCamionBaja.setUndecorated(true); 
			this.dlgSeguroCamionBaja.setBackground(Color.GRAY);
			
			
		//MODIFICACION CAMIONES
		
			frmModificarCamion.setLayout(new FlowLayout(FlowLayout.CENTER));
			frmModificarCamion.add(lblChoSelecCamion); 
			frmModificarCamion.add(choModificarCamion); 
			frmModificarCamion.add(lblChoSelecCampoCamion);
			frmModificarCamion.add(choSeleccionarCampoCamion); 
			choSeleccionarCampoCamion.add("Capacidad"); 
			frmModificarCamion.add(btnModificarCamion);
			frmModificarCamion.add(btnModVolCamion); 
			frmModificarCamion.setSize(270,150); 
			frmModificarCamion.setResizable(false);
			frmModificarCamion.setLocationRelativeTo(null);
			frmModificarCamion.setVisible(false);
			
			// Ventana modificar capacidad Camion 
			frmModificarCapacidadCamion.setLayout(new FlowLayout()); 
			frmModificarCapacidadCamion.add(lblNuevoCapacidadCamion);
			frmModificarCapacidadCamion.add(txtNuevoCapacidadCamion);
			frmModificarCapacidadCamion.add(btnModCapacidadCamion);
			frmModificarCapacidadCamion.add(btnVolModCapCamion);
			frmModificarCapacidadCamion.setSize(300,130); 
			frmModificarCapacidadCamion.setResizable(false);
			frmModificarCapacidadCamion.setLocationRelativeTo(null); 
			frmModificarCapacidadCamion.setVisible(false);
			
			//Diálogo modificación correcta camion 
			this.dlgModCorrectaCamion.setLayout(new FlowLayout()); 
			this.dlgModCorrectaCamion.add(lblModCorrectaCamion); 
			this.dlgModCorrectaCamion.add(btnModVolDialogoCorrectaCamion);
			this.dlgModCorrectaCamion.setSize(220,70); 
			this.dlgModCorrectaCamion.setResizable(false);
			this.dlgModCorrectaCamion.setLocationRelativeTo(null); 
			this.dlgModCorrectaCamion.setUndecorated (true); 
			this.dlgModCorrectaCamion.setBackground(Color.GRAY);
			
			
			//Dialogo error modificación camión 
			this.dlgModErrorCamion.setLayout(new FlowLayout()); 
			this.dlgModErrorCamion.add(lblModErrorCamion); 
			this.dlgModErrorCamion.add(btnModVolDialogoErrorCamion);
			this.dlgModErrorCamion.setSize(200,70);
			this.dlgModErrorCamion.setResizable(false); 
			this.dlgModErrorCamion.setLocationRelativeTo(null); 
			this.dlgModErrorCamion.setUndecorated(true); 
			this.dlgModErrorCamion.setBackground(Color.GRAY);
			
			
		//CONSULTA CAMIONES
		
			frmConsultaCamion.setLayout(new FlowLayout()); 
			frmConsultaCamion.add(txalistadoCamion);
			frmConsultaCamion.add(btnPdfCamion); 
			frmConsultaCamion.add(btnVolverConsultaCamion);
			frmConsultaCamion.setSize(480, 250); 
			frmConsultaCamion.setResizable(false); 
			frmConsultaCamion.setLocationRelativeTo(null); 
			frmConsultaCamion.setVisible(false);
			
			
			//Diálogo error exportar camión pdf 
			this.dialogoExportPdfMalCamion.setLayout(new FlowLayout());
			this.dialogoExportPdfMalCamion.add(lblExportPdfCamionMal);
			this.dialogoExportPdfMalCamion.add(btnExportMalCamion);
			this.dialogoExportPdfMalCamion.setSize(280,70);
			this.dialogoExportPdfMalCamion.setResizable(false);
			this.dialogoExportPdfMalCamion.setLocationRelativeTo(null); 
			this.dialogoExportPdfMalCamion.setUndecorated(true); 
			this.dialogoExportPdfMalCamion.setBackground(Color.GRAY);
			

//EXPLOSIVOS----------------------------------------------------------------------------------------------------------------------------------------
			
		//ALTA EXPLOSIVOS
			
			frmAltaExplosivo.setLayout(new FlowLayout()); 
			frmAltaExplosivo.add(lblTonelajeExplosivo);
			frmAltaExplosivo.add(txtTonelajeExplosivo); 
			frmAltaExplosivo.add(lblTipoExplosivo); 
			frmAltaExplosivo.add(txtTipoExplosivo); 
			frmAltaExplosivo.add(lblPrecioExplosivo); 
			frmAltaExplosivo.add(txtPrecioExplosivo);
			frmAltaExplosivo.add(btnAltaExplosivo); 
			frmAltaExplosivo.add(btnCorrectoAltaExplosivoVolver);
			frmAltaExplosivo.add(btnVolverGeneralAltaExplosivo);
			frmAltaExplosivo.setSize(220, 240); 
			frmAltaExplosivo.setResizable(false);
			frmAltaExplosivo.setLocationRelativeTo(null); 
			frmAltaExplosivo.setVisible(false);
			
			//Diálogo alta correcta explosivos 
			this.dialogoAltaExplosivoBien.setLayout(new FlowLayout()); 
			this.dialogoAltaExplosivoBien.add(lblCorrectAltaExplosivo); 
			this.dialogoAltaExplosivoBien.add(btnCorrectoAltaExplosivoVolver);
			this.dialogoAltaExplosivoBien.setSize(180,70);
			this.dialogoAltaExplosivoBien.setResizable(false); 
			this.dialogoAltaExplosivoBien.setLocationRelativeTo(null); 
			this.dialogoAltaExplosivoBien.setUndecorated(true); 
			this.dialogoAltaExplosivoBien.setBackground(Color.GRAY);
			
			
			//Diálogo error alta explosivos 
			this.dialogoAltaExplosivoMal.setLayout(new FlowLayout()); 
			this.dialogoAltaExplosivoMal.add(lblErrorAltaExplosivo); 
			this.dialogoAltaExplosivoMal.add(btnErrorAltaExplosivoVolver);
			this.dialogoAltaExplosivoMal.setSize(200,70); 
			this.dialogoAltaExplosivoMal.setResizable(false);
			this.dialogoAltaCamionMal.setLocationRelativeTo(null);
			this.dialogoAltaExplosivoMal.setUndecorated(true); 
			this.dialogoAltaExplosivoMal.setBackground(Color.GRAY);
			
			
			
		//BAJA EXPLOSIVOS
		
			frmBajaExplosivo.setLayout(new FlowLayout()); 
			frmBajaExplosivo.add(choExplosivo);
			choExplosivo.add("Elige el explosivo que quiere borrar"); 
			frmBajaExplosivo.add(lblCorrectBajaExplosivo); 
			frmBajaExplosivo.add(lblErrorBajaExplosivo); 
			frmBajaExplosivo.add(btnBajaExplosivo); 
			frmBajaExplosivo.add(btnCorrectoBajaExplosivoVolver); 
			frmBajaExplosivo.add(btnErrorBajaExplosivoVolver);
			frmBajaExplosivo.add(btnVolverGeneralBajaExplosivo); 
			frmBajaExplosivo.add(btnSiSeguroExplosivoBaja); 
			frmBajaExplosivo.add(btnNoSeguroExplosivoBaja);
			frmBajaExplosivo.setSize(220,120); 
			frmBajaExplosivo.setResizable(false); 
			frmBajaExplosivo.setLocationRelativeTo(null); 
			frmBajaExplosivo. setVisible(false);
			
			//Dialogo baja explosivo correcta 
			this.dialogoBajaExplosivoBien.setLayout(new FlowLayout()); 
			this.dialogoBajaExplosivoBien.add(lblCorrectBajaExplosivo); 
			this.dialogoBajaExplosivoBien.add(btnCorrectoBajaExplosivoVolver);
			this.dialogoBajaExplosivoBien.setSize(180,70); 
			this.dialogoBajaExplosivoBien.setResizable(false);
			this.dialogoBajaExplosivoBien.setLocationRelativeTo(null);
			this.dialogoBajaExplosivoBien.setUndecorated(true);
			this.dialogoBajaExplosivoBien.setBackground(Color.GRAY);
			
			
			//Diálogo baja explosivo error 
			this.dialogoBajaExplosivoMal.setLayout(new FlowLayout());
			this.dialogoBajaExplosivoMal.add(lblErrorBajaExplosivo);
			this.dialogoBajaExplosivoMal.add(btnErrorBajaExplosivoVolver);
			this.dialogoBajaExplosivoMal.setSize(180,70); 
			this.dialogoBajaExplosivoMal.setResizable(false);
			this.dialogoBajaExplosivoMal.setLocationRelativeTo(null); 
			this.dialogoBajaExplosivoMal.setUndecorated(true); 
			this.dialogoBajaExplosivoMal.setBackground(Color.GRAY);
			
			
			//Pregunta sí está seguro de BORRAR el explosivo 
			this.dlgSeguroExplosivoBaja.setLayout(new FlowLayout()); 
			this.dlgSeguroExplosivoBaja.add(lblSeguroExplosivoBaja); 
			this.dlgSeguroExplosivoBaja.add(btnSiSeguroExplosivoBaja); 
			this.dlgSeguroExplosivoBaja.add(btnNoSeguroExplosivoBaja);
			this.dlgSeguroExplosivoBaja.setSize(120,70); 
			this.dlgSeguroExplosivoBaja.setResizable(false); 
			this.dlgSeguroExplosivoBaja.setLocationRelativeTo(null); 
			this.dlgSeguroExplosivoBaja.setUndecorated(true); 
			this.dlgSeguroExplosivoBaja.setBackground(Color.GRAY);
			
		//MODIFICACIÓN EXPLOSIVOS
		
			frmModificarExplosivo.setLayout(new FlowLayout(FlowLayout.CENTER));
			frmModificarExplosivo.add(lblChoSelecExplosivo); 
			frmModificarExplosivo.add(choModificarExplosivo);
			frmModificarExplosivo.add(lblChoSelecCampoExplosivo);
			frmModificarExplosivo.add(choSeleccionarCampoExplosivo);
			choSeleccionarCampoExplosivo.add("Tonelaje");
			choSeleccionarCampoExplosivo.add("Precio");
			frmModificarExplosivo.add(btnModificarExplosivo); 
			frmModificarExplosivo.add(btnModVolExplosivo); 
			frmModificarExplosivo.setSize(270,150); 
			frmModificarExplosivo.setResizable(false); 
			frmModificarExplosivo.setLocationRelativeTo(null); 
			frmModificarExplosivo.setVisible(false);
			
			//Ventana modificar TONELAJE expclosivo 
			frmModificarTonelajeExplosivo.setLayout(new FlowLayout()); 
			frmModificarTonelajeExplosivo.add(lblNuevoTonelajeExplosivo);
			frmModificarTonelajeExplosivo.add(txtNuevoTonelajeExplosivo); 
			frmModificarTonelajeExplosivo.add(btnModTonelajeExplosivo); 
			frmModificarTonelajeExplosivo.add(btnVolModTonExplosivo);
			frmModificarTonelajeExplosivo.setSize(300,130);
			frmModificarTonelajeExplosivo.setResizable(false); 
			frmModificarTonelajeExplosivo.setLocationRelativeTo(null); 
			frmModificarTonelajeExplosivo.setVisible(false);

			//Ventana modificar PRECIO explosivo 
			frmModificarPrecioExplosivo.setLayout(new FlowLayout()); 
			frmModificarPrecioExplosivo.add(lblNuevoPrecioExplosivo);
			frmModificarPrecioExplosivo.add(txtNuevoPrecioExplosivo);
			frmModificarPrecioExplosivo.add(btnModPrecioExplosivo); 
			frmModificarPrecioExplosivo.add(btnVolModPreExplosivo);
			frmModificarPrecioExplosivo.setSize(300,130); 
			frmModificarPrecioExplosivo.setResizable(false);
			frmModificarPrecioExplosivo.setLocationRelativeTo(null);
			frmModificarPrecioExplosivo.setVisible(false);
			
			//Dialogo modificación correcta explosivo 
			this.dlgModCorrectaExplosivo.setLayout(new FlowLayout()); 
			this.dlgModCorrectaExplosivo.add(lblModCorrectaExplosivo); 
			this.dlgModCorrectaExplosivo.add(btnModVolDialogoCorrectaExplosivo);
			this.dlgModCorrectaExplosivo.setSize(180,70); 
			this.dlgModCorrectaExplosivo.setResizable(false); 
			this.dlgModCorrectaExplosivo.setLocationRelativeTo(null); 
			this.dlgModCorrectaExplosivo.setUndecorated(true);
			this.dlgModCorrectaExplosivo.setBackground(Color.GRAY);
			
			
			//Diálogo modificación error explosivo 
			this.dlgModErrorExplosivo.setLayout(new FlowLayout()); 
			this.dlgModErrorExplosivo.add(lblModErrorExplosivo); 
			this.dlgModErrorExplosivo.add(btnModVolDialogoErrorExplosivo);
			this.dlgModErrorExplosivo.setSize(190,70);
			this.dlgModErrorExplosivo.setResizable(false); 
			this.dlgModErrorExplosivo.setLocationRelativeTo(null);
			this.dlgModErrorExplosivo.setUndecorated(true); 
			this.dlgModErrorExplosivo.setBackground(Color.GRAY);
			
		//CONSULTA EXPLOSIVOS
			
			frmConsultaExplosivo.setLayout(new FlowLayout()); 
			frmConsultaExplosivo.add(txalistadoExplosivo); 
			frmConsultaExplosivo.add(btnPdfExplosivo); 
			frmConsultaExplosivo.add(btnVolverConsultaExplosivo);
			frmConsultaExplosivo.setSize(480,250); 
			frmConsultaExplosivo.setResizable(false); 
			frmConsultaExplosivo.setLocationRelativeTo(null);
			frmConsultaExplosivo.setVisible(false);
			
			
			//Diálogo exportar pdf explosivo 
			this.dialogoExportPdfMalExplosivo.setLayout(new FlowLayout());
			this.dialogoExportPdfMalExplosivo.add(lblExportPdfExplosivoMal); 
			this.dialogoExportPdfMalExplosivo.add(btnExportMalExplosivo);
			this.dialogoExportPdfMalExplosivo.setSize(200,70);
			this.dialogoExportPdfMalExplosivo.setResizable(false);
			this.dialogoExportPdfMalExplosivo.setLocationRelativeTo(null);
			this.dialogoExportPdfMalExplosivo.setUndecorated(true); 
			this.dialogoExportPdfMalExplosivo.setBackground(Color.GRAY);
			
			
		}
			public void setVisible(boolean b)
			{
				vista2.setVisible(b);
			}

}
