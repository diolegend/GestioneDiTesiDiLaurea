package businessLogic;

import userInterface.ViewLogin;
import utils.Console;
import utils.Utils;

import org.eclipse.swt.widgets.Text;
import databaseAccessObject.Database;

public class ControllerLogin {
	private ViewLogin viewLogin;
	
	public ControllerLogin() {
		viewLogin = new ViewLogin(this);
	}
	
	public void checkLogin(Text matricola, Text password) {
		if(matricola.getText().equals("") || password.getText().equals("")) {
			Utils.createErrorDialog(viewLogin.getShell(), "Messaggio", "Matricola o Password non puo' essere vuota");
		} else {
			if(Database.getInstance().isConnected()) {
				String[] info = Database.getInstance().verificaCredenziali(matricola.getText(), password.getText());
				if(info != null) {
					Console.print("Utente matricola: " + matricola.getText() + " password: " + password.getText() + " loggato", "app");
					viewLogin.close();
					switch(Integer.parseInt(info[2])) {
						case 0:					
							ControllerStudente controllerStudente = new ControllerStudente(info[0],info[1],info[3]);
							controllerStudente.run();		
							break;
						case 1:
							ControllerResponsabile controllerResponsabile = new ControllerResponsabile(info[0],info[1],info[3]);
							controllerResponsabile.run();
							break;
						case 2:
							ControllerPresidenteScuola controllerPresidenteScuola = new ControllerPresidenteScuola(info[0],info[1],info[3]);
							controllerPresidenteScuola.run();
							break;
						case 3:
							ControllerPresidenteCorso controllerPresidenteCorso = new ControllerPresidenteCorso(info[0],info[1],info[3]);
							controllerPresidenteCorso.run();
							break;
						case 4:		
							ControllerDocente controllerDocente = new ControllerDocente(info[0],info[1],info[3]);
							controllerDocente.run();
							break;
					}
				}else {
					Utils.createErrorDialog(viewLogin.getShell(), "Messaggio", "Matricola o Password errata");
				}	
			}
			else {
				Utils.createErrorDialog(viewLogin.getShell(), "Messaggio", "Connessione al database fallita");
			}
		}
	}
	
	public void run() {
		viewLogin.createAndRun();
	}
	
}
