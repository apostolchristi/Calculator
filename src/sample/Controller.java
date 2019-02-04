package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private Label screenOutput;

    @FXML
    private Button ac;

    private boolean start = true;
    private int number1 = 0;
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
            operator = value; //+
            number1 = Integer.valueOf(screenOutput.getText()); //22
            screenOutput.setText("0");
            start = true;
        } else {
            if (operator.isEmpty()) {
                return;
            }
            int number2 = Integer.valueOf(screenOutput.getText());
            int result = model.calculate(number1, number2, operator);
            screenOutput.setText(String.valueOf(result));
            operator = "";
            start = true;
        }





    }

}


