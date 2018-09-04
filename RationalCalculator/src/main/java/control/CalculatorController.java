package control;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import numericSystem.RationalNumber;

public class CalculatorController {

	@FXML
	private BorderPane fraction1;

	@FXML
	private TextField txtNumerator1;

	@FXML
	private TextField txtDenominator1;

	@FXML
	private TextField txtExponential;

	@FXML
	private BorderPane fraction2;

	@FXML
	private TextField txtNumerator2;

	@FXML
	private TextField txtDenominator2;

	@FXML
	private TextField txtExponential2;

	@FXML
	private BorderPane fraction3;

	@FXML
	private TextField txtNumerator3;

	@FXML
	private TextField txtDenominator3;

	@FXML
	private TextField txtExponential3;

	@FXML
	private BorderPane fraction4;

	@FXML
	private TextField txtNumerator4;

	@FXML
	private TextField txtDenominator4;

	@FXML
	private TextField txtExponential4;

	@FXML
	private BorderPane resultFraction;

	@FXML
	private TextField txtNumeratorResult;

	@FXML
	private TextField txtDenominatorResult;

	@FXML
	private TextField txtOperation1;

	@FXML
	private TextField txtOperation2;

	@FXML
	private TextField txtOperation3;

	@FXML
	private Button butNumber1;

	@FXML
	private Button butNumber2;

	@FXML
	private Button butNumber3;

	@FXML
	private Button butNumber4;

	@FXML
	private Button butNumber5;

	@FXML
	private Button butNumber6;

	@FXML
	private Button butNumber7;

	@FXML
	private Button butNumber8;

	@FXML
	private Button butNumber9;

	@FXML
	private Button butNumber0;

	@FXML
	private Button butNewRation;

	@FXML
	private Button butExponential;

	@FXML
	private Button butEqual;

	@FXML
	private Button butAC;

	@FXML
	private Button butMultiply;

	@FXML
	private Button ButDivide;

	@FXML
	private Button ButPlus;

	@FXML
	private Button ButSubstract;

	@FXML
	private Button butDeleteFraction;

	private int fractionsVisibles = -1;

	private TextField selectedFieldNow = null;

	private TextField selectedOperationField = null;

	@FXML
	private void addFraction() {

		BorderPane[] fractions = { this.fraction1, this.fraction2, this.fraction3, this.fraction4 };
		TextField[] operationsTexts = { this.txtOperation1, this.txtOperation2, this.txtOperation3 };

		if (fractionsVisibles <= 3)
			fractionsVisibles++;

		if (fractionsVisibles <= 3) {
			fractions[fractionsVisibles].setVisible(true);
			if (fractionsVisibles > 0 && fractionsVisibles < 4) {
				operationsTexts[fractionsVisibles - 1].setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"I am sorry :c my dad did not give power to operate more than 4 rational numbers. :c but i can operate more! I dare!",
					"I am so sorry ", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	@FXML
	private void deleteFraction() {

		BorderPane[] fractions = { this.fraction1, this.fraction2, this.fraction3, this.fraction4 };
		TextField[] operationsTexts = { this.txtOperation1, this.txtOperation2, this.txtOperation3 };

		if (fractionsVisibles == 4)
			fractionsVisibles--;

		if (fractionsVisibles >= 0) {

			fractions[fractionsVisibles].setVisible(false);

			if (fractionsVisibles >= 1) {
				operationsTexts[fractionsVisibles - 1].setVisible(false);
			}

			fractionsVisibles--;
		}
	}

	@FXML
	private void selectedField(ActionEvent event) {
		System.out.println(event.getTarget());
		this.selectedFieldNow = (TextField) event.getTarget();
	}

	@FXML
	private void operationFieldSelected(ActionEvent event) {
		this.selectedOperationField = (TextField) event.getTarget();
	}

	@FXML
	private void clean(ActionEvent event) {
		this.fractionsVisibles = -1;
		BorderPane[] fractions = { this.fraction1, this.fraction2, this.fraction3, this.fraction4 };
		TextField[] operationsTexts = { this.txtOperation1, this.txtOperation2, this.txtOperation3 };
		TextField[] numbersField = { this.txtNumerator1, this.txtNumerator2, this.txtNumerator3, this.txtNumerator4,
				this.txtDenominator1, this.txtDenominator2, this.txtDenominator3, this.txtDenominator4 };

		for (int i = 0; i < operationsTexts.length; i++) {
			operationsTexts[i].setVisible(false);
			operationsTexts[i].setText("");
		}

		for (int i = 0; i < fractions.length; i++) {
			fractions[i].setVisible(false);
		}

		for (int i = 0; i < numbersField.length; i++) {
			numbersField[i].setText("");
		}
	}

	@FXML
	private void result(ActionEvent event) {

		//'1' = suma, '2' = resta, '3' = multiplicacion, '4' = division
		char[] operations = new char[3];
		this.resultFraction.setVisible(true);

		if (fractionsVisibles >= 1) {
			if (fractionsVisibles == 1 && !txtOperation1.getText().isEmpty())
				operations[0] = txtOperation1.getText().charAt(0);
			if (fractionsVisibles == 2 && !txtOperation2.getText().isEmpty())
				operations[1] = txtOperation2.getText().charAt(0);
			if (fractionsVisibles == 3 && !txtOperation3.getText().isEmpty())
				operations[2] = txtOperation3.getText().charAt(0);
		}

		if (fractionsVisibles == 0) {
			if (!this.txtNumerator1.getText().isEmpty() && !this.txtDenominator1.getText().isEmpty()) {
				try {
					RationalNumber<Integer> val = new RationalNumber<Integer>(Integer.parseInt(txtNumerator1.getText()),
							Integer.parseInt(txtDenominator1.getText()));
					
					this.txtNumeratorResult.setText(val.getNumerator()+"");
					this.txtDenominatorResult.setText(val.getDenominator()+"");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "my father says: 'pls, give correct inputs", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(fractionsVisibles == 1) {
		
			
			
			if (!this.txtNumerator1.getText().isEmpty() && !this.txtDenominator1.getText().isEmpty() && !this.txtNumerator2.getText().isEmpty() && !this.txtDenominator2.getText().isEmpty()) {
				try {
					RationalNumber<Integer> val1 = new RationalNumber<Integer>(Integer.parseInt(txtNumerator1.getText()),
							Integer.parseInt(txtDenominator1.getText()));
					
					RationalNumber<Integer> val2 = new RationalNumber<Integer> (Integer.parseInt(txtNumerator2.getText()),
							Integer.parseInt(txtDenominator2.getText()));
					
					switch (operations[0]) {
					case '+':
						val1.addRational(val2);
						
						break;

					case '-':
						val1.substractRational(val2);
						break;
						
					case 'x':
						val1.multiplyRational(val2);
						break;
					
					case '/':
						val1.divideRational(val2);
					}
					
					this.txtNumeratorResult.setText(val1.getNumerator()+"");
					this.txtDenominatorResult.setText(val1.getDenominator()+"");
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "my father says: 'pls, give correct inputs", "error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
			
		}
//		TextField[] numbersField = { this.txtNumerator1, this.txtNumerator2, this.txtNumerator3, this.txtNumerator4,
//				this.txtDenominator1, this.txtDenominator2, this.txtDenominator3, this.txtDenominator4 };
//		RationalNumber<Long> frations;
//		int pos = fractionsVisibles;

	}

	@FXML
	void addNumberToFraction(ActionEvent event) {

		if (this.selectedFieldNow != null) {
			Button boton = (Button) event.getTarget();
			selectedFieldNow.setText(selectedFieldNow.getText() + boton.getText());
		}
	}
}
