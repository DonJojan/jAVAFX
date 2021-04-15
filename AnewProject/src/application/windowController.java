package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class windowController implements Initializable{
	

    @FXML
    private Label getgender;

    @FXML
    private Label getdob;

    @FXML
    private Button get;

    @FXML
    private TextField getuser;

    @FXML
    private TextField name;

    @FXML
    private DatePicker dob;

    @FXML
    private RadioButton gendermale;

    @FXML
    private RadioButton genderfemale;

    @FXML
    private Button btnsubmit;

    @FXML
    private Button clear;


    @FXML
    void onget(ActionEvent event) {
    	
    	FileInputStream fip;
    	ObjectInputStream ois = null;
    	
    	try {
		fip = new FileInputStream("p1.txt");
		
		ois = new ObjectInputStream(fip);
		Person p;
		while(fip.available()> 0)
		{
			try {
			try {
				p = (Person)ois.readObject();
			
			if(p.getName().equals(getuser.getText()))
			{
				System.out.println(p.getGender());
				getgender.setText(p.getGender());
				getdob.setText(p.getDob().toString());
			}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}

		}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

   	FileOutputStream fp;
	ObjectOutputStream ob ;
    @FXML
    void onsubmit(ActionEvent event) {
 

    	
		
    	String sname = name.getText();
    	String sgender;
    	if(genderfemale.isSelected())
    	{
    		sgender = "Female";
    	}
    	else {
    		sgender = "Male";
    	}
    	LocalDate sdob = dob.getValue();  
    	
    	Person p = new Person(sname,sgender,sdob);
    	try {
			ob.writeObject(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @FXML
    void onclear(ActionEvent event) {
    	try {
			ob.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		try {
			fp = new FileOutputStream("p1.txt");
		
				ob = new ObjectOutputStream(fp);
			}
    	catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
    

}
