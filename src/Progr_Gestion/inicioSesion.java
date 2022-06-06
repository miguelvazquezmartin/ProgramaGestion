package Progr_Gestion;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class inicioSesion 
	{
			Frame vista1 = new Frame("Programa Gestión"); 
			//Hacemos el diálogo modal para que el usuario no pueda realizar ninguna otra acción 
			Dialog dialogoLogin = new Dialog(vista1, "Error", true); 
			TextField nombreUsuario = new TextField(15); 
			TextField contraseniaUsuario = new TextField(15); 
			Button btnIniciar = new Button("Iniciar sesión"); 
			Button btnVolver = new Button("Volver"); 
			Label lblusuario = new Label("Usuario"); 
			Label lblContrasenia = new Label("Contraseña"); 
			Label lblError = new Label("Has introducido mal tus credenciales");
			
		public inicioSesion()
			{
				//ocultar la contraseña que introduce el usuario 
				contraseniaUsuario.setEchoChar('*');
				vista1.setLayout(new FlowLayout());
				vista1.add(lblusuario); 
				vista1.add(nombreUsuario); 
				vista1.add(lblContrasenia); 
				vista1.add(contraseniaUsuario); 
				vista1.add(btnIniciar);
				vista1.setSize(250, 200); 
				vista1.setResizable(false);
				vista1.setLocationRelativeTo(null); 
				vista1.setVisible(true);
				
				//Diálogo que aparece al introducir de forma erronea el usuario sus credenciales
				this.dialogoLogin.setSize(250,70); 
				this.dialogoLogin.setResizable(false); 
				this.dialogoLogin.setLocationRelativeTo(null); 
				this.dialogoLogin.setUndecorated(true); 
				this.dialogoLogin.setBackground(Color.GRAY);
				dialogoLogin.setLayout(new FlowLayout()); 
				dialogoLogin.add(lblError);
				dialogoLogin.add(btnVolver);
			}
		
		public void setVisible(boolean b)
			{
				vista1.setVisible(b);
			}
	}
