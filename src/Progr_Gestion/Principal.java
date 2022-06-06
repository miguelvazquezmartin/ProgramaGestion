package Progr_Gestion;

public class Principal {

	public static void main(String[] args) 
	{
		inicioSesion vista1 = new inicioSesion();
		pantallaMenu vista2 = new pantallaMenu();
		Modelo modelo = new Modelo();
		new Controlador(vista1, vista2, modelo);
		modelo.conectar();
	}
}
