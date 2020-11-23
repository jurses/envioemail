package envioemail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import controller.*;

public class Main extends Application {
	private MailController mailcontroller;

	public Main() {
		mailcontroller = new MailController();
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage s) {
		s.getIcons().add(new Image(Main.class.getResourceAsStream("/icon.png")));
		mailcontroller.get_bt_send().setOnAction(event -> {
			Email email = new SimpleEmail();
			email.setHostName(mailcontroller.get_url());
			email.setSmtpPort(Integer.parseInt(mailcontroller.get_port()));
			email.setAuthenticator(
					new DefaultAuthenticator(mailcontroller.get_email_orig(), mailcontroller.get_pass()));
			email.setSSLOnConnect(true);
			try {
				email.setFrom(mailcontroller.get_email_orig());
				email.setMsg(mailcontroller.get_message());
				email.addTo(mailcontroller.get_email_dest());
				email.setSubject(mailcontroller.get_subject());
				email.send();
			} catch (NumberFormatException e) {
				Alert not_sent = new Alert(AlertType.ERROR);
				not_sent.setTitle("Error");
				not_sent.setHeaderText("El número del puerto es incorrecto");
				not_sent.setContentText(e.getMessage());
				not_sent.showAndWait();
				e.printStackTrace();
			} catch (EmailException e) {
				Alert not_sent = new Alert(AlertType.ERROR);
				not_sent.setTitle("Error");
				not_sent.setHeaderText("El número del puerto es incorrecto");
				not_sent.setContentText(e.getMessage());
				not_sent.showAndWait();
				e.printStackTrace();
			}
		});
		Scene sc = new Scene(mailcontroller.get_view());
		s.setScene(sc);
		s.show();
	}
}
