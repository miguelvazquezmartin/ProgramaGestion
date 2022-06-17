package Progr_Gestion;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

public class pantallaMenu 
{

	Frame vista2 = new Frame("Menú Principal");


//EMPLEADOS----------------------------------------------------------------------------------------------------------	

	//ALTA EMPLEADOS (objetos)
	
		Frame frmPreAltaEmpleado = new Frame("Alta nuevo Empleado");
		Label lblPreAltaEmpleado = new Label("Seleccione el tipo de empleado"); 
		Choice choTipoEmpleado = new Choice();
		Button btnPreAltaEmpleado = new Button("Siguiente");
		Button btnVolverPreAltaEmpleado = new Button("Volver");
		Frame frmAltaEmpleado = new Frame("Alta nuevo Empleado");
		Label lblTelefonoEmpleado = new Label("Teléfono Empleado"); 
		Label lblDniEmpleado = new Label("DNI del Empleado"); 
		Label lblNombreEmpleado = new Label("Nombre del Empleado"); 
		Label lblDireccionEmpleado = new Label("Dirección del Empleado"); 
		Label lblApellidosEmpleado = new Label("Apellidos del Empleado"); 
		Label lblCorrectAltaEmpleado = new Label("Se ha realizado el alta"); 
		Label lblErrorAltaEmpleado = new Label("Se ha producido un error en el alta"); 
		TextField txtTelefonoEmpleado = new TextField(15); 
		TextField txtDniEmpleado = new TextField(15); 
		TextField txtNombreEmpleado = new TextField(15);
		TextField txtDireccionEmpleado = new TextField(15); 
		TextField txtApellidosEmpleado = new TextField(15); 
		Dialog dialogoAltaEmpleadoBien = new Dialog(frmAltaEmpleado, "Correcto");
		Dialog dialogoAltaEmpleadoMal = new Dialog(frmAltaEmpleado, "Error"); 
		Button btnAltaEmpleado = new Button("Crear Empleado"); 
		Button btnCorrectoAltaEmpleadoVolver = new Button("Aceptar"); 
		Button btnErrorAltaEmpleadoVolver = new Button("Volver"); 
		Button btnVolverGeneralAltaEmpleado = new Button("Volver");
		
		//segunda parte
		
		Panel panelConductor = new Panel();
		Panel panelAdministrativo = new Panel();
		Panel prePanelAlta = new Panel();
		Label lblCarnetConducirConductor = new Label("Carnet de conducir");
		Label lblTipoEmpleadoAdministrativo = new Label("Administrativo");
		Label lblTipoEmpleadoConductor = new Label("Conductor");
		TextField txtCarnetConducirConductor = new TextField(6);
		Label lblIdiomaAdministrativo = new Label("Idioma"); 
		TextField txtIdiomaAdministrativo = new TextField(6);
		Label lblTituloAdministrativo = new Label("Titulo"); 
		TextField txtTituloAdministrativo = new TextField(6);
		
		
		
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
		Label lblChoSelecEmpleado = new Label("Selecciona el empleado"); 
		Button btnModificarEmpleado = new Button("Siguiente");
		Button btnModVolEmpleado = new Button("Volver"); 
		Dialog dlgModCorrectaEmpleado = new Dialog(frmModificarEmpleado, "Correcto"); 
		Label lblModCorrectaEmpleado = new Label("Modificación realizada con éxito");
		Dialog dlgModErrorEmpleado = new Dialog(frmModificarEmpleado, "Error");
		Label lblModErrorEmpleado = new Label("Hubo un error en la modificación"); 
		Button btnModVolDialogoCorrectaEmpleado = new Button("Aceptar");
		Button btnModVolDialogoErrorEmpleado = new Button("Volver");

		//Ventana Modificación específica Empleado (objetos) 
		Frame frmModificarEspecificoEmpleado = new Frame ("Modificar empleado"); 
		Label lblTelefonoEmpleadoModificar = new Label("Modificar Teléfono Empleado"); 
		Label lblDniEmpleadoModificar = new Label("Modificar DNI del Empleado"); 
		Label lblNombreEmpleadoModificar = new Label("Modificar Nombre del Empleado"); 
		Label lblDireccionEmpleadoModificar = new Label("Modificar Dirección del Empleado"); 
		Label lblApellidosEmpleadoModificar = new Label("Modificar Apellidos del Empleado"); 
		Label lblCorrectAltaEmpleadoModificar = new Label("Se ha realizado el alta"); 
		Label lblErrorAltaEmpleadoModificar = new Label("Se ha producido un error en el alta"); 
		TextField txtTelefonoEmpleadoModificar = new TextField(20); 
		TextField txtDniEmpleadoModificar = new TextField(20); 
		TextField txtNombreEmpleadoModificar = new TextField(20);
		TextField txtDireccionEmpleadoModificar = new TextField(20); 
		TextField txtApellidosEmpleadoModificar = new TextField(20);
		TextField txtTipoEmpleadoModificar = new TextField(20);
		Label lblCarnetConducirConductorModificar = new Label("Carnet de conducir");
		TextField txtCarnetConducirConductorModificar = new TextField(20);
		Label lblIdiomaAdministrativoModificar = new Label("Idioma  Aministrativo"); 
		TextField txtIdiomaAdministrativoModificar = new TextField(20);
		Label lblTituloAdministrativoModificar = new Label("Titulo Aministrativo"); 
		TextField txtTituloAdministrativoModificar = new TextField(20);
		Button btnModEspecificoEmpleado = new Button("Modificar");
		Button btnVolModEspEmpleado = new Button("Volver");
		
	//CONSULTA EMPLEADOS (objetos)
		
		Frame frmConsultaEmpleado = new Frame("Consulta Empoleados"); 
		TextArea txaListadoEmpleado = new TextArea(5, 40); 
		TextArea txaListadoEmpleadoConductores = new TextArea(5, 40); 
		TextArea txaListadoEmpleadoAdministrativos = new TextArea(5, 40); 
		Label lblListadoEmpleado = new Label("Datos genéricos de los empleados"); 
		Label lblListadoEmpleadoConductores = new Label("Datos de los empleados conductores"); 
		Label lblListadoEmpleadoAdministrativos = new Label("Datos de los empleados administrativos"); 
		Button btnPdfEmpleado = new Button("Exportar a PDF");
		Button btnVolverConsultaEmpleado = new Button("Volver");
		Dialog dialogoExportPdfMalEmpleado = new Dialog(frmConsultaEmpleado, "Error");
		Label lblExportPdfEmpleadoMal = new Label("Ha habido un error"); 
		Button btnExportMalEmpleado = new Button("Aceptar");

//CAMIONES-----------------------------------------------------------------------------------------------------------------------------------------
		
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
		
		
//EXPLOSIVOS ------------------------------------------------------------------------------------------------------------------------------------------
		
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
		Choice choClienteExplosivo = new Choice();
		Label lblClienteExplosivo = new Label("Seleccionar Cliente"); 
		Panel panelAltaExplosivo = new Panel();
	
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
		Label lblChoSelecExplosivo = new Label("Selecciona el explosivo"); 
		Button btnModificarExplosivo = new Button("Modificar"); 
		Button btnModVolExplosivo = new Button("Volver");
		Dialog dlgModCorrectaExplosivo = new Dialog(frmModificarExplosivo, "Correcto");
		Label lblModCorrectaExplosivo = new Label("Modificación realizada correctamente");
		Dialog dlgModErrorExplosivo = new Dialog(frmModificarExplosivo, "Error");
		Label lblModErrorExplosivo = new Label("Hubo un error en la modificación");
		Button btnModVolDialogoCorrectaExplosivo = new Button("Aceptar");
		Button btnModVolDialogoErrorExplosivo = new Button("Volver");
				
		//Ventana modificación avanzada
		Frame frmModificarExplosivoAvanzado = new Frame("Modificar Explosivo"); 
		Label lblChoClienteSeleccionado = new Label("Selecciona al cliente para ver sus explosivos"); 
		Choice choClienteSeleccionado = new Choice();
		Label lblTonelajeExplosivoModificar = new Label("Tonelaje (kg)"); 
		Label lblTipoExplosivoModificar = new Label("Tipo"); 
		Label lblPrecioExplosivoModificar = new Label("Precio"); 
		TextField txtTonelajeExplosivoModificar = new TextField(15); 
		TextField txtTipoExplosivoModificar = new TextField(15); 
		TextField txtPrecioExplosivoModificar = new TextField(15); 
		Button btnModTonelajeExplosivo = new Button("Modificar");
		Button btnVolModTonExplosivo = new Button("Volver");
		
		
	
	//CONSULTA EXPLOSIVOS (objetos)
		
		Frame frmConsultaExplosivo = new Frame("Consulta Explosivos"); 
		TextArea txalistadoExplosivo = new TextArea(10, 40); 
		Button btnPdfExplosivo = new Button("Exportar a PDF");
		Button btnVolverConsultaExplosivo = new Button("Volver");
		Dialog dialogoExportPdfMalExplosivo = new Dialog(frmConsultaExplosivo, "Error"); 
		Label lblExportPdfExplosivoMal = new Label("Ha habido un error");
		Button btnExportMalExplosivo = new Button("Aceptar");
		
//CLIENTES ------------------------------------------------------------------------------------------------------------------------------------
	
	//ALTA CLIENTES
		
		Frame frmAltaCliente = new Frame("Alta Cliente");
		Label lblDireccionCliente = new Label("Dirección del cliente");
		Label lblNombreCliente = new Label("Nombre del cliente"); 
		Label lblCorreoElectronicoCliente = new Label("Correo electrónico del cliente"); 
		Label lblTelefonoCliente = new Label("Teléfono del cliente"); 
		Label lblCodigoPostalCliente = new Label("Código postal cliente"); 
		Label lblCorrectAltaCliente = new Label("Se ha realizado el alta");
		Label lblErrorAltaCliente = new Label("se ha producido un error en el alta"); 
		TextField txtDireccionCliente = new TextField(15); 
		TextField txtNombreCliente = new TextField (15);
		TextField txtCorreoElectronicoCliente = new TextField(15); 
		TextField txtTelefonoCliente = new TextField(15);  
		TextField txtCodigoPostalCliente = new TextField(15);  
		Dialog dialogoAltaClienteBien = new Dialog(frmAltaCliente, "Correcto"); 
		Dialog dialogoAltaClienteMal = new Dialog(frmAltaCliente, "Error"); 
		Button btnAltaCliente = new Button("Crear Cliente");
		Button btnCorrectoAltaClienteVolver = new Button("Aceptar"); 
		Button btnErrorAltaClienteVolver = new Button("Volver"); 
		Button btnVolverGeneralAltaCliente = new Button("Volver");
		
	//BAJA CLIENTES
		
		Frame frmBajaCliente = new Frame("Baja Cliente"); 
		Choice choCliente = new Choice(); 
		Label lblCorrectBajaCliente = new Label("se ha realizado la baja");
		Label lblErrorBajaCliente = new Label("se ha producido un error en la baja");
		Label lblSeguroClienteBaja = new Label("¿Estás seguro de borrar?"); 
		Dialog dialogoBajaClienteBien = new Dialog(frmBajaCliente, "Correcto"); 
		Dialog dialogoBajaClienteMal = new Dialog(frmBajaCliente, "Error"); 
		Dialog dlgSeguroClienteBaja = new Dialog(frmBajaCliente, "¿Seguro?", true); 
		Button btnBajaCliente = new Button("Borrar cliente");
		Button btnCorrectoBajaClienteVolver = new Button("Aceptar");
		Button btnErrorBajaClienteVolver = new Button("Volver"); 
		Button btnVolverGeneralBajaCliente = new Button("Volver"); 
		Button btnSiSeguroClienteBaja = new Button("Si");
		Button btnNoSeguroClienteBaja = new Button("No");
	
	//MODIFICACIÓN CLIENTE
		
		Frame frmModificarCliente = new Frame ("Modificar Empleado"); 
		Choice choModificarCliente = new Choice();
		Label lblChoSelecCliente = new Label("Selecciona el empleado"); 
		Button btnModificarCliente = new Button("Siguiente");
		Button btnModVolCliente = new Button("Volver"); 
		Dialog dlgModCorrectaCliente = new Dialog(frmModificarEmpleado, "Correcto"); 
		Label lblModCorrectaCliente = new Label("Modificación realizada con éxito");
		Dialog dlgModErrorCliente = new Dialog(frmModificarEmpleado, "Error");
		Label lblModErrorCliente = new Label("Hubo un error en la modificación"); 
		Button btnModVolDialogoCorrectaCliente = new Button("Aceptar");
		Button btnModVolDialogoErrorCliente = new Button("Volver");
		
		Frame frmModificarEspecificoCliente = new Frame ("Modificar cliente"); 
		Label lblDireccionClienteModificar = new Label("Dirección del cliente");
		Label lblNombreClienteModificar = new Label("Nombre del cliente"); 
		Label lblCorreoElectronicoClienteModificar = new Label("Correo electrónico del cliente"); 
		Label lblTelefonoClienteModificar = new Label("Teléfono del cliente"); 
		Label lblCodigoPostalClienteModificar = new Label("Código postal cliente"); 
		Label lblCorrectAltaClienteModificar = new Label("Se ha realizado el alta");
		Label lblErrorAltaClienteModificar = new Label("se ha producido un error en el alta"); 
		TextField txtDireccionClienteModificar = new TextField(15); 
		TextField txtNombreClienteModificar = new TextField (15);
		TextField txtCorreoElectronicoClienteModificar = new TextField(15); 
		TextField txtTelefonoClienteModificar = new TextField(15);  
		TextField txtCodigoPostalClienteModificar = new TextField(15);  
		Button btnModificarClienteNuevo = new Button("Modificar");
		Button btnVolModCliente = new Button("Volver");
		
	//CONSULKTA CLIENTES
		
		Frame frmConsultaCliente = new Frame("Consulta Clientes"); 
		TextArea txalistadoCliente = new TextArea(10, 40); 
		Button btnPdfCliente = new Button("Exportar a PDF");
		Button btnVolverConsultaCliente = new Button("Volver");
		
		Dialog dialogoExportPdfMalCliente = new Dialog(frmConsultaCliente, "Error"); 
		Label lblExportPdfClienteMal = new Label("Ha habido un error");
		Button btnExportMalCliente = new Button("Aceptar");
	
	//VENTANA INFORMACIÓN
		
		Frame frmInformacion = new Frame("CopyRight");
		Label lblNombreInformacion = new Label("Miguel Vázquez Martín");
		Label lblAnioInformacion = new Label("2022");
		Label lblCopy = new Label("© CopyRight");
		Button btnVolverInformacion = new Button("Volver");
		
		
		
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
		MenuItem mniModificacionExplosivo  = new MenuItem("Modificación"); 
		MenuItem mniConsultaExplosivo  = new MenuItem("Consulta");
		Menu mnuClientes = new Menu("Clientes"); 
		MenuItem mniAltaCliente = new MenuItem("Alta");
		MenuItem mniBajaCliente = new MenuItem("Baja");
		MenuItem mniModificacionCliente = new MenuItem("Modificación");
		MenuItem mniConsultaCliente = new MenuItem("Consulta");
		Menu mnuAyuda = new Menu("Ayuda"); 
		MenuItem mniAyuda = new MenuItem("Ayuda");
		MenuItem mniInform = new MenuItem("Información");
		MenuItem mniFichero = new MenuItem("Movimientos");
		
		
	
		
		

		public pantallaMenu()
		{
			//Añadir los objetos a las ventanas correspondientes
		
		//MENÚ BAR
			vista2.setLayout(new FlowLayout());
			mnBar.add(mnuEmpleados);
			mnuEmpleados.add(mniAltaEmpleado);
			mnuEmpleados.add(mniBajaEmpleado); 
			mnuEmpleados.add(mniModificacionEmpleado); 
			mnuEmpleados.add(mniConsultaEmpleado);
			mnBar.add(mnuCamiones);
			mnuCamiones.add(mniAltaCamion);
			mnuCamiones.add(mniBajaCamion); 
			mnuCamiones.add(mniModificacionCamion); 
			mnuCamiones.add(mniConsultaCamion); 
			mnBar.add(mnuExplosivos);
			mnuExplosivos.add(mniAltaExplosivo); 
			mnuExplosivos.add(mniBajaExplosivo);
			mnuExplosivos.add(mniModificacionExplosivo);
			mnuExplosivos.add(mniConsultaExplosivo); 
			mnBar.add(mnuClientes);
			mnuClientes.add(mniAltaCliente); 
			mnuClientes.add(mniBajaCliente); 
			mnuClientes.add(mniModificacionCliente); 
			mnuClientes.add(mniConsultaCliente); 
			mnBar.add(mnuAyuda);
			mnuAyuda.add(mniAyuda);
			mnuAyuda.add(mniInform);
			mnuAyuda.add(mniFichero);
			vista2.setMenuBar(mnBar); 
			vista2.setSize(340, 150); 
			vista2.setResizable(false); 
			vista2.setLocationRelativeTo(null);
			
//INFORMACIÓN ---------------------------------------------------------------------------------------
			frmInformacion.setLayout(new FlowLayout(FlowLayout.CENTER)); 
			frmInformacion.add(lblNombreInformacion);
			frmInformacion.add(lblAnioInformacion);
			frmInformacion.add(lblCopy);
			frmInformacion.add(btnVolverInformacion);
			frmInformacion.setVisible(false); 
			frmInformacion.setSize(160,140); 
			frmInformacion.setLocationRelativeTo(null); 
			frmInformacion.setResizable(false);
			
//EMPLEADOS-------------------------------------------------------------------------------------------
		
		//ALTA EMPLEADO
			frmPreAltaEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER));
			frmPreAltaEmpleado.add(lblPreAltaEmpleado);
			frmPreAltaEmpleado.add(prePanelAlta);
			prePanelAlta.setLayout(new FlowLayout());
			prePanelAlta.add(choTipoEmpleado);
			choTipoEmpleado.add("Administrativo");
			choTipoEmpleado.add("Conductor");
			prePanelAlta.add(btnPreAltaEmpleado);
			prePanelAlta.add(btnVolverPreAltaEmpleado);
			prePanelAlta.setPreferredSize(new Dimension(130,60)); 
			frmPreAltaEmpleado.setVisible(false); 
			frmPreAltaEmpleado.setSize(250,150); 
			frmPreAltaEmpleado.setLocationRelativeTo(null); 
			frmPreAltaEmpleado.setResizable(false);
			
			frmAltaEmpleado.setLayout(new FlowLayout(FlowLayout.CENTER)); 
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
			frmAltaEmpleado.add(lblTipoEmpleadoAdministrativo);
			frmAltaEmpleado.add(panelAdministrativo);
			frmAltaEmpleado.add(lblTipoEmpleadoConductor);
			frmAltaEmpleado.add(panelConductor);
			frmAltaEmpleado.add(btnAltaEmpleado); 
			frmAltaEmpleado.add(btnCorrectoAltaEmpleadoVolver); 
			frmAltaEmpleado.add(btnErrorAltaEmpleadoVolver); 
			frmAltaEmpleado.add(btnVolverGeneralAltaEmpleado);
			frmAltaEmpleado.setVisible(false); 
			frmAltaEmpleado.setSize(400,340); 
			frmAltaEmpleado.setLocationRelativeTo(null); 
			frmAltaEmpleado.setResizable(false);
			 
			
			panelAdministrativo.setLayout(new FlowLayout());
			
			panelAdministrativo.add(lblIdiomaAdministrativo);
			panelAdministrativo.add(txtIdiomaAdministrativo);
			panelAdministrativo.add(lblTituloAdministrativo);
			panelAdministrativo.add(txtTituloAdministrativo);
			panelAdministrativo.setBackground(Color.gray);
			panelAdministrativo.setPreferredSize(new Dimension(320,30)); 
			
			panelConductor.setLayout(new FlowLayout());
			panelConductor.add(lblCarnetConducirConductor);
			panelConductor.add(txtCarnetConducirConductor);
			panelConductor.setBackground(Color.lightGray);
			panelConductor.setPreferredSize(new Dimension(320,30)); 
			
			
			
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
			frmBajaEmpleado.setSize(270, 100); 
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
			frmModificarEmpleado.add(btnModificarEmpleado); 
			frmModificarEmpleado.add(btnModVolEmpleado);
			frmModificarEmpleado.setSize(300,150); 
			frmModificarEmpleado.setResizable(false); 
			frmModificarEmpleado.setLocationRelativeTo(null); 
			frmModificarEmpleado. setVisible(false);
			
			//MODIFICAR EMPLEADO ESPECÍFICO
			
			frmModificarEspecificoEmpleado.setLayout(new FlowLayout()); 
			frmModificarEspecificoEmpleado.add(lblTelefonoEmpleadoModificar); 
			frmModificarEspecificoEmpleado.add(txtTelefonoEmpleadoModificar); 
			frmModificarEspecificoEmpleado.add(lblDniEmpleadoModificar); 
			frmModificarEspecificoEmpleado.add(txtDniEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(lblNombreEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(txtNombreEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(lblDireccionEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(txtDireccionEmpleadoModificar);  
			frmModificarEspecificoEmpleado.add(lblApellidosEmpleadoModificar);  
			frmModificarEspecificoEmpleado.add(txtApellidosEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(txtTipoEmpleadoModificar);
			frmModificarEspecificoEmpleado.add(lblCarnetConducirConductorModificar);  
			frmModificarEspecificoEmpleado.add(txtCarnetConducirConductorModificar); 
			frmModificarEspecificoEmpleado.add(lblIdiomaAdministrativoModificar); 
			frmModificarEspecificoEmpleado.add(txtIdiomaAdministrativoModificar); 
			frmModificarEspecificoEmpleado.add(lblTituloAdministrativoModificar);  
			frmModificarEspecificoEmpleado.add(txtTituloAdministrativoModificar);  
			frmModificarEspecificoEmpleado.add(btnModEspecificoEmpleado);
			frmModificarEspecificoEmpleado.add(btnVolModEspEmpleado);
			frmModificarEspecificoEmpleado.setSize(300,600); 
			frmModificarEspecificoEmpleado.setResizable(false); 
			frmModificarEspecificoEmpleado.setLocationRelativeTo(null); 
			frmModificarEspecificoEmpleado.setVisible(false);
			
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
			frmConsultaEmpleado.add(lblListadoEmpleado); 
			frmConsultaEmpleado.add(txaListadoEmpleado); 
			frmConsultaEmpleado.add(lblListadoEmpleadoConductores); 
			frmConsultaEmpleado.add(txaListadoEmpleadoConductores); 
			frmConsultaEmpleado.add(lblListadoEmpleadoAdministrativos); 
			frmConsultaEmpleado.add(txaListadoEmpleadoAdministrativos); 
			frmConsultaEmpleado.add(btnPdfEmpleado); 
			frmConsultaEmpleado.add(btnVolverConsultaEmpleado);
			frmConsultaEmpleado.setSize(480, 460); 
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
			frmAltaExplosivo.add(lblClienteExplosivo);
			frmAltaExplosivo.add(choClienteExplosivo);
			frmAltaExplosivo.add(panelAltaExplosivo);
			frmAltaExplosivo.setSize(320, 300); 
			frmAltaExplosivo.setResizable(false);
			frmAltaExplosivo.setLocationRelativeTo(null); 
			frmAltaExplosivo.setVisible(false);
			
			panelAltaExplosivo.setLayout(new FlowLayout());
			panelAltaExplosivo.add(lblTonelajeExplosivo);
			panelAltaExplosivo.add(txtTonelajeExplosivo); 
			panelAltaExplosivo.add(lblTipoExplosivo); 
			panelAltaExplosivo.add(txtTipoExplosivo); 
			panelAltaExplosivo.add(lblPrecioExplosivo); 
			panelAltaExplosivo.add(txtPrecioExplosivo);
			panelAltaExplosivo.add(btnAltaExplosivo); 
			panelAltaExplosivo.add(btnCorrectoAltaExplosivoVolver);
			panelAltaExplosivo.add(btnVolverGeneralAltaExplosivo);
			panelAltaExplosivo.setPreferredSize(new Dimension(220,200)); 
			
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
			
			frmModificarExplosivo.add(lblChoClienteSeleccionado);
			frmModificarExplosivo.add(choClienteSeleccionado);
			frmModificarExplosivo.add(btnModificarExplosivo); 
			frmModificarExplosivo.add(btnModVolExplosivo); 
			frmModificarExplosivo.setSize(290,150); 
			frmModificarExplosivo.setResizable(false); 
			frmModificarExplosivo.setLocationRelativeTo(null); 
			frmModificarExplosivo.setVisible(false);
			
			//Ventana modificar avanzada
			frmModificarExplosivoAvanzado.setLayout(new FlowLayout()); 
			frmModificarExplosivoAvanzado.add(lblChoSelecExplosivo); 
			frmModificarExplosivoAvanzado.add(choModificarExplosivo);
			frmModificarExplosivoAvanzado.add(lblTonelajeExplosivoModificar); 
			frmModificarExplosivoAvanzado.add(txtTonelajeExplosivoModificar); 
			frmModificarExplosivoAvanzado.add(lblTipoExplosivoModificar); 
			frmModificarExplosivoAvanzado.add(txtTipoExplosivoModificar); 
			frmModificarExplosivoAvanzado.add(lblPrecioExplosivoModificar);
			frmModificarExplosivoAvanzado.add(txtPrecioExplosivoModificar); 
			frmModificarExplosivoAvanzado.add(btnModTonelajeExplosivo); 
			frmModificarExplosivoAvanzado.add(btnVolModTonExplosivo);
			frmModificarExplosivoAvanzado.setSize(230,300);
			frmModificarExplosivoAvanzado.setResizable(false); 
			frmModificarExplosivoAvanzado.setLocationRelativeTo(null); 
			frmModificarExplosivoAvanzado.setVisible(false);

		
			
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
			
//CLIENTES ------------------------------------------------------------------------------------------------------
	
	//ALTA CLIENTE 
			frmAltaCliente.setLayout(new FlowLayout());
			frmAltaCliente.add(lblNombreCliente); 
			frmAltaCliente.add(txtNombreCliente);
			frmAltaCliente.add(lblDireccionCliente);
			frmAltaCliente.add(txtDireccionCliente); 
			frmAltaCliente.add(lblTelefonoCliente); 
			frmAltaCliente.add(txtTelefonoCliente); 
			frmAltaCliente.add(lblCorreoElectronicoCliente); 
			frmAltaCliente.add(txtCorreoElectronicoCliente); 
			frmAltaCliente.add(lblCodigoPostalCliente); 
			frmAltaCliente.add(txtCodigoPostalCliente); 
			frmAltaCliente.add(btnAltaCliente); 
			frmAltaCliente.add(btnCorrectoAltaClienteVolver); 
			frmAltaCliente.add(btnVolverGeneralAltaCliente);
			frmAltaCliente.setSize(400,220); 
			frmAltaCliente.setResizable(false); 
			frmAltaCliente.setLocationRelativeTo(null); 
			frmAltaCliente.setVisible(false);
			
			//Dialogo alta correcta camión 
			this.dialogoAltaClienteBien.setLayout(new FlowLayout()); 
			this.dialogoAltaClienteBien.add(lblCorrectAltaCliente);
			this.dialogoAltaClienteBien.add(btnCorrectoAltaClienteVolver);
			this.dialogoAltaClienteBien.setSize(180,70);
			this.dialogoAltaClienteBien.setResizable(false); 
			this.dialogoAltaClienteBien.setLocationRelativeTo(null); 
			this.dialogoAltaClienteBien.setUndecorated(true); 
			this.dialogoAltaClienteBien.setBackground(Color.GRAY);
			
			
			//Diálogo error en el alta camion 
			this.dialogoAltaClienteMal.setLayout(new FlowLayout()); 
			this.dialogoAltaClienteMal.add(lblErrorAltaCliente); 
			this.dialogoAltaClienteMal.add(btnErrorAltaClienteVolver);
			this.dialogoAltaClienteMal.setSize(200,70); 
			this.dialogoAltaClienteMal.setResizable(false); 
			this.dialogoAltaClienteMal.setLocationRelativeTo(null); 
			this.dialogoAltaClienteMal.setUndecorated(true); 
			this.dialogoAltaClienteMal.setBackground(Color.GRAY);
			
		//BAJA CLIENTE
			
			frmBajaCliente.setLayout(new FlowLayout());
			frmBajaCliente.add(choCliente); 
			choCliente.add("Elige al cliente que quiere borrar"); 
			frmBajaCliente.add(lblCorrectBajaCliente); 
			frmBajaCliente.add(lblErrorBajaCliente); 
			frmBajaCliente.add(btnBajaCliente); 
			frmBajaCliente.add(btnCorrectoBajaClienteVolver);
			frmBajaCliente.add(btnErrorBajaClienteVolver); 
			frmBajaCliente.add(btnVolverGeneralBajaCliente); 
			frmBajaCliente.add(btnSiSeguroClienteBaja); 
			frmBajaCliente.add(btnNoSeguroClienteBaja);
			frmBajaCliente.setSize(250, 100); 
			frmBajaCliente.setResizable(false); 
			frmBajaCliente.setLocationRelativeTo(null); 
			frmBajaCliente.setVisible(false);
			
			//Diálogo baja camión correcta 
			this.dialogoBajaClienteBien.setLayout(new FlowLayout()); 
			this.dialogoBajaClienteBien.add(lblCorrectBajaCliente); 
			this.dialogoBajaClienteBien.add(btnCorrectoBajaClienteVolver);
			this.dialogoBajaClienteBien.setSize(180,70); 
			this.dialogoBajaClienteBien.setResizable(false); 
			this.dialogoBajaClienteBien.setLocationRelativeTo(null); 
			this.dialogoBajaClienteBien.setUndecorated(true); 
			this.dialogoBajaClienteBien.setBackground(Color.GRAY);
			
			
			//Diálogo error baja camión 
			this.dialogoBajaClienteMal.setLayout(new FlowLayout());
			this.dialogoBajaClienteMal.add(lblErrorBajaCliente); 
			this.dialogoBajaClienteMal.add(btnErrorBajaClienteVolver);
			this.dialogoBajaClienteMal.setSize(288,70);
			this.dialogoBajaClienteMal.setResizable(false);
			this.dialogoBajaClienteMal.setLocationRelativeTo(null); 
			this.dialogoBajaClienteMal.setUndecorated(true); 
			this.dialogoBajaClienteMal.setBackground(Color.GRAY);
			
			
			//Pregunta si está seguro de BORRAR al camión 
			this.dlgSeguroClienteBaja.setLayout(new FlowLayout()); 
			this.dlgSeguroClienteBaja.add(lblSeguroClienteBaja); 
			this.dlgSeguroClienteBaja.add(btnSiSeguroClienteBaja); 
			this.dlgSeguroClienteBaja.add(btnNoSeguroClienteBaja);
			this.dlgSeguroClienteBaja.setSize(150,70); 
			this.dlgSeguroClienteBaja.setResizable(false); 
			this.dlgSeguroClienteBaja.setLocationRelativeTo(null); 
			this.dlgSeguroClienteBaja.setUndecorated(true); 
			this.dlgSeguroClienteBaja.setBackground(Color.GRAY);
			
		//MODIFICACIÓN CLIENTE
			
			frmModificarCliente.setLayout(new FlowLayout(FlowLayout.CENTER));
			frmModificarCliente.add(lblChoSelecCliente); 
			frmModificarCliente.add(choModificarCliente); 
			frmModificarCliente.add(btnModificarCliente); 
			frmModificarCliente.add(btnModVolCliente);
			frmModificarCliente.setSize(350,150); 
			frmModificarCliente.setResizable(false); 
			frmModificarCliente.setLocationRelativeTo(null); 
			frmModificarCliente. setVisible(false);
			
			//MODIFICAR EMPLEADO ESPECÍFICO
			
			frmModificarEspecificoCliente.setLayout(new FlowLayout()); 
			frmModificarEspecificoCliente.add(lblDireccionClienteModificar); 
			frmModificarEspecificoCliente.add(txtDireccionClienteModificar); 
			frmModificarEspecificoCliente.add(lblNombreClienteModificar); 
			frmModificarEspecificoCliente.add(txtNombreClienteModificar);
			frmModificarEspecificoCliente.add(lblCorreoElectronicoClienteModificar);
			frmModificarEspecificoCliente.add(txtCorreoElectronicoClienteModificar);
			frmModificarEspecificoCliente.add(lblTelefonoClienteModificar);  
			frmModificarEspecificoCliente.add(txtTelefonoClienteModificar); 
			frmModificarEspecificoCliente.add(lblCodigoPostalClienteModificar);
			frmModificarEspecificoCliente.add(txtCodigoPostalClienteModificar);  
			frmModificarEspecificoCliente.add(btnModificarClienteNuevo);
			frmModificarEspecificoCliente.add(btnVolModCliente);
			frmModificarEspecificoCliente.setSize(250,350); 
			frmModificarEspecificoCliente.setResizable(false); 
			frmModificarEspecificoCliente.setLocationRelativeTo(null); 
			frmModificarEspecificoCliente.setVisible(false);
			
			//Diálogo modificación correcta empleado 
			this.dlgModCorrectaCliente.setLayout(new FlowLayout()); 
			this.dlgModCorrectaCliente.add(lblModCorrectaCliente);
			this.dlgModCorrectaCliente.add(btnModVolDialogoCorrectaCliente);
			this.dlgModCorrectaCliente.setSize(180,70); 
			this.dlgModCorrectaCliente.setResizable(false); 
			this.dlgModCorrectaCliente.setLocationRelativeTo(null);
			this.dlgModCorrectaCliente.setUndecorated(true);
			this.dlgModCorrectaCliente.setBackground(Color.GRAY);
			
			
			//Diálogo modificación error empleado 
			this.dlgModCorrectaCliente.setLayout(new FlowLayout());
			this.dlgModCorrectaCliente.add(lblModErrorCliente); 
			this.dlgModCorrectaCliente.add(btnModVolDialogoErrorCliente);
			this.dlgModCorrectaCliente.setSize(180,70); 
			this.dlgModCorrectaCliente.setResizable(false); 
			this.dlgModCorrectaCliente.setLocationRelativeTo(null);
			this.dlgModCorrectaCliente.setUndecorated(true); 
			this.dlgModCorrectaCliente.setBackground(Color.GRAY);
		
		//CONSULTA CLIENTE
			
			frmConsultaCliente.setLayout(new FlowLayout()); 
			frmConsultaCliente.add(txalistadoCliente);
			frmConsultaCliente.add(btnPdfCliente); 
			frmConsultaCliente.add(btnVolverConsultaCliente);
			frmConsultaCliente.setSize(480, 250); 
			frmConsultaCliente.setResizable(false); 
			frmConsultaCliente.setLocationRelativeTo(null); 
			frmConsultaCliente.setVisible(false);
			
			
			//Diálogo error exportar camión pdf 
			this.dialogoExportPdfMalCliente.setLayout(new FlowLayout());
			this.dialogoExportPdfMalCliente.add(lblExportPdfClienteMal);
			this.dialogoExportPdfMalCliente.add(btnExportMalCliente);
			this.dialogoExportPdfMalCliente.setSize(280,70);
			this.dialogoExportPdfMalCliente.setResizable(false);
			this.dialogoExportPdfMalCliente.setLocationRelativeTo(null); 
			this.dialogoExportPdfMalCliente.setUndecorated(true); 
			this.dialogoExportPdfMalCliente.setBackground(Color.GRAY);
	
		}
			public void setVisible(boolean b)
			{
				vista2.setVisible(b);
			}

}
