package executavel.cgi;
import modelo.cgi.Usuario;
import view.cgi.TelaLogin;

public class Main {

	public static void main(String[] args) {
		
		Usuario userTeste = new Usuario("gi@adm.com", "123", "Giovanna Carvalho", "Gih", "Estudante", 5000.0);
		Usuario.listaUsuarios.add(userTeste);

		//chamei a tela login e usei o "swingUtilities" p ñ travar 
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}