package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label screenOutput;

    @FXML
    private Button ac;

    @FXML
    private Button point;

    private boolean start = true;
    private Float number1;
    private String operator = "";
    private ArithmeticModel model = new ArithmeticModel();


    @FXML
    public void initialize() {
        screenOutput.setText("0");

    }

    @FXML
    public void onButtonClick(ActionEvent e) {
        if (start) {
            screenOutput.setText("");
            start = false;
        }
        String value = ((Button) e.getSource()).getText();
        screenOutput.setText(screenOutput.getText() + value);

        if (ac.isArmed()) {
            screenOutput.setText("0");
            start = true;
        }
    }


    public void getTheOperator(ActionEvent e) {

        String value = ((Button) e.getSource()).getText();

        if (!value.equals("=")) { //check if is not equal with =
            if (!operator.isEmpty()) { //check if is not empty
                return;
            }
            operator = value;
            number1 = Float.valueOf(screenOutput.getText());
            screenOutput.setText("0");
            start = true;
        } else {
            if (operator.isEmpty()) {
                return;
            }

            Float number2 = Float.valueOf(screenOutput.getText());
            Object result = model.calculate(number1, number2, operator);
            screenOutput.setText(String.valueOf(result));
            operator = "";
            start = true;
        }


    }

}


