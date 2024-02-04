package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController implements Initializable {
	
	@FXML //for they be associate with the display 
	private TextField txtNumber1;
	
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;

	@FXML
	private Button btSum;

	@FXML
	public void onBtSumAction() {
		try {
		Locale.setDefault(Locale.US);
		double number1 = Double.parseDouble(txtNumber1.getText()); //to transform the text of the the number in a number for the system
		double number2 = Double.parseDouble(txtNumber2.getText());
		double sum = number1 + number2;
		labelResult.setText(String.format("%.2f", sum));//to adress the sum for the label and transform into a string 
	}
		catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}

}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumber1); //that way will be possible to digit just number in the field first number
		Constraints.setTextFieldDouble(txtNumber2); //that way will be possible to digit just number in the field Second number
		Constraints.setTextFieldMaxLength(txtNumber1, 12); //that way the max length of the field first number is 12 characters
		Constraints.setTextFieldMaxLength(txtNumber2, 12); //that way the max length of the field second number is 12 characters
		
	}
}
