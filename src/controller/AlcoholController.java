package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class AlcoholController implements Initializable {

	@FXML
	private TextField amountFst;

	@FXML
	private TextField alcoholFst;

	@FXML
	private TextField amountSec;

	@FXML
	private TextField alcoholSec;

	@FXML
	private Button button;

	@FXML
	private Label result;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	public void onClick(ActionEvent event) {
		if (amountFst != null && alcoholFst != null && amountSec != null && alcoholSec != null) {
			try {

				double amountFst = Integer.parseInt(this.amountFst.getText());
				double alcoholFst = Integer.parseInt(this.alcoholFst.getText());
				double amountSec = Integer.parseInt(this.amountSec.getText());
				double alcoholSec = Integer.parseInt(this.alcoholSec.getText());

				check(amountFst, alcoholFst, amountSec, alcoholSec);

				double alcohol = (alcoholFst * (amountFst/(amountFst+amountSec)) + alcoholSec * (amountSec/(amountFst+amountSec)));
				String alcoholStr = String.format("%.1f", alcohol);

				String totalAmount = String.format("%.0f", amountFst + amountSec);

				result.setText("アルコール" + alcoholStr + "%" + " 総量" + totalAmount + "ml");
				result.setFont(Font.font(30));
			} catch(NumberFormatException nfe) {
				result.setText("数字を入力してください");
			} catch(Exception e) {
				result.setText("1以上を入力してください");
			}

		} else {
			result.setText("すべて入力してください");
		}
	}

	private void check(double d1, double d2, double d3, double d4) throws Exception {
		double[] doubleArray = {d1, d2, d3, d4};

		for (double d : doubleArray) {
			if (d <= 0) {
				throw new Exception();
			}
		}
	}

}
