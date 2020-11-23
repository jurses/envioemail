package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MailController
{
	@FXML
    private GridPane root;
	
    @FXML
    private TextField tf_urlserver;

    @FXML
    private TextField tf_port;

    @FXML
    private Button bt_send;

    @FXML
    private Button bt_clear;

    @FXML
    private Button bt_close;

    @FXML
    private TextArea ta_message;
    
    @FXML
    private CheckBox cb_sslconn;

    @FXML
    private TextField tf_email_orig;

    @FXML
    private TextField tf_email_dest;

    @FXML
    private TextField tf_subject;
    
    @FXML
    private PasswordField pf_email_pass;
    
    public Button get_bt_send()
    {
    	return bt_send;
    }
    
    public String get_email_orig()
    {
    	return tf_email_orig.getText();
    }
    
    public String get_email_dest()
    {
    	return tf_email_dest.getText();
    }
    
    public String get_subject()
    {
    	return tf_subject.getText();
    }
    
    public String get_url()
    {
    	return tf_urlserver.getText();
    }
    
    public String get_port()
    {
    	return tf_port.getText();
    }
    
    public String get_message()
    {
    	return ta_message.getText();
    }
    
    public GridPane get_view()
    {
    	return root;
    }
    
    public String get_pass()
    {
    	return pf_email_pass.getText();
    }

    public MailController()
    {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/enviar-email.fxml"));
	    	loader.setController(this);
	    	loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}